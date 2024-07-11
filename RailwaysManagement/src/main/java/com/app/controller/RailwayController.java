package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Category;
import com.app.entities.Railway;
import com.app.services.RailwayService;

@RestController
@RequestMapping("/railways")
public class RailwayController {
	
     @Autowired
     private RailwayService railwayService;
     
     @GetMapping("/getAllDetails")
     public List<Railway> getAllDetails(){
    	 return railwayService.getAllDetails();
     }
     @PostMapping("/addDetails")
     public Railway addDetails(@RequestBody Railway railway) {
    	 return railwayService.addDetails(railway);
     }
     @GetMapping("/{category}")
    	
     public List<Railway> GetByCategory(@PathVariable Category category){
    	 return railwayService.getByCategory(category);
     }
     
     @DeleteMapping("/{id}")
     public void DeleteById(Long Id) {
    	 railwayService.deleteRailway(Id);
     }
     
     @PutMapping("/{id}")
     public void UpdateDetails(@PathVariable Long id,@RequestBody Railway rail) {
    	 rail.setId(id);
    	 railwayService.updateDetails(rail);
     }
     
     @GetMapping("/sort")
      public List<Railway> sortCategory(){
    	 return railwayService.sortByCategory();
     }
     
}
