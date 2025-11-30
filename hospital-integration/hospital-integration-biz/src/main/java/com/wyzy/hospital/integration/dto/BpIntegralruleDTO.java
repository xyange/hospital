

package com.wyzy.hospital.integration.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.wyzy.hospital.integration.entity.BpIntegralrule;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 积分规则表
 *
 * @author hospital code generator
 * @date 2021-05-10 11:18:22
 */
@Data
public class BpIntegralruleDTO extends BpIntegralrule {

	/**
	 * 连续签到数组
	 */
    private List<Integer> integralDays;
}
