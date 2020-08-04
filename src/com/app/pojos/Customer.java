package com.app.pojos;
import java.util.*;

import javax.persistence.*;


@Entity
@Table(name="customer")
public class Customer {
	private Integer cid;
	private String cname;
	private String password;
	private String address;
	private String contact;
	private String email;
	private List<Provider> providers=new ArrayList<Provider>();
	private List<Booking> bookings=new ArrayList<Booking>();
	private List<Services> services= new ArrayList<Services>(); 
	
	
	public Customer() {
		System.out.println("In Customer Constructor");
	}
	
	@Id
	@Column(name="Cid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	
	@Column(name="Name",length = 20,nullable = false)
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	
	@OneToMany(mappedBy = "customer_booking")
	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name = "cust_prov",joinColumns = @JoinColumn(name="cid"),inverseJoinColumns = @JoinColumn(name="pid"))
	public List<Provider> getProviders() {
		return providers;
	}

	public void setProviders(List<Provider> providers) {
		this.providers = providers;
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
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name="Contact",length = 10,unique=true,nullable = false)
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	@Column(name="Email",length = 30,unique=true,nullable = false)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	/*
	 * @Column(name="Service")
	 * 
	 * @ManyToMany(mappedBy = "customer", cascade=CascadeType.ALL) public
	 * Set<Service> getServices() { return services; }
	 * 
	 * public void setServices(Set<Service> services) { this.services = services; }
	 */

	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name = "cust_serv",joinColumns = @JoinColumn(name="cid"),inverseJoinColumns = @JoinColumn(name="sid"))
	public List<Services> getServices() 
	{
		return services;
	}

	public void setServices(List<Services> services)
	{
		this.services = services;
	}
	public void addProvider(Provider p)
	{
		//add customer to a provider
		//this.getProviders().add(p);
		providers.add(p);
		//add provider to customer
		p.getCustomers().add(this);
	}
	public void removeProvider(Provider p)
	{
		//add customer to a provider
		providers.remove(p);
		//add provider to customer
		p.getCustomers().remove(this);
	}
	public void addServices(Services s)
	{
		//add customer to a provider
		services.add(s);
		//add provider to customer
		s.getCustomers().add(this);
	}
	public void removeServices(Services s)
	{
		//add customer to a provider
		services.remove(s);
		//add provider to customer
		s.getCustomers().remove(this);
	}
	
	
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", address=" + address + ", contact=" + contact
				+ ", email=" + email + "]";
	}
	
}
