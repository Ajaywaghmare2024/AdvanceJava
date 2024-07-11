package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.persistence.Id;



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
@Table(name="cricketers")
public class Cricket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
	@NotNull
    private String FristName;
	@NotNull
    private String LastName;
    @Enumerated(EnumType.STRING)
    private Role role;
	@NotNull
    private int rating ;
    @NotNull
    private int JersyNo;
    @NotNull
    private LocalDate JoinDate;
    @NotNull
    private int Matches;
    

}
