package com.library.controller;
import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.web.bind.annotation.RequestBody;    
import org.springframework.web.bind.annotation.RequestMapping;    
import org.springframework.web.bind.annotation.RequestMethod;    
import org.springframework.web.bind.annotation.RestController;

import com.library.model.UserRecord;
import com.library.service.UserService;

import java.util.List; 

@RestController    
public class UserController   
{    
@Autowired    
private UserService userService;     
@RequestMapping("/")    
public List<UserRecord> getAllUser()  
{    
return userService.getAllUsers();    
}       
@RequestMapping(value="/add-user", method=RequestMethod.POST)    
public void addUser(@RequestBody UserRecord userRecord)  
{    
userService.addUser(userRecord);    
}       

@RequestMapping(value="/check", method=RequestMethod.GET)    
public String check()  
{    
return "check";
}   

@RequestMapping(value="/getAllUsers", method=RequestMethod.GET)    
public List<UserRecord> getAllUsers()  
{    
return userService.getAllUsers();
}   
}    