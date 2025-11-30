package com.wyzy.hospital.app.producerConsumer;

import com.wyzy.hospital.app.api.entity.HospitalEs;
import com.wyzy.hospital.app.service.HospitalService;
import com.wyzy.hospital.app.utils.SpringBeanUtil;
import com.wyzy.hospital.common.mybatis.support.Query;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;

/**
 * @Author aqie
 * Date on 2021/5/21  11:50
 * @Function:
 */
@Slf4j
public class ProducerThread extends Thread{
	private final HospitalBlock table;
	private Random random = new Random();
	private static int id=1;

	private HospitalService hospitalService;

	public ProducerThread(String name, HospitalBlock table) {
		super(name);
		this.hospitalService = SpringBeanUtil.getBean(HospitalService.class);
		this.table = table;
	}

	@Override
	public void run() {
		super.run();
		while (true) {
			try {
				Query query = new Query();
				query.setCurrent(id);
				query.setSize(1);
				List<HospitalEs> hospitalEs = hospitalService.getHospitalFromMysql(query,"");
				log.info("从 mysql 读取数据");
				table.put(hospitalEs);
				Thread.sleep(random.nextInt(1000));//阻塞
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static synchronized int generateId(){
		return id++;
	}
}
