package com.vin.dao;

import java.util.Date;

import org.apache.commons.codec.binary.Base64;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.vin.appconstants.config;
import com.vin.models.ActiveUserInfo;
import com.vin.models.LoginDetails;
import com.vin.requestmodel.LoginModel;

@Repository("LoginLogoutDao")
public class LoginLogoutDaoImpl implements LoginLogoutDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public String ValidateUser(LoginModel model) {
		JSONObject responseJSON = new JSONObject();
		try {
			responseJSON.put(config.DATETIME, new Date().toString());
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from LoginDetails where USERNAME = :USERNAME and PASSWORD = :PASSWORD");
			query.setParameter("USERNAME", model.getUserName());
			query.setParameter("PASSWORD", model.getPassword());
			LoginDetails details = (LoginDetails) query.uniqueResult();
			if (details.getUSERNAME() != null && details.getPASSWORD() != null) {
				if (details.getIS_ACTIVE().equalsIgnoreCase("F")) {
					responseJSON.put(config.CODE, "202");
					responseJSON.put(config.DESCRIPTION, "USER IS NOT ACTIVE");

				} else if (details.getIS_LOCKED().equalsIgnoreCase("T")) {
					responseJSON.put(config.CODE, "203");
					responseJSON.put(config.DESCRIPTION, "USER IS LOCKED");
				} else {
					if (addToActiveUserDetails(details,
							Base64.encodeBase64String((model.getPassword() + new Date().toString()).getBytes()))) {
						responseJSON.put(config.CODE, "200");
						responseJSON.put("roll", details.getROLL_ID());
						responseJSON.put(config.SESSSIONID,
								Base64.encodeBase64String((model.getPassword() + new Date().toString()).getBytes()));
						responseJSON.put("username", details.getUSERNAME());
						responseJSON.put("email", details.getEMAIL());
						responseJSON.put(config.DESCRIPTION, "WelCome to Web Site");
					} else {
						responseJSON.put(config.CODE, "205");
						responseJSON.put(config.DESCRIPTION, "Cant Able to Save in Active User Info");
					}
					System.out.println("API Key for User " + model.getUserName() + "\n"
							+ Base64.encodeBase64String((model.getPassword() + new Date().toString()).getBytes()));
				}
			}
		} catch (Exception e) {
			responseJSON.put(config.CODE, "204");
			responseJSON.put(config.DESCRIPTION, e);
		} finally {

		}
		return responseJSON.toJSONString();
	}

	boolean addToActiveUserDetails(LoginDetails details, String sessionId) {
		boolean isSaved = false;
		try {
			System.out.println("sessionId:::" + sessionId);
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createSQLQuery(
					"insert into ACTIVE_USER_INFO (UID,SESSIONID,LOGGED_IN_TIME,IS_ACTIVE) values (:UID,:SESSIONID,:LOGGED_IN_TIME,:IS_ACTIVE)");
			System.out.println("" + query.toString());
			query.setParameter("UID", details.getUID());
			query.setParameter("SESSIONID", sessionId);
			query.setParameter("LOGGED_IN_TIME", new Date());
			query.setParameter("IS_ACTIVE", "T");
			int count = query.executeUpdate();
			System.out.println("count::::" + count);
			if (count > 0) {
				isSaved = true;
			}
		} catch (Exception e) {
			isSaved = false;
			e.printStackTrace();
		} finally {

		}
		return isSaved;
	}
	@Transactional
	public boolean isLoggedinUser(String sessionID) {
		boolean isLoggedIn=false;
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from ActiveUserInfo where SESSIONID = :SESSIONID and IS_ACTIVE = :IS_ACTIVE");
			query.setParameter("SESSIONID", sessionID);
			query.setParameter("IS_ACTIVE", "T");
			ActiveUserInfo details = (ActiveUserInfo) query.uniqueResult();
			if(details.getIS_ACTIVE().equalsIgnoreCase("T")) {
				isLoggedIn=true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			isLoggedIn=false;
		}
		finally {
			
		}
		return isLoggedIn;
	}
}
