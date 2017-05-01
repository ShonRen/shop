package com.ml.entity;

import java.io.Serializable;

//商品类
public class Product implements Serializable{
	private String shop_product_id; //商品Id
	private String shop_image_address;//商品图片地址
	private String shop_product_name;//商品名称
	private String shop_product_price;//商品价格
	private String shop_product_count;//商品数量
	private String shop_product_list;//商品类别
	public String getShop_product_id() {
		return shop_product_id;
	}
	public void setShop_product_id(String shop_product_id) {
		this.shop_product_id = shop_product_id;
	}
	public String getShop_image_address() {
		return shop_image_address;
	}
	public void setShop_image_address(String shop_image_address) {
		this.shop_image_address = shop_image_address;
	}
	public String getShop_product_name() {
		return shop_product_name;
	}
	public void setShop_product_name(String shop_product_name) {
		this.shop_product_name = shop_product_name;
	}
	public String getShop_product_price() {
		return shop_product_price;
	}
	public void setShop_product_price(String shop_product_price) {
		this.shop_product_price = shop_product_price;
	}
	public String getShop_product_count() {
		return shop_product_count;
	}
	public void setShop_product_count(String shop_product_count) {
		this.shop_product_count = shop_product_count;
	}
	public String getShop_product_list() {
		return shop_product_list;
	}
	public void setShop_product_list(String shop_product_list) {
		this.shop_product_list = shop_product_list;
	}
	
	
	
}
