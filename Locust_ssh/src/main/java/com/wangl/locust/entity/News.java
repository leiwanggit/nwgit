package com.wangl.locust.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="TNEWS")
public class News implements java.io.Serializable{
	
	@Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "TITLE")
	private String title;
	@Column(name = "URL")
	private String url;
	@Column(name = "INFOFROM")
	private String from;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	

}
