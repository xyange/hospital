package com.wyzy.hospital.admin.service.impl;

import com.wyzy.hospital.admin.api.Constant;
import com.wyzy.hospital.admin.api.entity.Hospitals;
import com.wyzy.hospital.admin.service.RabbitmqService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

/**
 * @Author aqie
 * Date on 2021/5/22  8:40
 * @Function:
 */
@Service
@RequiredArgsConstructor
public class RabbitmqServiceImpl implements RabbitmqService {
    private final RabbitTemplate rabbit;
    @Override
    public void updateHospital(Hospitals hospitals) {
        rabbit.convertAndSend(Constant.RABBIT_QUEUE_HOSPITAL, hospitals, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                MessageProperties props = message.getMessageProperties();
                props.setHeader("X_ORDER_SOURCE", "WEB");
                return message;
            }
        });
    }
}
