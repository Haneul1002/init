package com.init.resume.main.vo;

public class FileAttachVO {

	private int id;
	private String file_id;
    private String info_id;
    private String filename;
    private String fileoriginname;
    private String fileurl;
    
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFile_id() {
		return file_id;
	}
	public void setFile_id(String file_id) {
		this.file_id = file_id;
	}
	public String getInfo_id() {
		return info_id;
	}
	public void setInfo_id(String info_id) {
		this.info_id = info_id;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFileoriginname() {
		return fileoriginname;
	}
	public void setFileoriginname(String fileoriginname) {
		this.fileoriginname = fileoriginname;
	}
	public String getFileurl() {
		return fileurl;
	}
	public void setFileurl(String fileurl) {
		this.fileurl = fileurl;
	}
	@Override
	public String toString() {
		return "FileAttachVO [file_id=" + file_id + ", info_id=" + info_id + ", filename=" + filename
				+ ", fileoriginname=" + fileoriginname + ", fileurl=" + fileurl + "]";
	}
    
}
