package com.netease.salesystem.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netease.salesystem.pojo.AccountItem;
import com.netease.salesystem.pojo.BuyListItem;
import com.netease.salesystem.pojo.Goods;
import com.netease.salesystem.pojo.TradeOrder;
import com.netease.salesystem.pojo.ResponseFormat;
import com.netease.salesystem.service.IBuyerService;
import com.netease.salesystem.service.ISellerService;

@Controller
public class BuyerController {
	
	@Autowired
	private IBuyerService buyerService;
	@Autowired
	private ISellerService sellerService;
	@RequestMapping("/buy")  
    public @ResponseBody ResponseFormat buy(@RequestBody List<BuyListItem> item,HttpServletRequest request){  
		ResponseFormat response = new ResponseFormat();  
		if (item!=null) {
			try{
				for (BuyListItem tem:item){
					TradeOrder order = new TradeOrder();
					Goods goods = sellerService.findGoodsByGoodsid(tem.getId());
					order.setGoodsid(tem.getId());
					order.setPaynum(tem.getNumber());
					order.setPayprice(goods.getPrice());
					order.setPaytime(new Date());
					order.setUserid((Integer)request.getSession().getAttribute("userId"));
					if (buyerService.buyOperate(tem.getId(), tem.getNumber(), order)>0){
						response.setCode(200);
						response.setResult("购买成功");
					}else{
						response.setCode(300);
						response.setResult("购买失败！");
					}					
				}
			}catch (Exception e){
				System.out.println(e.toString());
				response.setCode(300);
				response.setResult("购买失败！");
			}
			
		}else{
			response.setCode(300);
			response.setResult("购物车为空！");
		}
		return response;
    }  

	@RequestMapping("/settleAccount")
	public String showSettleAccount(HttpServletRequest request,Model model){
		return "settleAccount";
	}
	@RequestMapping("/account")
	public String showAccount(HttpServletRequest request,Model model){
		List<AccountItem> orderlist;
		if (request.getSession().getAttribute("userId")==null){
			orderlist = buyerService.findAccount(1);
		}else{
			orderlist = buyerService.findAccount((Integer)request.getSession().getAttribute("userId"));			
		}
		model.addAttribute("list",orderlist);
		double sum = buyerService.getSumCost(orderlist);
		model.addAttribute("sum",sum);
		return "account";
	}
}
