package com.app.dao;


import java.util.*;

import com.app.pojos.Booking;
import com.app.pojos.Customer;
import com.app.pojos.Details;
import com.app.pojos.Provider;
import com.app.pojos.Services;

public interface IProvider {

	Provider auntheticateUser(String email, String pwd);
	public String RegisterProvider(Provider p);
	public String resetpassword(Provider p,String email, String pass, String cpass);
	public List<Booking> BookingList(int pid);
	public String acceptbooking(int pid, int sid,int bid);
	public String rejectbooking(int pid, int sid, int bid);
	List<Services> ProviderServices(int pid);
	public String deleteservice(int sid);
	//public String updateservice(Services s, int sid, int pid);
	public Customer acceptmail(int cid);
	public Customer rejectmail(int cid);
	
}
