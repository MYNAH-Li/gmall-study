package com.mynah.gmall.model.product;

import com.mynah.gmall.model.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * <p>
 * BaseAttrInfo
 * </p>
 *
 * @author qy
 */
@Data
@ApiModel(description = "平台属性")
@TableName("base_attr_info")
public class BaseAttrInfo extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "属性名称")
	@TableField("attr_name")
	private String attrName;

	@ApiModelProperty(value = "分类id")
	@TableField("category_id")
	private Long categoryId;

	@ApiModelProperty(value = "分类层级")
	@TableField("category_level")
	private Integer categoryLevel;

	//平台属性值集合   不存在   扩展属性  表中没有此字段的  Model与表映射
	@TableField(exist = false)
	private List<BaseAttrValue> attrValueList;

}

