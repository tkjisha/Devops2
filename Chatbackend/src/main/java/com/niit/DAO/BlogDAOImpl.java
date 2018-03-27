package com.niit.DAO;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Model.Blog;
import com.niit.Model.BlogComment;

@Repository("blogDAO") @Transactional
public class BlogDAOImpl implements BlogDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	public BlogDAOImpl(SessionFactory sessionFactory)
	{
	
		this.sessionFactory=sessionFactory;
	}
	
	
	public boolean addBlog(Blog blog) {
		try{
			sessionFactory.getCurrentSession().persist(blog);
			
			return true;
		}catch(Exception e)
		{e.printStackTrace();
			return false;
		}
		
	}

	
	
	public boolean deleteBlog(Blog blog) {
		
		try{
			sessionFactory.getCurrentSession().delete(blog);
			return true;
		}catch(Exception e)
		{
			return false;
		}
		
	}

	
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
		lb=session.createQuery("from Blog where loginname='"+username+"'").list();
		return lb;
		
	}


	@Override
	public boolean incrementLike(Blog blog) {
		try{
		int likes=blog.getLikes();
		likes++;
		blog.setLikes(likes);
		sessionFactory.getCurrentSession().update(blog);
		return true;
		}
		catch(Exception e)
		{
			
			return false;
		}
	}


	@Override
	public boolean addBlogComment(BlogComment blogComment) {
		try{
			sessionFactory.getCurrentSession().persist(blogComment);
			
			return true;
		}catch(Exception e)
		{e.printStackTrace();
			return false;
		}
	}


	@Override
	public boolean deleteBlogComment(BlogComment blogComment) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public BlogComment getBlogComment(int commentId) {
		BlogComment bc=null;
		Session session=sessionFactory.getCurrentSession();
		bc=(BlogComment) session.get(BlogComment.class, commentId);
		System.out.println(bc);
		return bc;
	}


	@Override
	public List<BlogComment> listBlogComments(int commentid) {
		
			Session session=sessionFactory.getCurrentSession();
			List lb=null;
			lb=session.createQuery("from BlogComment where commentid="+commentid).list();
			return lb;
			
		
	}

	
}
