

package com.wyzy.hospital.cyclopedia.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.ser.std.ToStringSerializer;

/**
 * 药品_疾病表
 *
 * @author hospital code generator
 * @date 2021-05-06 09:31:00
 */
@Data
@TableName("diseases_drug")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "药品_疾病表")
public class DiseasesDrug extends Model<DiseasesDrug> {

    private static final long serialVersionUID = 1L;

    /**
     * diseasesDrugId
     */
    @TableId(value = "diseases_drug_id",type = IdType.ASSIGN_ID)
	@JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value="diseasesDrugId")
    private Long diseasesDrugId;

    /**
     * cyDrugDetailsId
     */
    @ApiModelProperty(value="cyDrugDetailsId")
    private Long cyDrugDetailsId;
    /**
     * diseasesId
     */
    @ApiModelProperty(value="diseasesId")
    private Long diseasesId;

}
