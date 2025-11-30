
package com.wyzy.hospital.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.admin.api.entity.Region;
import com.wyzy.hospital.admin.mapper.RegionMapper;
import com.wyzy.hospital.admin.service.RegionService;
import org.springframework.stereotype.Service;

/**
 * 行政区划表
 *
 * @author aqie
 * @date 2021-04-10 14:05:23
 */
@Service
public class RegionServiceImpl extends ServiceImpl<RegionMapper, Region> implements RegionService {

}
