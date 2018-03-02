package com.niit.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.ForumDAO;
import com.niit.Model.Forum;

public class ForumDAOTest {

	static ForumDAO forumDAO;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext annotationConfigAppContext=new AnnotationConfigApplicationContext();
		annotationConfigAppContext.scan("com.niit.*");
		annotationConfigAppContext.refresh();
	
		forumDAO=(ForumDAO) annotationConfigAppContext.getBean("forumDAO");
	}
	
	@Test
	public void testaddForum()
	{
		Forum f=new Forum();
		f.setForumId(2);
		f.setForumName("aa");
		f.setForumContent("hi hello");
		f.setCreateDate(new Date());
		f.setStatus("a");
		f.setUsername("ji");
	
		assertEquals("added",true,forumDAO.addForum(f));
	}
/*	@Test
	public void test() {
		fail("Not yet implemented");
	}*/

}
