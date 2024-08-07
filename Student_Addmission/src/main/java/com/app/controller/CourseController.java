package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Course;
import com.app.services.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {
	@Autowired
   private CourseService courseService;
	
	@PostMapping
	public Course addNewCourse(@RequestBody Course course) {
		return courseService.addNewCource(course);
	}
	
	@GetMapping
	public List<Course> getAllCourse(){
		return courseService.GetAllCource();
	}

}
