package com.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
public class UpdateStudentDTO {
	 private Long studentId;
	 private String Fname;
	 private String Lname;
	 private String Email;
	 @JsonProperty(value="course_id" ,access=Access.WRITE_ONLY)
	 private Long courseId;
}
