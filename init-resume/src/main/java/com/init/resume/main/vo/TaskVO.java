package com.init.resume.main.vo;

public class TaskVO {
    
    private int task_nm;
    private String name;
    private String occupation;
    private int rnum;
    private int totcnt;
	public int getTask_nm() {
		return task_nm;
	}
	public void setTask_nm(int task_nm) {
		this.task_nm = task_nm;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	@Override
	public String toString() {
		return "TaskVO [task_nm=" + task_nm + ", name=" + name + ", occupation=" + occupation + ", rnum=" + rnum
				+ ", totcnt=" + totcnt + "]";
	}
    
    
}
