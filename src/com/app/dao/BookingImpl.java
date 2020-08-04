package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.*;

@Repository
@Transactional

public class BookingImpl implements IBooking {
	@Autowired // auto wiring by type
	private SessionFactory sf;
	@Override
	public String booking(Booking b) {
		// TODO Auto-generated method stub
		
		System.out.println("In Booking");	
		sf.getCurrentSession().save(b);
		Customer c1=sf.getCurrentSession().get(Customer.class, b.getCid());
		Provider p1=sf.getCurrentSession().get(Provider.class, b.getPid());
		Services s1=sf.getCurrentSession().get(Services.class, b.getSid());
		c1.getProviders().add(p1);
		p1.getCustomers().add(c1);
		c1.getServices().add(s1);
		s1.getCustomers().add(c1);
		b.addCustomer(c1);
		c1.getBookings().add(b);
		return "Booking and Payment Done Successfully. Thank You!!";
	}
	@Override
	public Provider sentmail(Booking b) {
		// TODO Auto-generated method stub
	int pid=b.getPid();
		String jpql = "select a from Provider a where a.pid = :pid";
		System.out.println("Booking Provider sentmail mpl");
		return sf.getCurrentSession().createQuery(jpql, Provider.class).setParameter("pid", pid).getSingleResult();
	}

}
