package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="students")

public class Student {
	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long Student_Id;
	@Column(name="First_Name", length=20)
      private String Fname;
	@Column(name="Last_Name", length=20)
      private String Lname;
	
	@Column(name="Email",unique = true)
      private String Email;
	
	
      private double Score;
      
      @ManyToOne 
      @JoinColumn (nullable = false)
      private Course course;
      
}
