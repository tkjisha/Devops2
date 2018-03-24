package com.niit.DAO;

import java.util.List;

import com.niit.Model.Users;

public interface UsersDAO {

	public boolean addUser(Users user);
	public boolean deleteUser(Users user);
	public boolean updateUser(Users user);
	public boolean approveUser(Users user);
	public boolean rejectUser(Users user);
	public Users getUser(String loginname);
	public List<Users> listUsers();
}
