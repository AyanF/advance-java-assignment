package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTO.Party;
import DTO.UserLogin;

public class LogicalCode extends DBConnection {

	public List<Party> displayAllUsers(Party party) {

		List<Party> partyList= new ArrayList<>();
		try(Connection conn = getConnection();
				PreparedStatement st = conn.prepareStatement("SELECT firstName,lastName,adddress,city,zip,state,country,phone FROM party ");){
			ResultSet rs= st.executeQuery();
			while(rs.next()) {
				/*party.setFirstName(rs.getString(1));
				party.setLastName(rs.getString(2));
				party.setAddress(rs.getString(3));
				party.setCity(rs.getString(4));
				party.setZip(rs.getString(5));
				party.setState(rs.getString(6));
				party.setCountry(rs.getString(7));
				party.setPhone(rs.getString(8));*/
				String fname = rs.getString(1);
				String lname = rs.getString(2);
				String address = rs.getString(3);
				String city = rs.getString(4);
				String zip = rs.getString(5);
				String state = rs.getString(6);
				String country = rs.getString(7);
				String phone = rs.getString(8);

				Party partyObj = new Party(fname,lname,address,city,zip,state,country,phone);
				partyList.add(partyObj);
			}
		}
		catch(SQLException sqlE) {
			sqlE.printStackTrace();
		}
		return partyList;
	}

	public void insertUser(Party party, UserLogin userLogin) throws SQLException {

		try(Connection conn = getConnection();
				PreparedStatement st = conn.prepareStatement("INSERT INTO party (firstName,lastName,address,city,zip,state,country,phone)" 
						+"VALUES(?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
				PreparedStatement st2= conn.prepareStatement("INSERT INTO userLogin (userLoginId,password,partyId) VALUES(?,?,?)");
				) {

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
		
		try(Connection conn = getConnection();
				PreparedStatement st = conn.prepareStatement("DELETE party, userlogin FROM party INNER JOIN userlogin "
						+ "ON party.partyId = userlogin.partyId WHERE party.partyId= ?");
				){
			st.setInt(1, partyId);
			st.executeUpdate();
			}
	}

	public void updateUser(Party party) throws SQLException{
		
		try(Connection conn = getConnection();
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
		}
	}

	public Party searchUser(String fname, String lname) {
		
		Party partyObj =new Party();
		
		try(Connection conn = getConnection();
				PreparedStatement st = conn.prepareStatement("SELECT (firstName,lastName,address,city,zip,state,country,phone) FROM party "
						+ " WHERE fname=? AND lname=?");
				){
			st.setString(1, fname);
			st.setString(2, lname);
			
			ResultSet rs= st.executeQuery();
			
			String fnameU = rs.getString(1);
			String lnameU = rs.getString(2);
			String addressU = rs.getString(3);
			String cityU = rs.getString(4);
			String zipU = rs.getString(5);
			String stateU = rs.getString(6);
			String countryU = rs.getString(7);
			String phoneU = rs.getString(8);
			
			 partyObj = new Party(fnameU,lnameU,addressU,cityU,zipU,stateU,countryU,phoneU);
			}
		
		catch(SQLException sqlE) {
			sqlE.printStackTrace();
		}
		return partyObj;
		
		}

	public void loginUser(UserLogin userLogin) throws SQLException {
		
		try(Connection conn = getConnection();
				PreparedStatement st = conn.prepareStatement("SELECT (userLoginId,password) FROM userLogin WHERE userLoginId= ? ");
				){
			String entId = userLogin.getUserLoginId();
			String entPwd = userLogin.getPassword();
			st.setString(1, entId);
			
			ResultSet rs= st.executeQuery();
			String id = rs.getString(1);
			if(id.equals(id))
			{
				String pwd = rs.getString(2);
				if(pwd.equals(entPwd))
				{
					System.out.println("Login success");
				}
			}
			
		}
		catch(SQLException sqlE) {
			
		}
		
	}


}
