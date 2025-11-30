

package com.wyzy.hospital.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.admin.api.entity.Area;
import com.wyzy.hospital.common.core.node.INode;

import java.util.List;
import java.util.Map;

/**
 * @author aqie
 * @date 2021-04-10 10:57:08
 */
public interface AreaService extends IService<Area> {
    /**
     * 提交
     *
     * @param area
     * @return
     */
    boolean submit(Area area);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    boolean removeArea(String id);

    /**
     * 懒加载列表
     *
     * @param parentCode
     * @param param
     * @return
     */
    List<INode> lazyList(String parentCode, Map<String, Object> param);

    /**
     * 懒加载列表
     *
     * @param parentCode
     * @param param
     * @return
     */
    List<INode> lazyTree(String parentCode, Map<String, Object> param);

    /**
     * 查区域
     *
     * @param parentId
     * @return java.util.List<com.wyzy.hospital.admin.api.entity.Area>
     * @author wrk
     * @date 2021/05/31 14:55
     */
    List<Area> listAreaByParentId(Integer parentId,String areaName);
}
