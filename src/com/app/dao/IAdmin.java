package com.app.dao;

import java.util.List;

import com.app.pojos.Admin;
import com.app.pojos.Booking;
import com.app.pojos.Customer;
import com.app.pojos.Provider;
import com.app.pojos.Services;

public interface IAdmin {
	Admin auntheticateUser(String name, String pwd);
	public List<Provider> ProviderList();
	public List<Services> ProviderServiceList();
	public List<Customer> customerList();
	public List<Booking> bookingList();
	public String AboutUs();
	public String services();
	public String photogallery();
	public String contact();
	public String deletecustomer(String email, int cid);
	public String providerdelete(int pid);
	public String deleteservice(int sid);
	public String bookingdelete(int bid);
	public String verifyservice(int sid);
	
}
