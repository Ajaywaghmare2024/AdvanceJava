package com.app.services;

import java.util.List;

import com.app.entities.Category;
import com.app.entities.Railway;

public interface RailwayService {
    List<Railway> getAllDetails();
    
    Railway addDetails(Railway railway);
    
    void deleteRailway(Long id);
    
     void updateDetails(Railway ralRailway);
    
    List<Railway> getByCategory(Category category);
    
    List<Railway> sortByCategory();
}
