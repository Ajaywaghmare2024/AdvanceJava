package com.app.services;

import java.util.List;

import com.app.entities.Course;

public interface CourseService {
  Course addNewCource(Course course);
  
  List<Course> GetAllCource();
}
