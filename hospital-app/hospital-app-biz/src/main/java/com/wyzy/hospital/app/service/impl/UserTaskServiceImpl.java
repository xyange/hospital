
package com.wyzy.hospital.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.app.api.entity.UserTask;
import com.wyzy.hospital.app.mapper.UserTaskMapper;
import com.wyzy.hospital.app.service.UserTaskService;
import org.springframework.stereotype.Service;

/**
 * 用户用药计划表
 *
 * @author aqie
 * @date 2021-05-28 14:59:31
 */
@Service
public class UserTaskServiceImpl extends ServiceImpl<UserTaskMapper, UserTask> implements UserTaskService {

}
