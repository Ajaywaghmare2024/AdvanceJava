package com.app.services;

import java.util.List;

import com.app.dto.StudentDTO;
import com.app.dto.UpdateStudentDTO;
import com.app.entities.Student;

public interface StudentService {

	Student addNewStudent(StudentDTO student);
	
	List<Student> getAllStudent();
	
	List<Student> getByCourseTitle(String title);
	
	Student updateStudent(UpdateStudentDTO updateStudentDTO);
	
	String deleteStudent(Long id);
}
