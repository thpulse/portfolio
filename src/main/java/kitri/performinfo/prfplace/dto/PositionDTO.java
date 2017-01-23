package kitri.performinfo.prfplace.dto;

public class PositionDTO {
	private String plcid;
	private String la;
	private String lo;
	
	public PositionDTO(){
		
	}

	public PositionDTO(String plcid, String la, String lo) {
		super();
		this.plcid = plcid;
		this.la = la;
		this.lo = lo;
	}

	@Override
	public String toString() {
		return "PositionDTO [plcid=" + plcid + ", la=" + la + ", lo=" + lo
				+ "]";
	}

	public String getPlcid() {
		return plcid;
	}

	public void setPlcid(String plcid) {
		this.plcid = plcid;
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
