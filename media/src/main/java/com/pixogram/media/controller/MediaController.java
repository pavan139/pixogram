package com.pixogram.media.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pixogram.media.entity.Media;
import com.pixogram.media.entity.NewMedia;
import com.pixogram.media.repo.MediaRepo;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/media")
public class MediaController {
	@Autowired
	MediaRepo repo;
	

    @Autowired
    ImageRepository imageRepository;

	
	  @PostMapping("/upload") 
	  public Media createMedia(@RequestBody NewMedia media)
	  { Media med = new Media(media.getUserid(),media.getTitle(),media.getDescription(),media.getTags(),media.getType());
			   if(repo.save(med) != null)
			   {
				   return med;
			   }   
		return null;
		  
	  } 

	  @GetMapping("/mymedia/{id}") 
	  public List<String> myMedia(@PathVariable int id )
	  { 
			   List<Media> m = repo.findByUserid(id);
			   List<String> mn= new  ArrayList<String>();
			   for(int i=0;i<m.size();i++)
			   {
				   mn.add(m.get(i).getTitle());
			   }
			   return mn;
		  
	  } 
	  
	  @GetMapping("/mymedia/{username}") 
	  public List<ImageModel> myMedia(@PathVariable String username )
	  { System.out.println("mymedia");
			   List<ImageModel> m = imageRepository.findByUsername(username);
			   for(int i=0;i<m.size();i++)
			   {
				   
			   }
			   System.out.println();
			   return m;
		  
	  } 
    
}
