package kitri.search.vo;

public class SearchResultVO {
	private String search_word;
	private int search_count;
	
	public SearchResultVO(){
		
	}

	public SearchResultVO(String search_word, int search_count) {
		super();
		this.search_word = search_word;
		this.search_count = search_count;
	}

	@Override
	public String toString() {
		return "SearchResultVO [search_word=" + search_word + ", search_count="
				+ search_count + "]";
	}

	public String getSearch_word() {
		return search_word;
	}

	public void setSearch_word(String search_word) {
		this.search_word = search_word;
	}

	public int getSearch_count() {
		return search_count;
	}

	public void setSearch_count(int search_count) {
		this.search_count = search_count;
	}
}
