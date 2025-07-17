package com.rlsa.repository;

import org.springframework.data.jpa.repository.JpaRepository; // We Can Use Methods 

import com.rlsa.entity.User;

//jpaRepository interface ( Provides Extra Functionality ) extends CRUD Repository interface ( Provides Functionality )             
public interface UserRepo extends JpaRepository<User , Integer>
                                            // class , User id type // Implementation automatically provided by Spring
{

	//-----------To Store UNIQUE DATA----------------------( Use method- existsBy )
	
	public boolean existsByemail(String email);
	
	public boolean existsBymobileNo(String mobileNo);
	
	//------------------------------------------------------
	
	
	public User findByEmail(String email);   //  // Custom Query ( Login Process )
}
