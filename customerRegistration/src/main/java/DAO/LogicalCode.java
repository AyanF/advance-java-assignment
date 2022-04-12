package DAO;

import java.sql.Connection;
import java.security.NoSuchAlgorithmException;  
import java.security.MessageDigest;  
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTO.Party;
import DTO.UserLogin;

public class LogicalCode  {

	DBConnection connection= new DBConnection();

	public List<Party> displayAllUsers() {

		List<Party> partyList= new ArrayList<Party>();
		try(Connection conn = connection.getConnection();
				PreparedStatement statement = conn.prepareStatement("SELECT firstName,lastName,address,city,zip,state,country,phone,partyId FROM party ");){
			ResultSet resultSet= statement.executeQuery();
			while(resultSet.next()) {
				String fname = resultSet.getString(1);
				String lname = resultSet.getString(2);
				String address = resultSet.getString(3);
				String city = resultSet.getString(4);
				String zip = resultSet.getString(5);
				String state = resultSet.getString(6);
				String country = resultSet.getString(7);
				String phone = resultSet.getString(8);
				int pId= resultSet.getInt(9);
				Party partyObj = new Party(pId,fname,lname,address,city,zip,state,country,phone);
				partyList.add(partyObj);
			}
		}
		catch(SQLException sqlE) {
			sqlE.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return partyList;
	}

	public void insertUser(Party party, UserLogin userLogin) throws Exception {

		try {
			Connection conn = connection.getConnection();
			PreparedStatement statement = conn.prepareStatement("INSERT INTO party (firstName,lastName,address,city,zip,state,country,phone)" 
					+"VALUES(?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			PreparedStatement statement2= conn.prepareStatement("INSERT INTO userLogin (userLoginId,password,partyId) VALUES(?,?,?)");
			statement.setString(1,party.getFirstName());
			statement.setString(2,party.getLastName());
			statement.setString(3,party.getAddress());
			statement.setString(4,party.getCity());
			statement.setString(5,party.getZip());
			statement.setString(6,party.getState());
			statement.setString(7,party.getCountry());
			statement.setString(8,party.getPhone());
			System.out.println(statement);
			statement.executeUpdate();
			ResultSet resultSet = statement.getGeneratedKeys();
			if(resultSet.next())
			{
				int partyId = resultSet.getInt(1);
				statement2.setString(1,userLogin.getUserLoginId());
				statement2.setString(2,userLogin.getPassword());
				statement2.setInt(3, partyId);
				statement2.executeUpdate();
			}

		}
		catch(SQLException sqlE){
			sqlE.printStackTrace();
		}

	}

	public void deleteUser(int partyId) throws Exception {

		try(Connection conn = connection.getConnection();
				PreparedStatement statement = conn.prepareStatement("DELETE FROM userlogin WHERE partyId= ?");
				PreparedStatement statement2 = conn.prepareStatement("DELETE FROM party WHERE partyId= ?");
				){
			statement.setInt(1, partyId);
			statement2.setInt(1, partyId);
			statement.executeUpdate();
			statement2.executeUpdate();
		} 
		catch (SQLException sqle) 
		{
			sqle.printStackTrace();
		}

	}

	public void updateUser(Party party) throws SQLException{

		try(Connection conn = connection.getConnection();
				PreparedStatement statement = conn.prepareStatement("UPDATE party SET firstName=?, lastName=? ,address=? ,"
						+ "city=?,zip=?,state=?,country=?,phone=? WHERE partyId=?");
				){
			statement.setString(1,party.getFirstName());
			statement.setString(2,party.getLastName());
			statement.setString(3,party.getAddress());
			statement.setString(4,party.getCity());
			statement.setString(5,party.getZip());
			statement.setString(6,party.getState());
			statement.setString(7,party.getCountry());
			statement.setString(8,party.getPhone());
			statement.setInt(9,party.getPartyId());
			statement.executeUpdate();
		}
		catch(SQLException sqlE) {
			sqlE.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Party searchUser(String fname, String lname) {


		Party partyObj =new Party();
		try(Connection conn = connection.getConnection();
				PreparedStatement statement = conn.prepareStatement("SELECT firstName,lastName,address,city,zip,state,country,phone,partyId FROM party WHERE firstname=? AND lastname=?");
				){
			statement.setString(1, fname);
			statement.setString(2, lname);
			ResultSet resultSet= statement.executeQuery();
			if(resultSet.next())
			{
				String fnameU = resultSet.getString(1);
				String lnameU = resultSet.getString(2);
				String addressU = resultSet.getString(3);
				String cityU = resultSet.getString(4);
				String zipU = resultSet.getString(5);
				String stateU = resultSet.getString(6);
				String countryU = resultSet.getString(7);
				String phoneU = resultSet.getString(8);
				int pId= resultSet.getInt(9);
				partyObj = new Party(pId,fnameU,lnameU,addressU,cityU,zipU,stateU,countryU,phoneU);
			}
			else
			{
				partyObj=null;
			}
		}
		catch(SQLException sqlE) {
			sqlE.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return partyObj;
	}

	public Party searchUser(String name) {

		System.out.println("method called");
		Party partyObj =new Party();
		try(Connection conn = connection.getConnection();
				PreparedStatement statement = conn.prepareStatement("SELECT firstName,lastName,address,city,zip,state,country,phone,partyId FROM party WHERE firstname LIKE '%"+name+"%' OR lastname LIKE '%"+name+"%'");
				){
			//st.setString(1, name);
			//st.setString(2, name);
			System.out.println(name);
			ResultSet resultSet= statement.executeQuery();
			System.out.println(resultSet);
			if(resultSet.next())
			{
				String fnameUpdated = resultSet.getString(1);
				String lnameUpdated = resultSet.getString(2);
				String addressUpdated = resultSet.getString(3);
				String cityUpdated = resultSet.getString(4);
				String zipUpdated = resultSet.getString(5);
				String stateUpdated = resultSet.getString(6);
				String countryUpdated = resultSet.getString(7);
				String phoneUpdated = resultSet.getString(8);
				int pId= resultSet.getInt(9);
				partyObj = new Party(pId,fnameUpdated,lnameUpdated,addressUpdated,cityUpdated,zipUpdated,stateUpdated,countryUpdated,phoneUpdated);
			}
			else
			{
				partyObj=null;
			}
		}
		catch(SQLException sqlE) {
			sqlE.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return partyObj;
	}

	public boolean loginUser(UserLogin userLogin) throws SQLException {

		boolean status=false;
		try(Connection conn = connection.getConnection();
				PreparedStatement statement = conn.prepareStatement("SELECT * FROM userLogin WHERE userLoginId= ? AND password=?");
				){
			System.out.println("prepared statement");
			String entId = userLogin.getUserLoginId();
			System.out.println(entId);
			String entPwd = userLogin.getPassword();
			statement.setString(1, entId);
			statement.setString(2, entPwd);
			ResultSet resultSet= statement.executeQuery();
			status = resultSet.next();
		}
		catch(SQLException sqlE) {

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return status;
	}

	public String passwordEncryption(String pass) {

		String encryptedPass=null;
		MessageDigest messageDigestInstance;
		try {
			messageDigestInstance = MessageDigest.getInstance("MD5");
			messageDigestInstance.update(pass.getBytes()); 
			byte[] bytes = messageDigestInstance.digest();  
			StringBuilder stringBuilder = new StringBuilder();  
			for(int i=0; i< bytes.length ;i++)  
			{  
				stringBuilder.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));  
			}  
			encryptedPass=stringBuilder.toString();
		} 
		catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  

		return encryptedPass;
	}
}
