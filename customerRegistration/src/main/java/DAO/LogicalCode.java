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
				PreparedStatement st = conn.prepareStatement("SELECT firstName,lastName,address,city,zip,state,country,phone,partyId FROM party ");){
				ResultSet rs= st.executeQuery();
			while(rs.next()) {
				String fname = rs.getString(1);
				String lname = rs.getString(2);
				String address = rs.getString(3);
				String city = rs.getString(4);
				String zip = rs.getString(5);
				String state = rs.getString(6);
				String country = rs.getString(7);
				String phone = rs.getString(8);
				int pId= rs.getInt(9);
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
			PreparedStatement st = conn.prepareStatement("INSERT INTO party (firstName,lastName,address,city,zip,state,country,phone)" 
					+"VALUES(?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			PreparedStatement st2= conn.prepareStatement("INSERT INTO userLogin (userLoginId,password,partyId) VALUES(?,?,?)");
			st.setString(1,party.getFirstName());
			st.setString(2,party.getLastName());
			st.setString(3,party.getAddress());
			st.setString(4,party.getCity());
			st.setString(5,party.getZip());
			st.setString(6,party.getState());
			st.setString(7,party.getCountry());
			st.setString(8,party.getPhone());
			System.out.println(st);
			st.executeUpdate();
			ResultSet rs = st.getGeneratedKeys();
			if(rs.next())
			{
				int partyId = rs.getInt(1);
				st2.setString(1,userLogin.getUserLoginId());
				st2.setString(2,userLogin.getPassword());
				st2.setInt(3, partyId);
				st2.executeUpdate();
			}
			
		}
		catch(SQLException sqlE){
			sqlE.printStackTrace();
		}

	}

	public void deleteUser(int partyId) throws SQLException {
		
		try(Connection conn = connection.getConnection();
				PreparedStatement st = conn.prepareStatement("DELETE FROM userlogin WHERE partyId= ?");
				PreparedStatement st2 = conn.prepareStatement("DELETE FROM party WHERE partyId= ?");
				){
				st.setInt(1, partyId);
				st2.setInt(1, partyId);
				st.executeUpdate();
				st2.executeUpdate();
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public void updateUser(Party party) throws SQLException{
		
		try(Connection conn = connection.getConnection();
				PreparedStatement st = conn.prepareStatement("UPDATE party SET firstName=?, lastName=? ,address=? ,"
						+ "city=?,zip=?,state=?,country=?,phone=? WHERE partyId=?");
				){
			st.setString(1,party.getFirstName());
			st.setString(2,party.getLastName());
			st.setString(3,party.getAddress());
			st.setString(4,party.getCity());
			st.setString(5,party.getZip());
			st.setString(6,party.getState());
			st.setString(7,party.getCountry());
			st.setString(8,party.getPhone());
			st.setInt(9,party.getPartyId());
			st.executeUpdate();
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
				PreparedStatement st = conn.prepareStatement("SELECT firstName,lastName,address,city,zip,state,country,phone,partyId FROM party WHERE firstname=? AND lastname=?");
				){
			st.setString(1, fname);
			st.setString(2, lname);
			ResultSet rs= st.executeQuery();
			if(rs.next())
			{
				String fnameU = rs.getString(1);
				String lnameU = rs.getString(2);
				String addressU = rs.getString(3);
				String cityU = rs.getString(4);
				String zipU = rs.getString(5);
				String stateU = rs.getString(6);
				String countryU = rs.getString(7);
				String phoneU = rs.getString(8);
				int pId= rs.getInt(9);
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

	public boolean loginUser(UserLogin userLogin) throws SQLException {
		
		boolean status=false;
		try(Connection conn = connection.getConnection();
				PreparedStatement st = conn.prepareStatement("SELECT * FROM userLogin WHERE userLoginId= ? AND password=?");
				){
			System.out.println("prepared statement");
			String entId = userLogin.getUserLoginId();
			System.out.println(entId);
			String entPwd = userLogin.getPassword();
			st.setString(1, entId);
			st.setString(2, entPwd);
			ResultSet rs= st.executeQuery();
			status = rs.next();
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
		MessageDigest m;
		try {
			m = MessageDigest.getInstance("MD5");
			m.update(pass.getBytes()); 
			byte[] bytes = m.digest();  
		    StringBuilder s = new StringBuilder();  
	            for(int i=0; i< bytes.length ;i++)  
	            {  
	                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));  
	            }  
	        encryptedPass=s.toString();
		} 
		catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		return encryptedPass;
	}
}
