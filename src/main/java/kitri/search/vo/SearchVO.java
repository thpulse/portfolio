package kitri.search.vo;

public class SearchVO {
	String prfid; // 공연 아이디
	String poster; // 포스터이미지경로
 	String prfnm; // 공연명
	String prfpdfrom; // 공연시작일
	String prfpdto; // 공연종료일
	String prfcast; // 공연 출연진
	String story; // 줄거리
	String prfstate;
	
	public SearchVO(){
		
	}

	public SearchVO(String prfid, String poster, String prfnm,
			String prfpdfrom, String prfpdto, String prfcast, String story,
			String prfstate) {
		super();
		this.prfid = prfid;
		this.poster = poster;
		this.prfnm = prfnm;
		this.prfpdfrom = prfpdfrom;
		this.prfpdto = prfpdto;
		this.prfcast = prfcast;
		this.story = story;
		this.prfstate = prfstate;
	}



	@Override
	public String toString() {
		return "SearchVO [prfid=" + prfid + ", poster=" + poster + ", prfnm="
				+ prfnm + ", prfpdfrom=" + prfpdfrom + ", prfpdto=" + prfpdto
				+ ", prfcast=" + prfcast + ", story=" + story + ", prfstate="
				+ prfstate + "]";
	}



	public String getPrfid() {
		return prfid;
	}

	public void setPrfid(String prfid) {
		this.prfid = prfid;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getPrfnm() {
		return prfnm;
	}

	public void setPrfnm(String prfnm) {
		this.prfnm = prfnm;
	}

	public String getPrfpdfrom() {
		return prfpdfrom;
	}

	public void setPrfpdfrom(String prfpdfrom) {
		this.prfpdfrom = prfpdfrom;
	}

	public String getPrfpdto() {
		return prfpdto;
	}

	public void setPrfpdto(String prfpdto) {
		this.prfpdto = prfpdto;
	}

	public String getPrfcast() {
		return prfcast;
	}

	public void setPrfcast(String prfcast) {
		this.prfcast = prfcast;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public String getPrfstate() {
		return prfstate;
	}

	public void setPrfstate(String prfstate) {
		this.prfstate = prfstate;
	}

	
}
