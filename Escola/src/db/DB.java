package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DB {
	
	public static Connection conn=null;

	private static   String password = null;
	private  static  String user=null;
	
	public static Connection conectar () throws DbException {
		password="root";
		user="root";
		try {
			if(conn==null) {
				Class.forName("com.mysql.jdbc.Driver");
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/escola",user,password);
				System.out.println("Banco de dados Conectado");
			}
			
			
		}catch (SQLException | ClassNotFoundException e) {
			throw new DbException(e.getMessage());
		}
		
		return conn;
	}
	
	public static  void desconectar () throws DbException {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new DbException("Erro ao fechar a conexao");
				
			}
			
		}
	}

}
