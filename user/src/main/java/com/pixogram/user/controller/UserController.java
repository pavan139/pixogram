package com.pixogram.user.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pixogram.user.entity.NewUser;
import com.pixogram.user.entity.User;
import com.pixogram.user.entity.UserLogin;
import com.pixogram.user.repo.UserRepo;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserRepo repo;
	 @PostMapping(path = "/login")
	    public User login(@RequestBody UserLogin userlogin){
		 User u = new User("1","1","1","1");
		 System.out.println(userlogin.getUsername());
		 System.out.println(userlogin.getPassword());
	      List<User> ur = repo.findByUsernameAndPassword(userlogin.getUsername(), userlogin.getPassword());
	      
	      System.out.println(ur.get(0).getEmail());
	      
	      return ur.get(0);
	        
	    }
	
	 
	  @PostMapping("/register") 
	  public User createUser(@RequestBody NewUser user)
	  { System.out.println("hhww");
		  	 User u =  new User( user.getEmail(),user.getUsername(),user.getPassword(),user.getProfilepicture());
			   if(repo.save(u) != null)
			   {
				   return u;
			   }   
		return null;
		  
	  } 
	  @GetMapping("/followpage/{username}") 
	  public List<User> followpage(@PathVariable String username )
	  { System.out.println("follow");
			   List<User> m = repo.findAllActiveUsers(username);
			   return m;
		  
	  } 
	  
	  
	  
	  @RequestMapping("/getUser/{userid}")
	  public User getuser(@PathVariable Integer id)
	  {
		  
		  Optional<User> object=repo.findById(id);
		 if(object.isPresent())
			 return object.get();
		 else
	      return object.get();
	  }
	  
	  
	  public List<User> follopage(String username)
	  {
		  List<User> m=repo.findAllActiveUsers(username);
		  return m;
	  }
	  
	  
	
	
}
