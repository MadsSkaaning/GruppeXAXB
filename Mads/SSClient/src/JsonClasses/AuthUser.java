package JsonClasses;

// TODO: Auto-generated Javadoc
/**
 * The Class AuthUser.
 */
public class AuthUser implements java.io.Serializable
{
	
	/** The serial version uid. */
	private  final long serialVersionUID = 2L;
	
	/** The overall id. */
	private final String overallID = "logIn";
	
	/** The email. */
	private String email;
	
	/** The password. */
	private String password;
	
	/** The is admin. */
	private boolean isAdmin;
	
	/** The is authenticated. */
	private boolean isAuthenticated;
	
	/**
	 * Checks if is authenticated.
	 *
	 * @return true, if is authenticated
	 */
	public boolean isAuthenticated() {
		return isAuthenticated;
	}
	
	/**
	 * Sets the authenticated.
	 *
	 * @param isAuthenticated the new authenticated
	 */
	public void setAuthenticated(boolean isAuthenticated) {
		this.isAuthenticated = isAuthenticated;
	}
	
	/**
	 * Gets the overall id.
	 *
	 * @return the overall id
	 */
	public String getOverallID() {
		return overallID;
	}
	
	/**
	 * Gets the auth user email.
	 *
	 * @return the auth user email
	 */
	public String getAuthUserEmail() {
		return email;
	}
	
	/**
	 * Sets the auth user email.
	 *
	 * @param email the new auth user email
	 */
	public void setAuthUserEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Gets the auth user password.
	 *
	 * @return the auth user password
	 */
	public String getAuthUserPassword() {
		return password;
	}
	
	/**
	 * Sets the auth user password.
	 *
	 * @param password the new auth user password
	 */
	public void setAuthUserPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Gets the auth user is admin.
	 *
	 * @return the auth user is admin
	 */
	public boolean getAuthUserIsAdmin() {
		return isAdmin;
	}
	
	/**
	 * Sets the auth user is admin.
	 *
	 * @param isAdmin the new auth user is admin
	 */
	public void setAuthUserIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}


}