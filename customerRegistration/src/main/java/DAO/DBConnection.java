package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private String jdbcUrl = "jdbc:mysql://localhost:3306/userdb?userSSL=false";
	private String user ="root";
	private String pass="123456";
	private String jdbcDriver="com.mysql.jdbc.driver";

	protected Connection getConnection() {

		Connection connection = null;

		try {

			Class.forName(jdbcDriver);
			connection = DriverManager.getConnection(jdbcUrl,user,pass);
			System.out.println("Connection successful");
		}

		catch (SQLException sqlE) {
			sqlE.printStackTrace();
		}

		catch(ClassNotFoundException clE) {
			clE.printStackTrace();
		}

		return connection;
	}


}
