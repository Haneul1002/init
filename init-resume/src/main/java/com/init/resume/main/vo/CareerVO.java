package com.init.resume.main.vo;

public class CareerVO {
    private int career_id;
    private String info_id;
    private String id;
    private String project_name;
    private String date;
    private String start_date;
    private String end_date;
    private String client_name;
    private String client_nm;
    private String task;
    private String occupation;
    private String task_occupation;
    private String career_year;
    private String career_month;
	public String getCareer_year() {
		return career_year;
	}
	public void setCareer_year(String career_year) {
		this.career_year = career_year;
	}
	public String getCareer_month() {
		return career_month;
	}
	public void setCareer_month(String career_month) {
		this.career_month = career_month;
	}
	private int rnum;
    private int totcnt;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getClient_nm() {
		return client_nm;
	}
	public void setClient_nm(String client_nm) {
		this.client_nm = client_nm;
	}
	public int getCareer_id() {
		return career_id;
	}
	public void setCareer_id(int career_id) {
		this.career_id = career_id;
	}
	public String getInfo_id() {
		return info_id;
	}
	public void setInfo_id(String info_id) {
		this.info_id = info_id;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
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
	public String getClient_name() {
		return client_name;
	}
	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
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
	public String getTask_occupation() {
		return task_occupation;
	}
	public void setTask_occupation(String task_occupation) {
		this.task_occupation = task_occupation;
	}
	@Override
	public String toString() {
		return "CareerVO [career_id=" + career_id + ", info_id=" + info_id + ", project_name=" + project_name
				+ ", date=" + date + ", start_date=" + start_date + ", end_date=" + end_date + ", client_name="
				+ client_name + ", task=" + task + ", occupation=" + occupation + ", rnum=" + rnum + ", totcnt="
				+ totcnt + "]";
	}
    
}
