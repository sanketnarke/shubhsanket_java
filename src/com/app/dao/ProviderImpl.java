package com.app.dao;

import java.util.*;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Booking;
import com.app.pojos.Customer;
import com.app.pojos.Details;
import com.app.pojos.Provider;
import com.app.pojos.Services;

@Repository
@Transactional
public class ProviderImpl implements IProvider {
	@Autowired // auto wiring by type
	private SessionFactory sf;
	@Override
	public Provider auntheticateUser(String email, String pwd) {
		String jpql = "select p from Provider p where p.email = :em and p.password=:pa";
		System.out.println("Cust auth impl");
		return sf.getCurrentSession().createQuery(jpql, Provider.class).setParameter("em", email).setParameter("pa", pwd).getSingleResult();
	}
		@Override
		public String RegisterProvider(Provider p) {
		System.out.println("In Register provider");	
		sf.getCurrentSession().save(p);
		return "provider Successfully Register";
		
	}
		@Override
		public String resetpassword(Provider p,String email, String password, String cpass) {
			
			System.out.println(p);
			String jpql = "select p from Provider p where p.email =:email";
			Provider p1=sf.getCurrentSession().createQuery(jpql, Provider.class).setParameter("email",email).getSingleResult();
			
			System.out.println(p1);
			p1.setPassword(cpass);
			sf.getCurrentSession().update(p1);
			return "Reset password Successful";
		}
		@Override
		public List<Booking> BookingList(int pid) {
			String jpql = "select b from Booking b where b.pid=:pid";
			System.out.println("in providerlist DaoImpl");
			System.out.println(sf.getCurrentSession().createQuery(jpql).setParameter("pid", pid).getResultList());
			return sf.getCurrentSession().createQuery(jpql, Booking.class).setParameter("pid", pid).getResultList();
		}
		@Override
		public String acceptbooking(int pid, int sid,int bid) {
			String jpql = "select p from Booking p where p.pid =:pid and p.sid=:sid and p.bid=:bid";
			Booking p1=sf.getCurrentSession().createQuery(jpql, Booking.class).setParameter("bid", bid).setParameter("sid", sid).setParameter("pid",pid).getSingleResult();
			System.out.println(p1);
			p1.setStatus("Accepted");
			sf.getCurrentSession().update(p1);
			return "Booking Accepted Successful";
		}
		@Override
		public String rejectbooking(int pid, int sid, int bid) {
			String jpql = "select p from Booking p where p.pid =:pid and p.sid=:sid and p.bid=:bid";
			Booking p1=sf.getCurrentSession().createQuery(jpql, Booking.class).setParameter("bid", bid).setParameter("sid", sid).setParameter("pid",pid).getSingleResult();
			System.out.println(p1);
			p1.setStatus("Rejected");
			sf.getCurrentSession().update(p1);
			return "Booking Rejected Successful";
		}
		@Override
		public List<Services> ProviderServices(int pid) {
			String jpql = "select b from Services b where b.pid=:pid";
			System.out.println("in ProviderServices DaoImpl");
			System.out.println(sf.getCurrentSession().createQuery(jpql).setParameter("pid", pid).getResultList());
			return sf.getCurrentSession().createQuery(jpql, Services.class).setParameter("pid", pid).getResultList();
		
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
			s1.setStatus("Service is in-active");
			sf.getCurrentSession().update(s1);
				System.out.println(s1+"---status is updated");
			}
			
			sf.getCurrentSession().delete(p1);
			return "Service Deleted Successful";
		}
		/*@Override
		public String updateservice(Services s, int sid, int pid) {
			String jpql = "select p from Services p where p.sid =:sid";
			Services p1=sf.getCurrentSession().createQuery(jpql, Services.class).setParameter("sid", sid).getSingleResult();
			System.out.println(p1);
			p1.setLocation(s.getLocation());
			p1.setPid(pid);
			p1.setPname(s.getPname());
			p1.setRate(s.getRate());
			p1.setSid(sid);
			p1.setServiceType(s.getServiceType());
			sf.getCurrentSession().update(p1);
			return "Service Updated Successful";
		}*/
		@Override
		public Customer acceptmail(int cid) {
			// TODO Auto-generated method stub
			String jpql = "select p from Customer p where p.cid =:cid";
			 Customer p1=sf.getCurrentSession().createQuery(jpql, Customer.class).setParameter("cid", cid).getSingleResult();
			 return p1;
		}
		@Override
		public Customer rejectmail(int cid) {
			String jpql = "select p from Customer p where p.cid =:cid";
			 Customer p1=sf.getCurrentSession().createQuery(jpql, Customer.class).setParameter("cid", cid).getSingleResult();
			 return p1;
		}
}



