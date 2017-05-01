package com.ml.service;

import java.util.List;

import com.ml.entity.Product;
import com.ml.util.Result;

public interface ProductService {

	//根据list模糊查询products
	Result<List<Product>> findProduct(String productList);
	
	public Result<List<Product>> SearchList(String productList);//根据类别搜索商品
	
}
