package com.ml.service;

import com.ml.entity.User;
import com.ml.util.Result;

public interface UserService {
	
	//检查username是否存在
	public Result checkName(String username);
	
	public Result<User> checkLogin(
			String username,String password);//用户登录验证
	public Result<User> addUser(
			String username,String password,String email);//用户注册
}
