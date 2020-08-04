package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name="admin")
public class Admin {
	private Integer id;
	private String name;
	private String password;
	
	public Admin()
	{
		System.out.println("In Admin Constructor");
	}
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="Name",length = 20,nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name="Password",length = 20,nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + "]";
	}
}
