

package com.wyzy.hospital.pay.mapper;

import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.pay.entity.PayNotifyRecord;
import org.apache.ibatis.annotations.Mapper;

/**
 * 异步通知记录
 *
 * @author wyzy
 * @date 2019-05-28 23:57:23
 */
@Mapper
public interface PayNotifyRecordMapper extends HospitalBaseMapper<PayNotifyRecord> {

}
