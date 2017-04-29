package com.ml.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ml.dao.UserDao;
import com.ml.entity.User;
import com.ml.util.IdUtil;
import com.ml.util.Result;
@Service("userService")
public class UserServiceImpl implements UserService{
    //注入dao对象
	@Resource
	private UserDao userDao;
	public Result<User> checkLogin(String username, String password) {
		Result<User> result = new Result<User>();
		//检查姓名
		User user = userDao.findByName(username);
		if(user==null){
			result.setStatus(1);
			result.setMsg("用户名不存在");
			return result;
		}
		//检查密码
	   String password1 = user.getShop_user_password();
	   if(!password1.equals(password)){
		   result.setStatus(2);
		   result.setMsg("密码错误");
		   return result;
	   }
	   //用户名和密码正确
	        result.setStatus(0);
	        result.setMsg("登录成功");
	        result.setData(user);
	        return result;
	}
	
	
	//注册功能
	public Result<User> addUser(String username, String password, String email) {
		Result<User> result =
				new Result<User>();
//		//执行用户名检测
//		User hasUser = userDao.findByName(username);
//		if(hasUser !=null){//用户名存在
//			result.setStatus(1);
//			result.setMsg("用户名已被占用");
//			return result;
//		}
		//执行用户添加
		User user = new User();
		String id = IdUtil.createId();
		user.setShop_user_id(id);
		user.setShop_user_name(username);
		user.setShop_user_password(password);
		user.setShop_user_email(email);
		
		userDao.save(user);//保存user
		//添加成功
		result.setStatus(0);
		result.setMsg("注册成功");
		return result;
	}

	/*
	 * 
	 * 
	 */
	public Result checkName(String username) {
		Result result = new Result();
		User user = userDao.findByName(username);
		if(username == "" || username == " ") {
			result.setStatus(2);
			result.setMsg("没填或者为空格");
			return result;
		}else if(user != null) {//user不为空
			result.setStatus(1);
			result.setMsg("用户名已被占用");
			return result;
		}
		//user为空
		result.setStatus(0);
		result.setMsg("用户名可用");
		return result;
	}
}







