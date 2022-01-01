package com.ssafy.happyhouse.model;

public class CoronaDto {
	String lat;
	String lng;
	String yadmNm;
	String telno;
	String adtFrDd;
	
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getYadmNm() {
		return yadmNm;
	}
	public void setYadmNm(String yadmNm) {
		this.yadmNm = yadmNm;
	}
	public String getTelno() {
		return telno;
	}
	public void setTelno(String telno) {
		this.telno = telno;
	}
	public String getAdtFrDd() {
		return adtFrDd;
	}
	public void setAdtFrDd(String adtFrDd) {
		this.adtFrDd = adtFrDd;
	}
	@Override
	public String toString() {
		return "CoronaDto [lat=" + lat + ", lng=" + lng + ", yadmNm=" + yadmNm + ", telno=" + telno + ", adtFrDd="
				+ adtFrDd + "]";
	}
	
	
	
}
