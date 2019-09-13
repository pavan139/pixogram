package com.pixogram.media.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.pixogram.media.entity.Media;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "check")

public class TestController {

    @Autowired
    ImageRepository imageRepository;

    @PostMapping("/upload")
    public ImageModel uplaodImage(@RequestParam("imagename") String imagename,@RequestParam("username") String username) throws IOException {

        ImageModel img = new ImageModel( "./assets/images/"+imagename,"png",username);


        final ImageModel savedImage = imageRepository.save(img);
        System.out.println("qqq");
        System.out.println(username);
        
        System.out.println("Image saved");


        return savedImage;


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