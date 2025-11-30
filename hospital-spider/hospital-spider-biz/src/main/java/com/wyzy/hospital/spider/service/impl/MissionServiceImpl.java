
package com.wyzy.hospital.spider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.spider.entity.Mission;
import com.wyzy.hospital.spider.mapper.MissionMapper;
import com.wyzy.hospital.spider.service.MissionService;
import org.springframework.stereotype.Service;

/**
 * 爬虫任务
 *
 * @author aqie
 * @date 2021-06-02 17:35:48
 */
@Service
public class MissionServiceImpl extends ServiceImpl<MissionMapper, Mission> implements MissionService {

}
