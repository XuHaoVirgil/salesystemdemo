package com.netease.salesystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netease.salesystem.pojo.Goods;

public interface GoodsDao {
    int deleteByPrimaryKey(Integer goodsid);

    int insert(Goods record);

    int insertSelective(Goods record);
    
    List<Goods> selectAll();
    
    List<Goods> selectUnsale();

    Goods selectByPrimaryKey(Integer goodsid);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
    
    int updateSalednum(@Param("goodsid")Integer goodsid,@Param("number")Integer number);
}