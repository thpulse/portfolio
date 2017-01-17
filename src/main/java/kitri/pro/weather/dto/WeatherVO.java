package kitri.pro.weather.dto;

import org.springframework.web.multipart.MultipartFile;

public class WeatherVO {
	String days;
	String max_temp;
	String min_temp;
	String info;
	String addr1;
	String addr2;
	String addr3;
	String addr4;
	public WeatherVO(){
		
	}
	public WeatherVO(String days, String max_temp, String min_temp,
			String info, String addr1, String addr2, String addr3, String addr4) {
		super();
		this.days = days;
		this.max_temp = max_temp;
		this.min_temp = min_temp;
		this.info = info;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.addr3 = addr3;
		this.addr4 = addr4;
	}
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	public String getMax_temp() {
		return max_temp;
	}
	public void setMax_temp(String max_temp) {
		this.max_temp = max_temp;
	}
	public String getMin_temp() {
		return min_temp;
	}
	public void setMin_temp(String min_temp) {
		this.min_temp = min_temp;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
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
	public String getAddr3() {
		return addr3;
	}
	public void setAddr3(String addr3) {
		this.addr3 = addr3;
	}
	public String getAddr4() {
		return addr4;
	}
	public void setAddr4(String addr4) {
		this.addr4 = addr4;
	}
	@Override
	public String toString() {
		return "WeatherVO [days=" + days + ", max_temp=" + max_temp
				+ ", min_temp=" + min_temp + ", info=" + info + ", addr1="
				+ addr1 + ", addr2=" + addr2 + ", addr3=" + addr3 + ", addr4="
				+ addr4 + "]";
	}

	
}
