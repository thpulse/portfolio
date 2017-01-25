package kitri.pro.stat.weather.dto;

import org.springframework.web.multipart.MultipartFile;

public class StatisticsVO {
	String days;
	String prfnm;
	String cate;
	String fcltynm;
	String addr1;
	String addr2;
	String totnmrs;
	public StatisticsVO(){
		
	}
	public StatisticsVO(String days, String prfnm, String cate, String fcltynm,
			String addr1, String addr2, String totnmrs) {
		super();
		this.days = days;
		this.prfnm = prfnm;
		this.cate = cate;
		this.fcltynm = fcltynm;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.totnmrs = totnmrs;
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
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getTotnmrs() {
		return totnmrs;
	}
	public void setTotnmrs(String totnmrs) {
		this.totnmrs = totnmrs;
	}
	@Override
	public String toString() {
		return "StatComVO [days=" + days + ", prfnm=" + prfnm + ", cate="
				+ cate + ", fcltynm=" + fcltynm + ", addr1=" + addr1
				+ ", addr2=" + addr2 + ", totnmrs=" + totnmrs + "]";
	}

}