package com.gouzal.icrm.entity;

import javax.persistence.*;

import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
//@AllArgsConstructor
public class User extends Person {

	private String login;
	private String password;
	private boolean active;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role")
	private List<Role> roles;

}
