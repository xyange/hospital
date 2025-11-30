
package com.wyzy.hospital.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.admin.api.entity.Area;
import com.wyzy.hospital.admin.mapper.AreaMapper;
import com.wyzy.hospital.admin.service.AreaService;
import com.wyzy.hospital.common.core.node.INode;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author aqie
 * @date 2021-04-10 10:57:08
 */
@Service
public class AreaServiceImpl extends ServiceImpl<AreaMapper, Area> implements AreaService {

    @Override
    public boolean submit(Area area) {
        return false;
    }

    @Override
    public boolean removeArea(String id) {
        return false;
    }

    @Override
    public List<INode> lazyList(String parentCode, Map<String, Object> param) {
        return null;
    }

    @Override
    public List<INode> lazyTree(String parentCode, Map<String, Object> param) {
        return null;
    }

    @Override
    public List<Area> listAreaByParentId(Integer parentId,String areaName) {
        return baseMapper.listAreaByParentId(parentId,areaName);
    }
}
