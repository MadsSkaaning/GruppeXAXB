package shared;

public class AuthUser implements java.io.Serializable
{
	private  final long serialVersionUID = 2L;
	private final String overallID = "logIn";
	private String email;
	private String password;
	private boolean isAdmin;
	private boolean isAuthenticated;
	
	//public AuthUser(String email, String password) {
	//	this.email = email;
	//	this.password = password;
	//}
	
	public boolean isAuthenticated() {
		return isAuthenticated;
	}
	public void setAuthenticated(boolean isAuthenticated) {
		this.isAuthenticated = isAuthenticated;
	}
	
	public String getOverallID() {
		return overallID;
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