package com.pixogram.user;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pixogram.user.controller.UserController;
import com.pixogram.user.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserApplicationTests {

	private static UserController controller;
	@BeforeClass
	public static void setup()
	{
		controller = new UserController();
	}
	
	@Test
	public void contextLoads() {
		
	}
	
	@Test
	public void checkReturnvalue()
	{
		User object=controller.getuser(1);
	}
	
	
	
	
	

}
