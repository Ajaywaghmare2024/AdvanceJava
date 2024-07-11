package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Course;
import com.app.repositories.CourseRepository;
@Service
@Transactional
public class CourseServiceImpl implements CourseService {
	@Autowired
   private CourseRepository courseRepository;
	@Override
	public Course addNewCource(Course course) {
		
		
		return courseRepository.save(course);
	}
	@Override
	public List<Course> GetAllCource() {
		// TODO Auto-generated method stub
		return courseRepository.findAll();
	}

}
