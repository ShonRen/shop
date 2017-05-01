package com.ml.controller.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ml.entity.Product;
import com.ml.service.ProductService;
import com.ml.util.Result;

@Controller
@RequestMapping("/product")
public class FindProductByListCon {

	@Autowired
	ProductService productService;
	
	@ResponseBody
	@RequestMapping("/find")
	public Result<List<Product>> exe(String productList) {
		Result<List<Product>> result = productService.findProduct(productList);
		System.out.println(result.getMsg());
		return result;
	}
	
}
