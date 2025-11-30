package com.wyzy.hospital.admin.kit;

import com.wyzy.hospital.admin.api.dto.PhysicalSymptomDTO;

import java.util.List;

/**
 * @Title: PhysicalFitnessKitService
 * @Description:
 * @Auther: SongM
 * @Version: 1.0
 * @create 2021/6/17 11:07
 */
public interface PhysicalFitnessKitService {

    List<PhysicalSymptomDTO> symptomTree();
}
