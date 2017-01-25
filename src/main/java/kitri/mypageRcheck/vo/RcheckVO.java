package kitri.mypageRcheck.vo;

public class RcheckVO {
	String reserv_num;
	String reserv_date;
	String user_id;
	String prf_id;
	String prf_day;
	String prf_day_yo;
	String prf_starttime;
	String del_flg;
	
	String prfnm;
	
	
	public RcheckVO(){
		
	}


	public RcheckVO(String reserv_num, String reserv_date, String user_id,
			String prf_id, String prf_day, String prf_day_yo,
			String prf_starttime, String del_flg, String prfnm) {
		super();
		this.reserv_num = reserv_num;
		this.reserv_date = reserv_date;
		this.user_id = user_id;
		this.prf_id = prf_id;
		this.prf_day = prf_day;
		this.prf_day_yo = prf_day_yo;
		this.prf_starttime = prf_starttime;
		this.del_flg = del_flg;
		this.prfnm = prfnm;
	}


	@Override
	public String toString() {
		return "RcheckVO [reserv_num=" + reserv_num + ", reserv_date="
				+ reserv_date + ", user_id=" + user_id + ", prf_id=" + prf_id
				+ ", prf_day=" + prf_day + ", prf_day_yo=" + prf_day_yo
				+ ", prf_starttime=" + prf_starttime + ", del_flg=" + del_flg
				+ ", prfnm=" + prfnm + "]";
	}


	public String getReserv_num() {
		return reserv_num;
	}


	public void setReserv_num(String reserv_num) {
		this.reserv_num = reserv_num;
	}


	public String getReserv_date() {
		return reserv_date;
	}


	public void setReserv_date(String reserv_date) {
		this.reserv_date = reserv_date;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getPrf_id() {
		return prf_id;
	}


	public void setPrf_id(String prf_id) {
		this.prf_id = prf_id;
	}


	public String getPrf_day() {
		return prf_day;
	}


	public void setPrf_day(String prf_day) {
		this.prf_day = prf_day;
	}


	public String getPrf_day_yo() {
		return prf_day_yo;
	}


	public void setPrf_day_yo(String prf_day_yo) {
		this.prf_day_yo = prf_day_yo;
	}


	public String getPrf_starttime() {
		return prf_starttime;
	}


	public void setPrf_starttime(String prf_starttime) {
		this.prf_starttime = prf_starttime;
	}


	public String getDel_flg() {
		return del_flg;
	}


	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}


	public String getPrfnm() {
		return prfnm;
	}


	public void setPrfnm(String prfnm) {
		this.prfnm = prfnm;
	}
	
	
	
}
