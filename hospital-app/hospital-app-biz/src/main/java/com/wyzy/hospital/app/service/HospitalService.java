package com.wyzy.hospital.app.service;

import com.wyzy.hospital.app.api.entity.HospitalEs;
import com.wyzy.hospital.common.mybatis.support.Query;
import org.springframework.data.domain.PageImpl;

import java.util.List;

/**
 * @Author aqie
 * Date on 2021/5/20  14:31
 * @Function: es 搜索相关
 */
public interface HospitalService {

	/**
	 * 清空医院所有es
	 */
	void deleteAll();

	/**
	 * 根据医院id 查询
	 * @param id
	 * @return
	 */
	HospitalEs getById(Long id);

	/**
	 * 批量插入 医院列表
	 */
	void saveAll(List<HospitalEs> list);


	/**
	 * 从mysql 获取数据
	 * @param query
	 * @return
	 */
	List<HospitalEs> getHospitalFromMysql(Query query, String hospitalName);

	/**
	 * es新增、修改数据
	 * @param hospitalVO
	 * @return
	 */
	HospitalEs createOrUpdate(HospitalEs hospitalVO);

	/**
	 * es 搜索医院
	 * @param hospitalName
	 * @param registrationDate
	 * @param query
	 * @return
	 */
	PageImpl<HospitalEs> searchHospital(String hospitalName, String registrationDate, Query query);
}
