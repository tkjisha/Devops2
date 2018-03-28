package com.niit.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.ForumDAO;
import com.niit.Model.Forum;
import com.niit.Model.ForumComment;

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
	
	@Ignore
	@Test
	public void testaddForum()
	{
		Forum f=new Forum();
		f.setForumName("abcd");
		f.setForumContent("forum15");
		java.sql.Date sdt=null;
		SimpleDateFormat dtformat=new SimpleDateFormat("MM/dd/yyyy");
		try {
		java.util.Date dt=dtformat.parse("15/01/2018");
			
			sdt = new java.sql.Date(dt.getTime());
		} catch (ParseException e) {
			
			e.printStackTrace();
		} 
		f.setCreateDate(sdt);
		f.setLoginname("jisha");
	
		assertEquals("added",true,forumDAO.addForum(f));
	}
	
	@Ignore
	@Test
	public void testdeleteForum()
	{
		Forum f=forumDAO.getForum(3);
		assertEquals("deleted",true,forumDAO.deleteForum(f));
	}
	
	@Ignore
	@Test
	public void testupdateForum()
	{
		Forum f=forumDAO.getForum(1);
		f.setForumName("aac");
		assertEquals("updated",true,forumDAO.updateForum(f));
	}
	
	@Ignore
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
	
	@Ignore
	@Test
	public void testgetForum()
	{
		Forum f=forumDAO.getForum(1600);
		System.out.println(f.getForumName()+","+f.getForumContent()+","+f.getLoginname());
	}
	
	@Test
	public void testaddForumComment()
	{
		ForumComment fc=new ForumComment();
		fc.setFcommentText("sss");
		fc.setLoginname("ji");
		fc.setForumId(2601);
		
		java.sql.Date sdt=null;
		SimpleDateFormat dtformat=new SimpleDateFormat("MM/dd/yyyy");
		try {
		java.util.Date dt=dtformat.parse("15/01/2018");
			
			sdt = new java.sql.Date(dt.getTime());
		} catch (ParseException e) {
			
			e.printStackTrace();
		} 
		fc.setFmCommentDate(new java.util.Date());
	
		assertEquals("added",true,forumDAO.addForumComment(fc));
	}
	
	@Ignore
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
