package kitri.performinfo.performance.dto;


public class PerformanceDTO {
	private String prfid;
	private String prfnm;
	private String prfpdfrom;
	private String prfpdto;
	private String plcid;
	private String prfcast;
	private String prfcrew;
	private String prfruntime;
	private String prfage;
	private String tckprice;
	private String poster;
	private String story;
	private String genre;
	private String prfstate;
	private String openrun;
	private String prfdaytime;
	
	public PerformanceDTO(){
		
	}

	public PerformanceDTO(String prfid, String prfnm, String prfpdfrom,
			String prfpdto, String plcid, String prfcast, String prfcrew,
			String prfruntime, String prfage, String tckprice, String poster,
			String story, String genre, String prfstate, String openrun,
			String prfdaytime) {
		super();
		this.prfid = prfid;
		this.prfnm = prfnm;
		this.prfpdfrom = prfpdfrom;
		this.prfpdto = prfpdto;
		this.plcid = plcid;
		this.prfcast = prfcast;
		this.prfcrew = prfcrew;
		this.prfruntime = prfruntime;
		this.prfage = prfage;
		this.tckprice = tckprice;
		this.poster = poster;
		this.story = story;
		this.genre = genre;
		this.prfstate = prfstate;
		this.openrun = openrun;
		this.prfdaytime = prfdaytime;
	}

	@Override
	public String toString() {
		return "PerformanceDTO [prfid=" + prfid + ", prfnm=" + prfnm
				+ ", prfpdfrom=" + prfpdfrom + ", prfpdto=" + prfpdto
				+ ", plcid=" + plcid + ", prfcast=" + prfcast + ", prfcrew="
				+ prfcrew + ", prfruntime=" + prfruntime + ", prfage=" + prfage
				+ ", tckprice=" + tckprice + ", poster=" + poster + ", story="
				+ story + ", genre=" + genre + ", prfstate=" + prfstate
				+ ", openrun=" + openrun + ", prfdaytime=" + prfdaytime + "]";
	}

	public String getPrfid() {
		return prfid;
	}

	public void setPrfid(String prfid) {
		this.prfid = prfid;
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

	public String getPlcid() {
		return plcid;
	}

	public void setPlcid(String plcid) {
		this.plcid = plcid;
	}

	public String getPrfcast() {
		return prfcast;
	}

	public void setPrfcast(String prfcast) {
		this.prfcast = prfcast;
	}

	public String getPrfcrew() {
		return prfcrew;
	}

	public void setPrfcrew(String prfcrew) {
		this.prfcrew = prfcrew;
	}

	public String getPrfruntime() {
		return prfruntime;
	}

	public void setPrfruntime(String prfruntime) {
		this.prfruntime = prfruntime;
	}

	public String getPrfage() {
		return prfage;
	}

	public void setPrfage(String prfage) {
		this.prfage = prfage;
	}

	public String getTckprice() {
		return tckprice;
	}

	public void setTckprice(String tckprice) {
		this.tckprice = tckprice;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getstory() {
		return story;
	}

	public void setstory(String story) {
		this.story = story;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPrfstate() {
		return prfstate;
	}

	public void setPrfstate(String prfstate) {
		this.prfstate = prfstate;
	}

	public String getOpenrun() {
		return openrun;
	}

	public void setOpenrun(String openrun) {
		this.openrun = openrun;
	}

	public String getPrfdaytime() {
		return prfdaytime;
	}

	public void setPrfdaytime(String prfdaytime) {
		this.prfdaytime = prfdaytime;
	}
	
}
