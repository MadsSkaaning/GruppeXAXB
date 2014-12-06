package GUI;

// TODO: Auto-generated Javadoc
// Fig. 28.30: Person.java
// Person class that represents an entry in an address book.
/**
 * The Class UserInformation.
 */
public class UserInformation
{

	/** The user name. */
	private String userName;
	
	/** The password. */
	private String password;


	// no-argument constructor
	/**
	 * Instantiates a new user information.
	 */
	public UserInformation()
	{
	} // end no-argument Person constructor

	// constructor
	/**
	 * Instantiates a new user information.
	 *
	 * @param user the user
	 * @param pass the pass
	 */
	public UserInformation(  String user, String pass )
	{

		//      setUserid(id);

		setUserName ( user );
		setPassword ( pass );


	} 




	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the user name.
	 *
	 * @param user the new user name
	 */
	public void setUserName(String user) {
		userName = user;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param pass the new password
	 */
	public void setPassword(String pass) {
		password = pass;
	}

}



