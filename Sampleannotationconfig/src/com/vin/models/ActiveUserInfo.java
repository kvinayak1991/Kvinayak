package com.vin.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "ACTIVE_USER_INFO")
public class ActiveUserInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer AUID;

	@NotEmpty
	@Column(name = "SESSIONID", nullable = false)
	private String SESSIONID;
	
	@NotEmpty
	@Column(name = "IS_ACTIVE", nullable = false)
	private String IS_ACTIVE;

	@NotEmpty
	@Column(name = "LOGGED_IN_TIME", nullable = false)
	private Date LOGGED_IN_TIME;

	@Column(name = "LOGGED_OUT_TIME", nullable = true)
	private Date LOGGED_OUT_TIME;

	@NotEmpty
	@Column(name = "UID", nullable = false)
	private Integer UID;

	
	
	public String getIS_ACTIVE() {
		return IS_ACTIVE;
	}

	public void setIS_ACTIVE(String iS_ACTIVE) {
		IS_ACTIVE = iS_ACTIVE;
	}

	@Override
	public String toString() {
		return "ActiveUserInfo [AUID=" + AUID + ", SESSIONID=" + SESSIONID + ", UID=" + UID + "]";
	}

	public Date getLOGGED_IN_TIME() {
		return LOGGED_IN_TIME;
	}

	public void setLOGGED_IN_TIME(Date lOGGED_IN_TIME) {
		LOGGED_IN_TIME = lOGGED_IN_TIME;
	}

	public Date getLOGGED_OUT_TIME() {
		return LOGGED_OUT_TIME;
	}

	public void setLOGGED_OUT_TIME(Date lOGGED_OUT_TIME) {
		LOGGED_OUT_TIME = lOGGED_OUT_TIME;
	}

	public Integer getAUID() {
		return AUID;
	}

	public void setAUID(Integer aUID) {
		AUID = aUID;
	}

	public String getSESSIONID() {
		return SESSIONID;
	}

	public void setSESSIONID(String sESSIONID) {
		SESSIONID = sESSIONID;
	}

	public Integer getUID() {
		return UID;
	}

	public void setUID(Integer uID) {
		UID = uID;
	}
}
