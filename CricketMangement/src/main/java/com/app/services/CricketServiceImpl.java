package com.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.entities.Cricket;
import com.app.entities.Role;
import com.app.repositories.CricketRepository;

@Service
@Transactional
public class CricketServiceImpl implements CricketService {
	@Autowired
	private CricketRepository cricketRepository;

	@Override
	public List<Cricket> getAllCricketer() {
		
		return cricketRepository.findAll();
	}

	@Override
	public void addNewCricketer(Cricket cricket) {
		cricketRepository.save(cricket);

	}

	@Override
	public void deleteCricketer(Long Id) {
		cricketRepository.deleteById(Id);

	}

	@Override
	public void UpdateCricketer(Cricket cricket) {
		Optional<Cricket> op=cricketRepository.findById(cricket.getId());
		if(op.isPresent()) {
			Cricket crick=op.get();
			crick.setMatches(cricket.getMatches());
			crick.setRole(cricket.getRole());
			crick.setRating(cricket.getRating());
			cricketRepository.save(crick);
		}
		else {
			throw new ResourceNotFoundException("Invalid to update");
		}
	}

	@Override
	public List<Cricket> getByRole(Role role) {
		
		return cricketRepository.findByRole(role);
	}
	@Override
	public List<Cricket> sortByRole() {
		List<Cricket> Cricketlist=cricketRepository.findAll(Sort.by(Sort.Direction.DESC,"role"));
		return Cricketlist;
	}

}
