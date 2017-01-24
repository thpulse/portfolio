package kitri.recommend.controller;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="reservation")
public class recommendDTO {
	@Id
	String _id;
	String user_id;
	String item_id;
	String preference;
	
	public recommendDTO() {
		super();
	}

	public recommendDTO(String _id, String user_id, String item_id, String preference) {
		super();
		this._id = _id;
		this.user_id = user_id;
		this.item_id = item_id;
		this.preference = preference;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
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

	public String getPreference() {
		return preference;
	}

	public void setPreference(String preference) {
		this.preference = preference;
	}

	@Override
	public String toString() {
		return "recommendDTO [_id=" + _id + ", user_id=" + user_id + ", item_id=" + item_id + ", preference="
				+ preference + "]";
	}

	
}