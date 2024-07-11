package com.app.entities;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Railways")
public class Railway {
	
   @JsonIgnore
   @Id
   @GeneratedValue (strategy = GenerationType.IDENTITY)
   private Long Id;
	
	@NotBlank
   private String Name;
	
   @Enumerated(EnumType.STRING)
   private Category category;
	
   @NotNull
   private LocalTime Start_time;  
   @NotNull
   private LocalTime End_time;
   @NotBlank
   private String Source;
   @NotBlank
   private String Destination;
   @NotBlank
   private String Station_Code;
   @NotNull
    private int Distance;
   @NotBlank
     private String Frequency;
   
   public Long getId() {
		return Id;
	}
   
}
