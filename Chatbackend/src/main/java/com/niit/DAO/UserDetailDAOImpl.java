package com.niit.DAO;


import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Model.UserDetail;

@Repository("userdetailDAO") @Transactional
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
		
		Session session=sessionFactory.getCurrentSession();System.out.println("checklogin");
		Query query=session.createQuery("from UserDetail where loginname=:loginname and password=:password");
		query.setParameter("loginname",userDetail.getLoginname());
		query.setParameter("password",userDetail.getPassword());
		UserDetail ud=(UserDetail) query.list().get(0);
		if(ud==null)
			return false;
		else
			return true;
	}

	
	@Override
	public boolean updateOnlineStatus(String status, UserDetail userDetail) {
		try{
			userDetail.setIsonline(status);
			sessionFactory.getCurrentSession().update(userDetail);
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public UserDetail getUser(String loginname) {
		
		UserDetail ud=null;
		Session session=sessionFactory.getCurrentSession();
		ud=(UserDetail) session.get(UserDetail.class, loginname);
		System.out.println(ud.getAddress()+ud.getPassword());
		return ud;
	}

	@Override
	public List<UserDetail> showusers() {
		Session session=sessionFactory.openSession();
		List<UserDetail> luser=null;
		luser=session.createQuery("from UserDetail where loginname !='admin'").list();session.close();
		return luser;
		
	}

}
