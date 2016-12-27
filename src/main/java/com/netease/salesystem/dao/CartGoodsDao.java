package com.netease.salesystem.dao;

import com.netease.salesystem.pojo.CartGoods;

public interface CartGoodsDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CartGoods record);

    int insertSelective(CartGoods record);

    CartGoods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CartGoods record);

    int updateByPrimaryKey(CartGoods record);
}