package kitri.search.vo;

public class SearchVO {
	String poster; // �������̹������
 	String prfnm; // ������
	String prfpdfrom; // ����������
	String prfpdto; // ����������
	String ptfcast; // ���� �⿬��
	String story; // �ٰŸ�
	String prfstats; // ���� ����
	
	
	
	public SearchVO(String poster, String prfnm,
			String prfpdfrom, String prfpdto, String ptfcast, String story,
			String prfstats) {
		super();
		this.poster = poster;
		this.prfnm = prfnm;
		this.prfpdfrom = prfpdfrom;
		this.prfpdto = prfpdto;
		this.ptfcast = ptfcast;
		this.story = story;
		this.prfstats = prfstats;
	}

	@Override
	public String toString() {
		return "SearchVO [poster=" + poster
				+ ", prfnm=" + prfnm + ", prfpdfrom=" + prfpdfrom
				+ ", prfpdto=" + prfpdto + ", ptfcast=" + ptfcast + ", story="
				+ story + ", prfstats=" + prfstats + "]";
	}

	public SearchVO(){
		
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

	public String getPtfcast() {
		return ptfcast;
	}

	public void setPtfcast(String ptfcast) {
		this.ptfcast = ptfcast;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public String getPrfstats() {
		return prfstats;
	}

	public void setPrfstats(String prfstats) {
		this.prfstats = prfstats;
	}
	
	
	
}
