package com.app.pojos;

import java.util.*;

import javax.persistence.*;


@Entity
@Table(name="provider")
public class Provider {
	private Integer pid;
	private String email;
	private String pname;
	private String password;
	private String Address;
	private String contact;
	private List<Customer> customers=new ArrayList<Customer>();
	private List<Services> services=new ArrayList<Services>();
	
	//private Set<Service> services = new HashSet<Service>();;
//	private Set<Customer> customers= new HashSet<Customer>();;
	public Provider() {
		System.out.println("In Provider Constructor");
	}

	@Id
	@Column(name="Pid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	@Column(name="Email",length = 30,unique=true,nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="Name",length = 20,nullable = false)
	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}
	@Column(name="Password",length = 20,nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="Address",length = 30,nullable = false)
	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}
	@Column(name="Contact",length = 10,unique=true)
	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	
	/*
	 * @Column(name="Services")
	 * 
	 * @ManyToMany(mappedBy = "providers", cascade=CascadeType.ALL) public
	 * Set<Service> getServices() { return services; }
	 * 
	 * public void setServices(Set<Service> services) { this.services = services; }
	 */
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name = "prov_serv",joinColumns = @JoinColumn(name="pid"),inverseJoinColumns = @JoinColumn(name="sid"))
	public List<Services> getServices() {
		return services;
	}

	public void setServices(List<Services> services) {
		this.services = services;
	}

	@ManyToMany(mappedBy = "providers")
	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
	public void addServices(Services s)
	{
		//add services to a provider
		services.add(s);
		//add provider to services
		s.getProviders().add(this);
	}
	public void removeServices(Services s)
	{
		//add services to a provider
		services.remove(s);
		//add provider to services
		s.getProviders().remove(this);
	}
	
	@Override
	public String toString() {
		return "Provider [pid=" + pid + ", email=" + email + ", pname=" + pname + ", Address=" + Address + ", contact="
				+ contact + "]";
	}

	
}
