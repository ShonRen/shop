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
public class CheckUserLoginNameCon {

	@Resource
	private UserService userService;
	@RequestMapping("/ckname.do")
	@ResponseBody
	public Result exe(String username){
		//调用userService处理登录
		Result result = 
				userService.checkName(username);
		return result;
	}
	
}
