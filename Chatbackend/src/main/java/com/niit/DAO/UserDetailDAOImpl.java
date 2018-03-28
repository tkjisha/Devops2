package com.niit.DAO;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Model.UserDetail;

@Repository("userdetDAO") @Transactional
public class UserDetailDAOImpl implements UserDetailDAO{

	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	public UserDetailDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Override
	public boolean registerUser(UserDetail userDetail) {
		try{
			
			sessionFactory.getCurrentSession().persist(userDetail);
			
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean checkLogin(UserDetail userDetail) {
		
		return false;
	}

	@Override
	public boolean updateOnlineStatus(String status, UserDetail userDetail) {
		try{
			userDetail.setIsonline(status);
			sessionFactory.getCurrentSession().save(userDetail);
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public UserDetail getUser(String loginname) {
		
		return null;
	}

}
