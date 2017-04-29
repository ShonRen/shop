  //主处理
$(function(){

	//登录按钮单机
	$("#login").click(userLogin);
	//单击注册按钮
	
	//清除text里面的内容
	$(".input").val("");
	
});
//登录处理
function userLogin(){
	 //清除原有效果
	   $("#user_span").html("");
	   $("#password_span").html("");
	    //获取请求参数
		 var username = $("#username").val().trim();
		 var password = $("#password").val().trim();
		 //检验格式
		 var ok = "true";
		 if(username==""){
			   $("#user_span").html("用户名为空").attr("style","font_size:20px;color:red");
			   
			   ok="false";
		   }
		   if(password==""){
			   $("#password_span").html("密码为空").attr("style","font_size:20px;color:red");
			   ok="false";
		   }
		   
		   //发送ajax请求
		   if(ok){
			 //  alert("---------------");
			  $.ajax({
				  
			      url:path+"/user/login.do",
			      type:"post",
			      data:{"username":username,"password":password},
			      dataType:"json",	  
			      success:function(result){
			    	  //alert(username);
				    if(result.status==0){
			   
					   //将用户信息写入cookie
					   alert("登录成功，正在跳转.....");
					  var userId = result.data.shop_user_id;
					   addCookie("userId",userId,2);
					   window.location.href="logined.html";
				    }else if(result.status==1){//用户名错误
				       $("#user_span").html(result.msg);
					   alert("无该用户，请注册");
				       window.location.href="register.html";
				    }else if(result.status==2){//密码错误
					   $("#password_span").html(result.msg);
				   }
				   
			   },
			   error:function(){
				   alert("登录失败");
			   }
				   
			   });
			 } 			

}