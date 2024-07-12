package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.aspectj.weaver.ast.Not;
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name="books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id;
	@NotNull
  private String Name;
	@NotNull
  private String Author;
	@NotNull
  private LocalDate Publish_date;
	@NotNull
	
  private double price;
	@NotNull
  private int Quantity;
	
  @Enumerated(EnumType.STRING)
  
  private Category category;
  
  
}
