package com.niit.test;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.UsersDAO;
import com.niit.Model.Users;

public class UsersDAOTest {

	static UsersDAO usersDAO;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext annotationConfigAppContext=new AnnotationConfigApplicationContext();
		annotationConfigAppContext.scan("com.niit.*");
		annotationConfigAppContext.refresh();
	
		usersDAO=(UsersDAO) annotationConfigAppContext.getBean("usersDAO");
	}
	
	@Ignore
	@Test
	public void testadduser()
	{
		Users u=new Users();
		u.setLoginname("acas");
		u.setPassword("1245");
		u.setEmail("acoic@gmail.com");
		u.setAddress("kannur");
		u.setPhone("959356");
		u.setRole("user");
		u.setStatus("rejected");
		u.setUsername("acas");
		assertEquals("added",true,usersDAO.addUser(u));
		
	}
	
	@Ignore
	@Test
	public void testdeleteuser()
	{
		Users u=usersDAO.getUser("ji");System.out.println(u);
		assertEquals("deleted",true,usersDAO.deleteUser(u));
	}
	
	@Ignore
	@Test
	public void testupdateuser()
	{
		Users u=usersDAO.getUser("ji");System.out.println(u);
		u.setUsername("sss");
		
		assertEquals("updated",true,usersDAO.updateUser(u));
	}
	
	@Ignore
	@Test
	public void testlistuser()
	{
		List<Users> l=usersDAO.listUsers();
		Iterator li=l.iterator();
		while(li.hasNext())
		{
			Users u=(Users)li.next();
			System.out.print(u.getRole());
		}
	}
	
	
	@Test
	public void testgetUser()
	{
		Users u=usersDAO.getUser("ji");
		System.out.print("Get user");
		System.out.print(u.getLoginname()+u.getRole());
	}
	
	@Ignore
	@Test
	public void testapproveUser()
	{
		Users u=usersDAO.getUser("ji");
		usersDAO.approveUser(u);
	}
	
	@Ignore
	@Test
	public void testrejectUser()
	{
		Users u=usersDAO.getUser("ji");
		usersDAO.rejectUser(u);
	}
	
	@Ignore
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
