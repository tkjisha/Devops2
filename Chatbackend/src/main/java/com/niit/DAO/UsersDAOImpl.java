package com.niit.DAO;

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
		
		return false;
	}

	@Override
	public boolean rejectUser(Users user) {
		
		return false;
	}

	@Override
	public Users getUser(int userId) {
		
		Users u=null;
		Session session=sessionFactory.getCurrentSession();
		u=(Users) session.get(Users.class, userId);
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
