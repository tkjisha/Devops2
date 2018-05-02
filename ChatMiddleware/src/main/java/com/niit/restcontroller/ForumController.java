package com.niit.restcontroller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
import com.niit.Model.UserDetail;

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
	
	@GetMapping(value="/getforum/{forumId}")
	public ResponseEntity<Forum> getForum(@PathVariable("forumId") int forumId)
	{
		Forum f=forumDAO.getForum(forumId);
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
	public ResponseEntity<String> addforum(@RequestBody Forum forum,HttpSession session)
	{
	
		UserDetail ud= (UserDetail) session.getAttribute("userDetail");
		String loginname=ud.getLoginname();
		forum.setCreateDate(new java.util.Date());
		forum.setLoginname(loginname);
		forum.setStatus("NA");
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
	
	@PostMapping(value="/updateforum/{forumId}")	
	public ResponseEntity<String> updateforum(@PathVariable("forumId") int forumId,@RequestBody Forum forum1)
	{
		Forum forum=(Forum)forumDAO.getForum(forumId);
		forum.setForumName(forum1.getForumName());
		forum.setForumContent(forum1.getForumContent());
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
	public ResponseEntity<String> addforumcomment(@RequestBody ForumComment forumcomment,HttpSession session)
	{
		System.out.println("addforumcomment");
		UserDetail ud= (UserDetail) session.getAttribute("userDetail");
		String loginname=ud.getLoginname();
		forumcomment.setLoginname(loginname);
		
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
	
	@GetMapping(value="/getforumcomment")
	public ResponseEntity<ForumComment> getforumComment()
	{
		ForumComment fc=forumDAO.getForumComment(150);
		if(fc.equals(null))
		{
			return new ResponseEntity<ForumComment>(fc,HttpStatus.NOT_FOUND);
		}
		else
		{
			return new ResponseEntity<ForumComment>(fc,HttpStatus.OK);
		}
	}
   
	@GetMapping(value="/listforumcomment")
	public ResponseEntity<List<ForumComment>> getListForumComment( )
	{
		List lfc=forumDAO.listForumComments();
		if(lfc.equals(null))
		{
			return new ResponseEntity<List<ForumComment>>(lfc,HttpStatus.NOT_FOUND);
		}
		else
		{
			return new ResponseEntity<List<ForumComment>>(lfc,HttpStatus.OK);
		}
	}
	
	@GetMapping(value="/deleteforumcomment/{fcommentId}")	
	public ResponseEntity<String> deleteforumcomment(@PathVariable("fcommentId") int fcommentId)
	{
		ForumComment forumcomment=(ForumComment)forumDAO.getForumComment(fcommentId);
		if(forumDAO.deleteForumComment(forumcomment))
		{
			return new ResponseEntity<String>("ForumComment deletd",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("delete Failed",HttpStatus.NOT_FOUND);
		}
		
	}
}
