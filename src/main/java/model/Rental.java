package model;

import java.util.Date;

public class Rental {
	private String mname;
	private String bid;
	private String bname;
	private String bcontent;
	private Date rdate;
	
	
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public Date getRdate() {
		return rdate;
	}
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
	@Override
	public String toString() {
		return "Rental [mname=" + mname + ", bid=" + bid + ", bname=" + bname + ", bcontent=" + bcontent + ", rdate="
				+ rdate + "]";
	}
	
	
	
	

}
