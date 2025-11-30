package com.wyzy.hospital.daemon.quartz.listener;

import com.wyzy.hospital.admin.api.Constant;
import com.wyzy.hospital.app.api.dto.UserTaskDTO;
import com.wyzy.hospital.daemon.quartz.entity.SysJob;
import com.wyzy.hospital.daemon.quartz.service.SysJobService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import static com.wyzy.hospital.daemon.quartz.constants.HospitalQuartzEnum.JOB_STATUS_RELEASE;
import static com.wyzy.hospital.daemon.quartz.constants.HospitalQuartzEnum.JOB_STATUS_RUNNING;

/**
 * @Author aqie
 * Date on 2021/5/29  14:12
 * @Function: 用户定时任务监听器
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class UserTaskListener {
    private final SysJobService sysJobService;

    @RabbitListener(queues = Constant.RABBIT_QUEUE_USER_TASK)
    @RabbitHandler
    public void onMessage(Message<UserTaskDTO> message) {
        UserTaskDTO payload = message.getPayload();
        log.info("消费端Payload: " + payload);
        SysJob sysJob = new SysJob();
        // 任务分组
        sysJob.setJobGroup(payload.getJobName());
        // 推送任务内容
        sysJob.setJobName(payload.getRemark());
        sysJob.setJobType("2");
        sysJob.setClassName("demo");
        sysJob.setMethodName("demoMethod");
        // 定时任务传递参数
        sysJob.setMethodParamsValue(String.valueOf(payload.getId()));
        // todo 解析payload time -> cron
        sysJob.setCronExpression("0 30 17 * * ?");
        // 发布定时任务即运行
        sysJob.setJobStatus(JOB_STATUS_RUNNING.getType());
        sysJobService.save(sysJob);
    }
}
