package com.vin.test;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vin.aspect.RestAspect;
import com.vin.dao.NotificationDao;

public class JUnitTestCaes {
	
	private static AnnotationConfigApplicationContext cntxt;
	
	private static NotificationDao ndao;
	 @Autowired
	    private RestAspect restAspect;
//	    @Autowired
//	    private UserManager userManager;
	@Before
	public void init() {
		cntxt=new AnnotationConfigApplicationContext();
		cntxt.scan("com.vin");
		cntxt.refresh();
		ndao=(NotificationDao)cntxt.getBean("ndao");
	}
	
	@Test
	public void getNotification() {
		assertEquals("SuucessFully getExecute Method", ndao.getNotification());
	}

}
