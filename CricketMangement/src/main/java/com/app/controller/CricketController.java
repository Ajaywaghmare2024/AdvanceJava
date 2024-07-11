package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Cricket;
import com.app.entities.Role;
import com.app.services.CricketService;
@RestController
@RequestMapping("/cricket")

public class CricketController {
	@Autowired
	private CricketService cricketService;
	
	@GetMapping("/getAllCrick")
	public List<Cricket> getAllCrick(){
		return cricketService.getAllCricketer();
	}
     
	@PostMapping("/addCricketer")
	public void addNewCricketer(@RequestBody Cricket cricket) {
		 cricketService.addNewCricketer(cricket);
	}
	
	@DeleteMapping("/id")
	public void deleteById(Long Id) {
		cricketService.deleteCricketer(Id);
	}
	
	@GetMapping("/{role}")
	
	public List<Cricket> getByRole(@PathVariable Role role){
		return cricketService.getByRole(role);
	}
	
	@PutMapping("/{id}")
	public void updateCricketer(@PathVariable Long id,@RequestBody Cricket cricket) {
		cricket.setId(id);
		cricketService.UpdateCricketer(cricket);
	}
	@GetMapping("/sortRole")
	public List<Cricket> sortRole(){
		return cricketService.sortByRole();
	}
}
