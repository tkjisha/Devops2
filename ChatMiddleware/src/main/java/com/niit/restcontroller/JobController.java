package com.niit.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.DAO.JobDAO;
import com.niit.Model.Job;

@RestController
public class JobController {

	@Autowired
	JobDAO jobDAO;
	
	@GetMapping(value="/testjob")
	public ResponseEntity<String> demo()
	{
		return new ResponseEntity<String>("Demo Job ",HttpStatus.OK);
	}
	
	@GetMapping(value="/listjob")
	public ResponseEntity<List<Job>> getListJob()
	{
		List<Job> listjob=jobDAO.listJob();
		if(listjob.size()>0)
		{
			return new ResponseEntity<List<Job>>(listjob,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Job>>(listjob,HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value="/getjob")
	public ResponseEntity<Job> getJob()
	{
		Job j=jobDAO.getJob(6200);
		if(j.equals(null))
		{
			return new ResponseEntity<Job>(j,HttpStatus.NOT_FOUND);
		}
		else
		{
			return new ResponseEntity<Job>(j,HttpStatus.OK);
		}
	}
}
