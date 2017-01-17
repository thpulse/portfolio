package kitri.performinfo.performance.dto;



public class PerformanceSogaeimgDTO {
	private String prfid;
	private String styurl;
	
	public PerformanceSogaeimgDTO(){
		
	}

	public PerformanceSogaeimgDTO(String prfid, String styurl) {
		super();
		this.prfid = prfid;
		this.styurl = styurl;
	}

	@Override
	public String toString() {
		return "PerformanceSogaeimgDTO [prfid=" + prfid + ", styurl="
				+ styurl + "]";
	}

	public String getPrfid() {
		return prfid;
	}

	public void setPrfid(String prfid) {
		this.prfid = prfid;
	}

	public String getstyurl() {
		return styurl;
	}

	public void setstyurl(String styurl) {
		this.styurl = styurl;
	}
	
	
	
}
