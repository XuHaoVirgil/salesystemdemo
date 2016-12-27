package com.netease.salesystem.service;

import java.util.List;

import com.netease.salesystem.pojo.AccountItem;
import com.netease.salesystem.pojo.Goods;
import com.netease.salesystem.pojo.TradeOrder;

public interface IBuyerService {

	public TradeOrder findOrderByGoodsid(Integer goodsid);
	
	public int insertOrder(TradeOrder order);
	
	public int updateGoodsSalenum(Integer goodsid, Integer num);
	
	public int buyOperate(Integer goodsid,Integer num,TradeOrder order);
	
	public List<AccountItem> findAccount(Integer userid);
	
	public List<Goods> findGoodsList(Integer flag);
	
	public double getSumCost(List<AccountItem> list);
}
