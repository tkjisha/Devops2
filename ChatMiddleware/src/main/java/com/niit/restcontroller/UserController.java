package com.niit.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.DAO.UsersDAO;

@RestController
public class UserController {
	
	@Autowired
	UsersDAO userDAO;
	
	@GetMapping(value="/testuser")
	public ResponseEntity<String> demo()
	{
		return new ResponseEntity<String>("Demo user ",HttpStatus.OK);
	}

}
