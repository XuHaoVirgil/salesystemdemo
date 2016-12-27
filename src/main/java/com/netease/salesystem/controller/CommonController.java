package com.netease.salesystem.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.netease.salesystem.pojo.Goods;
import com.netease.salesystem.pojo.User;
import com.netease.salesystem.service.IBuyerService;
import com.netease.salesystem.service.ISellerService;

@Controller
public class CommonController {

	@Autowired
	private ISellerService sellerService;
	@Autowired
	private IBuyerService buyerService;
	@RequestMapping("/show")
	public String showdetail(HttpServletRequest request,Model model){
		Goods goods = sellerService.findGoodsByGoodsid(Integer.parseInt(request.getParameter("id")));
		model.addAttribute(goods);
		if (goods.getSalednum()>0){
			model.addAttribute("payedprice",buyerService.findOrderByGoodsid(goods.getGoodsid()).getPayprice());
		}
		return "show";
	}
	@RequestMapping("/")
	public String showindex(HttpServletRequest request,Model model){
		int type ;
		if (request.getParameter("type") == null){
			type=0;	
		}else{
			try{
				type = Integer.parseInt(request.getParameter("type"));
			}catch(Exception e){
				type = 0;
			}	
		}
		model.addAttribute("type",type);
		if (type != 1){
			model.addAttribute("list",buyerService.findGoodsList(0));
		}else{
			if((Integer)request.getSession().getAttribute("userRole")==User.BUYER_ROLE){
				model.addAttribute("list",buyerService.findGoodsList(1));
			}else{
				model.addAttribute("list",buyerService.findGoodsList(0));
			}
		}
		return "index";
	}
}
