package kitri.mypageRcheck.vo;

public class RcheckVO {
	String prf_reserve_num; // 예매 번호
	String prf_day; // 예매 날짜
	String prfnm; //공연명
	String frf_starttime; // 예매 시간
	
	public RcheckVO(){
		
	}
	
	public RcheckVO(String prf_reserve_num, String prf_day, String prfnm,
			String frf_starttime) {
		super();
		this.prf_reserve_num = prf_reserve_num;
		this.prf_day = prf_day;
		this.prfnm = prfnm;
		this.frf_starttime = frf_starttime;
	}

	@Override
	public String toString() {
		return "RcheckVO [prf_reserve_num=" + prf_reserve_num + ", prf_day="
				+ prf_day + ", prfnm=" + prfnm + ", frf_starttime="
				+ frf_starttime + "]";
	}

	public String getPrf_reserve_num() {
		return prf_reserve_num;
	}
	public void setPrf_reserve_num(String prf_reserve_num) {
		this.prf_reserve_num = prf_reserve_num;
	}
	public String getPrf_day() {
		return prf_day;
	}
	public void setPrf_day(String prf_day) {
		this.prf_day = prf_day;
	}
	public String getPrfnm() {
		return prfnm;
	}
	public void setPrfnm(String prfnm) {
		this.prfnm = prfnm;
	}
	public String getFrf_starttime() {
		return frf_starttime;
	}
	public void setFrf_starttime(String frf_starttime) {
		this.frf_starttime = frf_starttime;
	}
	
	
}
