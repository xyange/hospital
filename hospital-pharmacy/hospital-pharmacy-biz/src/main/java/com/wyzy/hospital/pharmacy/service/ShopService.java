

package com.wyzy.hospital.pharmacy.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.pharmacy.dto.ShopDTO;
import com.wyzy.hospital.pharmacy.entity.Shop;

/**
 * 药房店铺表
 *
 * @author aqie
 * @date 2021-04-22 09:06:01
 */
public interface ShopService extends IService<Shop> {

    IPage<ShopDTO> pageList(IPage page, QueryWrapper<Shop> query);

	ShopDTO detail(Long shopId);
}
