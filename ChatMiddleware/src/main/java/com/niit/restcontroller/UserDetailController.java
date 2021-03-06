package com.niit.restcontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.DAO.UserDetailDAO;
import com.niit.Model.UserDetail;

@RestController
public class UserDetailController {

	@Autowired
	UserDetailDAO userdetailDAO;
	
	HttpSession session;
	@GetMapping(value="/userdetdemo")
	public ResponseEntity<String> userdettest()
	{
		return new ResponseEntity<String>("Demo user det",HttpStatus.OK);
	}
	
	@GetMapping(value="/listuser")
	public ResponseEntity<List<UserDetail>> getUserList()
	{
		List<UserDetail> luser=userdetailDAO.showusers();
		if(luser.size()>0)
		{
			return new ResponseEntity<List<UserDetail>>(luser,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<UserDetail>>(luser,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value="/getuserdet")
	public ResponseEntity<UserDetail> getuserDetail()
	{
		UserDetail u=userdetailDAO.getUser("ji");
		if(u.equals(null))
		{
			return new ResponseEntity<UserDetail>(u,HttpStatus.NOT_FOUND);
		}
		else
		{
			return new ResponseEntity<UserDetail>(u,HttpStatus.OK);
		}
	}
	
	@PostMapping(value="/registeruser")	
	public ResponseEntity<String> registerUser(@RequestBody UserDetail userDetail)
	{
		userDetail.setRole("ROLEUSER");
		userDetail.setIsonline("N");
		if(userdetailDAO.registerUser(userDetail))
		{
			return new ResponseEntity<String>("User Details Added",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Add Failed",HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping(value="/login")	
	public ResponseEntity<UserDetail> checkLogin(@RequestBody UserDetail userDetail,HttpServletRequest req)
	{
		
		if(userdetailDAO.checkLogin(userDetail))
		{
			UserDetail tmpuser=userdetailDAO.getUser(userDetail.getLoginname());
			userdetailDAO.updateOnlineStatus("y", tmpuser);
			session=req.getSession();
			session.setAttribute("userDetail", tmpuser);System.out.println("udcntrllr"+userDetail);
			return new ResponseEntity<UserDetail>(tmpuser,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<UserDetail>(userDetail,HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping(value="/updatestatus")	
	public ResponseEntity<String> updateStatus(@RequestBody UserDetail userDetail)
	{
		
		if(userdetailDAO.updateOnlineStatus("Y",userDetail))
		{
			
			return new ResponseEntity<String>("Statuss Updated",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Update Failed",HttpStatus.NOT_FOUND);
		}
		
	}
}
