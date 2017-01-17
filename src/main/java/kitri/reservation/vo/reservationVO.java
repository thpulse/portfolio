package kitri.reservation.vo;

public class reservationVO {
	String reserv_num;
	String user_id;
	String prf_id;
	String prf_day;
	String prf_starttime;
	String def_flg;
	public reservationVO(){}
	public reservationVO(String reserv_num, String user_id, String prf_id, String prf_day, String prf_starttime,
			String def_flg) {
		super();
		this.reserv_num = reserv_num;
		this.user_id = user_id;
		this.prf_id = prf_id;
		this.prf_day = prf_day;
		this.prf_starttime = prf_starttime;
		this.def_flg = def_flg;
	}
	public String getReserv_num() {
		return reserv_num;
	}
	public void setReserv_num(String reserv_num) {
		this.reserv_num = reserv_num;
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
	public String getPrf_starttime() {
		return prf_starttime;
	}
	public void setPrf_starttime(String prf_starttime) {
		this.prf_starttime = prf_starttime;
	}
	public String getDef_flg() {
		return def_flg;
	}
	public void setDef_flg(String def_flg) {
		this.def_flg = def_flg;
	}
	

}
