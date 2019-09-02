package vlg.access.mapping.model;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionFactory{
	String mySqlUser = System.getenv("MYSQL_USER");
	String mySqlPassword = System.getenv("MYSQL_PASSWORD");

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String caminhoBD = "//vlgconnect.dlinkddns.com/vlg_network";
			return DriverManager.getConnection("jdbc:mysql:" + caminhoBD, mySqlUser, mySqlPassword);
			
		} catch (Exception e) {
			System.out.println("nao conectou...........................");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
}
