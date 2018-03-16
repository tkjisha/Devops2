package com.niit.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	//	b.setBlogId(3);
		b.setBlogName("ji12");
		b.setBlogContent("hihihelloandghr");
		java.sql.Date sdt=null;
		SimpleDateFormat dtformat=new SimpleDateFormat("MM/dd/yyyy");
		try {
		java.util.Date dt=dtformat.parse("20/02/2018");
			
			sdt = new java.sql.Date(dt.getTime());
		} catch (ParseException e) {
			
			e.printStackTrace();
		} 
		b.setCreateDate(sdt);
		b.setStatus("a");
		b.setUsername("jish");
	//	BlogDAO bd=new BlogDAOImpl(null);
		assertEquals("added",true,blogDAO.addBlog(b));
	}
	
/*	@Test
	public void testdeleteBlog()
	{
		Blog b=blogDAO.getBlog(1);
		System.out.println(b);
		assertEquals("deleted",true,blogDAO.deleteBlog(b));
	}
	
	@Test
	public void testupdateBlog()
	{
		Blog b=blogDAO.getBlog(1);
		b.setBlogName("aac");
		assertEquals("updated",true,blogDAO.updateBlog(b));
		
	}*/
	
//	@Test
/*	public void test() {
		fail("Not yet implemented");
	}*/

}
