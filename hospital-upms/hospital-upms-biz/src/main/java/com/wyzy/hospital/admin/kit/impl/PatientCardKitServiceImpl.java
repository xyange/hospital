package com.wyzy.hospital.admin.kit.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdcardUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wyzy.hospital.admin.api.dto.member.PatientCardDTO;
import com.wyzy.hospital.admin.api.entity.PatientCard;
import com.wyzy.hospital.admin.exception.GlobalException;
import com.wyzy.hospital.admin.kit.PatientCardKitService;
import com.wyzy.hospital.admin.service.PatientCardService;
import com.wyzy.hospital.admin.utils.PhoneUtils;
import com.wyzy.hospital.common.core.util.CodeMsg;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author aqie
 * Date on 2021/4/27  9:34
 * @Function:
 */
@Service
public class PatientCardKitServiceImpl implements PatientCardKitService {
    @Autowired
    private PatientCardService patientCardService;

    @Override
    public List<PatientCardDTO> getPatientCard(Long memberId) {
        List<PatientCard> list = patientCardService.list(new LambdaQueryWrapper<PatientCard>().eq(PatientCard::getMemberId, memberId));
        List<PatientCardDTO> patientCards = list.stream().map(PatientCardDTO::new).collect(Collectors.toList());
        return patientCards;
    }

    /**
     * 新增就诊人
     * @param patientCardDTO
     * @return
     */
    @Override
    public boolean addPatientCard(PatientCardDTO patientCardDTO) {
        PatientCard patientCard = new PatientCard();
        BeanUtil.copyProperties(patientCardDTO, patientCard);
        try {
            /*boolean valid = IdcardUtil.isValidCard(patientCard.getPatientIdCard());
            if (!valid){
                throw new GlobalException(CodeMsg.THE_IDCARD_NOT_LEGAL);
            }
            boolean phoneLegal = PhoneUtils.isPhoneLegal(patientCard.getPatientPhone());
            if (!phoneLegal){
                throw new GlobalException(CodeMsg.THE_PHONE_NOT_LEGAL);
            }*/
            /**
             * 添加就诊人的时候每个会员ID只能添加同一位就诊人一次，相当于会员ID和身份证号唯一约束
             */
            PatientCard pojoByPatientIdCard = patientCardService.getPojoByPatientIdCard(patientCard.getPatientIdCard(),patientCard.getMemberId());
            if (pojoByPatientIdCard != null){
                throw new GlobalException(CodeMsg.THE_IDCARD_ALREADY_EXISTS);
            }
            patientCard.setCardId(null);
            boolean save = patientCardService.save(patientCard);
            return save;
        }catch (DuplicateKeyException e){
            throw new GlobalException(CodeMsg.THE_IDCARD_ALREADY_EXISTS);
        }
    }

    /**
     * 通过id查询就诊卡
     * @param cardId id
     * @return R
     */
    @Override
    public PatientCardDTO getById(Long cardId) {
        PatientCard byId = patientCardService.getById(cardId);
        PatientCardDTO patientCardDTO = new PatientCardDTO();
        BeanUtils.copyProperties(byId,patientCardDTO);
        return patientCardDTO;
    }

    /**
     * 修改就诊卡
     * @param patientCardDTO 就诊卡
     * @return R
     */
    @Override
    public boolean updateById(PatientCardDTO patientCardDTO) {
        PatientCard patientCard = new PatientCard();
        BeanUtils.copyProperties(patientCardDTO,patientCard);
        boolean b = patientCardService.updateById(patientCard);
        return b;
    }
}
