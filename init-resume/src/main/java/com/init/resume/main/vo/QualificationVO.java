package com.init.resume.main.vo;

public class QualificationVO {
	
	private int qualifi_id;
    private String info_id;
    private String id;
    private String name;  
    private String reg_num;  
    private String reg_date; 
    private String issuer; 
    private String qualifi_nm; 
    private int rnum;
    private int totcnt;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getQualifi_nm() {
		return qualifi_nm;
	}
	public void setQualifi_nm(String qualifi_nm) {
		this.qualifi_nm = qualifi_nm;
	}
	public int getQualifi_id() {
		return qualifi_id;
	}
	public void setQualifi_id(int qualifi_id) {
		this.qualifi_id = qualifi_id;
	}

	public String getInfo_id() {
		return info_id;
	}
	public void setInfo_id(String info_id) {
		this.info_id = info_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReg_num() {
		return reg_num;
	}
	public void setReg_num(String reg_num) {
		this.reg_num = reg_num;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getIssuer() {
		return issuer;
	}
	public void setIssuer(String issuer) {
		this.issuer = issuer;
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
		return "QualificationVO [qualifi_id=" + qualifi_id + ", info_id=" + info_id + ", name=" + name
				+ ", reg_num=" + reg_num + ", reg_date=" + reg_date + ", issuer=" + issuer + ", rnum=" + rnum
				+ ", totcnt=" + totcnt + "]";
	}  
    
}
