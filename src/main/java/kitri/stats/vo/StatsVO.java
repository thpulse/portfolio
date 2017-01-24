package kitri.stats.vo;

public class StatsVO {
	String user_ssn; // 주민번호
	String user_gender; // 성별
	String prf_reserve_num; // 예매 번호
	
	public StatsVO(){
		//기본생성자
	}

	public StatsVO(String user_ssn, String user_gender, String prf_reserve_num) {
		super();
		this.user_ssn = user_ssn;
		this.user_gender = user_gender;
		this.prf_reserve_num = prf_reserve_num;
	}

	@Override
	public String toString() {
		return "StatsVO [user_ssn=" + user_ssn + ", user_gender=" + user_gender
				+ ", prf_reserve_num=" + prf_reserve_num + "]";
	}

	public String getUser_ssn() {
		return user_ssn;
	}

	public void setUser_ssn(String user_ssn) {
		this.user_ssn = user_ssn;
	}

	public String getUser_gender() {
		return user_gender;
	}

	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}

	public String getPrf_reserve_num() {
		return prf_reserve_num;
	}

	public void setPrf_reserve_num(String prf_reserve_num) {
		this.prf_reserve_num = prf_reserve_num;
	} 
}
