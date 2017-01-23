package kitri.performinfo.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="performance")
public class Performance {
	@Id
	@Column(name="prfid")
	private String prfid;
	@Column(name="prfnm")
	private String prfnm;
	@Column(name="prfpdfrom")
	private String prfpdfrom;
	@Column(name="prfpdto")
	private String prfpdto;
	@Column(name="plcid")
	private String plcid;
	@Column(name="prfcast")
	private String prfcast;
	@Column(name="prfcrew")
	private String prfcrew;
	@Column(name="prfruntime")
	private String prfruntime;
	@Column(name="prfage")
	private String prfage;
	@Column(name="tckprice")
	private String tckprice;
	@Column(name="poster")
	private String poster;
	@Column(name="story")
	private String story;
	@Column(name="genre")
	private String genre;
	@Column(name="prfstate")
	private String prfstate;
	@Column(name="openrun")
	private String openrun;
	@Column(name="prfdaytime")
	private String prfdaytime;
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
	public String getStory() {
		return story;
	}
	public void setStory(String story) {
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
