package com.xyb.sshdemo.action;

import com.opensymphony.xwork2.ActionSupport;
import com.xyb.sshdemo.forms.UserForm;
import com.xyb.sshdemo.service.UserManager;
  
public class RegisterAction extends ActionSupport {  
  
    //Struts2 2.5.10.1 + Hibernate 5.2.10 �������ô���
    private static final long serialVersionUID = 1L;  
  
    private UserForm userForm; 
	public UserForm getUserForm() {
		return userForm;
	}
	public void setUserForm(UserForm userForm) {
		this.userForm = userForm;
	}  
  
    //����sevice���͵�UserManager�������������������ʵ�����ʵ��
    private UserManager userManagerImpl;  
 
    //���set()����������ע��ʹ��
    public void setUserManagerImpl(UserManager userManagerImpl) {  
        this.userManagerImpl = userManagerImpl;  
    }  
  
 /* ���û�����ע����ύ��ť��Struts2���û������봫�͵�Action��javabean��ʵ���ֶΡ�
  * Ȼ��Struts2���Զ�ִ��validate������������κε�if���Ϊ�棬
  * Struts2���Զ�������addFieldError���������ǵ�Action��̳���չ��ActionSupport����Ӵ�����Ϣ��
  * ������κδ����ѱ������ôStruts2��������е���execute������Struts2��ܽ����ء�input����Ϊ����Action��Ľ����
  * ����UserAction-validation.xml��֤�ļ���������������ͬһ���£����������á�
  * ��ʹ���ֶ���֤ʱ���ֶ���֤�﷨���Ǹ���ȡ��ʹ����ͨ��֤�﷨����Ϊ�������ڸ����ֶ��ֶ�У����顣
  * ���Ƿǳ������ر������һ���ֶ���Ҫ������ֶ���֤���⼸��������ˡ�
  * Action���е�validate����������execute��������struts��ܵ���ʱ��
  * ����֤���������ء�input��������֤ͨ���������execute����������execute�����ķ���ֵ��
  */  
    public String execute() {  
        try { 
        	
        	/*
        	//Struts2 2.5.10.1 + Hibernate 5.2.10 �������ô���
            this.setUserManager(new UserManagerImpl());
            */ 
                       
            System.out.println("��ʼע��...");
            userManagerImpl.regUser(userForm); 
            System.out.println("ע��ɹ���");
            return SUCCESS;  
  
        } catch (Exception e) {  
            e.printStackTrace();  
            return ERROR;  
        }  
    }

} 
