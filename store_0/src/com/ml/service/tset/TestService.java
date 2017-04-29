package com.ml.service.tset;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
	
}
