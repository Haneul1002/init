package com.init.resume.main.vo;

public class WorkVO {
    
	private int work_id;
    private String info_id;
    private String id;
    private String start_date;
    private String end_date;
    private String company_name;
    private String department;
    private String task;
    private String occupation;
    private String spot;
    private String spot_nm;
    private String spot_mc;
    private String work_year;
    private String work_month;
	public String getWork_year() {
		return work_year;
	}
	public void setWork_year(String work_year) {
		this.work_year = work_year;
	}
	public String getWork_month() {
		return work_month;
	}
	public void setWork_month(String work_month) {
		this.work_month = work_month;
	}
	public String getSpot_mc() {
		return spot_mc;
	}
	public void setSpot_mc(String spot_mc) {
		this.spot_mc = spot_mc;
	}
	private String date;
    private String task_occupation;
    
    
    public String getSpot_nm() {
 		return spot_nm;
 	}
 	public void setSpot_nm(String spot_nm) {
 		this.spot_nm = spot_nm;
 	}
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTask_occupation() {
		return task_occupation;
	}
	public void setTask_occupation(String task_occupation) {
		this.task_occupation = task_occupation;
	}
	private int rnum;
    private int totcnt;
	public int getWork_id() {
		return work_id;
	}
	public void setWork_id(int work_id) {
		this.work_id = work_id;
	}
	public String getInfo_id() {
		return info_id;
	}
	public void setInfo_id(String info_id) {
		this.info_id = info_id;
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
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
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
	public String getSpot() {
		return spot;
	}
	public void setSpot(String spot) {
		this.spot = spot;
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
		return "WorkVO [work_id=" + work_id + ", info_id=" + info_id + ", start_date=" + start_date + ", end_date="
				+ end_date + ", company_name=" + company_name + ", department=" + department + ", task=" + task
				+ ", occupation=" + occupation + ", spot=" + spot + ", rnum=" + rnum + ", totcnt=" + totcnt + "]";
	}
    
    
}
