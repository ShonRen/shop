这是一个类似于淘宝的购物网站。

功能：登陆，注册，添加购物车，退出等
工具：MyEclipse8.6 Tomcat jdk1.7 MySql
框架：Spring SpringMVC MyBatis 

数据处理：后台传到页面的是JSON字符串，

遇到的问题：

1.@Service("userService")里面的内容写成了UserService，导致测试的时候(getBean)获取不了Service.class

解决：注解后面可以不写标注

2.在浏览器测试Controller的时候，传过来的中文参数查不到数据。

解决：1.1在后台可以查到，但是在浏览器上面查不到，考虑到编码问题。最后将数据库里面的数据改成英文，浏览器端的参数相应的变成英文之后，测试成功。

1.2 确定编码问题后，在web.xml文件中假如过滤器（用来设置编码为UTF-8），与数据库、自己写的页面的编码一致，最后问题没有解决。-----待解决------

-------2017-05-01---------

更新：


1.新增产品数据库


2.新增产品页面的查询，产品的显示

3.新增搜索功能

问题：


1.页面用$("#id").val().trim();获取参数的时候没有写trim()，导致在页面取不到数据

2.MyBatis框架在mapper里面模糊查询的语句写法

1.1 sql中字符串拼接

   SELECT * FROM tableName WHERE name LIKE CONCAT(CONCAT('%',#{text}),'%');

1.2 使用 ${...} 代替 #{...}

   SELECT * FROM tableName WHERE name LIKE '%${text}%'; 

不能更新readme?
暂时就这么多！后面有进展在更新
