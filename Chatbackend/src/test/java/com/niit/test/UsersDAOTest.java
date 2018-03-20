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
	
		@Test
	public void testadduser()
	{
		Users u=new Users();
		u.setUsername("acas");
		u.setPassword("1245");
		u.setEmail("acoic@gmail.com");
		u.setAddress("kannur");
		u.setPhone("959356");
		u.setRole("user");
		u.setStatus("rejected");;
		assertEquals("added",true,usersDAO.addUser(u));
		
	}
	
	@Test
	public void testdeleteuser()
	{
		Users u=usersDAO.getUser(1);System.out.println(u);
		assertEquals("deleted",true,usersDAO.deleteUser(u));
	}
	
	@Test
	public void testupdateuser()
	{
		Users u=usersDAO.getUser(1);System.out.println(u);
		u.setUsername("sss");
		
		assertEquals("updated",true,usersDAO.updateUser(u));
	}
	
	@Test
	public void testlistuser()
	{
		List<Users> l=usersDAO.listUsers();
		Iterator li=l.iterator();
		while(li.hasNext())
		{
			Users u=(Users)li.next();
			System.out.print(u.getUserId()+u.getRole());
		}
	}
	
	@Test
	public void testgetUser()
	{
		Users u=usersDAO.getUser(50);
		System.out.print("Get user");
		System.out.print(u.getUsername()+u.getRole());
	}
	
	
	@Test
	public void testapproveUser()
	{
		Users u=usersDAO.getUser(1250);
		usersDAO.approveUser(u);
	}
	
	
	@Test
	public void testrejectUser()
	{
		Users u=usersDAO.getUser(1200);
		usersDAO.rejectUser(u);
	}
	
	@Ignore
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
