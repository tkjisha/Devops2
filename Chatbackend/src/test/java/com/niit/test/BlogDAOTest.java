package com.niit.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.BlogDAO;
import com.niit.DAO.BlogDAOImpl;
import com.niit.Model.Blog;

public class BlogDAOTest {

	static BlogDAO blogDAO;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext annotationConfigAppContext=new AnnotationConfigApplicationContext();
		annotationConfigAppContext.scan("com.niit");
		annotationConfigAppContext.refresh();
	
		blogDAO=(BlogDAO) annotationConfigAppContext.getBean("blogDAO");
	}
	
	@Test
	public void testaddBlog()
	{
		Blog b=new Blog();
		b.setBlogId(2);
		b.setBlogName("aa");
		b.setBlogContent("hi hello");
		b.setCreateDate(new Date());
		b.setStatus("a");
		b.setUsername("ji");
	//	BlogDAO bd=new BlogDAOImpl(null);
		assertEquals("added",true,blogDAO.addBlog(b));
	}
//	@Test
/*	public void test() {
		fail("Not yet implemented");
	}*/

}
