
package com.rlsa.controller;

import java.security.Principal;  

import org.springframework.beans.factory.annotation.Autowired;   
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rlsa.entity.User;
import com.rlsa.repository.UserRepo;
import com.rlsa.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;



@Controller                                // To Accept And Handle All The Request
public class HomeController
{

	//----------------------------------------
	
	
	@Autowired
	private UserService userService;         // Method call ---> Create obj
	
	
	@Autowired                            
	private UserRepo userRepo;
	
	
	
	//-----------------To Remove register , login when we go inside profile page
	
	 @ModelAttribute
	 public void commonUser( Principal p , Model model)
	{
			  if( p != null)
			  {
				  
				  String email = p.getName();
				   
				   User user = userRepo.findByEmail(email);
				   
				   model.addAttribute("user",user);
				   
			  }
			  		   		
    }
	
    //-----------------------Index----------------------------
	 
	
	@GetMapping("/")                           // It Reads The Resource
	public String index(Model model)          // model --> To Send data To Template
	{
		model.addAttribute("title", "Home - User Management App");
		return "index";                        // return view
	}
	
	
	
//----------------------------Register----------------------------------------------------------------------------------------------------------------------	
	
	
	
	@GetMapping("/register")
	public String register(Model model) 
	{
		model.addAttribute("title", "Register - User Management App");
		model.addAttribute("user", new User());
		return "register";
	}	
	
	
	
//--------------------------Register---------------------------------------------
	
	
	@PostMapping("/register")
	public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) 
	{
		                                     // @ModelAttribute  --> To Get Value
		
		
		//-----------To Store UNIQUE DATA-------------
		
	    boolean emailExists = userService.checkemail(user.getEmail());
	    boolean mobileExists = userService.checkmobileNo(user.getMobileNo());

	    if (emailExists) 
	    {
	        session.setAttribute("msg", "Email Id Already Exists");
	    } else if (mobileExists) 
	    {
	        session.setAttribute("msg", "Mobile Number Already Exists");
	    } else
	    {
	    	
	        // If there are validation errors, return to the registration page
	        if (result.hasErrors())
	        {
	            return "register";
	        }

	        try 
	        {
	            // Save the user if no errors & Returns Obj
	            userService.saveUser(user);
	            model.addAttribute("user", new User()); // Clear the form after successful registration
	            session.setAttribute("msg", "Registration successful !!");
	            return "redirect:/register"; // Redirect to the registration page to clear the form
	        } catch (Exception e) 
	        {
	            e.printStackTrace();
	            session.setAttribute("msg", "Registration failed !! : " + e.getMessage());
	        }
	    }

	    return "redirect:/register"; // Redirect to the registration page in case of any error
	}

	
	
//----------------------------Login------------------------------------------------------------------------------------------------------------	
	
	
	@GetMapping("/signin")
	public String login(Model model) 
	{
		model.addAttribute("title", "Login - User Management App");
		return "login";
	}


    
    
    @PostMapping("/saveUser") 
	public String saveUser(@ModelAttribute User user , HttpSession session ) 
	{                                                                                               
		
		User u = userService.saveUser(user);  
		
		

		return "signin";       
		 
	}

//-----------------------------------------------------------------------------------------------------------------------------------------------------
	
}
