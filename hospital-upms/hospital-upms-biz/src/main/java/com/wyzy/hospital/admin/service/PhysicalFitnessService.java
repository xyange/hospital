

package com.wyzy.hospital.admin.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.admin.api.dto.PhysicalFitnessDTO;
import com.wyzy.hospital.admin.api.entity.PhysicalFitness;

/**
 * 身体管理体能
 *
 * @author hospital code generator
 * @date 2021-06-16 15:13:44
 */
public interface PhysicalFitnessService extends IService<PhysicalFitness> {

    /**
     * 通过memberId查询身体管理体能
     * @param memberId id
     * @return R
     */
    IPage<PhysicalFitnessDTO> getByMemberId(IPage<PhysicalFitnessDTO> page, Long memberId);

}
