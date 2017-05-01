package com.ml.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ml.dao.ProductDao;
import com.ml.entity.Product;
import com.ml.util.Result;


@Service("productService")
public class ProductServiceImpl implements ProductService{

	/*
	 * 模糊查询商品
	 */
	@Autowired
	ProductDao productDao;
	public Result<List<Product>> findProduct(String productList) {
		Result<List<Product>> result = new Result<List<Product>>();
		if(productList == "" || productList == " " || productList == null) {
			result.setStatus(1);
			result.setMsg("参数不能为空!");
			return result;
		}
		List<Product> list = productDao.findByProductList(productList);
		result.setStatus(0);
		result.setMsg("查到了！");
		result.setData(list);
		
		return result;
	}
	
	
	/*
	 * 根据商品类别查询商品
	 */
	public Result<List<Product>> SearchList(String productList) {
		List<Product> allList = productDao.findByList(productList);

      //构建返回对象
	Result<List<Product>> result = new Result<List<Product>>();
//      if(allList == null) {
//    	  result.setStatus(1);
//    	  result.setMsg("没查到！");
//    	  return result;
//      }
      result.setStatus(0);
      result.setMsg("加载商品信息完成");
      result.setData(allList);
	  return result;     		
	}

}
