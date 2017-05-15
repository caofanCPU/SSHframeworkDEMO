package com.xyb.sshdemo.daoImpl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
  
public class HibernateSessionFactory {  
	
	/**
	 * 定义CFG_FILE_LOCATION="/Hibernate.cfg.xml"，指向本项目顶层目录，即src，下的Hibernate.cfg.xml配置文件
	 */
    private static final String CFG_FILE_LOCATION = "/Hibernate.cfg.xml";  
  
    private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();    
  
    private static SessionFactory sessionFactory;  
  
    public static Session currentSession() throws HibernateException {  
        Session session = threadLocal.get();  
  
        if (session == null || session.isOpen() == false) {  
  
            if (sessionFactory == null) {  
                try {
                	/**
                	 * 使用Hibernate (4.35及之后版本)5的新特性
                	 * 创建SessionFactory：
                	 * 		new Configuration().configure(CFG_FILE_LOCATION).buildSessionFactory()
                	 * 		Hibernate.cfg.xml配置文件的引用变量CFG_FILE_LOCATION传入.configure()中
                	 */
                    sessionFactory = new Configuration().configure(CFG_FILE_LOCATION).buildSessionFactory();   
                } catch (Exception e) {  
                    e.printStackTrace();  
                }  
            }  
            session = sessionFactory.openSession();
            //另一种方式
            //session = sessionFactory.getCurrentSession();
            threadLocal.set(session);    
        }  
  
        return session;  
    }  
  
    public static void closeSession() throws HibernateException {  
        Session session = threadLocal.get();  
        threadLocal.set(null);  
        if (session != null) {  
            session.close();  
        }  
    }  
  
} 
