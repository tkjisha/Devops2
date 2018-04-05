package com.niit.Model;

import java.util.Date;

public class OutputMessage extends Message {
	
	private Date MessageTime;
	public OutputMessage(Message original,Date msgTime)
	{
		this.setId(original.getId());
		this.setMessage(original.getMessage());
	}
	public Date getMessageTime() {
		return MessageTime;
	}
	public void setMessageTime(Date messageTime) {
		MessageTime = messageTime;
	}

	
}
