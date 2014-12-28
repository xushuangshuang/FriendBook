package com.xu.friendBook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("user")
public class FriendsList {

	 @RequestMapping(value = "/list", method = RequestMethod.GET) 
	 public String friendList() {
		 return null;
	 }
	
}
