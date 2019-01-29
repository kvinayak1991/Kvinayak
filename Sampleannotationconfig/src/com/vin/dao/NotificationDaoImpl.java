package com.vin.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vin.models.Notification;

@Repository("NotificationDao")
public class NotificationDaoImpl  implements NotificationDao{

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public String getNotification() {
		System.out.println("In Add orders");
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Notification.class).list().toString();
		
//		return session.createQuery("from Notification").list().toString();
	}
}
