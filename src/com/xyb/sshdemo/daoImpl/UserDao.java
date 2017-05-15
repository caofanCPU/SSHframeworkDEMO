package com.xyb.sshdemo.daoImpl;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xyb.sshdemo.dao.BaseDao;  
  
public class UserDao implements BaseDao {  
  
/*    //Struts2 2.5.10.1 + Hibernate 5.2.10 �������ô���
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
	
	//��SSH��������Ҫʹ��ĳ��ʵ������ô�Ͷ�������һ������Ȼ��
	//�������set����������springע�������
	//ʵ�ֲ�Ҫ��ע���ʵ������������Լ���ô��������������˭    
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@Override  
    public void saveObject(Object obj) throws HibernateException {
		//sessionFactory���ʵ�������Լ��������hibernate��ͳд������
		//Ҳ���Խ���springȥ�й�
		/*
		Configuration cfg = new Configuration().configure();
		sessionFactory = cfg.buildSessionFactory();
		*/
		
		//��ȡsession
		Session session = sessionFactory.openSession();
		session.save(obj);
		
		//�ر�session
		session.close();
		//�ر�sessionFactory
		sessionFactory.close();         
    }
}
