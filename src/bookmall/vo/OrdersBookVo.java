package bookmall.vo;

public class OrdersBookVo {
	
		private Long order_no;
		private Long book_no;
		private Long qty;
		private Long payment;
		public Long getOrder_no() {
			return order_no;
		}
		public void setOrder_no(Long order_no) {
			this.order_no = order_no;
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
		@Override
		public String toString() {
			return "OrdersBookVo [order_no=" + order_no + ", book_no=" + book_no + ", qty=" + qty + ", payment="
					+ payment + "]";
		}
		
		
		
	
}
