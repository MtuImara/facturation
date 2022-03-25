package com.obr.facturation.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;



@Entity
@Table(name = "role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",length = 11)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	//@Column(length = 20)
	@JoinTable(	name = "user_roles", 
	joinColumns = @JoinColumn(name = "role_id"), 
	inverseJoinColumns = @JoinColumn(name = "utilisateurs_id"))
	private LesRoles name;

	public Role() {
		super();
	}	

	public Role(LesRoles name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LesRoles getName() {
		return name;
	}

	public void setName(LesRoles name) {
		this.name = name;
	}
	
	
	
	

}
