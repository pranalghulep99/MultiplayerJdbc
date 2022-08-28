package com.jspider.hibernate.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class HusbandDTO {
	@Id
	private int hId;
	private String hName;
	private int hAge;
	@OneToOne
	private WifeDTO wifeDTO;
	

}
