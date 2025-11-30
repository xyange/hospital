
package com.wyzy.hospital.spider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.spider.entity.Config;
import com.wyzy.hospital.spider.mapper.ConfigMapper;
import com.wyzy.hospital.spider.service.ConfigService;
import org.springframework.stereotype.Service;

/**
 * 爬虫配置
 *
 * @author aqie
 * @date 2021-06-02 17:34:51
 */
@Service
public class ConfigServiceImpl extends ServiceImpl<ConfigMapper, Config> implements ConfigService {

}
