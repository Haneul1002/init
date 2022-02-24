package com.init.resume.main.vo;

public class OccupationVO {
    
    private int occupation_nm;
    private String name;
    private int rnum;
    private int totcnt;
	public int getOccupation_nm() {
		return occupation_nm;
	}
	public void setOccupation_nm(int occupation_nm) {
		this.occupation_nm = occupation_nm;
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
	@Override
	public String toString() {
		return "OccupationVO [occupation_nm=" + occupation_nm + ", name=" + name + ", rnum=" + rnum + ", totcnt="
				+ totcnt + "]";
	}
    
}
