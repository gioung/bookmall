package bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import bookmall.main.DBConn;
import bookmall.vo.CartVo;

public class CartDao {
	//insert
		public Boolean insert(CartVo vo) {
			Boolean result = false;
			Connection conn = null; 
			PreparedStatement pstmt = null;
			try {
					conn = DBConn.getConnection();
					String sql="insert into cart values(null,?,?,?,?)";
					//Long member_no,Long book_no,Long qty,Long payment
					pstmt = conn.prepareStatement(sql);
					pstmt.setLong(1, vo.getMember_no());
					pstmt.setLong(2, vo.getBook_no());
					pstmt.setLong(3,vo.getQty());
					pstmt.setLong(4, vo.getPayment());
					int count = pstmt.executeUpdate();
					result = (count == 1);
					
					
			}catch (SQLException e) {
					// TODO Auto-generated catch block
				 System.out.println("error" + e);
				}
			finally {
					try {
						if(conn!=null)
							conn.close();
						if(pstmt!=null)
							pstmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					};
			}return result;
		}
		
		//select
		public List<CartVo> getList(){
			List<CartVo> result = new ArrayList<>();
			
			Connection conn = null; 
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			try {
				
					conn=DBConn.getConnection();
					String sql = "select no,member_no,book_no,qty,payment from cart"; 
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					
			
					while(rs.next()) {
						Long no = rs.getLong(1);
						Long member_no = rs.getLong(2);
						Long book_no = rs.getLong(3);
						Long qty = rs.getLong(4);
						Long payment = rs.getLong(5);
						CartVo vo = new CartVo();
						vo.setNo(no);
						vo.setMember_no(member_no);
						vo.setBook_no(book_no);
						vo.setQty(qty);
						vo.setPayment(payment);
						result.add(vo);
					}
					
			}catch (SQLException e) {
					// TODO Auto-generated catch block
				 System.out.println("error" + e);
				}
			finally {
					try {
						if(conn!=null)
							conn.close();
						if(rs!=null)
								rs.close();
						if(pstmt!=null)
								pstmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			
			return result;
		}
}
