package com.init.resume.main.vo;

public class PrizeVO {
	
    private int prize_id;
    private String info_id;
    private String id;
    private String name;
    private String agency; 
    private String reg_date;
    private String evidence;
    private int rnum;
    private int totcnt;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPrize_id() {
		return prize_id;
	}
	public void setPrize_id(int prize_id) {
		this.prize_id = prize_id;
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
	public String getAgency() {
		return agency;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getEvidence() {
		return evidence;
	}
	public void setEvidence(String evidence) {
		this.evidence = evidence;
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
		return "PrizeVO [prize_id=" + prize_id + ", info_id=" + info_id + ", name=" + name + ", agency=" + agency
				+ ", reg_date=" + reg_date + ", evidence=" + evidence + ", rnum=" + rnum + ", totcnt=" + totcnt + "]";
	}
    
}
