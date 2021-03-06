package com.mynah.gmall.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mynah.gmall.model.product.BaseAttrInfo;
import org.apache.ibatis.annotations.Param;



import java.util.List;

public interface BaseAttrInfoMapper extends BaseMapper<BaseAttrInfo> {

    List<BaseAttrInfo> attrInfoList(
            @Param("category1Id") Long category1Id,
            @Param("category2Id") Long category2Id,
            @Param("category3Id") Long category3Id);


}
