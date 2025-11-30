

package com.wyzy.hospital.pharmacy.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 药房分类表
 *
 * @author aqie
 * @date 2021-04-22 09:19:47
 */
@Data
@TableName("ph_category")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "药房分类表")
public class Category extends Model<Category> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty(value="id")
    private Long id;

    /**
     * 父级ID
     */
    @ApiModelProperty(value="父级ID")
    private Long pid;

	/**
	 * 分类层级
	 */
	@ApiModelProperty(value="分类层级")
	private Integer level;

	/**
	 * 商品图片
	 */
	@ApiModelProperty(value="商品图片")
	private String picture;

    /**
     * 路径
     */
    @ApiModelProperty(value="路径")
    private String path;

    /**
     * 分类名称
     */
    @ApiModelProperty(value="分类名称")
    private String name;

    /**
     * 类型，1 产品分类，2 附件分类，3 文章分类， 4 设置分类， 5 菜单分类
     */
    @ApiModelProperty(value="类型，1 产品分类，2 附件分类，3 文章分类， 4 设置分类， 5 菜单分类")
    private Integer type;

    /**
     * 地址
     */
    @ApiModelProperty(value="地址")
    private String url;

    /**
     * 扩展字段 Json格式
     */
    @ApiModelProperty(value="扩展字段 Json格式")
    private String extra;

    /**
     * 状态, 1正常，0失效
     */
	@TableLogic
    @ApiModelProperty(value="状态, 0正常 1删除")
    private Integer delFlag;

    /**
     * 排序
     */
    @ApiModelProperty(value="排序")
    private Integer sort;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value="更新时间")
    private LocalDateTime updateTime;

}
