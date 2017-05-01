package com.ml.controller.Product;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ml.entity.Product;
import com.ml.service.ProductService;
import com.ml.util.Result;

@Controller
@RequestMapping("/product")
public class ProductListController {
    //应用接口类型去接收
	@Resource
	private ProductService productService;
	@RequestMapping("/list")
	@ResponseBody
	public Result<List<Product>> execute(String productList){
		//调用userService处理登录
		Result<List<Product>> result = productService.SearchList(productList);
		
		//循环
		List<Product> all = result.getData();
		for(int i=0;i<all.size();i++){
			//获取商品ID
			String productId  =all.get(i).getShop_product_name();
			System.out.println(productId);
			//获取商品名称
			String productName  =all.get(i).getShop_product_count();
		    System.out.println(productName);
			String productImg =all.get(i).getShop_image_address();
		    System.out.println(productImg);
		}
			
//		List<Product> allList = 
//		          result.getData();
//		for(Product pro:allList){
//			System.out.println(pro.getShop_product_name());				
//		}
		 
		return result;
	}
}
