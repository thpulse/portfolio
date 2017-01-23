package kitri.search.vo;

import java.sql.Date;

public class SearchLogVO {
	private String search_word;
	private Date search_date;
	
	public SearchLogVO(){
		
	}
	
	public SearchLogVO(String search_word, Date search_date) {
		super();
		this.search_word = search_word;
		this.search_date = search_date;
	}

	@Override
	public String toString() {
		return "SearchLogVO [search_word=" + search_word + ", search_date="
				+ search_date + "]";
	}

	public String getSearch_word() {
		return search_word;
	}

	public void setSearch_word(String search_word) {
		this.search_word = search_word;
	}

	public Date getSearch_date() {
		return search_date;
	}

	public void setSearch_date(Date search_date) {
		this.search_date = search_date;
	}
}
