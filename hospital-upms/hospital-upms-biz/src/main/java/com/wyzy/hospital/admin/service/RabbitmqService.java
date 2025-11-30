package com.wyzy.hospital.admin.service;

import com.wyzy.hospital.admin.api.entity.Hospitals;

/**
 * @Author aqie
 * Date on 2021/5/22  8:39
 * @Function:
 */
public interface RabbitmqService {
    /**
     * 更新医院
     * @param hospitals
     */
    void updateHospital(Hospitals hospitals);
}
