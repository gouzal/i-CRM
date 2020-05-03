package com.gouzal.icrm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String CompanyName;
	private String legalType;
	private String mobileNumber;
	private String fixNumber;
	private String email;
	private String ice;
	private String address;
	
    @ManyToOne
	private City city;
	
}
