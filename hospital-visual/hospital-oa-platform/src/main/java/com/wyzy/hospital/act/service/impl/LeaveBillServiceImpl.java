

package com.wyzy.hospital.act.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.act.entity.LeaveBill;
import com.wyzy.hospital.act.mapper.LeaveBillMapper;
import com.wyzy.hospital.act.service.LeaveBillService;
import org.springframework.stereotype.Service;

/**
 * @author wyzy
 * @date 2018-09-27
 */
@Service("leaveBillService")
public class LeaveBillServiceImpl extends ServiceImpl<LeaveBillMapper, LeaveBill> implements LeaveBillService {

}
