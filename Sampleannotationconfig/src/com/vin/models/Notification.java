package com.vin.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "NOTIFICATIONS")
public class Notification implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@Column(name = "FILE_NAME")
	private String filename;

	@Column(name = "NOTIFICATION_TITLE")
	private String notificationtitle;

	@Column(name = "NOTIFICATION_DESC")
	private String notificationdesc;

	
	
	public Notification() {
		super();
	}

	public Notification(String filename, String notificationtitle, String notificationdesc) {
		super();
		this.filename = filename;
		this.notificationtitle = notificationtitle;
		this.notificationdesc = notificationdesc;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getNotificationtitle() {
		return notificationtitle;
	}

	public void setNotificationtitle(String notificationtitle) {
		this.notificationtitle = notificationtitle;
	}

	public String getNotificationdesc() {
		return notificationdesc;
	}

	public void setNotificationdesc(String notificationdesc) {
		this.notificationdesc = notificationdesc;
	}
}
