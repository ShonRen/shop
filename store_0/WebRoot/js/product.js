/**
 * 查询显示商品
 */

function searchProductList(){   
				 	//alert("-----");
				 	var productList = $(".form-control").val().trim()
				 	$(".all").hide();//隐藏首页
					 $(".all2").show();//显示商品页  
				 	alert(productList);
				 	  $.ajax({					  
						  url:path+"/product/find.do",
						  type:"post",
						  data:{"productList":productList},
						  dataType:"json",
						  success:function(result){
							if(result.status==1) {//
								alert(result.msg);
								//alert(result.data)
							}else if(result.status==0){
								
								 var products = result.data;
								 
								for(var i=0;i<products.length;i++){
									//获取商品ID
									var productId    = products[i].shop_product_id;
									//获取商品名称
									var productName  = products[i].shop_product_name;
									//获取商品名称
									var productPrice = products[i].shop_product_price;
									//获取图片地址
									var productImg   = products[i].shop_image_address;
									
									//创建一个商品列表项<div>元素					
								 var sli="";
								   sli+='<div align="center" class="col-md-2">';
								   sli+='<a style="display: inline-block width="170" height="170">';
								   sli+='<img src=';
								   sli+=productImg;
								   sli+='>';
								   sli+='</a>';
								   sli+='<p>';
								   sli+='<a >';
								   sli+=productName;
								   sli+='</a>';
								   sli+='</p>';
								   sli+='<p>';
								   sli+='<font color="#FF0000">商城价：&yen;';
								   sli+=productPrice;
								   sli+='</font>';
								   sli+='</p>';
							       sli+='</div>';
							       var $li = $(sli);//将sli字符串转成jQuery对象li元素
							       $li.data("productId",productId);//将值与jQuery对象元素绑定
							    	//将li元素添加到笔记本div列表区
							    	$("#image_all").append($li);
							       
								}
							  }	
							
						  },
						  error:function(){
							  alert("跳转失败");
						  }
						  
					  });
					
				 	
				 }




/**
 * 显示商品
 */

function showProductList(){   
						
					  $(".all").hide();//隐藏首页
					  $(".all2").show();//显示商品页  
					 //获取请求参数
					 var productList = $(this).parent().text().trim();	
					 
					  alert(productList);
					  //发送Ajax请求
					  $.ajax({					  
						  url:path+"/product/list.do",
						  type:"post",
						  data:{"productList":productList},
						  dataType:"json",
						  success:function(result){
							  	
							if(result.status==0){
								
								 var products = result.data;
								 
								for(var i=0;i<products.length;i++){
									//获取商品ID
									var productId    = products[i].shop_product_id;
									//获取商品名称
									var productName  = products[i].shop_product_name;
									//获取商品名称
									var productPrice = products[i].shop_product_price;
									//获取图片地址
									var productImg   = products[i].shop_image_address;
									
									//创建一个商品列表项<div>元素					
								 var sli="";
								   sli+='<div align="center" class="col-md-2">';
								   sli+='<a style="display: inline-block width="170" height="170">';
								   sli+='<img src=';
								   sli+=productImg;
								   sli+='>';
								   sli+='</a>';
								   sli+='<p>';
								   sli+='<a >';
								   sli+=productName;
								   sli+='</a>';
								   sli+='</p>';
								   sli+='<p>';
								   sli+='<font color="#FF0000">商城价：&yen;';
								   sli+=productPrice;
								   sli+='</font>';
								   sli+='</p>';
							       sli+='</div>';
							       var $li = $(sli);//将sli字符串转成jQuery对象li元素
							       $li.data("productId",productId);//将值与jQuery对象元素绑定
							    	//将li元素添加到笔记本div列表区
							    	$("#image_all").append($li);
							       
								}
							  }	
							
						  },
						  error:function(){
							  alert("跳转失败");
						  }
						  
					  });
					
					 }