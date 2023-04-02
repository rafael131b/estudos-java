import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class Program {
	
public static void main(String[] args) {
	
	Connection conn =null;
	Statement st= null;
	ResultSet rs=null;
	PreparedStatement pst= null;
	Scanner sc= new Scanner(System.in);
	
	
	try {
		conn=Conexao.conectar();
		pst=conn.prepareStatement(
				"INSERT INTO fornecedores"
				+ "(codigo,nome,email)"
				+ "VALUES" 
				+ "(?,?,?)",
				Statement.RETURN_GENERATED_KEYS
				);
		
		System.out.println("Digite o  codigo ");
		int codigo=sc.nextInt();
		System.out.println("Digite o  nome ");
		String nome=sc.next();
		System.out.println("Digite o  email ");
		String email=sc.next();
		pst.setInt(1, codigo);
		pst.setString(2, nome);
		pst.setString(3, email);
		int rowsAffected = pst.executeUpdate();
		System.out.println("DONE ! " + rowsAffected + "Linhas afetadas");
	}catch (Exception e) {
		throw new DbIntregrityException(e.getMessage());
	}
	
//	try {
//		conn=Conexao.conectar();
//		if(conn!=null) {
//		
//			st=conn.createStatement();
//			rs=st.executeQuery("select * from fornecedores");
//			System.out.println("chegou aqui");
//			while(rs.next()) {
//				System.out.println(rs.getInt("codigo") + ","  +  rs.getString("nome"));
//			}
//		}
//		
//	}catch (SQLException e) {
//		e.printStackTrace();
//	}
	
	
//	try {
//		conn=Conexao.conectar();
//		pst=conn.prepareStatement("UPDATE fornecedores "
//								+"SET email = ? "
//								+ "WHERE"
//								+ "(email=?)"
//				);
//		pst.setString(1, "zezinhopaodeacucar.com");
//		pst.setString(2, "jose.com");
//		
//		int rowsAffecteds =pst.executeUpdate();
//		System.out.println("DONE!" + rowsAffecteds + "linhas afetadas");
//	}catch (SQLException e) {
//		e.printStackTrace();
//	}finally {
//		Conexao.closeConnection();
//	}
	
	
	
//	try {
//		conn=Conexao.conectar();
//		pst=conn.prepareStatement(
//				"DELETE FROM fornecedores " 
//				+ "WHERE "
//				+ "codigo=?");
//		pst.setInt(1, 6);
//		int rowsAffecteds =pst.executeUpdate();
//	System.out.println("DONE!" + rowsAffecteds + "linhas afetadas");
//	}catch (SQLException e) {
//		throw new DbIntregrityException(e.getMessage());
//	}
}

}
