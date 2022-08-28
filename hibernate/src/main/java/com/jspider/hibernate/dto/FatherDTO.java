package com.jspider.hibernate.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
public class FatherDTO {
	@ Id
	private int id;
	private String Name;
	private int age;
	@OneToMany
	private List<ChildDTO> Children;
	

}
