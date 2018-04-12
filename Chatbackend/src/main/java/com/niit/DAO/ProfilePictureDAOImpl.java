package com.niit.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Model.ProfilePicture;

@Repository("profilePictureDAO")
public class ProfilePictureDAOImpl implements ProfilePictureDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void savepic(ProfilePicture profPicture) {
		
		Session session=sessionFactory.openSession();
		session.save(profPicture);
		session.flush();
		session.close();
	}

	@Override
	public ProfilePicture getProfilePicture(String loginname) {
		
		Session session=sessionFactory.openSession();
		ProfilePicture profilePicture=(ProfilePicture)session.get(ProfilePicture.class,loginname);
		session.close();
		return profilePicture;
	}

}
