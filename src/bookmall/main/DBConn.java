package bookmall.main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	public static Connection getConnection(){
		Connection conn = null;
		// 1. jdbc driver(mariadb) loading
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://192.168.1.41:3307/bookmall";
			conn = DriverManager.getConnection(url,"bookmall","bookmall");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	
		return conn;
	}
}
