package kitri.performinfo.boxweekly.dto;

public class BoxWeeklyDTO {
	private String area;
	private Long prfcount;
	private Long nmrs;
	private String prfperiod;
	private String genre;
	private String prfplcnm;
	private String prfnm;
	private Long rank;
	private Long seatcnt;
	private String poster;
	private String prfid;
	public BoxWeeklyDTO(){
		
	}
	public BoxWeeklyDTO(String area, Long prfcount, Long nmrs,
			String prfperiod, String genre, String prfplcnm, String prfnm,
			Long rank, Long seatcnt, String poster, String prfid) {
		super();
		this.area = area;
		this.prfcount = prfcount;
		this.nmrs = nmrs;
		this.prfperiod = prfperiod;
		this.genre = genre;
		this.prfplcnm = prfplcnm;
		this.prfnm = prfnm;
		this.rank = rank;
		this.seatcnt = seatcnt;
		this.poster = poster;
		this.prfid = prfid;
	}
	@Override
	public String toString() {
		return "BoxWeeklyDTO [area=" + area + ", prfcount=" + prfcount
				+ ", nmrs=" + nmrs + ", prfperiod=" + prfperiod + ", genre="
				+ genre + ", prfplcnm=" + prfplcnm + ", prfnm=" + prfnm
				+ ", rank=" + rank + ", seatcnt=" + seatcnt + ", poster="
				+ poster + ", prfid=" + prfid + "]";
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Long getPrfcount() {
		return prfcount;
	}
	public void setPrfcount(Long prfcount) {
		this.prfcount = prfcount;
	}
	public Long getNmrs() {
		return nmrs;
	}
	public void setNmrs(Long nmrs) {
		this.nmrs = nmrs;
	}
	public String getPrfperiod() {
		return prfperiod;
	}
	public void setPrfperiod(String prfperiod) {
		this.prfperiod = prfperiod;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getPrfplcnm() {
		return prfplcnm;
	}
	public void setPrfplcnm(String prfplcnm) {
		this.prfplcnm = prfplcnm;
	}
	public String getPrfnm() {
		return prfnm;
	}
	public void setPrfnm(String prfnm) {
		this.prfnm = prfnm;
	}
	public Long getRank() {
		return rank;
	}
	public void setRank(Long rank) {
		this.rank = rank;
	}
	public Long getSeatcnt() {
		return seatcnt;
	}
	public void setSeatcnt(Long seatcnt) {
		this.seatcnt = seatcnt;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getPrfid() {
		return prfid;
	}
	public void setPrfid(String prfid) {
		this.prfid = prfid;
	}
	
}
