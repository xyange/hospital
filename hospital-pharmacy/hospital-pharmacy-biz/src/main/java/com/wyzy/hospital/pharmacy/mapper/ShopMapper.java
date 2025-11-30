

package com.wyzy.hospital.pharmacy.mapper;

import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.pharmacy.dto.ShopDTO;
import com.wyzy.hospital.pharmacy.entity.Shop;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 药房店铺表
 *
 * @author aqie
 * @date 2021-04-22 09:06:01
 */
@Mapper
public interface ShopMapper extends HospitalBaseMapper<Shop> {

	/**
	 * 药店详情
	 * @param shopId
	 * @return
	 */
    ShopDTO shopDetail(@Param("shopId") Long shopId);
}
