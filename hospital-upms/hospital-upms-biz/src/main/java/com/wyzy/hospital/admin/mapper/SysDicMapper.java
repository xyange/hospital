

package com.wyzy.hospital.admin.mapper;

import com.wyzy.hospital.admin.api.dto.SysDicDTO;
import com.wyzy.hospital.admin.api.entity.SysDic;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 字典表 Mapper 接口
 * </p>
 *
 * @author wyzy
 * @since 2017-11-19
 */
@Mapper
public interface SysDicMapper extends HospitalBaseMapper<SysDic> {
    /**
    * @Description: 查询医生类型列表
    * @Param: []
    * @return: java.util.List<com.wyzy.hospital.admin.api.dto.SysDicDTO>
    * @Author: songM
    * @Date: 2021/5/25
    */
    List<SysDicDTO> getAllDoctorType();
    /**
    * @Description: 查询所有诊疗模式-远程会诊
    * @Param: []
    * @return: java.util.List<com.wyzy.hospital.admin.api.dto.SysDicDTO>
    * @Author: songM
    * @Date: 2021/6/15
    */
    List<SysDicDTO> getAllConsultationType();
}
