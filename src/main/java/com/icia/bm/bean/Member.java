package com.icia.bm.bean;

public class Member {
	private String mid;
	private String mpass;
	private String mname;
	private String etc;
	
	
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpass() {
		return mpass;
	}
	public void setMpass(String mpass) {
		this.mpass = mpass;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}
	@Override
	public String toString() {
		return "Member [mid=" + mid + ", mpass=" + mpass + ", name=" + mname + ", etc=" + etc + "]";
	}
	
	

}
