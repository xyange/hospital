package com.wyzy.hospital.app.controller;


import com.wyzy.hospital.app.api.entity.HospitalEs;
import com.wyzy.hospital.app.producerConsumer.ConsumerThread;
import com.wyzy.hospital.app.producerConsumer.HospitalBlock;
import com.wyzy.hospital.app.producerConsumer.ProducerThread;
import com.wyzy.hospital.app.service.HospitalService;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.mybatis.support.Query;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author aqie
 * Date on 2021/5/19  8:38
 * @Function: 医院搜索引擎
 */
@RestController
@RequestMapping("esHospital")
@RequiredArgsConstructor
@Slf4j
public class EsHospitalController {

	private final HospitalService hospitalService;


	/**
	 * 新增/修改 医院数据
	 * @param hospitalVO
	 * @return
	 */
	@PostMapping(value = "/create")
	public R<HospitalEs> create(@RequestBody HospitalEs hospitalVO){
		HospitalEs save = hospitalService.createOrUpdate(hospitalVO);
		return R.ok(save);
	}

	/**
	 * 批量插入mysql 数据到 elasticsearch
	 * todo 1. 线程池  2. 生产-消费 模型
	 * @param query
	 * @return
	 */
	@PostMapping(value = "/batchInsert")
	public R batchInsert(Query query){
		List<HospitalEs> hospitalEs = hospitalService.getHospitalFromMysql(query,"");
		hospitalService.saveAll(hospitalEs);
		return R.ok();
	}

	@Deprecated
	@GetMapping("t")
	public void transparent(){
		HospitalBlock tableBlock = new HospitalBlock(10);
		new ProducerThread("1", tableBlock).start();
		new ConsumerThread("6", tableBlock).start();
	}

	/**
	 * 调用微服务Admin接口 通过 mysql 获取医院列表
	 * @param query
	 * @return
	 */
	@GetMapping(value = "/mysqlList")
	public R<List<HospitalEs>> mysqlList(Query query, String hospitalName){
		List<HospitalEs> hospitalFromMysql = hospitalService.getHospitalFromMysql(query, hospitalName);
		return R.ok(hospitalFromMysql);
	}

	/**
	 * es根据医院名称 分页获取医院列表
	 * page 从零开始
	 * @return
	 */
	@GetMapping(value="esList")
	public R<Page<HospitalEs>> esList(String hospitalName, String registrationDate, Query query){
		PageImpl<HospitalEs> hospitalEs = hospitalService.searchHospital(hospitalName, registrationDate, query);
		return R.ok(hospitalEs);
	}


	/**
	 * 根据id 查询
	 * @param id
	 * @return
	 */
	@GetMapping(value="getById/{id}")
	public R<HospitalEs> getById(@PathVariable("id") Long id){
		return R.ok(hospitalService.getById(id));
	}


	/**
	 * 删除全部
	 */
	@DeleteMapping(value = "/deleteAll")
	public R deleteAll(){
		hospitalService.deleteAll();
		return R.ok();
	}




}
