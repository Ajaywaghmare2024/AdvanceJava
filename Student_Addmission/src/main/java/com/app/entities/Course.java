package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="courses")

public class Course {
	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long Course_Id;
	@Column(name="Title", length=20)
       private String Title;
	@Column(name="StartDate", length=20)
       private LocalDate start_date;
	@Column(name="LastDate", length=20)
       private LocalDate end_date;
	
       private double fees;
       
       @Column(name="MinScore", length=20)
       private double min_score;
       
}
