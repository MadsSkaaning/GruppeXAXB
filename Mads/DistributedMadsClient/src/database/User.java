/*
 * 
 */
package database;

// TODO: Auto-generated Javadoc
// User.java
/**
 * The Class User.
 */
public class User
{

	/** The ID mail. */
	private String IDMail;

	/** The first name. */
	private String firstName;

	/** The last name. */
	private String lastName;

	/** The user adress. */
	private String userAdress;

	/** The zip code. */
	private int zipCode;

	/** The user age. */
	private int userAge;

	/** The user phone. */
	private String userPhone;

	/** The user btc balance. */
	private double userBTCBalance;

	/** The Password. */
	private String Password;

	/** The is admin. */
	private boolean isAdmin;

	/** The current user. */
	public static User currentUser = null;

	// constructor
	/**
	 * Instantiates a new user.
	 *
	 * @param id the id
	 * @param first the first
	 * @param last the last
	 * @param adress the adress
	 * @param zip the zip
	 * @param phone the phone
	 * @param age the age
	 * @param balance the balance
	 * @param pw the pw
	 * @param admin the admin
	 */
	public User(String id, String first, String last, String adress, int zip,
			String phone, int age, double balance, String pw, boolean admin)
	{
		setIDMail( id );
		setfirstName( first );
		setlastName( last );
		setuserAdress( adress );
		setzipCode ( zip );
		setuserPhone( phone );
		setuserAge( age );
		setuserBTCBalance ( balance );
		setPassword ( pw );
		setisAdmin ( admin );
	} 

	/**
	 * Sets the ID mail.
	 *
	 * @param id the new ID mail
	 */
	public void setIDMail( String id )
	{
		IDMail = id;
	} // end method setIDMail

	// returns the IDMail
	/**
	 * Gets the ID mail.
	 *
	 * @return the ID mail
	 */
	public String getIDMail()
	{
		return IDMail;
	} // end method IDMail

	// sets the firstName
	/**
	 * Sets the first name.
	 *
	 * @param first the new first name
	 */
	public void setfirstName( String first )
	{
		firstName = first;
	} // end method setFirstName

	// returns the first name 
	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getfirstName()
	{
		return firstName;
	} // end method getFirstName

	// sets the lastName
	/**
	 * Sets the last name.
	 *
	 * @param last the new last name
	 */
	public void setlastName( String last )
	{
		lastName = last;
	} // end method setLastName

	// returns the last name 
	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName()
	{
		return lastName;
	} 

	/**
	 * Sets the user adress.
	 *
	 * @param adress the new user adress
	 */
	public void setuserAdress( String adress )
	{
		userAdress = adress;
	} // end method setEmail

	// returns the email address
	/**
	 * Gets the user adress.
	 *
	 * @return the user adress
	 */
	public String getuserAdress()
	{
		return userAdress;
	}

	/**
	 * Sets the user age.
	 *
	 * @param age the new user age
	 */
	public void setuserAge( int age )
	{
		userAge = age;
	} // end method setEmail

	// returns the email address
	/**
	 * Gets the user age.
	 *
	 * @return the user age
	 */
	public int getuserAge()
	{
		return userAge;
	}

	/**
	 * Sets the user btc balance.
	 *
	 * @param balance the new user btc balance
	 */
	public void setuserBTCBalance( double balance )
	{
		userBTCBalance = balance;
	} // end method setEmail

	// returns the email address
	/**
	 * Gets the user btc balance.
	 *
	 * @return the user btc balance
	 */
	public double getuserBTCBalance()
	{
		return userBTCBalance;
	}


	/**
	 * Sets the password.
	 *
	 * @param pw the new password
	 */
	public void setPassword( String pw )
	{
		Password = pw;
	} // end method setEmail

	// returns the email address
	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword()
	{
		return Password;
	}

	/**
	 * Sets the zip code.
	 *
	 * @param zip the new zip code
	 */
	public void setzipCode( int zip )
	{
		zipCode = zip;
	} // end method setEmail

	// returns the email address
	/**
	 * Gets the zip code.
	 *
	 * @return the zip code
	 */
	public int getzipCode()
	{
		return zipCode;
	}

	/**
	 * Sets the user phone.
	 *
	 * @param phone the new user phone
	 */
	public void setuserPhone( String phone )
	{
		userPhone = phone;
	} // end method setEmail

	// returns the email address
	/**
	 * Gets the user phone.
	 *
	 * @return the user phone
	 */
	public String getuserPhone()
	{
		return userPhone;
	}

	/**
	 * Sets the checks if is admin.
	 *
	 * @param admin the new checks if is admin
	 */
	public void setisAdmin(boolean admin )
	{
		isAdmin = admin;
	} // end method setEmail

	// returns the email address
	/**
	 * Gets the checks if is admin.
	 *
	 * @return the checks if is admin
	 */
	public boolean getisAdmin()
	{
		return isAdmin;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [IDMail=" + IDMail + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", userAdress=" + userAdress
				+ ", zipCode=" + zipCode + ", userAge=" + userAge + ", userPhone="
				+ userPhone + ", userBTCBalance=" + userBTCBalance + ", Password="
				+ Password + ", isAdmin=" + isAdmin + "]";
	}

} // end class User
