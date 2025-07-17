package com.rlsa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data                        // Lombok --> Java Libreay Tool ( To Remove & Minimize ) Boilerplate Code  ( @Getter , @Setter , @AllArgsConstructor , @ToString() )
@Entity                      // Hibernate Will Automatically Create Table In db
public class User 
{
		

		    @Id                                                  // Primary Key
			@GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto Generated
			private int id;
			  
		    
		    
		    
		    @NotBlank(message = "Name field is required !!")
			@Size(min = 2,max = 20,message = "min 2 and max 20 characters are allowed !!")
			private String  name;
			    
		    
		    
		    @NotBlank(message = "Email is required !!")
		    @Email(message = "Invalid email format")
			private String email;
			   
		    
		    
		    @Pattern(regexp = "\\d{10}", message = "Mobile number must be 10 digits")
			private String mobileNo;		     
			 
		    
		    
		    @NotBlank(message = "Password is required !!")
			private String password;
			   
		    
		    
			private String role;

     }

