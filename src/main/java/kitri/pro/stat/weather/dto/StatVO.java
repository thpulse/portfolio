package kitri.pro.stat.weather.dto;

import org.springframework.web.multipart.MultipartFile;

public class StatVO {
	String days;
	String prfid;
	String prfnm;
	String cate;
	String fcltynm;
	String totnmrs;
	public StatVO(){
		
	}
	public StatVO(String days, String prfid, String prfnm, String cate,
			String fcltynm, String totnmrs) {
		super();
		this.days = days;
		this.prfid = prfid;
		this.prfnm = prfnm;
		this.cate = cate;
		this.fcltynm = fcltynm;
		this.totnmrs = totnmrs;
	}
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	public String getPrfid() {
		return prfid;
	}
	public void setPrfid(String prfid) {
		this.prfid = prfid;
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
	@Override
	public String toString() {
		return "StatVO [days=" + days + ", prfid=" + prfid + ", prfnm="
				+ prfnm + ", cate=" + cate + ", fcltynm=" + fcltynm
				+ ", totnmrs=" + totnmrs + "]";
	}

}