package logic;

// TODO: Auto-generated Javadoc
/**
 * The Class encryption.
 */
public class Encryption {
	/**
	 * Decrypt.
	 *
	 * @param b the b
	 * @return the string
	 */
	public String decrypt(byte[] b)
	{
		
		// Getting the configurations to get the set values in config.json
		// Can prove useful the cryptkey is to be changed.
		// This system is NOT using the encryption - as it turned out to be bugged when returning the answer from the server to client. 
		Configurations CF = new Configurations();


		String configKey = CF.getFfcryptkey();
		double cryptKey = Double.parseDouble(configKey);
		byte ff = (byte) cryptKey;
		//		Generates for loop containing decryption value
		for(int i = 0 ; i<b.length ; i++)
		{
			b[i] = (byte)(b[i]^ff);
		}
		//		Generates new String without any white spaces following or leading
		String encrypted = new String(b).trim();
		//		Returns decrypted String
		return encrypted;
	}
}
