package com.rlsa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  // It Is Doing Work Of 3 Annotations ( Make Config Class, EnableAutoConfig , Component Scan )
public class RegisterLoginSecurityAppApplication 
{

	
	public static void main(String[] args) 
	{
		SpringApplication.run(RegisterLoginSecurityAppApplication.class, args);
	}
	
    
/*  BootStraping Class 
  run method is Used to start  Spring application and ready to handle requests
  or perform other tasks based on the application's configuration and components.*/
	
}
