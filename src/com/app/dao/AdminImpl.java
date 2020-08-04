package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Admin;
import com.app.pojos.Booking;
import com.app.pojos.Customer;
import com.app.pojos.Provider;
import com.app.pojos.Services;

@Repository
@Transactional
public class AdminImpl implements IAdmin {
	@Autowired // auto wiring by type
	private SessionFactory sf;
	@Override
	public Admin auntheticateUser(String name, String pwd) {
		
			String jpql = "select a from Admin a where a.name = :em and a.password=:pa";
			System.out.println("Admin auth impl");
			return sf.getCurrentSession().createQuery(jpql, Admin.class).setParameter("em", name).setParameter("pa", pwd).getSingleResult();
		
	}
	@Override
	public List<Provider> ProviderList() {
		// TODO Auto-generated method stub
		//String jpql = "select p1,s1 from Provider p1,Services s1 INNER JOIN p1.pname s1 ";
		//String jpql ="select p.pid,p.pname,p.contact,p.email,p.Address,s.sid,s.location,s.rate,s.servicetype from Provider p JOIN Services s ON p.pname=s.pname";
		String jpql = "select p1 from Provider p1 ";
		System.out.println("in providerlist DaoImpl");
		System.out.println(sf.getCurrentSession().createQuery(jpql).getResultList());
		return sf.getCurrentSession().createQuery(jpql, Provider.class).getResultList();
	 
	}
	@Override
	public List<Services> ProviderServiceList() {
		// TODO Auto-generated method stub
		String jpql = "select s1 from Services s1 ";
		System.out.println("in providerservicelist DaoImpl");
		System.out.println(sf.getCurrentSession().createQuery(jpql).getResultList());
		return sf.getCurrentSession().createQuery(jpql, Services.class).getResultList();
	}
	@Override
	public List<Customer> customerList() {
		// TODO Auto-generated method stub
		String jpql = "select c from Customer c ";
		System.out.println("in customerList DaoImpl");
		System.out.println(sf.getCurrentSession().createQuery(jpql).getResultList());
		return sf.getCurrentSession().createQuery(jpql, Customer.class).getResultList();
	}
	@Override
	public List<Booking> bookingList() {
		// TODO Auto-generated method stub
		String jpql = "select b from Booking b ";
		System.out.println("in bookingList DaoImpl");
		System.out.println(sf.getCurrentSession().createQuery(jpql).getResultList());
		return sf.getCurrentSession().createQuery(jpql, Booking.class).getResultList();
	}
	@Override
	public String AboutUs() {
		// TODO Auto-generated method stub
		return "In aboutus";
	}
	@Override
	public String services() {
		// TODO Auto-generated method stub
		return "in services";
	}
	@Override
	public String photogallery() {
		// TODO Auto-generated method stub
		return "in photos";
	}
	@Override
	public String contact() {
		// TODO Auto-generated method stub
		return "in contact";
	}
	@Override
	public String deletecustomer(String email, int cid) {
		String jpql = "select p from Customer p where p.cid =:cid and p.email=:email";
		Customer p1=sf.getCurrentSession().createQuery(jpql, Customer.class).setParameter("cid", cid).setParameter("email", email).getSingleResult();
		System.out.println(p1);
		String jpql2 = "select b from Booking b where b.cid =:cid";
		List<Booking> p2=sf.getCurrentSession().createQuery(jpql2, Booking.class).setParameter("cid", cid).getResultList();
		System.out.println(p2);
		int k=1;
		for(int i=0;i<p2.size();i++) 
		{System.out.println(p2.size());
		
		System.out.println("-----"+k+"--------");
		k=k+1;
		Booking s1=p2.get(i);
		s1.setStatus("Customer is in-active");
		sf.getCurrentSession().update(s1);
			System.out.println(s1+"---status is updated");
		}
		
		sf.getCurrentSession().delete(p1);
		return "Customer Deleted Successful";
	}
	@Override
	public String providerdelete(int pid) {
		String jpql = "select p from Provider p where p.pid =:pid";
		Provider p=sf.getCurrentSession().createQuery(jpql, Provider.class).setParameter("pid", pid).getSingleResult();
		System.out.println(p);
		String jpql1 = "select s from Services s where s.pid =:pid";
		List<Services> p1=sf.getCurrentSession().createQuery(jpql1, Services.class).setParameter("pid", pid).getResultList();
		System.out.println(p1);
		String jpql2 = "select b from Booking b where b.pid =:pid";
		List<Booking> p2=sf.getCurrentSession().createQuery(jpql2, Booking.class).setParameter("pid", pid).getResultList();
		System.out.println(p2);
		System.out.println(p1.isEmpty());
		int c=1;
		if(p1.isEmpty() && p2.isEmpty())
		{
			sf.getCurrentSession().delete(p);
			return "Provider is deleted successful";
		}
		
		 
		for(int i=0;i<p1.size();i++) 
		{System.out.println(p1.size());
		
		System.out.println("-----"+c+"--------");
		c=c+1;
		Services s1=p1.get(i);
			sf.getCurrentSession().delete(s1);
			System.out.println(p1.isEmpty());
		}
		int k=1;
		for(int i=0;i<p2.size();i++) 
		{System.out.println(p2.size());
		
		System.out.println("-----"+c+"--------");
		k=k+1;
		Booking s1=p2.get(i);
		s1.setStatus("Provider is in-active");
		sf.getCurrentSession().update(s1);
			System.out.println(s1+"---status is updated");
		}
		
			sf.getCurrentSession().delete(p);
		return "Provider and his services are deleted successful";
		
	}
	@Override
	public String deleteservice(int sid) {
		String jpql = "select p from Services p where p.sid =:sid";
		Services p1=sf.getCurrentSession().createQuery(jpql, Services.class).setParameter("sid", sid).getSingleResult();
		System.out.println(p1);
		String jpql2 = "select b from Booking b where b.sid =:sid";
		List<Booking> p2=sf.getCurrentSession().createQuery(jpql2, Booking.class).setParameter("sid", sid).getResultList();
		System.out.println(p2);
		int k=1;
		for(int i=0;i<p2.size();i++) 
		{System.out.println(p2.size());
		
		System.out.println("-----"+k+"--------");
		k=k+1;
		Booking s1=p2.get(i);
		s1.setStatus("Service is in-active from Admin");
		sf.getCurrentSession().update(s1);
			System.out.println(s1+"---status is updated");
		}
		
		sf.getCurrentSession().delete(p1);
		return "Service Deleted Successful";
	}
	@Override
	public String bookingdelete(int bid) {
		String jpql = "select p from Booking p where p.bid =:bid";
		Booking p1=sf.getCurrentSession().createQuery(jpql, Booking.class).setParameter("bid", bid).getSingleResult();
		System.out.println(p1);
		sf.getCurrentSession().delete(p1);
		return "Booking Deleted Successful";
	}
	@Override
	public String verifyservice(int sid) {
		String jpql = "select p from Services p where p.sid =:sid";
		Services p1=sf.getCurrentSession().createQuery(jpql, Services.class).setParameter("sid", sid).getSingleResult();
		System.out.println(p1);
		p1.setVerification("Verified");
		sf.getCurrentSession().update(p1);
		return "Provider Verified Successful";
		
	}
}
