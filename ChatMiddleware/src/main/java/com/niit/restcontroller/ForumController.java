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
import com.niit.Model.ForumComment;

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
		forum.setForumName("forum3");
		forum.setStatus("A");
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
	
	@GetMapping(value="/approveforum/{forumId}")	
	public ResponseEntity<String> approveforum(@PathVariable("forumId") int forumId)
	{
		Forum forum=(Forum)forumDAO.getForum(forumId);
		forum.setStatus("A");
		if(forumDAO.approveForum(forum))
		{
			return new ResponseEntity<String>("Forum approved",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("approve Failed",HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping(value="/rejectforum/{forumId}")	
	public ResponseEntity<String> rejectforum(@PathVariable("forumId") int forumId)
	{
		Forum forum=(Forum)forumDAO.getForum(forumId);
		forum.setStatus("NA");
		if(forumDAO.rejectForum(forum))
		{
			return new ResponseEntity<String>("Forum rejected",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("reject Failed",HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping(value="/addforumcomment")	
	public ResponseEntity<String> addforumcomment(@RequestBody ForumComment forumcomment)
	{
		System.out.println("addforumcomment");
		forumcomment.setLoginame("ji");
		forumcomment.setForumId(2601);
		forumcomment.setFcommentText("forumcomment4");
		forumcomment.setFmCommentDate(new java.util.Date());
		
		
		if(forumDAO.addForumComment(forumcomment))
		{
			return new ResponseEntity<String>("Forum Comment Added",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Add Failed",HttpStatus.NOT_FOUND);
		}
		
	}
   

}
