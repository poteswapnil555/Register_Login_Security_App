package com.rlsa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.rlsa.entity.User;
import com.rlsa.repository.UserRepo;

import jakarta.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService // implements ---> abstract methods to override
{

	
	//-----------To Store UNIQUE DATA--------------Override Here - implement method
	
	@Override
	public boolean checkemail(String email)
	{
		
		return userRepo.existsByemail(email);    // method call & id pass
	}

	@Override
	public boolean checkmobileNo(String mobileNo) 
	{
		
		return userRepo.existsBymobileNo(mobileNo);  // method call & id pass
	}

	
	//--------------------------------------------------
	
	
	@Autowired
	private UserRepo userRepo; // obj Is Created Automatically

	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;   // to store in Encrypted form
	
		
	
	
	@Override
	public User saveUser(User user) // Click on Error & Add Unimplemented methods
	{

		
		//------------------------------------------------
		

				String password = passwordEncoder.encode(user.getPassword());
				
				user.setPassword(password);
				
				user.setRole("ROLE_USER");


		//-------------------------------------------------
		
		
		
		User newuser = userRepo.save(user); // obj pass , return user obj & save

		return newuser;
		
		
	}

	
	
	// -----------Override Method

	@Override
	public void removeSessionMessage()
	{

		HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest().getSession();

		session.removeAttribute("msg");

	}

}
