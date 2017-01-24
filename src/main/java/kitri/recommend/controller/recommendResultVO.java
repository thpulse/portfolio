package kitri.recommend.controller;

public class recommendResultVO {
	String user_id;
	String item_id;
	public recommendResultVO(String user_id, String item_id) {
		super();
		this.user_id = user_id;
		this.item_id = item_id;
	}
	public recommendResultVO() {
		super();
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	@Override
	public String toString() {
		return "recommendResultVO [user_id=" + user_id + ", item_id=" + item_id + "]";
	}

	
}
