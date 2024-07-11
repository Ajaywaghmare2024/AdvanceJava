package com.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Category;
import com.app.entities.Railway;

public interface RailwayRepository extends JpaRepository<Railway, Long> {
	
   List<Railway> findByCategory(Category category);

         
}
