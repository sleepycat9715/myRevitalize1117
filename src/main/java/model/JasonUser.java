package model;

public class JasonUser {
	String username;
	boolean uservalue;
	
	
	public JasonUser(String username, boolean uservalue) {		
		this.username = username;
		this.uservalue = uservalue;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public boolean isUservalue() {
		return uservalue;
	}
	
	public void setUservalue(boolean uservalue) {
		this.uservalue = uservalue;
	}
	
	@Override
	public String toString() {
		return "JasonUser [username=" + username + ", uservalue=" + uservalue + "]";
	}
	
	
	
	
}
