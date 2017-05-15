package com.xyb.sshdemo.serviceImpl;

import org.hibernate.HibernateException;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
import org.springframework.beans.BeanUtils;

import com.xyb.sshdemo.beans.User;
import com.xyb.sshdemo.dao.BaseDao;
//import com.xyb.sshdemo.daoImpl.HibernateSessionFactory;
//import com.xyb.sshdemo.daoImpl.UserDao;
import com.xyb.sshdemo.forms.UserForm;
import com.xyb.sshdemo.service.UserManager;

public class UserManagerImpl implements UserManager {  
  
/*    @Override  
    public void regUser(UserForm user) {  
          System.out.println("ע��ing��");
    }*/
    
    /*
     * 
    //Struts2 2.5.10.1 + Hibernate 5.2.10 �������ô���
    private BaseDao baseDao;  
    
    private Session session;  
  
    public UserManagerImpl() {  
        baseDao = new UserDao();  
    }  
  
    @Override  
    public void regUser(UserForm userForm) throws HibernateException {  
        session = HibernateSessionFactory.currentSession();  
        baseDao.setSession(session);  
        // ��ȡ����  
        Transaction ts = session.beginTransaction();  
        // ����User����  
        User user = new User();  
        user.setUsername(userForm.getUsername());  
        user.setPassword(userForm.getPassword());  
        user.setGender(userForm.getGender());  
        // ����User����  
        baseDao.saveObject(user);  
        // �ύ����  
        ts.commit();  
        // �ر�Session  
        HibernateSessionFactory.closeSession();
    }*/
	
	//userʵ��ʹ��ע�뷽ʽ
	private BaseDao userDao;  

	//���set()����������ע��ʹ��
	public void setUserDao(BaseDao userDao) {
		this.userDao = userDao;
	}
	
	@Override  
    public void regUser(UserForm userForm) throws HibernateException {  
        User user = new User();  
        BeanUtils.copyProperties(userForm, user);  
        userDao.saveObject(user);
    }
}
