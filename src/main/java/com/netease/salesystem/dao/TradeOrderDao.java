package com.netease.salesystem.dao;

import java.util.List;

import com.netease.salesystem.pojo.TradeOrder;

public interface TradeOrderDao{
    int deleteByPrimaryKey(Integer orderid);

    int insert(TradeOrder record);

    int insertSelective(TradeOrder record);

    TradeOrder selectByPrimaryKey(Integer orderid);

    int updateByPrimaryKeySelective(TradeOrder record);

    int updateByPrimaryKey(TradeOrder record);
    
    TradeOrder selectByGoodsid(Integer goodsid);
    
    List<TradeOrder> selectAccountByUserId(Integer userid);
}