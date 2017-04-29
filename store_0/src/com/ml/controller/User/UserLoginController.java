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
public class UserLoginController {
    //应用接口类型去接�?
	@Resource
	private UserService userService;
	@RequestMapping("/login.do")
	@ResponseBody
	public Result<User> execute(String username,String password){
		//调用userService处理登录
		Result<User> result = 
				userService.checkLogin(username, password);
		return result;
	}
}
