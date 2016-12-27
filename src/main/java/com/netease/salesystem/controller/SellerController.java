package com.netease.salesystem.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.netease.salesystem.pojo.Goods;
import com.netease.salesystem.pojo.ResponseFormat;
import com.netease.salesystem.service.ISellerService;
import com.netease.common.utils.FileHelper;
import com.netease.common.utils.GUID;

@Controller
public class SellerController {
	
	@Autowired
	private ISellerService sellerService;
	
	@RequestMapping("/public")  
    public String showPublic(HttpServletRequest request,Model model){  
        return "public";  
    }  
	
	@RequestMapping("/upload")
    public @ResponseBody ResponseFormat uploadImage(HttpServletRequest request,Model model){  
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile multipartFile = null;
		ResponseFormat response = new ResponseFormat();  
		multipartFile = multipartRequest.getFile("file");
		if (multipartFile == null) {
			response.setCode(300);
			return response;
        }
		String fileName = multipartFile.getOriginalFilename();
        String fileExt = FileHelper.getFileExtention(fileName);
		String guid = GUID.make();
        String newFileName = guid + fileExt;
        
        String path = request.getSession().getServletContext().getRealPath("/upload/image")+"/";  
        
        File imageFile = new File(path,newFileName);
        
        try {
            multipartFile.transferTo(imageFile);
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
            response.setCode(300);
            return response;
        }
        	response.setCode(200);
        	response.setResult("/upload/image/"+newFileName);
        return response;  
    }  
	
	@RequestMapping("/publicSubmit")
	public String publicSubmit(HttpServletRequest request,Model model){
		
		Goods goods = new Goods();
		goods.setTitle(request.getParameter("title"));
		goods.setSummary(request.getParameter("summary"));
		goods.setDescription(request.getParameter("detail"));
		goods.setPrice(Double.parseDouble(request.getParameter("price")));
		goods.setOwner(2);
		goods.setSalednum(0);
		goods.setImageurl(request.getParameter("image"));
		int flag = sellerService.insertGoods(goods);
		model.addAttribute("operate", "public");
		if (flag >0){
			model.addAttribute("status", "success");
			model.addAttribute("goodsid", flag);
		}else{
			model.addAttribute("status", "failed");			
		}
		return "comeback";
	}
	@RequestMapping("/edit")
	public String editgoods(HttpServletRequest request,Model model){
		int goodsid = Integer.parseInt(request.getParameter("id"));
		Goods goods = sellerService.findGoodsByGoodsid(goodsid);
		model.addAttribute(goods);
		return "edit";
	}
	@RequestMapping("/editSubmit")
	public String editcomback(HttpServletRequest request,Model model){
		Goods goods = new Goods();
		goods.setGoodsid(Integer.parseInt(request.getParameter("id")));
		goods.setTitle(request.getParameter("title"));
		goods.setSummary(request.getParameter("summary"));
		goods.setDescription(request.getParameter("detail"));
		goods.setPrice(Double.parseDouble(request.getParameter("price")));
		goods.setImageurl(request.getParameter("image"));
		goods.setOwner(null);
		goods.setSalednum(null);
		int flag = sellerService.updateGoods(goods);
		model.addAttribute("operate", "edit");
		model.addAttribute("goodsid", goods.getGoodsid());
		if (flag >0){
			model.addAttribute("status", "success");
		}else{
			model.addAttribute("status", "failed");			
		}
		return "comeback";
	}
	@RequestMapping("/delete")
	public @ResponseBody ResponseFormat deletegoods(HttpServletRequest request,Model model){  
		ResponseFormat response = new ResponseFormat(); 
		int id = Integer.parseInt(request.getParameter("id"));
		if (sellerService.deleteGoodsByGoodsid(id)>0){
			response.setCode(200);
        		response.setResult("删除成功");
		}else{
			response.setCode(300);
    			response.setResult("删除失败");
		}
		return response;
	}
}
