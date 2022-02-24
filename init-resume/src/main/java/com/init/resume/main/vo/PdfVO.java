package com.init.resume.main.vo;

public class PdfVO {
    private String id;
    private String info_id;
    private String oname;
    private String tname;
    
    public String getOname() {
		return oname;
	}
	public void setOname(String oname) {
		this.oname = oname;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getInfo_id() {
		return info_id;
	}
	public void setInfo_id(String info_id) {
		this.info_id = info_id;
	}
	private String member_id;
    private String photo;
    private String resume;
    public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	private String userid;
    private String userpw;
    private String month;
    private String reg_date;
    public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	private String name;
    private String birth;
    private String career_age;
    private String area;
    private String phone;
    private String email;
    private String qualifi;
    private String occupation;
    private String task;
    private String address;
    private String detailaddress;
	private String imgname;
    private String imgoriginname;
    private String imgurl;
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
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getCareer_age() {
		return career_age;
	}
	public void setCareer_age(String career_age) {
		this.career_age = career_age;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQualifi() {
		return qualifi;
	}
	public void setQualifi(String qualifi) {
		this.qualifi = qualifi;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDetailaddress() {
		return detailaddress;
	}
	public void setDetailaddress(String detailaddress) {
		this.detailaddress = detailaddress;
	}
	public String getImgname() {
		return imgname;
	}
	public void setImgname(String imgname) {
		this.imgname = imgname;
	}
	public String getImgoriginname() {
		return imgoriginname;
	}
	public void setImgoriginname(String imgoriginname) {
		this.imgoriginname = imgoriginname;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
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
		return "UserInfoVO [userId=" + id + ", name=" + name + ", birth=" + birth
				+ ", career_age=" + career_age + ", area=" + area + ", phone=" + phone + ", email=" + email
				+ ", qualifi=" + qualifi + ", occupation=" + occupation + ", task=" + task + ", address=" + address
				+ ", detailaddress=" + detailaddress + ", imgname=" + imgname + ", imgoriginname=" + imgoriginname
				+ ", imgurl=" + imgurl + ", rnum=" + rnum + ", totcnt=" + totcnt + "]";
	}
  
}
