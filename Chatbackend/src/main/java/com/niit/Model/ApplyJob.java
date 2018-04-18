package com.niit.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="applyjob")
public class ApplyJob {

	@Id	
	@SequenceGenerator(name = "applyjobseq",sequenceName="applyjobseq" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="applyjobseq")
	@Column(name="applid", columnDefinition="integer")
	int applId;
	int jobId;
	String loginname;
	Date applyDate;
	public int getApplId() {
		return applId;
	}
	public void setApplId(int applId) {
		this.applId = applId;
	}
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public Date getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	
	
}
