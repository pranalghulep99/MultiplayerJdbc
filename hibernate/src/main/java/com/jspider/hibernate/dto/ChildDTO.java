package com.jspider.hibernate.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ChildDTO {
	@Id
	private int Id;
	private String Name;
	private int Age;

	
}
