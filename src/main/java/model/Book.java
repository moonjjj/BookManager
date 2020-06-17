package model;

public class Book {
	private String id;
    private String name;
    private String content;
    private int rnum;
    
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
		return "Book [id=" + id + ", name=" + name + ", content=" + content + ", rnum=" + rnum + "]";
	}
	
    
    

}
