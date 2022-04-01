package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTO.Party;

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

	public void insertUser(Party party) throws SQLException {

		try(Connection conn = getConnection();
				PreparedStatement st = conn.prepareStatement("INSERT INTO party (firstName,lastName,address,city,zip,state,country,phone)" 
						+"VALUES(?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
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

		}
		catch(SQLException sqlE){
			sqlE.printStackTrace();
		}

	}

	public void deleteUser(int partyId) throws SQLException {
		
		try(Connection conn = getConnection();
				PreparedStatement st = conn.prepareStatement("SELECT FROM ");
				){
			
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
			
		}
		catch(SQLException sqlE) {
			sqlE.printStackTrace();
		}


	}

	public void searchUser(String fname, String lname) {


	}


	//call DBCONNECTION create connection

	//search method (by first name and last name )
	//call DBCONNECTION create connection

	//delete (delete by user id)
	//call DBCONNECTION create connection

	//user exist + password match




}
