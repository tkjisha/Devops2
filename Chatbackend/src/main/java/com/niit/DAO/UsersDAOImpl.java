package com.niit.DAO;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Model.Users;

@Repository("usersDAO") @Transactional
public class UsersDAOImpl implements UsersDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	public UsersDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@Override
	public boolean addUser(Users user) {
		
		try{			
			sessionFactory.getCurrentSession().persist(user);			
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean deleteUser(Users user) {
		
		try{			
			sessionFactory.getCurrentSession().delete(user);			
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean updateUser(Users user) {
		
		try{			
			sessionFactory.getCurrentSession().update(user);			
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean approveUser(Users user) {
		try{
			user.setStatus("approved");
			sessionFactory.getCurrentSession().update(user);
			return true;
		}catch(Exception e)
		{
			
			return false;
		}

	}

	@Override
	public boolean rejectUser(Users user) {
		
		try{
			user.setStatus("rejected");
			sessionFactory.getCurrentSession().update(user);
			return true;
		}catch(Exception e)
		{
			
			return false;
		}

	}

	@Override
	public Users getUser(String loginname) {
		
		Users u=null;
		Session session=sessionFactory.getCurrentSession();
		List lu=session.createQuery("from Users where loginname='"+loginname+"'").list();
		
		Iterator i=lu.iterator();
		u=(Users)i.next();
		return u;
	}

	@Override
	public List<Users> listUsers() {
		
		Session session=sessionFactory.getCurrentSession();
		List lu=null;
		lu=session.createQuery("from Users ").list();
		return lu;
	}

}
