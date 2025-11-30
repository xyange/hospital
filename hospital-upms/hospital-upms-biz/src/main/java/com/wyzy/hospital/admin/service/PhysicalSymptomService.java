

package com.wyzy.hospital.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.admin.api.entity.PhysicalSymptom;

import java.util.List;


/**
 * 身体管理症状自查
 *
 * @author songM
 * @date 2021-06-17 10:28:22
 */
public interface PhysicalSymptomService extends IService<PhysicalSymptom> {

    List<PhysicalSymptom> symptomTree();
}
