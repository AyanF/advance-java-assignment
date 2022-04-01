package DTO;

public class userLogin {

	private String userLoginId;
	private String password;
	private int partyId;
	
	public userLogin(String userLoginId, String password, int partyId) {
		super();
		this.userLoginId = userLoginId;
		this.password = password;
		this.partyId = partyId;
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
