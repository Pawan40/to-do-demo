package edu.todotask.controller;
import java.util.Date;
public class Task {
	private int id;
	private String title;
	private String status;
	private Date ScheduledOn;
	private Date UpdateOn;
	public int getId() {
		return id;
		
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getScheduledOn() {
		return ScheduledOn;
	}
	public void setScheduledOn(Date scheduledOn) {
		ScheduledOn = scheduledOn;
	}
	public Date getUpdateOn() {
		return UpdateOn;
	}
	public void setUpdateOn(Date updateOn) {
		UpdateOn = updateOn;
	}
	public void setId(int id) {
		this.id = id;
	}
}
	