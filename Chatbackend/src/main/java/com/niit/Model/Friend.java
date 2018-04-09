package com.niit.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="friend")
public class Friend {

	@Id
	@SequenceGenerator(name = "friendseq",sequenceName="friendseq" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="friendseq")
	int friendId;
	String loginname;
	String friendloginname;
	String status;
	public int getFriendId() {
		return friendId;
	}
	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getFriendloginname() {
		return friendloginname;
	}
	public void setFriendloginname(String friendloginname) {
		this.friendloginname = friendloginname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
