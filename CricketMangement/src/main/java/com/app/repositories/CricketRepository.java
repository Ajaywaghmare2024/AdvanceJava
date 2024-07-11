package com.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Cricket;
import com.app.entities.Role;

public interface CricketRepository extends JpaRepository<Cricket, Long>{
	
   List<Cricket> findByRole(Role role);
}
