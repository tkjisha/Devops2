package com.niit.DAO;

import com.niit.Model.ProfilePicture;

public interface ProfilePictureDAO {
	
	public void savepic(ProfilePicture profPicture);
	public ProfilePicture getProfilePicture(String loginname);

}
