package com.icia.bm.bean;

public class Book {
	private String id;
    private String name;
    private String content;
    private int rnum;
    private String thumbnail;
    
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
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
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", content=" + content + ", rnum=" + rnum + ", thumbnail="
				+ thumbnail + "]";
	}
	
	
    
    

}
