package com.app.pojos;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="services")
public class Services {

	private Integer sid;
	private Integer pid;
	private String pname;
	private String serviceType;
	private String location;
	private float rate;
	private String verification;
	private List<Provider> providers=new ArrayList<Provider>();
	private List<Customer> customers=new ArrayList<Customer>();
	
	public Services() {
		System.out.println("in service constr");
	}

	@Id
	@Column(name="Sid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	public Integer getSid() {
		return sid;
	}


	public void setSid(Integer sid) {
		this.sid = sid;
	}

	@Column(name="Service_type",length = 20,nullable = false)
	public String getServiceType() {
		return serviceType;
	}


	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	

	@ManyToMany(mappedBy = "services")
	public List<Provider> getProviders() {
		return providers;
	}

	public void setProviders(List<Provider> providers) {
		this.providers = providers;
	}
	@Column(name="Location",length = 30,nullable = false)
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	@Column(name="Rate",length = 20,nullable = false)
	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	@ManyToMany(mappedBy = "services")
	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
	public String getVerification() {
		return verification;
	}

	public void setVerification(String verification) {
		this.verification = verification;
	}

	@Override
	public String toString() {
		return "Services [sid=" + sid + ", pid=" + pid + ", pname=" + pname + ", serviceType=" + serviceType
				+ ", location=" + location + ", rate=" + rate + ", verification=" + verification + ", providers="
				+ providers + ", customers=" + customers + "]";
	}
	
	
}
