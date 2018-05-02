package com.niit.test;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.UserDetailDAO;
import com.niit.Model.UserDetail;

public class UserDetailDAOTest {

	static UserDetailDAO userdetailDAO;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext annotationConfigAppContext=new AnnotationConfigApplicationContext();
		annotationConfigAppContext.scan("com.niit");
		annotationConfigAppContext.refresh();
	
		userdetailDAO=(UserDetailDAO) annotationConfigAppContext.getBean("userdetailDAO");
	}
	
	@Ignore
	@Test
	public void testregisterUser()
	{
		UserDetail ud=new UserDetail();
		ud.setLoginname("ji");
		ud.setPassword("asd12");
		ud.setRole("ROLEUSER");
		ud.setUsername("jis");
		ud.setEmailid("ji123@gmail.com");
		ud.setMobileno("933398899");
		ud.setAddress("Ksd");
		ud.setIsonline("N");
		assertTrue("Create problem",userdetailDAO.registerUser(ud));
	}
	
	@Ignore
	@Test
	public void testcheckLogin()
	{
		UserDetail ud=new UserDetail();
		ud.setLoginname("jis");
		ud.setPassword("pwd");
		assertTrue("failure",userdetailDAO.checkLogin(ud));
	}
	
	@Ignore
	@Test
	public void testgetUser()
	{
		UserDetail ud=userdetailDAO.getUser("jis");
		System.out.println(ud.getAddress()+ud.getEmailid());
		
	}
	
	@Ignore
	@Test
	public void testupdateOnlineStatus()
	{
		UserDetail ud=userdetailDAO.getUser("abc");
		System.out.println(ud.getIsonline());
		assertTrue("Problem",userdetailDAO.updateOnlineStatus("Y", ud));
	}
	
	@Test
	public void testshowusers()
	{
		List<UserDetail> l=userdetailDAO.showusers();
		Iterator li=l.iterator();
		while(li.hasNext())
		{
			UserDetail ud=(UserDetail)li.next();
			System.out.print(ud.getEmailid()+ud.getPassword());
			
		}
	}
	
	@Ignore
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
