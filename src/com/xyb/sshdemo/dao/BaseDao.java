package com.xyb.sshdemo.dao;

import org.hibernate.HibernateException;  
//import org.hibernate.Session;  
  
public interface BaseDao {  
  
/*
    //Struts2 2.5.10.1 + Hibernate 5.2.10 �������ô���
	public void saveObject(Object obj) throws HibernateException;  
  
    public Session getSession();  
  
    public void setSession(Session session);
 */    
	
	public void saveObject(Object obj) throws HibernateException;
}
