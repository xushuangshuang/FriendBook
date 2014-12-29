package com.xu.friendBook.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xu.friendBook.formModel.Friends;
import com.xu.friendBook.service.FriendsService;

@Controller
@RequestMapping("/user")
public class FriendsList {

	 private FriendsService service;
	 
	 @Autowired
	 public  FriendsList(FriendsService service) {
		 this.service = service;
	 }
	 
	 @RequestMapping(value = "/list", method = RequestMethod.GET) 
	 public ModelAndView friendList() {
		 
		 Map<String, Friends> modelUser = service.getAllFriendsMap();
		 
		 ModelAndView mv = new ModelAndView();
		 mv.addAllObjects(modelUser);
		 mv.setViewName("userList");
		 return mv;
	 }
	
}
