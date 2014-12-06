package model.calendar;

import java.security.MessageDigest;

// TODO: Auto-generated Javadoc
/**
 * The Class EncryptUserID.
 */
public class EncryptUserID {

	/**
	 * Constant cipher seed - DO NOT CHANGE.
	 * http://www.miraclesalad.com/webtools/md5.php - Du kan her saette userid foerst og derefter hashkey for at teste
	 */
	private static final String HASHKEY = "v.eRyzeKretW0r_t";

	/** The user id. */
	private static String userId = "haje13ac";

	/** The digester. */
	private static MessageDigest digester;

	static {
		try {
			digester = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Enkryptere en tekst streng som bliver parset til funktionen
	/**
	 * Crypt.
	 *
	 * @param str the str
	 * @return the string
	 */
	public static String crypt(String str) {
		if (str == null || str.length() == 0) {
			throw new IllegalArgumentException("Error");
		}

		digester.update(str.getBytes());
		byte[] hash = digester.digest();
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < hash.length; i++) {
			if ((0xff & hash[i]) < 0x10) {
				hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
			} else {
				hexString.append(Integer.toHexString(0xFF & hash[i]));
			}
		}
		return hexString.toString();
	}

	//Quick example of howe hash.

	/** The key. */
	String key = crypt(userId+ HASHKEY);



	/**
	 * Gets the key.
	 *
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

}

