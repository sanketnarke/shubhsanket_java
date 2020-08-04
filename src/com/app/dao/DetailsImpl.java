package com.app.dao;

import com.app.pojos.Details;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Admin;
import com.app.pojos.Booking;
import com.app.pojos.Customer;
import com.app.pojos.Details;
import com.app.pojos.Provider;
import com.app.pojos.Services;

@Repository
@Transactional
public class DetailsImpl implements IDetails {

	@Autowired // auto wiring by type
	private SessionFactory sf;
	@Override
	public String details(Details d,int sid, int pid, double rate, String sname, String location) {
		System.out.println(d);
		sf.getCurrentSession().save(d);
		return "Details added successfully";
	}
	@Override
	public Details showdetails(int sid) {
		String jpql = "select d from Details d where d.sid = :sid";
		System.out.println("detials showdetails impl");
		return sf.getCurrentSession().createQuery(jpql, Details.class).setParameter("sid", sid).getSingleResult();
	
	}
}

