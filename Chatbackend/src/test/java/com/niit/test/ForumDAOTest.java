package com.niit.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

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
	
/*	@Test
	public void testaddForum()
	{
		Forum f=new Forum();
		f.setForumId(3);
		f.setForumName("acc");
		f.setForumContent("forum12");
		f.setCreateDate(new Date());
		f.setUsername("jis");
	
		assertEquals("added",true,forumDAO.addForum(f));
	}
	
	@Test
	public void testdeleteForum()
	{
		Forum f=forumDAO.getForum(3);
		assertEquals("deleted",true,forumDAO.deleteForum(f));
	}
	
	@Test
	public void testupdateForum()
	{
		Forum f=forumDAO.getForum(1);
		f.setForumName("aac");
		assertEquals("updated",true,forumDAO.updateForum(f));
	}*/
	
	@Test
	public void testlistforum()
	{
		List<Forum> l=forumDAO.listForum();
		Iterator li=l.iterator();
		while(li.hasNext())
		{
			Forum f=(Forum)li.next();
			System.out.print(f.getForumId()+f.getForumContent());
		}
	}
	
/*	@Test
	public void test() {
		fail("Not yet implemented");
	}*/

}
