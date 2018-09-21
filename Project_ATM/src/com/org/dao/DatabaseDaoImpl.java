package com.org.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.org.bean.Admin;
import com.org.bean.Users;

public class DatabaseDaoImpl implements DatabaseDao{

	Session session;
	public DatabaseDaoImpl() {
		Configuration cfg=new AnnotationConfiguration();
		SessionFactory factory=cfg.configure().buildSessionFactory();
		session=factory.openSession();
	}
	
	public Users verifyCardNumber(String cardNumber)
	{
		Transaction t=session.beginTransaction();
		Users users=(Users)session.get(Users.class, cardNumber);
		t.commit();
		
		return users;
	}//end verifyCardNumber
	
	public List<Users> verifyPinAndCardNumber(String cardNumber, int pinNumber)
	{
		Transaction t=session.beginTransaction();
		Query query=session.createQuery("FROM Users WHERE accountNo=? AND pinNo=?");
		query.setString(0, cardNumber);
		query.setInteger(1, pinNumber);
		
		List<Users> userList=query.list();
		t.commit();
		
		return userList;
	}//end verifyPinAndCardNumber
	
	public List<Admin> loginAdmin(Admin admin)
	{
		List<Admin> adminList=new ArrayList<Admin>();
		System.out.println(admin.getAdminid()+"----------"+admin.getPassword());
		Transaction t=session.beginTransaction();
		Query query=session.createQuery("FROM Admin WHERE adminid=? AND password=?");
		query.setString(0, admin.getAdminid());
		query.setString(1, admin.getPassword());
		adminList=query.list();
		t.commit();
		
		System.out.println("New List"+adminList);
		
		for(Admin admin1:adminList)
		{
			System.out.println(admin1);
		}//end forEach
		
		return adminList;
	}//end loginAdmin
	
	public void totalUserCount()
	{
		Transaction t=session.beginTransaction();
		Query query=session.createQuery("SELECT count(*) FROM Users");
	}//end totalUserCount
}//end class
