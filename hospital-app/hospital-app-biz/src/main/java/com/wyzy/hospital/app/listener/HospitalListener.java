package com.wyzy.hospital.app.listener;

import cn.hutool.core.bean.BeanUtil;
import com.wyzy.hospital.admin.api.Constant;
import com.wyzy.hospital.admin.api.entity.Hospitals;
import com.wyzy.hospital.app.api.entity.HospitalEs;
import com.wyzy.hospital.app.service.HospitalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author aqie
 * Date on 2021/5/22  8:42
 * @Function: 监听rabbitmq 医院修改
 */
@Component
@Slf4j
public class HospitalListener {

	@Autowired
	private HospitalService hospitalService;

	@RabbitListener(queues = Constant.RABBIT_QUEUE_HOSPITAL)
	public void receiveOrder(Hospitals hospitals) {
		log.info("rabbitMQ listener: {}", hospitals);
		HospitalEs hospitalEs = new HospitalEs();
		BeanUtil.copyProperties(hospitals, hospitalEs);
		hospitalService.createOrUpdate(hospitalEs);
	}
}
