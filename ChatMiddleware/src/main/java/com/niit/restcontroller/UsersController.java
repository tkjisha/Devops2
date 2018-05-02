/*package com.niit.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.DAO.UsersDAO;
import com.niit.Model.Users;

@RestController
public class UsersController {

	@Autowired
	UsersDAO usersDAO;
	
	@GetMapping(value="/demouser")
	public ResponseEntity<String> demotest()
	{
		return new ResponseEntity<String>("Demo user",HttpStatus.OK);
	}
	
	@GetMapping(value="/listuser")
	public ResponseEntity<List<Users>> getListUsers()
	{
		List<Users> listuser=usersDAO.listUsers();
		if(listuser.size()>0)
		{
			return new ResponseEntity<List<Users>>(listuser,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Users>>(listuser,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value="/getuser")
	public ResponseEntity<Users> getuser()
	{
		Users u=usersDAO.getUser("ji");
		if(u.equals(null))
		{
			return new ResponseEntity<Users>(u,HttpStatus.NOT_FOUND);
		}
		else
		{
			return new ResponseEntity<Users>(u,HttpStatus.OK);
		}
	}
	
	@PostMapping(value="/adduser")	
	public ResponseEntity<String> adduser(@RequestBody Users users)
	{
		users.setAddress("Thalikavu");
		users.setPhone("98239");
		users.setStatus("approved");
		users.setRole("user");
		users.setUsername("jis11");
		if(usersDAO.addUser(users))
		{
			return new ResponseEntity<String>("Users Added",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Add Failed",HttpStatus.NOT_FOUND);
		}
		
	}
	
	 @GetMapping(value="/deleteuser/{loginname}")	
		public ResponseEntity<String> deleteuser(@PathVariable("loginname") String loginname)
		{
			Users u=(Users)usersDAO.getUser(loginname);
			if(usersDAO.deleteUser(u))
			{
				return new ResponseEntity<String>("user deletd",HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<String>("delete Failed",HttpStatus.NOT_FOUND);
			}
			
		}
	 
	 @GetMapping(value="/updateuser/{loginname}")	
		public ResponseEntity<String> updateuser(@PathVariable("loginname") String loginname)
		{
			Users u=(Users)usersDAO.getUser(loginname);
			u.setAddress("tly");
			if(usersDAO.updateUser(u))
			{
				return new ResponseEntity<String>("user updated",HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<String>("update Failed",HttpStatus.NOT_FOUND);
			}
			
		}
	 
	 @GetMapping(value="/approveuser/{loginname}")	
		public ResponseEntity<String> approveuser(@PathVariable("loginname") String loginname)
		{
			Users users=(Users)usersDAO.getUser(loginname);
			
			if(usersDAO.approveUser(users))
			{
				return new ResponseEntity<String>("Users approved",HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<String>("approve Failed",HttpStatus.NOT_FOUND);
			}
			
		}
	 
	 @GetMapping(value="/rejectuser/{loginname}")	
		public ResponseEntity<String> rejectuser(@PathVariable("loginname") String loginname)
		{
			Users users=(Users)usersDAO.getUser(loginname);
			
			if(usersDAO.rejectUser(users))
			{
				return new ResponseEntity<String>("Users rejected",HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<String>("Reject Failed",HttpStatus.NOT_FOUND);
			}
			
		}
	
}*/
