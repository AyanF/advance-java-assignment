package DAO;

import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

	private String jdbcUrl = "jdbc:mysql://localhost:3306/hotwaxsystem?useSSL=false";
	private String jdbcDriver="com.mysql.cj.jdbc.Driver";

	protected Connection getConnection() throws Exception {

		Properties propCred = new Properties();
		Path pathToProject = Paths.get("").toAbsolutePath();
		propCred.load(new FileInputStream(pathToProject+"/data.properties"));
		String user = propCred.getProperty("dbusername");
		String pass = propCred.getProperty("dbpassword");
		Class.forName(jdbcDriver);
		Connection connection = DriverManager.getConnection(jdbcUrl,user,pass);
		System.out.println("Connection successful");

		System.out.println(connection);
		return connection;
	}

	/*
	 * public static void main(String...args) { // TODO Auto-generated method stub
	 * System.out.println(Paths.get("").toAbsolutePath()+"/data.properties"); }
	 */


}
