package com.mtz.po;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.mtz.dao.MTZDao;

public class MTZ {
	private int id;
	private String time;
	private int grade;
	private  String state;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public MTZ() {
	}
	public MTZ(String time, int grade, String state) {
		super();
		this.time = time;
		this.grade = grade;
		this.state = state;
	}
	public MTZ(int id, String time, int grade, String state) {
		super();
		this.id = id;
		this.time = time;
		this.grade = grade;
		this.state = state;
	}

	
}
