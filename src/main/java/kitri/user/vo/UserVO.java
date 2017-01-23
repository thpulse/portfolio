package kitri.user.vo;

public class UserVO {
	private String user_id;
	private String user_pass;
	private String user_pass2;
	private String user_name;
	private String user_ssn;
	private String user_tel;
	private String user_email;
	private String user_gender;
	private String user_gerne;
	private String del_flg;
	
	
	public UserVO(){
		System.out.println("UserVO기본생성자");
	}


	public UserVO(String user_id, String user_pass, String user_pass2,
			String user_name, String user_ssn, String user_tel,
			String user_email, String user_gender, String user_gerne,
			String del_flg) {
		super();
		this.user_id = user_id;
		this.user_pass = user_pass;
		this.user_pass2 = user_pass2;
		this.user_name = user_name;
		this.user_ssn = user_ssn;
		this.user_tel = user_tel;
		this.user_email = user_email;
		this.user_gender = user_gender;
		this.user_gerne = user_gerne;
		this.del_flg = del_flg;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getUser_pass() {
		return user_pass;
	}


	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}


	public String getUser_pass2() {
		return user_pass2;
	}


	public void setUser_pass2(String user_pass2) {
		this.user_pass2 = user_pass2;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public String getUser_ssn() {
		return user_ssn;
	}


	public void setUser_ssn(String user_ssn) {
		this.user_ssn = user_ssn;
	}


	public String getUser_tel() {
		return user_tel;
	}


	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}


	public String getUser_email() {
		return user_email;
	}


	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}


	public String getUser_gender() {
		return user_gender;
	}


	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}


	public String getUser_gerne() {
		return user_gerne;
	}


	public void setUser_gerne(String user_gerne) {
		this.user_gerne = user_gerne;
	}


	public String getDel_flg() {
		return del_flg;
	}


	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}


	@Override
	public String toString() {
		return "UserVO [user_id=" + user_id + ", user_pass=" + user_pass
				+ ", user_pass2=" + user_pass2 + ", user_name=" + user_name
				+ ", user_ssn=" + user_ssn + ", user_tel=" + user_tel
				+ ", user_email=" + user_email + ", user_gender=" + user_gender
				+ ", user_gerne=" + user_gerne + ", del_flg=" + del_flg + "]";
	}
	
	

	

}
