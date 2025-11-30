package com.wyzy.hospital.psychology.Kit.impl;

import cn.hutool.core.date.DateUtil;
import com.wyzy.hospital.admin.api.entity.Doctor;
import com.wyzy.hospital.admin.api.feign.RemotePsychologyDoctorService;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.psychology.Kit.PsychologistRecommendKitService;
import com.wyzy.hospital.psychology.api.dto.OrderRecordDTO;
import com.wyzy.hospital.psychology.api.dto.PsychologistRecommendDTO;
import com.wyzy.hospital.psychology.api.dto.PsychologistRecommendDetailDTO;
import com.wyzy.hospital.psychology.service.PsychologistRecommendService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static java.lang.Math.abs;

/**
 * 查图片实现类
 *
 * @author wrk
 * @date 2021/05/08 09:39
 **/
@Service
@AllArgsConstructor
public class PsychologistRecommendKitServiceImpl implements PsychologistRecommendKitService {

	@Resource
	private RemotePsychologyDoctorService remotePsychologyDoctorService;
	@Resource
	private PsychologistRecommendService psychologistRecommendService;

	/**
	 * app推荐心理医生
	 * @param sex 性别
	 * @param area 地址
	 * @param day 可见日期
	 * @param counselId  咨询类型
	 * @param minPrice 小价格
	 * @param maxPrice 大价格
	 * @return
	 */
	@Override
	public List<PsychologistRecommendDTO> getRecommendDoctorIds(Integer sex, String area, Integer day, Integer counselId, BigDecimal minPrice, BigDecimal maxPrice,Long categoryId,Long serveId) {
		R<List<Doctor>> doctorIds = remotePsychologyDoctorService.getPsychologyDoctorIds(sex,area);
		if (doctorIds.getData() == null){return null;}
		Date dayweek = null;
		Date week = null;
		if (day != null){
			//获取可见时间getWeek
			dayweek = getWeek(0);
			//获取可见时间getWeek
			week = getWeek(day);
		}
		/**
		 * 查询所有满足条件的推荐医生信息
		 * @param counselId
		 * @param minPrice
		 * @param maxPrice
		 * @return
		 */
		String longList= psychologistRecommendService.getRecommendDoctorIdList(dayweek,week,counselId,minPrice,maxPrice,categoryId,serveId);
		if (longList == null){
			return null;
		}
		List<PsychologistRecommendDTO> poJoList= psychologistRecommendService.getRecommendByDoctorIds(longList);
		if (poJoList == null || poJoList.size()==0){
			return null;
		}
		List<PsychologistRecommendDTO> psychologistRecommendDTOList = new ArrayList<>();
		/**
		 * 循环遍历心理医生
		 */
		for (Doctor doctor:doctorIds.getData()){
			for (PsychologistRecommendDTO psychologistRecommendDTO:poJoList){
				if (psychologistRecommendDTO.getDoctorId().equals(doctor.getDoctorId())){
					psychologistRecommendDTO.setDoctorName(doctor.getDoctorName());
					psychologistRecommendDTO.setAvatar(doctor.getAvatar());
					psychologistRecommendDTO.setWorkYears(doctor.getWorkYears());
					psychologistRecommendDTOList.add(psychologistRecommendDTO);
				}
			}
		}
		return psychologistRecommendDTOList;
	}

	//根据天数取得星期几
	public Date getWeek(Integer day){
		Date date = DateUtil.date();
		Calendar now =Calendar.getInstance();
		now.setTime(date);
		now.set(Calendar.DATE,now.get(Calendar.DATE)+day);
		return now.getTime();
	}

	/**
	 * 查询咨询记录
	 * @param memberId
	 * @return
	 */
	@Override
	public List<OrderRecordDTO> getOrderrecordDTO(Long memberId) {
		List<Long> orderIds = psychologistRecommendService.getOrderIds(memberId);
		if (orderIds == null){
			return null;
		}
		/**
		 * 根据预约号查询信息
		 */
		List<OrderRecordDTO> orderRecordDTOList = psychologistRecommendService.getOrderRecordDTOByOrderIds(orderIds);
		if (orderRecordDTOList == null||orderRecordDTOList.size()==0){
			return null;
		}
		/**
		 * 根据ID集合查询医生信息
		 */
		R<List<Doctor>> doctorIds = remotePsychologyDoctorService.getPsychologyDoctorIds(null,null);
		for (OrderRecordDTO orderRecordDTO:orderRecordDTOList){
			for (Doctor doctor:doctorIds.getData()){
				if (orderRecordDTO.getDoctorId().equals(doctor.getDoctorId())){
					orderRecordDTO.setDoctorName(doctor.getDoctorName());
					orderRecordDTO.setPhone(doctor.getPhone());
				}
			}
		}
		return orderRecordDTOList;
	}
}
