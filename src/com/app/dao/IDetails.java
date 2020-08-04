package com.app.dao;

import com.app.pojos.Details;

public interface IDetails {
	public String details(Details d,int sid, int pid, double rate, String sname, String location);

	public Details showdetails(int sid);

}
