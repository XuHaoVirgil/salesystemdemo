package com.netease.salesystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.netease.salesystem.dao.AccountItemDao;
import com.netease.salesystem.dao.GoodsDao;
import com.netease.salesystem.dao.TradeOrderDao;
import com.netease.salesystem.pojo.AccountItem;
import com.netease.salesystem.pojo.Goods;
import com.netease.salesystem.pojo.TradeOrder;
import com.netease.salesystem.service.IBuyerService;

@Service
public class BuyerService implements IBuyerService{

	@Autowired
	private TradeOrderDao orderDao;
	@Autowired
	private GoodsDao goodsDao;
	@Autowired
	private AccountItemDao accountDao;
	@Override
	public TradeOrder findOrderByGoodsid(Integer goodsid) {
		// TODO Auto-generated method stub
		return orderDao.selectByGoodsid(goodsid);
	}
	
	@Override
	public int insertOrder(TradeOrder order) {
		// TODO Auto-generated method stub
		return orderDao.insert(order);
	}

	@Override
	public int updateGoodsSalenum(Integer goodsid, Integer num) {
		// TODO Auto-generated method stub
		return goodsDao.updateSalednum(goodsid, num);
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public int buyOperate(Integer goodsid, Integer num , TradeOrder order) {
		// TODO Auto-generated method stub
		if (goodsDao.updateSalednum(goodsid, num)>0){
			if (orderDao.insert(order)>0){
				return 1;
			}else {
				return 0;
			}
		}else{
			return 0;
		}
		
	}

	@Override
	public List<AccountItem> findAccount(Integer userid) {
		// TODO Auto-generated method stub
		return accountDao.selectAccountByUserId(userid);
	}

	@Override
	public double getSumCost(List<AccountItem> list) {
		// TODO Auto-generated method stub
		double result = 0;
		for (int i=0;i<list.size();i++){
			result += list.get(i).getPaynum()*list.get(i).getPayprice();
		}
		return result;
	}

	@Override
	public List<Goods> findGoodsList(Integer flag) {
		// TODO Auto-generated method stub
		if (flag == 0) {
			return goodsDao.selectAll();
		}else{
			return goodsDao.selectUnsale();
		}
	}

}
