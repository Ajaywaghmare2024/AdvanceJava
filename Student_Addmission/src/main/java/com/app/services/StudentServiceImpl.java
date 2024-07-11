package com.app.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourcesNotFoundException;
import com.app.dto.StudentDTO;
import com.app.dto.UpdateStudentDTO;
import com.app.entities.Course;
import com.app.entities.Student;
import com.app.repositories.CourseRepository;
import com.app.repositories.StudentRepository;
@Service
@Transactional
public class StudentServiceImpl implements StudentService{

	@Autowired 
	private StudentRepository repository;
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private ModelMapper mapper;
	
	@Override
	
	public Student addNewStudent(StudentDTO student) {
	 Course findCourse=courseRepository.findById(student.getCourse_id())
			 .orElseThrow(() -> new ResourcesNotFoundException("course not found") );
	 
	 Student newStudent = mapper.map(student, Student.class);
	 if(findCourse!=null) {
		 newStudent.setCourse(findCourse);
	 }
	 
			 
		return repository.save(newStudent);
	}
	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	@Override
	public List<Student> getByCourseTitle(String title) {
		//Course findCourse=courseRepository.findByTitle(title);
		return repository.findAll().stream()
				.filter(entry->entry.getCourse().getTitle()==title)
				.collect(Collectors.toList());
	}
	@Override
	public Student updateStudent(UpdateStudentDTO updateStudentDTO) {
		Student findStudent=repository.findById(updateStudentDTO.getStudentId())
				.orElseThrow(()->new ResourcesNotFoundException("Student of this Id in not found"));
		         Course findCourse=courseRepository
		        		 .findById(updateStudentDTO.getCourseId())
		        		 .orElseThrow(()->new ResourcesNotFoundException("Course Not found"));
		         
		        findStudent.setCourse(findCourse);
		        findStudent.setEmail(updateStudentDTO.getEmail());
		        findStudent.setFname(updateStudentDTO.getFname());
		        findStudent.setLname(updateStudentDTO.getLname());
		        repository.save(findStudent);
		        return findStudent;
		        
		
	}
	@Override
	public String deleteStudent(Long id) {
	
		 repository.deleteById(id);
		 
		 return "Student Delete Successfull";
	}
	
	

}
