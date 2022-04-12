package DAO;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

	private String jdbcUrl = "jdbc:mysql://localhost:3306/hotwaxsystem?useSSL=false";
	private String jdbcDriver="com.mysql.cj.jdbc.Driver";

	protected Connection getConnection() throws Exception {

		//Connection connection = null;

		//try {
			Properties propCred = new Properties();
    		propCred.load(new FileInputStream("/home/ayan/eclipse-workspace/customerRegistration/data.properties"));
    		String user = propCred.getProperty("dbusername");
    		String pass = propCred.getProperty("dbpassword");
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
