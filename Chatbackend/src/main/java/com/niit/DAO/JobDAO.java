package com.niit.DAO;

import java.util.List;

import com.niit.Model.ApplyJob;
import com.niit.Model.Job;

public interface JobDAO {

	public boolean addJob(Job job);
	public boolean deleteJob(Job job);
	public boolean updateJob(Job job);	
	public List<Job> listJob();
	public Job getJob(int JobId);
	public boolean applyJob(ApplyJob apjob);
	public List<ApplyJob> showMyJobs(String loginname);
}
