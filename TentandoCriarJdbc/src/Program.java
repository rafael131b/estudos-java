

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {

	public static void main(String[] args) throws DbException {
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		
		try {
			conn=DB.getConnection();
			st=conn.createStatement();
			rs=st.executeQuery("select * from department");
			while(rs.next()) {
				System.out.println(rs.getInt("id") + ","  +  rs.getString("Name"));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				
			}catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
		
		
		

		
	}

}
