package com.wyzy.hospital.app.producerConsumer;

import com.wyzy.hospital.app.api.entity.HospitalEs;
import com.wyzy.hospital.app.repository.HospitalRepository;
import com.wyzy.hospital.app.utils.SpringBeanUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;

/**
 * @Author aqie
 * Date on 2021/5/21  11:53
 * @Function:
 */
@Slf4j
public class ConsumerThread extends Thread{
	private final HospitalBlock table;
	private Random random = new Random();

	private HospitalRepository hospitalRepository;

	public ConsumerThread(String name, HospitalBlock table) {
		super(name);
		this.hospitalRepository = SpringBeanUtil.getBean(HospitalRepository.class);
		this.table = table;
	}

	@Override
	public void run() {
		super.run();
		while (true) {
			try {
				List<HospitalEs> hospitalEs = table.take();
				hospitalRepository.saveAll(hospitalEs);
				log.info("向es 写入数据");
				Thread.sleep(random.nextInt(1000));//阻塞
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
