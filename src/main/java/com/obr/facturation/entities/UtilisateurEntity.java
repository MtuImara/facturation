package com.obr.facturation.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "utilisateurs")
public class UtilisateurEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",length = 11)
	private Long id;
	
	
	@Column(name = "username",length = 30)
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "utilisateurs_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
		
//	@Column(name = "token")
//	private String token;
	
	public UtilisateurEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UtilisateurEntity(Long id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
//		this.token = token;
	}

	public UtilisateurEntity(String username, String password) {
		super();
		this.username = username;
		this.password = password;
//		this.token = token;
	}
	
		

	@Override
	public String toString() {
		return "UtilisateursModel [id=" + id + ", username=" + username + ", password=" + password + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public String getToken() {
//		return token;
//	}
//
//	public void setToken(String token) {
//		this.token = token;
//	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	

}
