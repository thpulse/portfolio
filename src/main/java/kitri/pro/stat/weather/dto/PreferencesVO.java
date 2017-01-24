package kitri.pro.stat.weather.dto;

import org.springframework.web.multipart.MultipartFile;

public class PreferencesVO {
	String addr1;
	String addr2;
	String cate;
	String totnmrs ;

	public PreferencesVO(){
		
	}

	public PreferencesVO(String addr1, String addr2, String cate, String totnmrs ) {
		super();
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.cate = cate;
		this.totnmrs  = totnmrs ;
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

	public String getCate() {
		return cate;
	}

	public void setCate(String cate) {
		this.cate = cate;
	}

	public String getTotnmrs () {
		return totnmrs ;
	}

	public void setTotnmrs (String totnmrs ) {
		this.totnmrs  = totnmrs ;
	}

	@Override
	public String toString() {
		return "PreferencesVO [addr1=" + addr1 + ", addr2=" + addr2 + ", cate="
				+ cate + ", totnmrs =" + totnmrs  + "]";
	}
	
	
}