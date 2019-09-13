package com.pixogram.media.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pixogram.media.entity.Media;


@Repository
public interface MediaRepo  extends JpaRepository<Media, Integer>{

	
	List<Media> findByUserid(int id);
}
