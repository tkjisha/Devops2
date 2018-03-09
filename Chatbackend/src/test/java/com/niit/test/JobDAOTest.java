package com.niit.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.JobDAO;
import com.niit.Model.Job;

public class JobDAOTest {

	static JobDAO jobDAO;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext annotationConfigAppContext=new AnnotationConfigApplicationContext();
		annotationConfigAppContext.scan("com.niit.*");
		annotationConfigAppContext.refresh();
	
		jobDAO=(JobDAO) annotationConfigAppContext.getBean("jobDAO");
	}
	
	@Test
	public void testaddJob()
	{
		Job j=new Job();
	//	j.setJobId(3);
		j.setDescription("ass");
		j.setDesig("Engr");
		j.setCompany("niit");
		j.setPostdate(new Date(25-02-2018));
		j.setSal(5000);
		j.setCtc(2000);
		j.setLocation("knr");
		
		assertEquals("added",true,jobDAO.addJob(j));
	}
	
/*	@Test
	public void testdeleteJob()
	{
		Job j=jobDAO.getJob(3);
		assertEquals("deleted",true,jobDAO.deleteJob(j));
	}
	
	@Test
	public void testupdateJob()
	{
		Job j=jobDAO.getJob(1);
		j.setDescription("job vacancy");
		assertEquals("updated",true,jobDAO.updateJob(j));
	}
	
	@Test
	public void testlistjob()
	{
		List<Job> l=jobDAO.listJob();
		Iterator li=l.iterator();
		while(li.hasNext())
		{
			Job j=(Job)li.next();
			System.out.print(j.getJobId()+j.getCompany());
		}
	}*/
	
	/*@Test
	public void test() {
		fail("Not yet implemented");
	}*/

}
