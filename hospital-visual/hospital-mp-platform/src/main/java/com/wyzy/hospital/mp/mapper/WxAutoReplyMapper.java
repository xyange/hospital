package com.wyzy.hospital.mp.mapper;

import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.mp.entity.WxAutoReply;
import org.apache.ibatis.annotations.Mapper;

/**
 * 消息自动回复
 *
 * @author JL
 * @date 2019-04-18 15:40:39
 */
@Mapper
public interface WxAutoReplyMapper extends HospitalBaseMapper<WxAutoReply> {

}
