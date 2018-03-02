package com.niit.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Model.Forum;

@Repository("forumDAO")
public class ForumDAOImpl implements ForumDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	public ForumDAOImpl(SessionFactory sessionFactory)
	{
	
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
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
		
		return false;
	}

	@Override
	public boolean updateForum(Forum forum) {
		
		return false;
	}

	@Override
	public boolean approveForum(Forum forum) {
		
		return false;
	}

	@Override
	public boolean rejectForum(Forum forum) {
		
		return false;
	}

	@Override
	public Forum getForum(int ForumId) {
		
		return null;
	}

	@Override
	public List<Forum> listForum(String username) {
		
		return null;
	}

	
}
