

package com.wyzy.hospital.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.admin.api.entity.EnMedicine;

import java.util.List;

/**
 * 药品表
 *
 * @author hospital code generator
 * @date 2021-04-20 15:19:35
 */
public interface EnMedicineService extends IService<EnMedicine> {
//根据疾病找药

    List<EnMedicine> lookEnMedicineByDiseaseName (String diseaseName);
}
