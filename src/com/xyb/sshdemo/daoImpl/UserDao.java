package com.xyb.sshdemo.daoImpl;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xyb.sshdemo.dao.BaseDao;  
  
public class UserDao implements BaseDao {  
  
/*    //Struts2 2.5.10.1 + Hibernate 5.2.10 集成所用代码
    private Session session;  
  
    @Override  
    public Session getSession() {  
        return session;  
    }  
  
    @Override  
    public void setSession(Session session) {  
        this.session = session;  
    }  
  
    @Override  
    public void saveObject(Object obj) throws HibernateException {  
        session.save(obj);  
    }
*/
	
	//在SSH的设计理念：要使用某个实例，那么就定义声明一个对象，然后
	//给它添加set方法（用于spring注入进来）
	//实现不要关注这个实例来自于那里，以及怎么创建，或者它是谁    
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@Override  
    public void saveObject(Object obj) throws HibernateException {
		//sessionFactory这个实例可以自己按常规的hibernate传统写法创建
		//也可以交给spring去托管
		/*
		Configuration cfg = new Configuration().configure();
		sessionFactory = cfg.buildSessionFactory();
		*/
		
		//获取session
		Session session = sessionFactory.openSession();
		session.save(obj);
		
		//关闭session
		session.close();
		//关闭sessionFactory
		sessionFactory.close();         
    }
}
