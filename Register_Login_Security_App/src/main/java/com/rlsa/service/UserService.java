package com.rlsa.service;

import com.rlsa.entity.User;

public interface UserService 
{
	
	//-----------To Store UNIQUE DATA--------------------( Operation Define )
	
	
	 public boolean checkemail(String email);
	 
	 public boolean checkmobileNo(String mobileNo);
	
	//---------------------------------------------------
	
	 
	 
     // return type   parameter obj ( Method To Store Details in db --> Overide in Impl Class )
	public User saveUser(User user);

	

	
	
	public void removeSessionMessage(); // Create  Method To Remove msg ---> Registration Sucessfull After Registration

}
