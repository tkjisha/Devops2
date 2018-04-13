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

import com.niit.DAO.FriendDAO;
import com.niit.Model.Friend;
import com.niit.Model.UserDetail;

@RestController
public class FriendController {

	@Autowired
	FriendDAO friendDAO;
	
	
	
	@PostMapping(value="/sendFriendRequest")
	public ResponseEntity<String> sendFriendRequest(@RequestBody Friend friend)
	{
		if(friendDAO.sendFriendRequest(friend))
		{
			return new ResponseEntity<String>("Request sent",HttpStatus.OK);
		}
		else{
			
			return new ResponseEntity<String>("Request failedd",HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping(value="/deleteFriendRequest/{friendId}")
	public ResponseEntity<String> deleteFriendRequest(@PathVariable("friendId") int  friendId)
	{
		if(friendDAO.deleteFriendRequest(friendId))
		{
			return new ResponseEntity<String>("Deleted",HttpStatus.OK);
		}
		else{
			
			return new ResponseEntity<String>("Delete failedd",HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping(value="/acceptFriendRequest/{friendId}")
	public ResponseEntity<String> acceptFriendRequest(@PathVariable("friendId") int  friendId)
	{
		if(friendDAO.acceptFriendRequest(friendId))
		{
			return new ResponseEntity<String>("Accepted",HttpStatus.OK);
		}
		else{
			
			return new ResponseEntity<String>("Accept failedd",HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping(value="/showAllFriend")
	public ResponseEntity<List<Friend>> showAllFriend(HttpSession session)
	{
	/*	UserDetail ud= (UserDetail) session.getAttribute("userDetail");
		String loginname=ud.getLoginname();*/
		List<Friend> l=friendDAO.showAllFriend("ji");
		if(l.size()>0)
		{
			return new ResponseEntity<List<Friend>>(l,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Friend>>(l,HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping(value="/showPendingRequestList")
	public ResponseEntity<List<Friend>> showPendingRequestList(HttpSession session)
	{
		/*UserDetail ud= (UserDetail) session.getAttribute("userDetail");
		String loginname=ud.getLoginname();*/
		List<Friend> l=friendDAO.showPendingRequestList("ji");
		if(l.size()>0)
		{
			return new ResponseEntity<List<Friend>>(l,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Friend>>(l,HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping(value="/showSuggestedFriend")
	public ResponseEntity<List<UserDetail>> showSuggestedFriend(HttpSession session)
	{
		/*UserDetail ud= (UserDetail) session.getAttribute("userDetail");
		String loginname=ud.getLoginname();*/
		List<UserDetail> listSuggestedFriend=friendDAO.showSuggestedFriend("jis");
		if(listSuggestedFriend.size()>0)
		{
			return new ResponseEntity<List<UserDetail>>(listSuggestedFriend,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<UserDetail>>(listSuggestedFriend,HttpStatus.NOT_FOUND);
		}
		
	}
}
