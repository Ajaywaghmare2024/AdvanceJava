package com.app.dto;



import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
	
	 private String Fname;
	 private String Lname;
	 private String Email;
	 @JsonProperty(value="course_id" ,access=Access.WRITE_ONLY)
	 private Long course_id;
}
