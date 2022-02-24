package com.init.resume.main.vo;

public class ClientVO {
    
    private int client_nm;
    private String name;
    private int rnum;
    private int totcnt;
	public int getClient_nm() {
		return client_nm;
	}
	public void setClient_nm(int client_nm) {
		this.client_nm = client_nm;
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
		return "ClientVO [client_nm=" + client_nm + ", name=" + name + ", rnum=" + rnum + ", totcnt=" + totcnt + "]";
	}
    
}
