package kitri.review.VO;

public class ReviewVO {
	public int revno;
	public String revgrade;
	public String revcomment;
	public String revdate;
	public String mem_id;
	public int revgb;
	public String prf_id;
	
	public ReviewVO(){
		
	}

	@Override
	public String toString() {
		return "ReviewVO [revno=" + revno + ", revgrade=" + revgrade
				+ ", revcomment=" + revcomment + ", revdate=" + revdate
				+ ", mem_id=" + mem_id + ", revgb=" + revgb + ", prf_id="
				+ prf_id + "]";
	}

	public ReviewVO(int revno, String revgrade, String revcomment,
			String revdate, String mem_id, int revgb, String prf_id) {
		super();
		this.revno = revno;
		this.revgrade = revgrade;
		this.revcomment = revcomment;
		this.revdate = revdate;
		this.mem_id = mem_id;
		this.revgb = revgb;
		this.prf_id = prf_id;
	}

	public int getRevno() {
		return revno;
	}

	public void setRevno(int revno) {
		this.revno = revno;
	}

	public String getRevgrade() {
		return revgrade;
	}

	public void setRevgrade(String revgrade) {
		this.revgrade = revgrade;
	}

	public String getRevcomment() {
		return revcomment;
	}

	public void setRevcomment(String revcomment) {
		this.revcomment = revcomment;
	}

	public String getRevdate() {
		return revdate;
	}

	public void setRevdate(String revdate) {
		this.revdate = revdate;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public int getRevgb() {
		return revgb;
	}

	public void setRevgb(int revgb) {
		this.revgb = revgb;
	}

	public String getPrf_id() {
		return prf_id;
	}

	public void setPrf_id(String prf_id) {
		this.prf_id = prf_id;
	}

}