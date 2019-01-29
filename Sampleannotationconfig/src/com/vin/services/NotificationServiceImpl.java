package com.vin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vin.dao.NotificationDao;

@Service("NotificationService")
@Transactional
public class NotificationServiceImpl implements NotificationService{

	

	@Autowired
    NotificationDao notificationDao;
	
	@Override
	public String getNotification() {
		// TODO Auto-generated method stub
		return notificationDao.getNotification();
	}

}
