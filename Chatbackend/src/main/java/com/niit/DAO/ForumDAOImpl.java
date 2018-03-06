package com.niit.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Model.Forum;

@Repository("forumDAO") @Transactional
public class ForumDAOImpl implements ForumDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	public ForumDAOImpl(SessionFactory sessionFactory)
	{
	
		this.sessionFactory=sessionFactory;
	}
	
	
	@Override
	public boolean addForum(Forum forum) {
		
		try{
			
			sessionFactory.getCurrentSession().persist(forum);
			
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}

	
	@Override
	public boolean deleteForum(Forum forum) {
		try{
			
			sessionFactory.getCurrentSession().delete(forum);
			
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean updateForum(Forum forum) {
		
		try{
			sessionFactory.getCurrentSession().update(forum);
			
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}

	

	@Override
	public Forum getForum(int ForumId) {
		
		Forum f=null;
		Session session=sessionFactory.getCurrentSession();
		f=(Forum) session.get(Forum.class, ForumId);
		System.out.println(f);
		return f;
	}

	@Override
	public List<Forum> listForum() {
		Session session=sessionFactory.getCurrentSession();
		List lf=null;
		lf=session.createQuery("from Forum").list();
		return lf;
		
	}

	
}
