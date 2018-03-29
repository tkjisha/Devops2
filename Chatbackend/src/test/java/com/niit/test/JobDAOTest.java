package com.niit.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
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
	
	@Ignore
	@Test
	public void testaddJob()
	{
		
		Job j=new Job();
		j.setDescription("hardware engineer");
		j.setDesig("Engineerr");
		j.setCompany("TCS");
		java.sql.Date sdt=null;
		SimpleDateFormat dtformat=new SimpleDateFormat("MM/dd/yyyy");
		try {
		java.util.Date dt=dtformat.parse("22/03/2018");
			
			sdt = new java.sql.Date(dt.getTime());
		} catch (ParseException e) {
			
			e.printStackTrace();
		} 
		j.setPostdate(sdt);
		j.setSal(5000);
		j.setCtc(2000);
		j.setLocation("knr");
		
		assertEquals("added",true,jobDAO.addJob(j));
	}
	
	@Ignore
	@Test
	public void testdeleteJob()
	{
		Job j=jobDAO.getJob(3);
		assertEquals("deleted",true,jobDAO.deleteJob(j));
	}
	
	@Ignore
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
	}
	
	@Ignore	
	@Test
	public void testgetJob()
	{
		  
		Job j=jobDAO.getJob(6250);
		System.out.println(j.getDesig()+","+j.getLocation()+","+j.getDescription());
	}
	
	@Ignore
	@Test
	public void testapplyJob()
	{
		
	}
	
	@Ignore
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
