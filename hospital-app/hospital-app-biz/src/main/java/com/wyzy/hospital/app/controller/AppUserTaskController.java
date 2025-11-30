package com.wyzy.hospital.app.controller;

import cn.hutool.core.bean.BeanUtil;
import com.wyzy.hospital.app.api.dto.UserTaskDTO;
import com.wyzy.hospital.app.api.entity.UserTask;
import com.wyzy.hospital.app.service.UserTaskService;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.wyzy.hospital.admin.api.Constant.RABBIT_QUEUE_USER_TASK;

/**
 * 用户用药计划表
 * @Author aqie
 * Date on 2021/5/28  15:02
 * @Function:
 */
@RestController
@AllArgsConstructor
@RequestMapping("/app/usertask")
@Api(value = "appUsertask", tags = "app用户用药计划表管理")
public class AppUserTaskController {

	private final UserTaskService userTaskService;


	private final AmqpTemplate amqpTemplate;

	/**
	 * 新增用户用药计划表
	 * @param userTaskDTO 用户用药计划表
	 * @return R
	 */
	@ApiOperation(value = "新增用户用药计划表", notes = "新增用户用药计划表")
	@SysLog("新增用户用药计划表" )
	@PostMapping
	@PreAuthorize("@pms.hasPermission('app')" )
	public R<Boolean> save(@RequestBody UserTaskDTO userTaskDTO) {
		UserTask userTask = new UserTask();
		BeanUtil.copyProperties(userTaskDTO, userTask);
		boolean save = userTaskService.save(userTask);
		// todo 异步发送定时任务
		amqpTemplate.convertAndSend(RABBIT_QUEUE_USER_TASK, userTaskDTO);
		return R.ok(save);
	}
}
