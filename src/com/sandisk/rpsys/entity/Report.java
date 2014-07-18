package com.sandisk.rpsys.entity;

import java.util.Date;

public class Report {
	private int id;
	private int authorId;
	private String content;
	private Date date;
	
	
	
	@Override
	public String toString() {
		return "Report [Author=" + authorId + ", content=" + content + ", date="
				+ date + "]";
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int author) {
		authorId = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

}
