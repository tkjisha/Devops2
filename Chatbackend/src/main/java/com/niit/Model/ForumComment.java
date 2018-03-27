package com.niit.Model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class ForumComment {

	@Id
	@SequenceGenerator(name = "forumcommentseq",sequenceName="forumcommentseq" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="forumcommentseq")
	int fcommentId;	
	String fcommentText;
	String loginame;
	int forumId;
	Date fmCommentDate;
	
	public int getFcommentId() {
		return fcommentId;
	}
	public void setFcommentId(int fcommentId) {
		this.fcommentId = fcommentId;
	}
	
	public String getLoginame() {
		return loginame;
	}
	public void setLoginame(String loginame) {
		this.loginame = loginame;
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
