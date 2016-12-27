package com.netease.salesystem.service;

import com.netease.salesystem.pojo.Goods;

public interface ISellerService {

	public int insertGoods(Goods goods);
	
	public Goods findGoodsByGoodsid(int goodsid);
	
	public int updateGoods(Goods goods);
	
	public int deleteGoodsByGoodsid(int goodsid);
}
