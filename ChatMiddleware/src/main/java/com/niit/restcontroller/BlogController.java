package com.niit.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.DAO.BlogDAO;
import com.niit.Model.Blog;

@RestController
public class BlogController {
	
	@Autowired
	BlogDAO blogDAO;
	
	@GetMapping(value="/demo")
	public ResponseEntity<String> demoPurpose()
	{
		return new ResponseEntity<String>("Demo Data",HttpStatus.OK);
	}

	@GetMapping(value="/listblog")
	public ResponseEntity<List<Blog>> getListBlogs()
	{
		List<Blog> listblog=blogDAO.listBlog("jish");
		if(listblog.size()>0)
		{
			return new ResponseEntity<List<Blog>>(listblog,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Blog>>(listblog,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value="/getblog")
	public ResponseEntity<Blog> getBlogs()
	{
		Blog b=blogDAO.getBlog(50);
		if(b.equals(null))
		{
			return new ResponseEntity<Blog>(b,HttpStatus.NOT_FOUND);
		}
		else
		{
			return new ResponseEntity<Blog>(b,HttpStatus.OK);
		}
	}
	
/*	@PostMapping(value="/addblog")	
	public ResponseEntity<String> addblog(@RequestBody Blog blog)
	{
		blog.setCreateDate(new java.util.Date());
		//blog.setBlogName("blogname1");
		if(blogDAO.addBlog(blog))
		{
			return new ResponseEntity<String>("Blog Added",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Add Failed",HttpStatus.NOT_FOUND);
		}
		
	}*/
	
}
