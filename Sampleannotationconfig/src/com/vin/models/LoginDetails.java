package com.vin.models;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "USERLOGIN")
public class LoginDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ID;

	@Column(name = "EMAIL", nullable = true)
	private String EMAIL;

	@NotEmpty
	@Column(name = "USERNAME", nullable = false)
	private String USERNAME;

	@NotEmpty
	@Column(name = "PASSWORD", nullable = false)
	private String PASSWORD;

	@NotEmpty
	@Column(name = "IS_ACTIVE", nullable = false)
	private String IS_ACTIVE;

	@NotEmpty
	@Column(name = "LAST_UPDATE_DATETIME", nullable = false)
	private Date LAST_UPDATE_DATETIME;

	@NotEmpty
	@Column(name = "IS_LOCKED", nullable = false)
	private String IS_LOCKED;

	@Column(name = "ROLL_ID", nullable = false)
	private String ROLL_ID;
	
	@ManyToMany(mappedBy = "userRole")
    private Set<UserRole> userRole;
	
	
	public Set<UserRole> getUserRole() {
		return userRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}

	public Integer getUID() {
		return ID;
	}

	public void setUID(Integer uID) {
		ID = uID;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public String getIS_LOCKED() {
		return IS_LOCKED;
	}

	public void setIS_LOCKED(String iS_LOCKED) {
		IS_LOCKED = iS_LOCKED;
	}

	public String getROLL_ID() {
		return ROLL_ID;
	}

	public void setROLL_ID(String rOLL_ID) {
		ROLL_ID = rOLL_ID;
	}

	public String getUSERNAME() {
		return USERNAME;
	}

	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	public String getIS_ACTIVE() {
		return IS_ACTIVE;
	}

	public void setIS_ACTIVE(String iS_ACTIVE) {
		IS_ACTIVE = iS_ACTIVE;
	}

	public Date getLAST_UPDATE_DATETIME() {
		return LAST_UPDATE_DATETIME;
	}

	public void setLAST_UPDATE_DATETIME(Date lAST_UPDATE_DATETIME) {
		LAST_UPDATE_DATETIME = lAST_UPDATE_DATETIME;
	}

	@Override
	public String toString() {
		return "LoginDetails [UID=" + ID + ", EMAIL=" + EMAIL + ", USERNAME=" + USERNAME + ", PASSWORD=" + PASSWORD
				+ ", IS_ACTIVE=" + IS_ACTIVE + ", LAST_UPDATE_DATETIME=" + LAST_UPDATE_DATETIME + ", IS_LOCKED="
				+ IS_LOCKED + ", ROLL_ID=" + ROLL_ID + "]";
	}
	
	
}
