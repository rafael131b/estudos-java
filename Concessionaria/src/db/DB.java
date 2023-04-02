package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB {
	
	public static Connection  conn =null;
	PreparedStatement st=null;
	ResultSet rs=null;
	
	public  static Connection getConexao () throws DbException {
		if(conn==null) {
			try {
				String url="jdbc:mysql://localhost:3306/concessionaria";
				String user="root";
				String password="root";
				conn=DriverManager.getConnection(url,user,password);
				
			}catch (SQLException e) {
				throw new DbException(e.getMessage());
				
			}
		}
		
		return conn;
	}

}
