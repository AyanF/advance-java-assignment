package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private String jdbcUrl = "jdbc:mysql://localhost:3306/hotwaxsystem?useSSL=false";
	private String user ="root";
	private String pass="123456";
	private String jdbcDriver="com.mysql.cj.jdbc.Driver";

	protected Connection getConnection() throws Exception {

		//Connection connection = null;

		//try {

			Class.forName(jdbcDriver);
			Connection connection = DriverManager.getConnection(jdbcUrl,user,pass);
			System.out.println("Connection successful");
			
		//}

		//catch  (SQLException sqlE) {
			//sqlE.printStackTrace();
		//}

		//catch(ClassNotFoundException clE) {
			//clE.printStackTrace();
		//}
		System.out.println(connection);
		return connection;
	}


}
