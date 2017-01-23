package kitri.performinfo.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="prf_place")
public class Prf_Place {
	@Id
	@Column(name="plcid")
	private String plcid;
	@Column(name="sidonm")
	private String sidonm;
	@Column(name="gugunnm")
	private String gugunnm;
	@Column(name="plcnm")
	private String plcnm;
	@Column(name="plcnum")
	private String plcnum;
	@Column(name="plcchar")
	private String plcchar;
	@Column(name="seatscale")
	private String seatscale;
	@Column(name="tel")
	private String tel;
	@Column(name="relateurl")
	private String relateurl;
	@Column(name="address")
	private String address;
	@Column(name="la")
	private String la;
	@Column(name="lo")
	private String lo;
	public String getPlcid() {
		return plcid;
	}
	public void setPlcid(String plcid) {
		this.plcid = plcid;
	}
	public String getSidonm() {
		return sidonm;
	}
	public void setSidonm(String sidonm) {
		this.sidonm = sidonm;
	}
	public String getGugunnm() {
		return gugunnm;
	}
	public void setGugunnm(String gugunnm) {
		this.gugunnm = gugunnm;
	}
	public String getPlcnm() {
		return plcnm;
	}
	public void setPlcnm(String plcnm) {
		this.plcnm = plcnm;
	}
	public String getPlcnum() {
		return plcnum;
	}
	public void setPlcnum(String plcnum) {
		this.plcnum = plcnum;
	}
	public String getPlcchar() {
		return plcchar;
	}
	public void setPlcchar(String plcchar) {
		this.plcchar = plcchar;
	}
	public String getSeatscale() {
		return seatscale;
	}
	public void setSeatscale(String seatscale) {
		this.seatscale = seatscale;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getRelateurl() {
		return relateurl;
	}
	public void setRelateurl(String relateurl) {
		this.relateurl = relateurl;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLa() {
		return la;
	}
	public void setLa(String la) {
		this.la = la;
	}
	public String getLo() {
		return lo;
	}
	public void setLo(String lo) {
		this.lo = lo;
	}
	
}
