/*package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name="provider_Services")
public class ProviderServices {
	
	private Integer Id;
	private String location;
	private int rate;
	
	public ProviderServices() {
		System.out.println("in a ps constr");
	}
	@Column(name="Location",length = 20,nullable = false)
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	@Column(name="Rate",length = 20,nullable = false)
	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "ProviderServices [location=" + location + ", rate=" + rate + "]";
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	
	

}
*/