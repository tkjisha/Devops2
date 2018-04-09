package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Iterator;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.FriendDAO;
import com.niit.Model.Friend;



public class FriendDAOTest {

	static FriendDAO friendDAO;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext annotationConfigAppContext=new AnnotationConfigApplicationContext();
		annotationConfigAppContext.scan("com.niit");
		annotationConfigAppContext.refresh();
	
		friendDAO=(FriendDAO) annotationConfigAppContext.getBean("friendDAO");
	}
	
	@Ignore
	@Test
	public void testsendFriendRequest()
	{
		Friend friend=new Friend();
		friend.setLoginname("jis");
		friend.setFriendloginname("jis");
		assertTrue("Req Error",friendDAO.sendFriendRequest(friend));
		
	}
	
	@Ignore
	@Test
	public void testshowAllFriend()
	{
		Friend friend=new Friend();
		friend.setLoginname("ji");
		List lf=friendDAO.showAllFriend("ji");
		Iterator it1= lf.iterator();
		while(it1.hasNext()){
			
			Friend f=(Friend)it1.next();
			System.out.print(f.getFriendloginname()+f.getLoginname()+f.getStatus());
		}	
				
	}
	
	@Ignore
	@Test
	public void testshowPendingRequestList()
	{
		Friend friend=new Friend();
		friend.setLoginname("ji");
		List lf=friendDAO.showPendingRequestList("ji");
		Iterator it1= lf.iterator();
		while(it1.hasNext()){
			
			Friend f=(Friend)it1.next();
			System.out.print(f.getFriendloginname()+f.getLoginname()+f.getStatus());
		}	
				
	}
	
	@Test
	public void testshowsuggestedFriend()
	{
		Friend friend=new Friend();
		friend.setLoginname("ji");
		List lf=friendDAO.showSuggestedFriend("ji");
		Iterator it1= lf.iterator();
		while(it1.hasNext()){
			
			Friend f=(Friend)it1.next();
			System.out.print(f.getFriendloginname()+f.getLoginname()+f.getStatus());
		}	
				
	}
	@Ignore
	@Test
	public void testdeleteFriendRequest()
	{
		
		assertTrue("Delete Error",friendDAO.deleteFriendRequest(150));
	}
	
	@Ignore
	@Test
	public void testacceptFriendRequest()
	{
		Friend friend=new Friend();		
		assertTrue("Accept Error",friendDAO.acceptFriendRequest(100));
	}
	
	@Ignore
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
