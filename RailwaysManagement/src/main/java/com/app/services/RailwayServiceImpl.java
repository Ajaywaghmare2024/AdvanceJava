package com.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourcesNotFoundException;
import com.app.entities.Category;
import com.app.entities.Railway;
import com.app.repositories.RailwayRepository;
@Service
@Transactional
public class RailwayServiceImpl implements RailwayService{
	
	
     @Autowired
     private RailwayRepository railwayRepository;
     
     
	@Override
	public List<Railway> getAllDetails() {
		
		return railwayRepository.findAll();
	}

	@Override
	public Railway addDetails(Railway railway) {
		
		return railwayRepository.save(railway);
	}

	@Override
	public void deleteRailway(Long id) {
		
		railwayRepository.deleteById(id);
		
	}

	@Override
	public void updateDetails(Railway railway) {
		Optional<Railway> op=railwayRepository.findById(railway.getId());
		if(op.isPresent()) {
			Railway rail=op.get();
			rail.setName(railway.getName());
			//rail.setStart_time(railway.getStart_time());
			rail.setEnd_time(railway.getEnd_time());
			rail.setCategory(railway.getCategory());
		       railwayRepository.save(rail);
		}
		else {
			throw new ResourcesNotFoundException("invlaid to update");
		}
	}

	

	@Override
	public List<Railway> getByCategory(Category category) {
		// TODO Auto-generated method stub
		return railwayRepository.findByCategory(category);
	}

	@Override
	public List<Railway> sortByCategory() {
		List<Railway> railList=railwayRepository.findAll(Sort.by("category"));
		return railList;
	}

}
