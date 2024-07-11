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

import com.app.dto.StudentDTO;
import com.app.dto.UpdateStudentDTO;
import com.app.entities.Student;
import com.app.services.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService service;
	
	@PostMapping
	public Student addStudent(@RequestBody  StudentDTO student) {
		return service.addNewStudent(student);
	}
	@GetMapping
	public List<Student> getAllStduentList(){
		return  service.getAllStudent();
	}
    @GetMapping("/{CourseTitle}")
    public List<Student> GetByTitle(@PathVariable String CourseTitle){
    	return service.getByCourseTitle(CourseTitle);
    } 
    @PutMapping("/{UpdateStudnet}")
    public Student updateStududent(@RequestBody UpdateStudentDTO updateStudentDTO){
    	return service.updateStudent(updateStudentDTO);
    }
    
    @DeleteMapping("/{id}")
    
    public String deleteStudent(Long id) {
    	
    	return service.deleteStudent(id);
    }
}
