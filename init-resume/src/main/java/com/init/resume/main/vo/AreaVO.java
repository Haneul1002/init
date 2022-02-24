package com.init.resume.main.vo;

public class AreaVO {

	private String id;
	private String name;
	private int rnum;
    private int totcnt;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
		return "AreaVO [id=" + id + ", name=" + name + ", rnum=" + rnum + ", totcnt=" + totcnt + "]";
	}
    
    
}	