package com.niit.restcontroller;

import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

import com.niit.Model.Message;
import com.niit.Model.OutputMessage;

public class ChatController {

	@MessageMapping("/chat")
	@SendTo("/topic/message")
	public OutputMessage sendMessage(Message message)
	{
		return new OutputMessage(message,new Date());
	}
}
