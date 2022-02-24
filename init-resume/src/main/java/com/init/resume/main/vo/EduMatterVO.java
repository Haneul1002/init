package com.init.resume.main.vo;

public class EduMatterVO {
    private String edumatter_id; 
    private String info_id;
    private String id;
    private String course_name;
    private String date;
    private String start_date;
    private String end_date;  
    private String institation;
    private String completion_number;
    private String institute_nm;
    private int rnum;
    private int totcnt;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEdumatter_id() {
		return edumatter_id;
	}
	public void setEdumatter_id(String edumatter_id) {
		this.edumatter_id = edumatter_id;
	}
	public String getInfo_id() {
		return info_id;
	}
	public void setInfo_id(String info_id) {
		this.info_id = info_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
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
	public String getInstitation() {
		return institation;
	}
	public void setInstitation(String institation) {
		this.institation = institation;
	}
	public String getCompletion_number() {
		return completion_number;
	}
	public void setCompletion_number(String completion_number) {
		this.completion_number = completion_number;
	}
	public String getInstitute_nm() {
		return institute_nm;
	}
	public void setInstitute_nm(String institute_nm) {
		this.institute_nm = institute_nm;
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
		return "EduMatterVO [edumatter_id=" + edumatter_id + ", info_id=" + info_id + ", course_name=" + course_name
				+ ", date=" + date + ", start_date=" + start_date + ", end_date=" + end_date + ", institation="
				+ institation + ", completion_number=" + completion_number + ", institute_nm=" + institute_nm
				+ ", rnum=" + rnum + ", totcnt=" + totcnt + "]";
	}
    
}
