package shared;

public class AuthUser implements java.io.Serializable
{
	private  final long serialVersionUID = 2L;
	private String overallID = "logIn";
	private String email;
	private String password;
	private boolean isAdmin;
	private boolean isAuthenticated;
	
	//Getters and setters for everything, bitch
	
	public boolean isAuthenticated() {
		return isAuthenticated;
	}
	public void setAuthenticated(boolean isAuthenticated) {
		this.isAuthenticated = isAuthenticated;
	}
	
	public String getOverallID() {
		return overallID;
	}
	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}
	public String getAuthUserEmail() {
		return email;
	}
	public void setAuthUserEmail(String email) {
		this.email = email;
	}
	public String getAuthUserPassword() {
		return password;
	}
	public void setAuthUserPassword(String password) {
		this.password = password;
	}
	public boolean getAuthUserIsAdmin() {
		return isAdmin;
	}
	public void setAuthUserIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	


}