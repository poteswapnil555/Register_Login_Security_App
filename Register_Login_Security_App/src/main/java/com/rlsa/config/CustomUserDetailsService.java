package com.rlsa.config;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.rlsa.entity.User;
import com.rlsa.repository.UserRepo;

@Component
public class CustomUserDetailsService  implements UserDetailsService
{
	
	
	@Autowired
	private UserRepo userRepo;   //database Authenctication
	
	
	
	//override unimplemented method -(loadUserByUsername) 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		
		
   //--> // To Check Email id given by user is correct or not ( loadUserByUsername)

                 User user = userRepo.findByEmail(username);
		
		if(user==null)
		{
			
			throw new UsernameNotFoundException("User Not Found");
		}
		else
		{
			
			return new CustomUser(user);
		}
	 
	
	
	     
	//-----------------------------------------------------------
	}
}