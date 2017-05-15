package com.xyb.sshdemo.action;

import com.opensymphony.xwork2.ActionSupport;
import com.xyb.sshdemo.forms.UserForm;
import com.xyb.sshdemo.service.UserManager;
  
public class RegisterAction extends ActionSupport {  
  
    //Struts2 2.5.10.1 + Hibernate 5.2.10 集成所用代码
    private static final long serialVersionUID = 1L;  
  
    private UserForm userForm; 
	public UserForm getUserForm() {
		return userForm;
	}
	public void setUserForm(UserForm userForm) {
		this.userForm = userForm;
	}  
  
    //声明sevice类型的UserManager，但不给它创建具体的实现类的实例
    private UserManager userManagerImpl;  
 
    //添加set()方法，用于注入使用
    public void setUserManagerImpl(UserManager userManagerImpl) {  
        this.userManagerImpl = userManagerImpl;  
    }  
  
 /* 当用户按下注册表单提交按钮，Struts2将用户的输入传送到Action或javabean的实例字段。
  * 然后，Struts2会自动执行validate方法。如果有任何的if语句为真，
  * Struts2将自动调用其addFieldError方法（我们的Action类继承扩展了ActionSupport）添加错误信息。
  * 如果有任何错误已被添加那么Struts2将不会进行调用execute方法。Struts2框架将返回“input”作为调用Action后的结果。
  * 形如UserAction-validation.xml验证文件必须和起动作类放在同一包下，否则不起作用。
  * 当使用字段验证时，字段验证语法总是更可取比使用普通验证语法，因为它有利于根据字段字段校验分组。
  * 这是非常方便特别是如果一个字段需要有许多字段验证，这几乎总是如此。
  * Action类中的validate方法优先于execute方法当被struts框架调用时，
  * 若验证出错，将返回“input”，如验证通过，则调用execute方法并返回execute方法的返回值。
  */  
    public String execute() {  
        try { 
        	
        	/*
        	//Struts2 2.5.10.1 + Hibernate 5.2.10 集成所用代码
            this.setUserManager(new UserManagerImpl());
            */ 
                       
            System.out.println("开始注册...");
            userManagerImpl.regUser(userForm); 
            System.out.println("注册成功！");
            return SUCCESS;  
  
        } catch (Exception e) {  
            e.printStackTrace();  
            return ERROR;  
        }  
    }

} 
