package com.netease.salesystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netease.salesystem.dao.GoodsDao;
import com.netease.salesystem.pojo.Goods;
import com.netease.salesystem.service.ISellerService;

@Service
public class SellerService implements ISellerService{

	@Autowired
	private GoodsDao goodsDao;
	
	@Override
	public int insertGoods(Goods goods) {
		// TODO Auto-generated method stub
		if (goodsDao.insert(goods)>0){
			return goods.getGoodsid();
		}else {
			return 0;
		}		
	}

	@Override
	public Goods findGoodsByGoodsid(int goodsid) {
		// TODO Auto-generated method stub
		return goodsDao.selectByPrimaryKey(goodsid);
	}

	@Override
	public int updateGoods(Goods goods) {
		// TODO Auto-generated method stub
		return goodsDao.updateByPrimaryKeySelective(goods);
	}

	@Override
	public int deleteGoodsByGoodsid(int goodsid) {
		// TODO Auto-generated method stub
		return goodsDao.deleteByPrimaryKey(goodsid);
	}

}
