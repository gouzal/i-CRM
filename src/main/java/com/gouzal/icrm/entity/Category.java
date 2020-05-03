package com.gouzal.icrm.entity;

import javax.persistence.*;

import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;

	@ManyToOne(optional=true, fetch=FetchType.LAZY)
	private Category category;
}
