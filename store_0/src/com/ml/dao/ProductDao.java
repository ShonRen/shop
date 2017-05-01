package com.ml.dao;

import java.util.List;

import com.ml.entity.Product;

public interface ProductDao {
	//查询商品
	List<Product> findByProductList(String productList);
	
	
	public List<Product> findByList(String productList);//根据类别查询商品
}
