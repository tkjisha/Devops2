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

import com.niit.DAO.ForumDAO;
import com.niit.Model.Forum;

@RestController
public class ForumController {
	
	@Autowired
	ForumDAO forumDAO;

	@GetMapping(value="/test")
	public ResponseEntity<String> demo()
	{
		return new ResponseEntity<String>("Demo ",HttpStatus.OK);
	}
	
	@GetMapping(value="/listforum")
	public ResponseEntity<List<Forum>> getListForum()
	{
		List<Forum> listforum=forumDAO.listForum();
		if(listforum.size()>0)
		{
			return new ResponseEntity<List<Forum>>(listforum,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Forum>>(listforum,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value="/getforum")
	public ResponseEntity<Forum> getForum()
	{
		Forum f=forumDAO.getForum(1550);
		if(f.equals(null))
		{
			return new ResponseEntity<Forum>(f,HttpStatus.NOT_FOUND);
		}
		else
		{
			return new ResponseEntity<Forum>(f,HttpStatus.OK);
		}
	}
	
	@PostMapping(value="/addforum")	
	public ResponseEntity<String> addforum(@RequestBody Forum forum)
	{
		forum.setCreateDate(new java.util.Date());
		forum.setForumName("forum1");
		if(forumDAO.addForum(forum))
		{
			return new ResponseEntity<String>("Forum Added",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Add Failed",HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping(value="/deleteforum/{forumId}")	
	public ResponseEntity<String> deleteforum(@PathVariable("forumId") int forumId)
	{
		Forum forum=(Forum)forumDAO.getForum(forumId);
		if(forumDAO.deleteForum(forum))
		{
			return new ResponseEntity<String>("Forum deletd",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("delete Failed",HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping(value="/updateforum/{forumId}")	
	public ResponseEntity<String> updateforum(@PathVariable("forumId") int forumId)
	{
		Forum forum=(Forum)forumDAO.getForum(forumId);
		forum.setForumName("niitforum");
		if(forumDAO.updateForum(forum))
		{
			return new ResponseEntity<String>("Forum updated",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Update Failed",HttpStatus.NOT_FOUND);
		}
		
	}
}
