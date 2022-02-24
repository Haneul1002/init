package com.init.resume.main.vo;

public class SpotVO {
    
    private int spot_nm;
    private String name;
    private int rnum;
    private int totcnt;
	public int getSpot_nm() {
		return spot_nm;
	}
	public void setSpot_nm(int spot_nm) {
		this.spot_nm = spot_nm;
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
		return "SpotVO [spot_nm=" + spot_nm + ", name=" + name + ", rnum=" + rnum + ", totcnt=" + totcnt + "]";
	}
    
}
