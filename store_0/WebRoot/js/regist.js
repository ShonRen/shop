			$(function(){
				
				$("#username").focus(function(){
					//alert("++++==");
					$("#1_msg").html("");
				});

				$("#email").focus(function(){
					$("#7_msg").html("");
				});
				
				
				$("#password").focus(function(){
					$("#9_msg").html("");
				});
				$("#password1").focus(function(){
					$("#10_msg").html("");
				});
				
				
				
				
						//1.判断用户名是否那个重复
						$("#username").blur(function(){
						//获取姓名
						var username = $("#username").val().trim();
						//alert(username);
						var flag = true;
						if(username == "") {
							$("#1_msg").html("名字不能为空");
							flag = false;
						}
						//2.发送ajax请求
						if(flag) {
							$.ajax({
							url:"http://localhost:8080/store_0/user/ckname.do",
								type:"post",
								data:{"username":username},
								success:function(result){
									if(result.status == 0) {//用户名可用
										$("#1_msg").html(result.msg);
									}else if(result.status == 1) {//用户名已存在
										$("#1_msg").html(result.msg);
									}else {//用户名不能为空
										$("#1_msg").html(result.msg);
									}
								},
								error:function() {
									alert("注册异常！");
								}
							
						});
						}
					
					});
						
				$("#send").click(function(){
					alert("----");
					//3.获取文本框的内容
					var username = $("#username").val().trim();
					var email = $("#email").val().trim();
					var password = $("#password").val().trim();
					var password1 = $("#password1").val().trim();
					alert(password);
					alert(password1);
					
					
					
					$("span").html("");
					
					
					//4.判断
					var flag = true;
					if(username == "") {
						$("#1_msg").html("名字不能为空");
						flag = false;
					}

					if(email == "") {
						$("#7_msg").html("email不能为空");
						flag = false;
					}

					if(password == "") {
						$("#9_msg").html("密码不能为空");
						flag = false;
					}
					if(password1 == "") {
						$("#10_msg").html("密码不能为空");
						flag = false;
					}else if(password !== password1) {
						$("#10_msg").html("r密码不一致");
						flag = false;
					}
					
					//5.发送ajax请求
					if(flag) {
						$.ajax({
							url:"http://localhost:8080/store_0/user/add.do",
							type:"post",
							data:{"username":username,"password":password,"email":email},
							success:function(result){
								if(result.status == 0) {//正确
									window.location.href="login.html";
								}
							},
							error:function() {
								alert("登陆异常！");
							}
							
						});
					}
					
				});	
			});