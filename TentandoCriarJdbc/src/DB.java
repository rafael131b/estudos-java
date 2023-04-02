import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



public class DB {
	
	public static Connection conn=null;
	
	public static Connection getConnection () throws DbException {
		if(conn==null) {
			try {
				Properties props= loadProperties();
				String url=props.getProperty("url");
				conn=DriverManager.getConnection(url,props);
				System.out.println("Conectou");
			}catch (SQLException e) {
				// TODO: handle exception
			}
		}
		return conn;
	}
	
	
	private static Properties  loadProperties() throws DbException {
		try(FileInputStream fs=new FileInputStream("db.properties")){
			Properties props=new Properties();
			props.load(fs);
			return props;
			
		}catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	
		
	}
	
	
	
}
