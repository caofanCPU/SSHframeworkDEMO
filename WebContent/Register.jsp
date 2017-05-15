<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>  
<%@ taglib prefix="s" uri="/struts-tags"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>User Register Page</title>  
</head>  
<body>  
 
 	<!--  
 		1. webapp在tomcat上部署后，web.xml加载，然后struts.xml加载，浏览器的部分http请求将交给struts2拦截器处理
 		2. 当点击"注册"后，触发动作：register.action，试图访问默认方法excute()，URL则变为http://localhost:8080/webapp名称/register.action
 			而struts2默认配置中，自动拦截.action或无后缀的http请求
 			如此一来，点击"注册"后，浏览器请求将交给struts2的 action = "register"的对象处理
 		3. 由于struts.xml已配置Spring mvc托管对象，因而服务器扫描Spring MVC配置文件applicationContext.xml，Spring MVC预先记住注入绑定关系：
 				一旦出现匹配到的需要创建的action动作实例，那么就流水线的执行，实现了底层实现，内部封装好，
 				给人的感觉就是：一旦action动作实例创建，那么合法的form实体数据就将被传输到数据库进行某些操作
 
 				即在执行action动作实例创建过程中，action动作实例注入绑定创建sevice实例，
 				sevice实例注入绑定创建POJOdao实例，POJOdao实例注入绑定sessionFactory实例，
 				sessionFactory实例注入绑定创建configLocation实例，configLocation实例映射Hibernate.cfg.xml配置文件
 				从功能上理解：action动作实例调用sevice实例，将form实体属性数据拷贝到POJO实体中
 				sevice实例调用POJOdao获取sessionFactory的session会话线程，而sessionFactory绑定的会话配置信息存储在Hibernate.cfg.xml配置文件中；
 				Hibernate.cfg.xml配置文件，指定了连接的数据库，线程池，SQL方言语句，还指定了POJO类对应的数据库表，
 				因而：sevice实例调用POJOdao就是将PODO实体与数据库表进行session会话
 				Session.save(object)就是数据库的inser table 数据库表(字段1, 字段2,...) values(?, ?, ...)
 				
 			Spring MVC准备创建regiter的对象：com.xyb.sshdemo.action.RegisterAction
 		4. 因com.xyb.sshdemo.action.RegisterAction存在form实体属性且提供get/set方法
 			(若form实体是通过new form实体()得到的，只需要提供set方法即可)
 			从而，Spring MVC先创建了form实体，将浏览器提交的表单域模型数据(对象.属性)保存在form实体中，即form实体获取了浏览器提交的表单数据
 		5. 但是，因为存在表单数据校验配置文件：action动作名-validation.xml，从而，struts2将根据校验文件进行匹配form实体中保存的属性数据
 			匹配通过，那么Spring MVC就创建regiter的对象：com.xyb.sshdemo.action.RegisterAction，执行默认excute()方法，继续步骤6
 			匹配不通过，那么Struts2将校验文件提示信息响应浏览器，Spring MVC不会创建regiter的对象，本轮http请求结束
 		6. 由于action动作实例满足Spring MVC配置关系，因而Spring MVC创建sevice实例，POJOdao实例、sessionFactory实例、configLocation实例，
 			读取Hibernate.cfg.xml配置文件，完成将orm实体属性数据传入数据库进行操作。
 		7. Struts2返回操作结果视图，浏览器根据结果视图跳转到相应页面。
 		
 	 --> 
    <s:form action="register">  
        <s:textfield name="userForm.username" label="用户名"></s:textfield>  
        <s:password name="userForm.password" label="密码"></s:password>  
        <s:select list="#{'1':'男','0':'女'}" listKey="key" listValue="value"  
            name="userForm.gender" label="性别" value="1"></s:select>  
        <s:submit value="注册"></s:submit>  
    </s:form>  
  
</body>  
</html>