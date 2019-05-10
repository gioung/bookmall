package bookmall.vo;

public class OrderVo {
	private Long no;
	private Long member_no; 
	private String address;
	
	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "OrderDaoVo [no=" + no + ", member_no=" + member_no + ", address=" + address + "]";
	}
	
	
}
