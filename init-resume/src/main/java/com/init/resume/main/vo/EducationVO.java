package com.init.resume.main.vo;

public class EducationVO {
    private String education_id; 
    private String info_id;
    private String id;
    private String department;
    private String name;
    private String date;
    private String start_date;
    private String end_date;  
    private String degree;    
    private int rnum;
    private int totcnt;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEducation_id() {
		return education_id;
	}
	public void setEducation_id(String education_id) {
		this.education_id = education_id;
	}
	public String getInfo_id() {
		return info_id;
	}
	public void setInfo_id(String info_id) {
		this.info_id = info_id;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public int getTotcnt() {
		return totcnt;
	}
	public void setTotcnt(int totcnt) {
		this.totcnt = totcnt;
	}
	@Override
	public String toString() {
		return "EducationVO [education_id=" + education_id + ", info_id=" + info_id + ", department=" + department
				+ ", name=" + name + ", date=" + date + ", start_date=" + start_date + ", end_date=" + end_date
				+ ", degree=" + degree + ", rnum=" + rnum + ", totcnt=" + totcnt + "]";
	}  
    
}
