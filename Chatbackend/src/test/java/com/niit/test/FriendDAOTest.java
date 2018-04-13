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
import com.niit.Model.UserDetail;



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
		friend.setLoginname("sree");
		friend.setFriendloginname("sree");
		assertTrue("Req Error",friendDAO.sendFriendRequest(friend));
		
	}
	
	@Ignore
	@Test
	public void testshowAllFriend()
	{
		Friend friend=new Friend();
		friend.setLoginname("jis");
		List lf=friendDAO.showAllFriend("jis");
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
		friend.setLoginname("jis");
		List lf=friendDAO.showPendingRequestList("jis");
		Iterator it1= lf.iterator();
		while(it1.hasNext()){
			
			Friend f=(Friend)it1.next();
			System.out.print(f.getFriendloginname()+f.getLoginname()+f.getStatus());
		}	
				
	}
	@Ignore
	@Test
	public void testshowsuggestedFriend()
	{
		Friend friend=new Friend();
		friend.setLoginname("ji");
		List<UserDetail> lf=friendDAO.showSuggestedFriend("ji");
		int cnt=0;
		while(cnt<lf.size()){			
			
			System.out.print(lf.get(cnt));
		}	
				
	}
	@Ignore
	@Test
	public void testdeleteFriendRequest()
	{
		
		assertTrue("Delete Error",friendDAO.deleteFriendRequest(1150));
	}
	
	
	@Test
	public void testacceptFriendRequest()
	{
		Friend friend=new Friend();		
		assertTrue("Accept Error",friendDAO.acceptFriendRequest(1));
	}
	
	@Ignore
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
