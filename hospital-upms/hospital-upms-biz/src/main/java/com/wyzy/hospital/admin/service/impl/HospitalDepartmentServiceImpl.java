
package com.wyzy.hospital.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.admin.api.entity.ConsultatRoom;
import com.wyzy.hospital.admin.api.entity.HospitalDepartment;
import com.wyzy.hospital.admin.mapper.ConsultatRoomMapper;
import com.wyzy.hospital.admin.mapper.HospitalDepartmentMapper;
import com.wyzy.hospital.admin.service.HospitalDepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 医院科室详情
 *
 * @author hospital code generator
 * @date 2021-04-17 09:26:01
 */
@Service
public class HospitalDepartmentServiceImpl extends ServiceImpl<HospitalDepartmentMapper, HospitalDepartment> implements HospitalDepartmentService {

    @Resource
    private ConsultatRoomMapper consultatRoomMapper;

    /**
     * 根据医院科室表中科室ID查询医院科室表信息
     * @return R
     */
    @Override
    public List<HospitalDepartment> getHosdepDetailBydepartmentsId(Long departmentsId) {
        List<HospitalDepartment> hospitalDepartments = baseMapper.getHosdepDetailBydepartmentsId(departmentsId);
        return hospitalDepartments;
    }

    /**
     * 通过科室departments_id删除医院科室详情
     * @param departmentsId 科室id
     * @return R
     */
    @Override
    public boolean removeBydepartmentsId(Long departmentsId) {
       Integer integer = baseMapper.removeBydepartmentsId(departmentsId);
       if (integer>0){
           return true;
       }
        return false;
    }

    /**
     * 通过医院科室ID删除医院科室详情
     * @param id id
     * @return R
     */
    @Override
    public boolean removeById(Long id) {
        List<ConsultatRoom> consultatRoomList = consultatRoomMapper.selectConsultatRoomByhosdepdetailId(id);
        if (null != consultatRoomList || consultatRoomList.size() !=0){
            Integer integer = consultatRoomMapper.deleteByHosdepdetailId(id);
            if (integer == -1){
                return false;
            }
        }
        Integer integer = baseMapper.deleteById(id);
        if (integer == -1){
            return false;
        }
        return true;
    }
}
