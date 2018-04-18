package com.niit.Config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.DAO.BlogDAOImpl;
import com.niit.DAO.ForumDAOImpl;
import com.niit.DAO.FriendDAOImpl;
import com.niit.DAO.JobDAOImpl;
import com.niit.DAO.UserDetailDAOImpl;
import com.niit.DAO.UsersDAOImpl;

@Configuration
@ComponentScan("com.niit.*")
@EnableTransactionManagement
public class DBConfig {
	
	public DataSource getDataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("hr");
		dataSource.setPassword("hr");
		System.out.println("data prop");
		return dataSource;
	}
	
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionfactory()
	{
		Properties hibProp=new Properties();
		hibProp.put("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
		hibProp.put("hibernate.hbm2.ddl.auto","update" );
		hibProp.put("hibernate.show_sql", "true");
		System.out.println("Data created");
		LocalSessionFactoryBuilder localSessionFacBuilder=new LocalSessionFactoryBuilder(getDataSource());
		localSessionFacBuilder.addProperties(hibProp);
		localSessionFacBuilder.addAnnotatedClass(com.niit.Model.Blog.class);
		localSessionFacBuilder.addAnnotatedClass(com.niit.Model.Forum.class);
		localSessionFacBuilder.addAnnotatedClass(com.niit.Model.Job.class);
		localSessionFacBuilder.addAnnotatedClass(com.niit.Model.Users.class);
		localSessionFacBuilder.addAnnotatedClass(com.niit.Model.BlogComment.class);
		localSessionFacBuilder.addAnnotatedClass(com.niit.Model.ForumComment.class);
		localSessionFacBuilder.addAnnotatedClass(com.niit.Model.UserDetail.class);
		localSessionFacBuilder.addAnnotatedClass(com.niit.Model.Friend.class);
		localSessionFacBuilder.addAnnotatedClass(com.niit.Model.ProfilePicture.class);
		localSessionFacBuilder.addAnnotatedClass(com.niit.Model.ApplyJob.class);
		SessionFactory sessionFactory=localSessionFacBuilder.buildSessionFactory();
		System.out.println("Session Factory Object Created");
		return sessionFactory;
	}
 
	@Autowired
	@Bean(name="transactionManager")	
	 public HibernateTransactionManager gettrans(SessionFactory sf)
	 {
		 HibernateTransactionManager tm=new HibernateTransactionManager(sf);
		 return tm;
	 }
	
	@Autowired
	@Bean(name="blogDAOImpl")
	public BlogDAOImpl getblogData(SessionFactory sf)
	{
		return new BlogDAOImpl(sf);
	}
	
	@Autowired
	@Bean(name="forumDAOImpl")
	public ForumDAOImpl getforumData(SessionFactory sf)
	{
		return new ForumDAOImpl(sf);
	}
	
	@Autowired
	@Bean(name="jobDAOImpl")
	public JobDAOImpl getjobData(SessionFactory sf)
	{
		return new JobDAOImpl(sf);
	}
	
	@Autowired
	@Bean(name="usersDAOImpl")
	public UsersDAOImpl getuserData(SessionFactory sf)
	{
		return new UsersDAOImpl(sf);
	}
	
	@Autowired
	@Bean(name="userDetailDAOImpl")
	public UserDetailDAOImpl getuserDetailsDAO(SessionFactory sf)
	{
		return new UserDetailDAOImpl(sf);
	}
	
	@Autowired
	@Bean(name="friendDAOImpl")
	public FriendDAOImpl getfriendDAO(SessionFactory sf)
	{
		return new FriendDAOImpl(sf);
	}
}
