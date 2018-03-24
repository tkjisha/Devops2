package com.niit.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@PostMapping(value="/addblog")	
	public ResponseEntity<String> addblog(@RequestBody Blog blog)
	{
		blog.setCreateDate(new java.util.Date());
		blog.setBlogName("blogname1");
		blog.setStatus("a");
		if(blogDAO.addBlog(blog))
		{
			return new ResponseEntity<String>("Blog Added",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Add Failed",HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping(value="/deleteblog/{blogId}")	
	public ResponseEntity<String> deleteblog(@PathVariable("blogId") int blogId)
	{
		Blog blog=(Blog)blogDAO.getBlog(blogId);
		if(blogDAO.deleteBlog(blog))
		{
			return new ResponseEntity<String>("Blog deletd",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("delete Failed",HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping(value="/updateblog/{blogId}")	
	public ResponseEntity<String> updateblog(@PathVariable("blogId") int blogId)
	{
		Blog blog=(Blog)blogDAO.getBlog(blogId);
		blog.setStatus("NA");
		if(blogDAO.updateBlog(blog))
		{
			return new ResponseEntity<String>("Blog updatd",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("update Failed",HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping(value="/approveblog/{blogId}")	
	public ResponseEntity<String> approveblog(@PathVariable("blogId") int blogId)
	{
		Blog blog=(Blog)blogDAO.getBlog(blogId);
		blog.setStatus("A");
		if(blogDAO.approveBlog(blog))
		{
			return new ResponseEntity<String>("Blog approved",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("approve Failed",HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping(value="/rejectblog/{blogId}")	
	public ResponseEntity<String> rejectblog(@PathVariable("blogId") int blogId)
	{
		Blog blog=(Blog)blogDAO.getBlog(blogId);
		blog.setStatus("NA");
		if(blogDAO.rejectBlog(blog))
		{
			return new ResponseEntity<String>("Blog rejected",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Reject Failed",HttpStatus.NOT_FOUND);
		}
		
	}
}
