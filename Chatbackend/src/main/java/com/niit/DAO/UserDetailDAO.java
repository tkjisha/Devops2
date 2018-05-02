package com.niit.DAO;

import java.util.List;

import com.niit.Model.UserDetail;

public interface UserDetailDAO {
	
	public boolean registerUser(UserDetail userDetail);
	public boolean checkLogin(UserDetail userDetail);
	public boolean updateOnlineStatus(String status,UserDetail userDetail);
	public UserDetail getUser(String loginname);
	public List showusers();
}
