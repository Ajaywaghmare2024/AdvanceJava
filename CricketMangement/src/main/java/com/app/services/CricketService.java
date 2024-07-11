package com.app.services;

import java.util.List;

import com.app.entities.Cricket;
import com.app.entities.Role;

public interface CricketService  {
	//get List of all cricketers
   List<Cricket> getAllCricketer();
   // Add new Cricketer
   void addNewCricketer(Cricket cricket);
   // delete cricketer
   void deleteCricketer(Long Id);
   // update criketers details
   void UpdateCricketer(Cricket cricket);
   // find Cricketer by role
   List<Cricket> getByRole(Role role);
   
   List<Cricket> sortByRole();
   
   
}
