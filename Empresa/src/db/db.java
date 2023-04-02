package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class db {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/funcionarios";
	static final String user = "root";
	static final String password = "root";

	private static	Connection conn = null;
	private static Statement st = null;
	private static PreparedStatement pst=null;
	public static Connection conectar() {
		try {

			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, user, password);
			st = conn.createStatement();

//			STRING SQL = "CREATE TABLE PESSOA (\R\N"
//					+ "  ID INT AUTO_INCREMENT PRIMARY KEY,\R\N"
//					+ "  NOME VARCHAR(50) NOT NULL,\R\N"
//					+ "  IDADE INT NOT NULL,\R\N"
//					+ "  PROFISSAO VARCHAR(50) NOT NULL\R\N"
//					+ ");";
//			INT ROWSAFFECTED = ST.EXECUTEUPDATE(SQL);
//			
//			
//			SYSTEM.OUT.PRINTLN("EXECUTADO COM SUCESSO" + "LINHAS AFETADAS" + ROWSAFFECTED);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
		}
		return conn;
	}

	public static Connection adicionar(String nome,int idade,String profissao) {
		
		String sql= "INSERT INTO pessoa(nome,idade,profissao) VALUES (?,?,?)";
		
		
		
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, nome);
			pst.setInt(2, idade);
			pst.setString(3, profissao);
			int rowsAffecteds=pst.executeUpdate();
			
			System.out.println("Linhas afetadas" + rowsAffecteds);
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	public static  void deletar (int id) {
		String sql="DELETE  FROM pessoa WHERE id =?";
		
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			
			  int rowsAffected = pst.executeUpdate();
			  
			  System.out.println("Linhas afetadas" + rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void atualizar (int id,String novoNome,int novaIdade,String novaProfissao) {
		String sql= "UPDATE  pessoa set nome=?,idade=?,profissao=? WHERE id=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, novoNome);
			pst.setInt(2, novaIdade);
			pst.setString(3, novaProfissao);
			pst.setInt(4, id);
			
			int rowsAfected=pst.executeUpdate();
			
			System.out.println("Linahs afetadas" + rowsAfected);
			
		}catch (SQLException e) {
			
		}
	}

}



