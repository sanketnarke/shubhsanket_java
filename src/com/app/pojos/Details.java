package com.app.pojos;
import javax.persistence.*;

@Entity
@Table(name="details")
public class Details {

	private Integer sid;
	private Integer did;
	private Integer pid;
	private String pname;
	private String city;
	private String address;
	private String sname;
	private Double rate;
	private String readdtls;
	private String imageurl1;
	private String imageurl2;
	private String imageurl3;
	
	
	public Details() {
		System.out.println("in Details pojo constr");
	}
	
	/*public Details(Integer sid, Integer did, Integer pid, String pname, String city, String address, String sname,
			Double rate, String read, String imageurl1, String imageurl2, String imageurl3) {
		super();
		this.sid = sid;
		this.did = did;
		this.pid = pid;
		this.pname = pname;
		this.city = city;
		this.address = address;
		this.sname = sname;
		this.rate = rate;
		this.read = read;
		this.imageurl1 = imageurl1;
		this.imageurl2 = imageurl2;
		this.imageurl3 = imageurl3;
	}*/

	
	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}
	@Column(length = 255)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	@Column(length = 255)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name="sid" ,unique=true)
	public Integer getSid() {
		return sid;
	}
	
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	@Id
	@Column(name="did")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
	@Column(length = 255)
	public String getReaddtls() {
		return readdtls;
	}
	public void setReaddtls(String readdtls) {
		this.readdtls = readdtls;
	}
	@Column(length = 255)
	public String getImageurl1() {
		return imageurl1;
	}
	public void setImageurl1(String imageurl1) {
		this.imageurl1 = imageurl1;
	}
	@Column(length = 255)
	public String getImageurl2() {
		return imageurl2;
	}
	public void setImageurl2(String imageurl2) {
		this.imageurl2 = imageurl2;
	}
	@Column(length = 255)
	public String getImageurl3() {
		return imageurl3;
	}
	public void setImageurl3(String imageurl3) {
		this.imageurl3 = imageurl3;
	}

	@Override
	public String toString() {
		return "Details [sid=" + sid + ", did=" + did + ", pid=" + pid + ", pname=" + pname + ", city=" + city
				+ ", address=" + address + ", sname=" + sname + ", rate=" + rate + ", read=" + readdtls + ", imageurl1="
				+ imageurl1 + ", imageurl2=" + imageurl2 + ", imageurl3=" + imageurl3 + "]";
	}
	
	
	
}
