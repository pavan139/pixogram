package com.pixogram.user.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pixogram.user.entity.User;


@Repository
public interface UserRepo  extends JpaRepository<User, Integer>{
	List<User> findByUsernameAndPassword(String username,String password);
	
	@Query("SELECT u FROM User u WHERE u.username != ?1")
	List<User> findAllActiveUsers(String username);
}
