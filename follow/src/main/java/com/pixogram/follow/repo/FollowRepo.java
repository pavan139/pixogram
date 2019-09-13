package com.pixogram.follow.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pixogram.follow.entity.Follow;
@Repository
public interface FollowRepo extends JpaRepository<Follow, Integer>{
	long deleteByUsernameAndFollowername(String username,String followername);

	List<Follow> findByUsername(String username);
	
}
