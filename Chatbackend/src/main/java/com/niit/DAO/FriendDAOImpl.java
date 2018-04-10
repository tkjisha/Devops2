package com.niit.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Model.Friend;
import com.niit.Model.UserDetail;

@Repository("friendDAO") @Transactional
public class FriendDAOImpl implements FriendDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	public FriendDAOImpl(SessionFactory sessionFactory)
	{
	
		this.sessionFactory=sessionFactory;
	}
	
	@Override
	public boolean sendFriendRequest(Friend friend) {
		
		try{
			friend.setStatus("p");
			sessionFactory.getCurrentSession().save(friend);
					
						return true;
					}catch(Exception e)
					{e.printStackTrace();
						return false;
					}
	}

	@Override
	
	public boolean deleteFriendRequest(int friendId) {
		try{
				Session session=sessionFactory.getCurrentSession();		
				Friend friend=(Friend)session.get(Friend.class,friendId);
				session.delete(friend);System.out.println("del");
								
				return true;
				}catch(Exception e)
				{e.printStackTrace();
					return false;
				}
	}

	@Override
	public List<Friend> showSuggestedFriend(String loginname) {
		Session session=sessionFactory.getCurrentSession();
		List lf=null;
		Query query= session.createQuery("from Friend where loginname=:currentuser ");
		query.setParameter("currentuser", loginname);
		lf=query.list();
		return lf;
	}

	@Override
	public List<Friend> showAllFriend(String loginname) {
		Session session=sessionFactory.getCurrentSession();
		List<Friend> lf=null;
		Query query= session.createQuery("from Friend where loginname=:currentuser and status='A'");
		query.setParameter("currentuser", loginname);
		lf=query.list();
		return lf;
		
	}

	@Override
	public List<Friend> showPendingRequestList(String loginname) {
		
		Session session=sessionFactory.getCurrentSession();
		List<Friend> lp=null;
		Query query= session.createQuery("from Friend where loginname=:currentuser and status='p'");
		query.setParameter("currentuser",loginname);
		lp=query.list();
		return lp;
	}

	@Override
	public boolean acceptFriendRequest(int friendId) {
		Session session=sessionFactory.getCurrentSession();
		Friend friend=(Friend)session.get(Friend.class,friendId);
		friend.setStatus("A");
		session.update(friend);		
		return true;
	}

	
}
