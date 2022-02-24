package com.init.resume.main.vo;

public class InstituteVO {
    
    private String Institute_nm;
    private String name;
    private int rnum;
    private int totcnt;
	@Override
	public String toString() {
		return "InstituteVO [Institute_nm=" + Institute_nm + ", name=" + name + ", rnum=" + rnum + ", totcnt=" + totcnt
				+ "]";
	}
	public String getInstitute_nm() {
		return Institute_nm;
	}
	public void setInstitute_nm(String institute_nm) {
		Institute_nm = institute_nm;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
    
}
