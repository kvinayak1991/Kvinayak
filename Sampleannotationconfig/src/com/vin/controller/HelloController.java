package com.vin.controller;


import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vin.requestmodel.filemodel;
import com.vin.services.NotificationService;

@RestController
@PropertySource("classpath:appexternal.properties")
public class HelloController {

	
//    @Autowired
//    private Environment environment;
    
    @Autowired
    NotificationService service;
    
    private static final Logger logger = Logger.getLogger(HelloController.class);
    
	@RequestMapping(value="api/Hello" , method=RequestMethod.GET)
	public String getHello() {
		String msg="Hello Vinayak";
		try {
			logger.info("Entry of Hello");
			msg="Hello Vinayak";
			logger.info("Exit of Hello");
		}
		catch(Exception e) {
			msg=e.getMessage();
			logger.error("HelloController getHello Exception::"+e);
		}
		return msg;
	}
	
	@RequestMapping(value="api/notification" , method=RequestMethod.POST)
	public String getAllNotification() {
		return service.getNotification();
	}
	
	@RequestMapping(value="api/chkjaxson" , method=RequestMethod.POST)
	public String chkJaxson(@RequestBody filemodel mddel) {
		
		System.out.println("filemodel Properties"+mddel.getProperties());
		System.out.println("filemodel Href"+mddel.getHref());
		return "Hello Vinayak";
	}
	@RequestMapping(value="api/simplejson" , method=RequestMethod.POST)
	public String chkJaxson(@RequestBody String mddel) throws ParseException {
		JSONParser parser=new JSONParser();
		JSONObject obj=new JSONObject();
		obj=(JSONObject)parser.parse(mddel);
		
		System.out.println("filemodel Properties:::"+obj.get("properties"));
		System.out.println("filemodel Href:::"+obj.get("href"));
		return "Hello Vinayak";
	}
	@RequestMapping(value="api/testapi" , method=RequestMethod.POST)
	public String testapi(@RequestBody String mddel) throws ParseException {
		System.out.println("Model:::"+mddel.toString());
		return "Hello Vinayak";
	}
	
}
