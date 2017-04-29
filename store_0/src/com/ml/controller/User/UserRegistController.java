package com.ml.controller.User;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ml.entity.User;
import com.ml.service.UserService;
import com.ml.util.Result;
@Controller
@RequestMapping("/user")
public class UserRegistController {
	@Resource
	private UserService userService; 
	@RequestMapping("/add.do")
	@ResponseBody
	public Result<User> execute(
			String username,String password,String email){
		
		Result<User> result =
				userService.addUser(username, password, email);
		System.out.println("注册结果显示："+result.getStatus()+"---"+result.getMsg()+"---"+result.getData());
		return result;
		
	}
}
