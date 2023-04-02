package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DB;
import db.DbException;
public class ProfessorDao {
	public static PreparedStatement st=null;
	
	public ProfessorDao(String materia,double salario) {
		
	}
 public  static void adicionarBanco(String nome,String cpf,int idade,String materia,double salario) throws DbException {
	
	
	 
	try {
		 
		 String sql="INSERT INTO professores "
		 		+ "(nome,cpf,idade,materia,salario)"
		 		+ "VALUES "
		 		+ "(?,?,?,?,?)";
		 
		  st=DB.conn.prepareStatement(sql);
		 st.setString(1, nome);
		 st.setString(2, cpf);
		 st.setInt(3, idade);
		 st.setString(4, materia);
		 st.setDouble(5, salario);
		 int rowsAffected=st.executeUpdate();
		 
		 System.out.println("linhas afetadas" + rowsAffected);
	}catch (Exception e) {
		throw new DbException(e.getMessage());
	}

 }
 
 public static void deletarBanco (String cpf) {
	 String sql="DELETE FROM professores WHERE materia=?";
	 try {
		st=DB.conn.prepareStatement(sql);
		st.setString(1, cpf);
		int rowsAffected=st.executeUpdate();
		
		System.out.println("Linhas excluidas" + rowsAffected);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
 }
 
 public static void consulta(String cpf) throws DbException {
	 String sql="SELECT  * FROM professores where cpf=?";
	 try {
		st=db.DB.conn.prepareStatement(sql);
		st.setString(1, cpf);
		ResultSet rs=st.executeQuery();
		
		while(rs.next()) {
			System.out.println("Nome do professor" + rs.getString("nome") + " cpf :" + rs.getString("cpf"));
		}
	} catch (SQLException e) {
		throw new DbException(e.getMessage());
		
	}
 }
 
 public static void update(String materia) {
	 try {
		String sql="UPDATE professores set materia=?";
		st=db.DB.conn.prepareStatement(sql);
		st.setString(1, materia);
		
		 
	 }catch (SQLException e) {
		// TODO: handle exception
	}
	 
 }
 
 public static void update(String cpf, double salario) {
	 try {
		String sql="UPDATE professores set  salario =?  WHERE cpf =?";
		st=db.DB.conn.prepareStatement(sql);
		st.setDouble(1, salario);
		st.setString(2, cpf);
		
int rowsAffected=st.executeUpdate();
		
		System.out.println("Linhas atualizadas" + rowsAffected);
		
		 
	 }catch (SQLException e) {
		// TODO: handle exception
	}
	 
 }

}
