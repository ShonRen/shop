package com.ml.service.test;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ml.entity.Product;
import com.ml.service.ProductService;
import com.ml.service.UserService;
import com.ml.util.Result;

public class TestService {

	//测试检查用户名
	@Test
	public void test1() throws SQLException {
		String conf= "applicationContext.xml";
		ApplicationContext  ac = new ClassPathXmlApplicationContext(conf);
		DataSource dbcp = ac.getBean("dbcp",DataSource.class);
		  System.out.println(dbcp.getConnection());
		  
		  UserService service = ac.getBean("userService",UserService.class);
		  Result re = service.checkName("lml");
		  System.out.println(re.getMsg());
	}
	
	/**
	 * 测试查询产品
	 */
	@Test
	public void test2() throws SQLException {
		String conf= "applicationContext.xml";
		ApplicationContext  ac = new ClassPathXmlApplicationContext(conf);
		DataSource dbcp = ac.getBean("dbcp",DataSource.class);
		  ProductService ps = ac.getBean("productService",ProductService.class);
		  Result<List<Product>> result = ps.findProduct("");
		  System.out.println(result.getStatus()+"---"+result.getMsg());
		 // System.out.println(result.getData());
		  List<Product> list = result.getData();
		  if(result.getData()==null) {
			  System.out.println("Data为空!拿什么输出？");
			  return;
		  }
		  for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getShop_product_name());
		}
	}
	
}
