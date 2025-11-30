

package com.wyzy.hospital.act.listener;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.collection.CollUtil;
import com.wyzy.hospital.admin.api.entity.SysUser;
import com.wyzy.hospital.admin.api.feign.RemoteUserService;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.core.util.SpringContextHolder;
import com.wyzy.hospital.common.data.tenant.TenantContextHolder;
import com.wyzy.hospital.common.security.util.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;

/**
 * @author wyzy
 * @date 2018/9/27 请假流程监听器
 */
@Slf4j
public class LeaveProcessTaskListener implements TaskListener {

	/**
	 * 查询提交人的上级
	 * @param delegateTask
	 */
	@Override
	public void notify(DelegateTask delegateTask) {
		SimpMessagingTemplate simpMessagingTemplate = SpringContextHolder.getBean(SimpMessagingTemplate.class);
		RemoteUserService userService = SpringContextHolder.getBean(RemoteUserService.class);

		R<List<SysUser>> result = userService.ancestorUsers(SecurityUtils.getUser().getUsername());
		List<String> remindUserList = new ArrayList<>();

		if (CollUtil.isEmpty(result.getData())) {
			log.info("用户 {} 不存在上级,任务单由当前用户审批", SecurityUtils.getUser().getUsername());
			delegateTask.addCandidateUser(SecurityUtils.getUser().getUsername());
			remindUserList.add(SecurityUtils.getUser().getUsername());
		}
		else {
			List<String> userList = result.getData().stream().map(SysUser::getUsername).collect(Collectors.toList());
			log.info("当前任务 {}，由 {}处理", delegateTask.getId(), userList);
			delegateTask.addCandidateUsers(userList);
			remindUserList.addAll(userList);
		}

		remindUserList.forEach(user -> {

			// 订阅通道 /task/租户ID/用户名称/remind
			String target = String.format("/task/%s/%s/remind", TenantContextHolder.getTenantId(),
					SecurityUtils.getUser().getUsername());
			simpMessagingTemplate.convertAndSend(target, delegateTask.getName());
		});
	}

}
