package vlg.access.mapping.model;

import java.sql.Connection;
import java.sql.DriverManager;

//CHANGE THIS CLASS NAME TO 'ConnectionFactory' AND INSERT THE DATABASE-ADDRESS, DATABASE-LOGIN AND DATABASE-PASSWORD BELOW.
public class ConnectionFactoryNoData{
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String caminhoBD = "DATABASE-ADDRESS-HERE";
			return DriverManager.getConnection("jdbc:mysql:" + caminhoBD,"DATABASE-LOGIN-HERE","DATABASE-PASSWORD-HERE");
			
		} catch (Exception e) {
			System.out.println("nao conectou...........................");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
}
