package com.niit.DAO;

import java.util.List;

import com.niit.Model.Blog;

public interface BlogDAO {
	
	public boolean addBlog(Blog blog);
	public boolean deleteBlog(Blog blog);
	public boolean updateBlog(Blog blog);
	public boolean approveBlog(Blog blog);
	public boolean rejectBlog(Blog blog);
	public Blog getBlog(int blogId);
	public List<Blog> listBlog(String username);

}
