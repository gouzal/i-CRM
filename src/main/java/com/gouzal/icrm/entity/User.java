package com.gouzal.icrm.entity;

import javax.persistence.*;

import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected long id;
	private String prefix;
	private String firstName;
	private String lastName;
	private String login;
	private String password;
	private boolean active;
	private String avatar;
	private String poste;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role")
	private List<Role> roles;


}
