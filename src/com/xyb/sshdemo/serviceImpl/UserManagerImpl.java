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
          System.out.println("注册ing！");
    }*/
    
    /*
     * 
    //Struts2 2.5.10.1 + Hibernate 5.2.10 集成所用代码
    private BaseDao baseDao;  
    
    private Session session;  
  
    public UserManagerImpl() {  
        baseDao = new UserDao();  
    }  
  
    @Override  
    public void regUser(UserForm userForm) throws HibernateException {  
        session = HibernateSessionFactory.currentSession();  
        baseDao.setSession(session);  
        // 获取事务  
        Transaction ts = session.beginTransaction();  
        // 构造User对象  
        User user = new User();  
        user.setUsername(userForm.getUsername());  
        user.setPassword(userForm.getPassword());  
        user.setGender(userForm.getGender());  
        // 保存User对象  
        baseDao.saveObject(user);  
        // 提交事务  
        ts.commit();  
        // 关闭Session  
        HibernateSessionFactory.closeSession();
    }*/
	
	//user实例使用注入方式
	private BaseDao userDao;  

	//添加set()方法，用于注入使用
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
