package com.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.hibernate.*;

import com.app.pojos.Booking;
import com.app.pojos.Customer;
import com.app.pojos.Provider;
import com.app.pojos.Services;


@Repository
@Transactional
public class CustomerImpl implements ICustomer {
	@Autowired // auto wiring by type
	private SessionFactory sf;
	@Override
	public Customer auntheticateUser(String email, String pwd) {
		String jpql = "select c from Customer c where c.email = :em and c.password=:pa";
		System.out.println("Cust auth impl");
		return sf.getCurrentSession().createQuery(jpql, Customer.class).setParameter("em", email).setParameter("pa", pwd)
				.getSingleResult();
		
	}
	@Override
	public String RegisterCustomer(Customer c) {
		System.out.println("In Register customer");
		sf.getCurrentSession().save(c);
		return "Customer Successfully Register";
	}
	@Override
	public String Book(Booking b) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void addProvider(Provider p)
	{
		//add customer to a provider
		//this.getProviders().add(p);
		sf.getCurrentSession().persist(p);
		//providers.add(p);
		//add provider to customer
		//p.getCustomers().add(this);
	}
	@Override
	public void removeProvider(Provider p)
	{
		//add customer to a provider
		sf.getCurrentSession().persist(p);
		//providers.remove(p);
		//add provider to customer
		//p.getCustomers().remove(this);
	}
	
	
	
	@Override
	public void addServices(Services s) {
		// TODO Auto-generated method stub
		//add customer to a provider
				sf.getCurrentSession().persist(s);
				//services.add(s);
				//add provider to customer
				//s.getCustomers().add(this);

	}
	@Override
	public void removeServices(Services s) {
		// TODO Auto-generated method stub
		//add customer to a provider
				//services.remove(s);
				sf.getCurrentSession().persist(s);
				//add provider to customer
				//s.getCustomers().remove(this);
	}
	@Override
	public List<Services> SearchServices(String location, String serviceType) {
		// TODO Auto-generated method stub
		String cstr="Verified";
		System.out.println("Services run verified method "+cstr);
		String jpql = "select s from Services s where s.location=:location and s.serviceType=:serviceType and s.verification=:cstr";
		System.out.println("in Search Service DaoImpl");
		System.out.println(sf.getCurrentSession().createQuery(jpql, Services.class).setParameter("location", location).setParameter("serviceType", serviceType).setParameter("cstr", cstr).getResultList());
		return sf.getCurrentSession().createQuery(jpql, Services.class).setParameter("location", location).setParameter("serviceType", serviceType).setParameter("cstr", cstr).getResultList();
	
	}
	@Override
	public List<Booking> history(int cid) {
		// TODO Auto-generated method stub
		
		String jpql = "select b from Booking b where b.cid=:cid";
		System.out.println("in customerhist DaoImpl");
		System.out.println(sf.getCurrentSession().createQuery(jpql).setParameter("cid", cid).getResultList());
		return sf.getCurrentSession().createQuery(jpql, Booking.class).setParameter("cid", cid).getResultList();
	}
	@Override
	public String resetpassword(Customer c,String email, String password, String cpass) {
		
		
		System.out.println(c);
		String jpql = "select c from Customer c where c.email =:email";
		Customer c1=sf.getCurrentSession().createQuery(jpql, Customer.class).setParameter("email",email).getSingleResult();
		
		System.out.println(c1);
		c1.setPassword(cpass);
		sf.getCurrentSession().update(c1);
		return "Reset password Successful";
	}
	@Override
	public List<String> placelist(Services s) {
		// TODO Auto-generated method stub
		String jpql="select distinct s.location from Services s";
		List<String> p=sf.getCurrentSession().createQuery(jpql).getResultList();
		return p;
	}
	@Override
	public List<String> servicelist(Services s) {
		// TODO Auto-generated method stub
		String jpql="select distinct s.serviceType from Services s";
		List<String> p=sf.getCurrentSession().createQuery(jpql).getResultList();
		return p;
		}


}
