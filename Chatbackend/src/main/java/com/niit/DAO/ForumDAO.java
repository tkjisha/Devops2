package com.niit.DAO;

import java.util.List;

import com.niit.Model.Forum;

public interface ForumDAO {

	public boolean addForum(Forum forum);
	public boolean deleteForum(Forum forum);
	public boolean updateForum(Forum forum);
	public Forum getForum(int ForumId);
	public List<Forum> listForum();
	
}
