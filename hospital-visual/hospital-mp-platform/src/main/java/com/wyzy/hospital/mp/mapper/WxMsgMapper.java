package com.wyzy.hospital.mp.mapper;

import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.mp.entity.WxMsg;
import org.apache.ibatis.annotations.Mapper;

/**
 * 微信消息
 *
 * @author JL
 * @date 2019-05-28 16:12:10
 */
@Mapper
public interface WxMsgMapper extends HospitalBaseMapper<WxMsg> {

}
