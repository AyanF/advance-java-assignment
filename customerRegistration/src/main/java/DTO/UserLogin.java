package DTO;

public class UserLogin {

	private String userLoginId;
	private String password;
	private int partyId;
	
	public UserLogin(String userLoginId, String password, int partyId) {
		super();
		this.userLoginId = userLoginId;
		this.password = password;
		this.partyId = partyId;
	}

	public UserLogin() {
		// TODO Auto-generated constructor stub
	}

	public String getUserLoginId() {
		return userLoginId;
	}
	public void setUserLoginId(String userLoginId) {
		this.userLoginId = userLoginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPartyId() {
		return partyId;
	}
	public void setPartyId(int partyId) {
		this.partyId = partyId;
	}
	
}
