package com.ml.dao.test;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ml.dao.ProductDao;
import com.ml.entity.Product;

public class TestDao {

	@Test
	public void testP1() throws SQLException {
		String conf= "applicationContext.xml";
		ApplicationContext  ac = new ClassPathXmlApplicationContext(conf);
		DataSource dbcp = ac.getBean("dbcp",DataSource.class);
//		System.out.println(dbcp.getConnection());
		
		ProductDao pd = ac.getBean("productDao",ProductDao.class);
		List<Product> list = pd.findByProductList("pan");
		//遍历list集合
		//System.out.println(list.get(1));
		//Product product = new Product();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getShop_product_name()+"-----"+list.get(i).getShop_product_id());
		}
		
	}
	
}
