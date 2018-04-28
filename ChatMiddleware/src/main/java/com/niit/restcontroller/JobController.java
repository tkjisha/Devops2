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

import com.niit.DAO.JobDAO;
import com.niit.Model.ApplyJob;
import com.niit.Model.Blog;
import com.niit.Model.Job;
import com.niit.Model.UserDetail;

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
	
	@PostMapping(value="/addjob")	
	public ResponseEntity<String> addjob(@RequestBody Job job)
	{
		
	/*	job.setDescription("Handle classes");
		job.setCompany("NIIT");*/
	job.setPostdate(new java.util.Date());
	/*		job.setCtc(12000);
		job.setSal(10000);
		job.setLocation("kannur");*/
		
		if(jobDAO.addJob(job))
		{
			return new ResponseEntity<String>("Job Added",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Add Failed",HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping(value="/deletejob/{jobId}")	
	public ResponseEntity<String> deletejob(@PathVariable("jobId") int jobId)
	{
		Job job=(Job)jobDAO.getJob(jobId);
		if(jobDAO.deleteJob(job))
		{
			return new ResponseEntity<String>("Job deletd",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("delete Failed",HttpStatus.NOT_FOUND);
		}
		
	}
	
	 @GetMapping(value="/updatejob/{jobId}")	
		public ResponseEntity<String> updatejob(@PathVariable("jobId") int jobId)
		{
			Job job=(Job)jobDAO.getJob(jobId);
			job.setSal(11000);
			job.setCtc(18000);
			if(jobDAO.updateJob(job))
			{
				return new ResponseEntity<String>("Job updated",HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<String>("update Failed",HttpStatus.NOT_FOUND);
			}  
			
		}
	 
	 @PostMapping(value="/applyJob/{jobId}")
		public ResponseEntity<String> applyJob(@PathVariable("jobId") int jobId,HttpSession session){
			
		 	UserDetail ud= (UserDetail) session.getAttribute("userDetail");
			String loginname=ud.getLoginname(); 
		     System.out.println(jobId);
			ApplyJob ajob=new ApplyJob();
			ajob.setJobId(jobId);
			ajob.setLoginname(loginname);
			ajob.setApplyDate(new java.util.Date());
			if(jobDAO.applyJob(ajob))
			{
				return new ResponseEntity<String>("Job Applied",HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<String>("Apply Failed",HttpStatus.NOT_FOUND);
			}		
					
		}
	 
	 @GetMapping(value="/showmyjobs")
		public ResponseEntity<List<ApplyJob>> showMyJobs(HttpSession session)
		{
			UserDetail ud= (UserDetail) session.getAttribute("userDetail");
			String loginname=ud.getLoginname();
			List<ApplyJob> l=jobDAO.showMyJobs(loginname);
			if(l.size()>0)
			{
				return new ResponseEntity<List<ApplyJob>>(l,HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<List<ApplyJob>>(l,HttpStatus.NOT_FOUND);
			}
			
		}
}
