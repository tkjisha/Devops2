package com.niit.DAO;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Model.Blog;

@Repository("blogDAO")
public class BlogDAOImpl implements BlogDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	public BlogDAOImpl(SessionFactory sessionFactory)
	{
	
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public boolean addBlog(Blog blog) {
		try{
			sessionFactory.getCurrentSession().persist(blog);
			listBlog("ji");
			return true;
		}catch(Exception e)
		{e.printStackTrace();
			return false;
		}
		
	}

	@Transactional
	public boolean deleteBlog(Blog blog) {
		
		try{
			sessionFactory.getCurrentSession().delete(blog);
			return true;
		}catch(Exception e)
		{
			return false;
		}
		
	}

	@Transactional
	public boolean updateBlog(Blog blog) {
		try{
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}catch(Exception e)
		{
			return false;
		}
		
	}

	public boolean approveBlog(Blog blog) {
		try{
			blog.setStatus("A");
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}catch(Exception e)
		{
			
			return false;
		}
		
	}

	public boolean rejectBlog(Blog blog) {
		try{
			blog.setStatus("NA");
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}catch(Exception e)
		{
			
			return false;
		}
		
	}

	@Override
	public Blog getBlog(int blogId) {
		Blog b=null;
		Session session=sessionFactory.getCurrentSession();
		b=(Blog) session.get(Blog.class, blogId);
		System.out.println(b);
		return b;

		
	}

	@Override
	public List<Blog> listBlog(String username) {
		Session session=sessionFactory.getCurrentSession();
		List lb=null;
		lb=session.createQuery("from Blog where username='"+username+"'").list();
		return lb;
		
	}

	
}
