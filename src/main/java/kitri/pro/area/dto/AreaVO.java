package kitri.pro.area.dto;


public class AreaVO {

	String addr1;
	String addr2;
	String addr3;
	String addr4;

	public AreaVO() {

	}

	public AreaVO(String addr1, String addr2, String addr3, String addr4) {
		super();
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.addr3 = addr3;
		this.addr4 = addr4;
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
		return "WeatherVO [addr1=" + addr1 + ", addr2=" + addr2 + ", addr3="
				+ addr3 + ", addr4=" + addr4 + "]";
	}

}
