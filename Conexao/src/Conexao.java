import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private static Connection conn=null;
	  public static Connection conectar() {
		   
		    try {
		      Class.forName("com.mysql.jdbc.Driver");
		      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursejdbc", "root", "root");
		      System.out.println("Conectou no banco de dados.");
		    } catch (SQLException ex) {
		      System.out.println("Erro: Não conseguiu conectar no BD.");
		      ex.printStackTrace();
		    } catch (ClassNotFoundException ex) {
		      System.out.println("Erro: Não encontrou o driver do BD.");
		      ex.printStackTrace();
		    }

		    return conn;
		  }
	  
	  
	  public static void closeConnection () {
		  if(conn!=null) {
			  try {
				  conn.close();
			  }catch (SQLException e) {
				e.printStackTrace();
			}
		  }
	  }
	  

}
