
package com.rlsa.config;

import java.util.Arrays;  
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.rlsa.entity.User;


public class CustomUser implements UserDetails                                                                                      //( Inbuild interface ) --> Provide Inbuild Methods
{

	private User user;                                                                                                                          // Pass User Class(entity) -->  obj
	

	

	//---------------------------------------------Generate Constructor using field
	
			public CustomUser(User user) 
			{
				super();
				this.user = user;
			}
		
	



	//------------Override unimplemented methods 
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities()                                        // Role Provide ( getAuthorities Need Collection Type --->  Arrays ( Class ) )
	{
		
     SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());                   // get role
		
		return Arrays.asList(authority);                                                                             // Convert Authority Into List

	}

	@Override
	public String getPassword()
	{
		
		return user.getPassword();                                                                                  // get password from user
	}

	@Override
	public String getUsername() 
	{
		
		return user.getEmail();                                                                                        // get email from user
	}

	@Override
	public boolean isAccountNonExpired()
	{
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked()
	{
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() 
	{
		
		return true;
	}

	@Override
	public boolean isEnabled()
	{
		
		return true;
	}

			
}
