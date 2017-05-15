package com.xyb.sshdemo.daoImpl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
  
public class HibernateSessionFactory {  
	
	/**
	 * ����CFG_FILE_LOCATION="/Hibernate.cfg.xml"��ָ����Ŀ����Ŀ¼����src���µ�Hibernate.cfg.xml�����ļ�
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
                	 * ʹ��Hibernate (4.35��֮��汾)5��������
                	 * ����SessionFactory��
                	 * 		new Configuration().configure(CFG_FILE_LOCATION).buildSessionFactory()
                	 * 		Hibernate.cfg.xml�����ļ������ñ���CFG_FILE_LOCATION����.configure()��
                	 */
                    sessionFactory = new Configuration().configure(CFG_FILE_LOCATION).buildSessionFactory();   
                } catch (Exception e) {  
                    e.printStackTrace();  
                }  
            }  
            session = sessionFactory.openSession();
            //��һ�ַ�ʽ
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
