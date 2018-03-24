package com.niit.DAO;

import java.util.List;

import com.niit.Model.Blog;
import com.niit.Model.BlogComment;

public interface BlogDAO {
	
	public boolean addBlog(Blog blog);
	public boolean deleteBlog(Blog blog);
	public boolean updateBlog(Blog blog);
	public boolean approveBlog(Blog blog);
	public boolean rejectBlog(Blog blog);
	public Blog getBlog(int blogId);
	public List<Blog> listBlog(String username);	
	public boolean incrementLike(Blog blog);	    
    public boolean addBlogComment(BlogComment blogComment);
    public boolean deleteBlogComment(BlogComment blogComment);
    public BlogComment getBlogComment(int commentId);
    public List<BlogComment> listBlogComments(int blogid);

}
