package bookmall.vo;

public class CartVo {
	private Long no;
	private Long member_no;
	private Long book_no;
	private Long qty;
	private Long payment;
	@Override
	public String toString() {
		return "CartVo [no=" + no + ", member_no=" + member_no + ", book_no=" + book_no + ", qty=" + qty + ", payment="
				+ payment + "]";
	}
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public Long getMember_no() {
		return member_no;
	}
	public void setMember_no(Long member_no) {
		this.member_no = member_no;
	}
	public Long getBook_no() {
		return book_no;
	}
	public void setBook_no(Long book_no) {
		this.book_no = book_no;
	}
	public Long getQty() {
		return qty;
	}
	public void setQty(Long qty) {
		this.qty = qty;
	}
	public Long getPayment() {
		return payment;
	}
	public void setPayment(Long payment) {
		this.payment = payment;
	}
}
