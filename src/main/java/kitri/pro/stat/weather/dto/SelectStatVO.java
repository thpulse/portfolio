package kitri.pro.stat.weather.dto;

import org.springframework.web.multipart.MultipartFile;

public class SelectStatVO {
	String days;
	String prfnm;
	String cate;
	String fcltynm;
	String totnmrs;
	String address;
	public SelectStatVO(){
		
	}
	public SelectStatVO(String days, String prfnm, String cate, String fcltynm,
			String totnmrs, String address) {
		super();
		this.days = days;
		this.prfnm = prfnm;
		this.cate = cate;
		this.fcltynm = fcltynm;
		this.totnmrs = totnmrs;
		this.address = address;
	}
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	public String getPrfnm() {
		return prfnm;
	}
	public void setPrfnm(String prfnm) {
		this.prfnm = prfnm;
	}
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
	}
	public String getFcltynm() {
		return fcltynm;
	}
	public void setFcltynm(String fcltynm) {
		this.fcltynm = fcltynm;
	}
	public String getTotnmrs() {
		return totnmrs;
	}
	public void setTotnmrs(String totnmrs) {
		this.totnmrs = totnmrs;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "SelectStatVO [days=" + days + ", prfnm=" + prfnm + ", cate="
				+ cate + ", fcltynm=" + fcltynm + ", totnmrs=" + totnmrs
				+ ", address=" + address + "]";
	}
	
}