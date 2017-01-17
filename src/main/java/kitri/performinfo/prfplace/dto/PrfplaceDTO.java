package kitri.performinfo.prfplace.dto;

public class PrfplaceDTO {

	private String plcid;
	private String sidonm;
	private String gugunnm;
	private String plcnm;
	private String plcnum;
	private String plcchar;
	private String seatscale;
	private String tel;
	private String relateurl;
	private String address;
	private String la;
	private String lo;
	
	public PrfplaceDTO() {
		
	}

	public PrfplaceDTO(String plcid, String sidonm, String gugunnm,
			String plcnm, String plcnum, String plcchar, String seatscale,
			String tel, String relateurl, String address, String la, String lo) {
		super();
		this.plcid = plcid;
		this.sidonm = sidonm;
		this.gugunnm = gugunnm;
		this.plcnm = plcnm;
		this.plcnum = plcnum;
		this.plcchar = plcchar;
		this.seatscale = seatscale;
		this.tel = tel;
		this.relateurl = relateurl;
		this.address = address;
		this.la = la;
		this.lo = lo;
	}

	@Override
	public String toString() {
		return "PrfplaceDTO [plcid=" + plcid + ", sidonm=" + sidonm
				+ ", gugunnm=" + gugunnm + ", plcnm=" + plcnm + ", plcnum="
				+ plcnum + ", plcchar=" + plcchar + ", seatscale=" + seatscale
				+ ", tel=" + tel + ", relateurl=" + relateurl + ", address="
				+ address + ", la=" + la + ", lo=" + lo + "]";
	}

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
