package db;

public class DbException extends Exception {
	
	public DbException(String msg) {
		super(msg);
		
		System.out.println("ERRO COM O MYSQL" + msg);
		
	}

}
