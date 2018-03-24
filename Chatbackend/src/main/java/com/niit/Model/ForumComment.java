package com.niit.Model;

import java.util.Date;

public class ForumComment {

	int forumId;
	String forumName;
	String forumComment;
	Date fmCommentDate;
	public int getForumId() {
		return forumId;
	}
	public void setForumId(int forumId) {
		this.forumId = forumId;
	}
	public String getForumName() {
		return forumName;
	}
	public void setForumName(String forumName) {
		this.forumName = forumName;
	}
	public String getForumComment() {
		return forumComment;
	}
	public void setForumComment(String forumComment) {
		this.forumComment = forumComment;
	}
	public Date getFmCommentDate() {
		return fmCommentDate;
	}
	public void setFmCommentDate(Date fmCommentDate) {
		this.fmCommentDate = fmCommentDate;
	}
	
	
}
