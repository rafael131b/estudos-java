package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

	private static Connection conn = null;

	public static Connection conectar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursejdbc", "root", "root");
			System.out.println("Conectou no banco de dados.");
		} catch (SQLException e) {
			System.out.println("Impossivel conectar ao banco de dados");
			e.printStackTrace();
		} catch (ClassNotFoundException ex) {
			System.out.println("Erro: Não encontrou o driver do BD.");
			ex.printStackTrace();
		}
		return conn;
	}


}
