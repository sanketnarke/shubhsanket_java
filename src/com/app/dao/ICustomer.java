package com.app.dao;

import java.util.List;

import com.app.pojos.Booking;
import com.app.pojos.Customer;
import com.app.pojos.Provider;
import com.app.pojos.Services;

public interface ICustomer {
	public Customer auntheticateUser(String email, String pwd);
	public String RegisterCustomer(Customer c);
	public String Book(Booking b);
	public void addProvider(Provider p);
	public void removeProvider(Provider p);
	public void addServices(Services s);
	public void removeServices(Services s);
	public List<Services> SearchServices(String location,String serviceType);
	public List<Booking> history(int cid);
	public String resetpassword(Customer c,String email, String pass, String cpass);
	public List<String> placelist(Services s);
	public List<String> servicelist(Services s);
}
