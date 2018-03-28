package com.niit.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="forumcomment")
public class ForumComment {

	@Id
	@SequenceGenerator(name = "forumcommentseq",sequenceName="forumcommentseq" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="forumcommentseq")
	int fcommentId;	
	String fcommentText;
	String loginname;
	int forumId;
	Date fmCommentDate;
	
	public int getFcommentId() {
		return fcommentId;
	}
	public void setFcommentId(int fcommentId) {
		this.fcommentId = fcommentId;
	}
	
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getFcommentText() {
		return fcommentText;
	}
	public void setFcommentText(String fcommentText) {
		this.fcommentText = fcommentText;
	}
	public int getForumId() {
		return forumId;
	}
	public void setForumId(int forumId) {
		this.forumId = forumId;
	}
	public Date getFmCommentDate() {
		return fmCommentDate;
	}
	public void setFmCommentDate(Date fmCommentDate) {
		this.fmCommentDate = fmCommentDate;
	}
	
	
}
