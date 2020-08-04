package com.app.pojos;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="booking")
public class Booking {

	
	private Integer bid;
	private Integer sid;
	private Integer pid;
	private Integer cid;
	private String pname;
	private String cname;
	private Float total_cost;
	//private int guest_count;
	private String status;
	private String service;
	private Date date;
	private Customer customer_booking;
	
	public Booking() {
		System.out.println("in booking constr");
	}
	@Id
	@Column(name="Bid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}
	@Column(name="Total_cost")
	public Float getTotal_cost() {
		return total_cost;
	}
	
	public void setTotal_cost(Float total_cost) {
		this.total_cost = total_cost;
	}
	
	@Column(name="Status",length = 255,nullable = false)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	@Column(name="Service")
	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name="Event_Date")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	@ManyToOne(cascade = { CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name = "book_cust",joinColumns = {@JoinColumn(name="bid")},inverseJoinColumns = { @JoinColumn(name="cid")})
	public Customer getCustomer_booking() {
		return customer_booking;
	}
	public void setCustomer_booking(Customer customer_booking) {
		this.customer_booking = customer_booking;
	}
	
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	public void addCustomer(Customer c)
	{
		//add customer to a provider
		setCustomer_booking(c);
		//add provider to customer
		c.getBookings().add(this);
	}
	public void removeCustomer(Customer c)
	{
		//add customer to a provider
		
		//add provider to customer
		c.getBookings().remove(this);
	}
	
	@Override
	public String toString() {
		return "Booking [bid=" + bid + ", total_cost=" + total_cost + ", status="
				+ status + ", service=" + service + ", date=" + date + "]";
	}
	
	
	
	
}
