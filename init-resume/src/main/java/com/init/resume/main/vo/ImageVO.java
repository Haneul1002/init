package com.init.resume.main.vo;

public class ImageVO {

    private String id;
    private String info_id;
    private String imgname;
    private String imgoriginname;
    private String imgurl;
	@Override
	public String toString() {
		return "ImageVO [id=" + id + ", info_id=" + info_id + ", imgname=" + imgname + ", imgoriginname="
				+ imgoriginname + ", imgurl=" + imgurl + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getInfo_id() {
		return info_id;
	}
	public void setInfo_id(String info_id) {
		this.info_id = info_id;
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
    
}
