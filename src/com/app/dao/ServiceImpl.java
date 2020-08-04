package com.app.dao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.app.pojos.*;
@Repository
@Transactional

public class ServiceImpl implements IService {

	@Autowired // auto wiring by type
	private SessionFactory sf;
	@Override
	public String AddServices(Services s) {
		System.out.println("in Service impl");
		sf.getCurrentSession().save(s);
		Provider p1=sf.getCurrentSession().get(Provider.class, s.getPid());
		p1.getServices().add(s);
		s.getProviders().add(p1);
		return "Service added successfully";
	}

}
