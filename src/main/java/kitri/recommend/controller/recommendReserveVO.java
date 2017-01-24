package kitri.recommend.controller;

public class recommendReserveVO {
	String user_id;
	String prf_id;
	int count;
	public recommendReserveVO() {
		super();
	}
	public recommendReserveVO(String user_id, String prf_id, int count) {
		super();
		this.user_id = user_id;
		this.prf_id = prf_id;
		this.count = count;
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "recommendReserveVO [user_id=" + user_id + ", prf_id=" + prf_id + ", count=" + count + "]";
	}
}
