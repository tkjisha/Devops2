package com.niit.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Model.Job;

@Repository("jobDAO") @Transactional
public class JobDAOImpl implements JobDAO{

	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	public JobDAOImpl(SessionFactory sessionFactory)
	{
	
		this.sessionFactory=sessionFactory;
	}
	@Override
	public boolean addJob(Job job) {
		try{
			
			sessionFactory.getCurrentSession().persist(job);
			
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean deleteJob(Job job) {
		
		try{
			
			sessionFactory.getCurrentSession().delete(job);
			
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean updateJob(Job job) {
		
		try{
			sessionFactory.getCurrentSession().update(job);
			
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public List<Job> listJob() {
		Session session=sessionFactory.getCurrentSession();
		List lj=null;
		lj=session.createQuery("from Job ").list();
		return lj;
	}

	@Override
	public boolean applyJob() {
		
		return false;
	}
	@Override
	public Job getJob(int JobId) {					
			Job j=null;
			Session session=sessionFactory.getCurrentSession();
			j=(Job) session.get(Job.class, JobId);
			return j;
		
	}

}
