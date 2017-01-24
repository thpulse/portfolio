package kitri.reservation.vo;

public class reservationDetailVO {
	String reserv_num ;
	String grade;
	String seat;
	String price;
	public reservationDetailVO() {
		super();
	}
	public reservationDetailVO(String reserv_num, String grade, String seat, String price) {
		super();
		this.reserv_num = reserv_num;
		this.grade = grade;
		this.seat = seat;
		this.price = price;
	}
	public String getReserv_num() {
		return reserv_num;
	}
	public void setReserv_num(String reserv_num) {
		this.reserv_num = reserv_num;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "reservationDetailVO [reserv_num=" + reserv_num + ", grade=" + grade + ", seat=" + seat + ", price="
				+ price + "]";
	}
}
