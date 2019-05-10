package bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.main.DBConn;
import bookmall.vo.BookVo;

public class BookDao {
	//insert
	public Boolean insert(BookVo vo) {
		Boolean result = false;
		Connection conn = null; 
		PreparedStatement pstmt = null;
		try {
				conn = DBConn.getConnection();
				String sql="insert into book values(null,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,vo.getCategory());
				pstmt.setString(2,vo.getTitle());
				pstmt.setLong(3, vo.getPrice());
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
	public List<BookVo> getList(){
		List<BookVo> result = new ArrayList<>();
		
		Connection conn = null; 
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			
				conn=DBConn.getConnection();
				String sql = "select no,category,title,price from book"; 
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
		
				while(rs.next()) {
					Long no =rs.getLong(1);
					String category = rs.getString(2);
					String title = rs.getString(3);
					Long price = rs.getLong(4);
					BookVo vo = new BookVo();
					
					vo.setNo(no);
					vo.setCategory(category);
					vo.setTitle(title);
					vo.setPrice(price);
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
