package kitri.mypageRcheck.vo;

public class RcheckVO {
	String reserv_date; // 예매 일
	String prf_day; // 공연 시작일
	String prf_starttime; // 예매 시간
	String prfnm; //공연명
	
	public RcheckVO(){
		
	}

	
	
	public RcheckVO(String reserv_date, String prf_day, String prf_starttime,
			String prfnm) {
		super();
		this.reserv_date = reserv_date;
		this.prf_day = prf_day;
		this.prf_starttime = prf_starttime;
		this.prfnm = prfnm;
	}



	@Override
	public String toString() {
		return "RcheckVO [reserv_date=" + reserv_date + ", prf_day=" + prf_day
				+ ", prf_starttime=" + prf_starttime + ", prfnm=" + prfnm + "]";
	}



	public String getReserv_date() {
		return reserv_date;
	}

	public void setReserv_date(String reserv_date) {
		this.reserv_date = reserv_date;
	}

	public String getPrf_day() {
		return prf_day;
	}

	public void setPrf_day(String prf_day) {
		this.prf_day = prf_day;
	}

	public String getPrf_starttime() {
		return prf_starttime;
	}

	public void setPrf_starttime(String prf_starttime) {
		this.prf_starttime = prf_starttime;
	}

	public String getPrfnm() {
		return prfnm;
	}

	public void setPrfnm(String prfnm) {
		this.prfnm = prfnm;
	}

	
	
	
}
