
package com.wyzy.hospital.pharmacy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.pharmacy.dto.ShopDTO;
import com.wyzy.hospital.pharmacy.entity.Shop;
import com.wyzy.hospital.pharmacy.mapper.ShopMapper;
import com.wyzy.hospital.pharmacy.service.ShopService;
import org.springframework.stereotype.Service;

/**
 * 药房店铺表
 *
 * @author aqie
 * @date 2021-04-22 09:06:01
 */
@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop> implements ShopService {

	@Override
	public IPage<ShopDTO> pageList(IPage page, QueryWrapper<Shop> query) {
		return baseMapper.selectPage(page, query);
	}

	@Override
	public ShopDTO detail(Long shopId) {
		return baseMapper.shopDetail(shopId);
	}
}
