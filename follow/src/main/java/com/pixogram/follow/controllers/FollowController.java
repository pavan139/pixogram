package com.pixogram.follow.controllers;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pixogram.follow.entity.Follow;
import com.pixogram.follow.entity.NewFollow;
import com.pixogram.follow.repo.FollowRepo;




@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/follow")
public class FollowController {
	@Autowired
	FollowRepo repo;
	
	 
	  @Transactional
	  @PostMapping("/delete") 
	  public int deleteFollower(@RequestBody Follow follow)
	  { 
			  long x= repo.deleteByUsernameAndFollowername(follow.getUsername(), follow.getFollowername());
		  return (int)x;
	  } 
	  @Transactional
	  @PostMapping("/followuser")
	    public void followuser(@RequestParam("username") String username,@RequestParam("followername") String followername) throws IOException {
		  	
		  	Follow fol= new Follow(username,followername,"active");
		  repo.save(fol);
			  
	    }
	  
	  
	  @GetMapping("/follower/{username}") 
	  public List<Follow> follow(@PathVariable String username )
	  { 
			   List<Follow> m = repo.findByUsername(username);
		       
			   return m;
		  
	  } 
	  
	  
	
}
