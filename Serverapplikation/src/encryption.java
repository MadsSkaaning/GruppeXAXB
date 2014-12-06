import config.Configurations;



// TODO: Auto-generated Javadoc
/**
 * The Class encryption.
 */
public class encryption {
	//	Decryption path
	/**
	 * Decrypt.
	 *
	 * @param b the b
	 * @return the string
	 */
	public String decrypt(byte[] b)
	{
		Configurations CF = new Configurations();


		System.out.println(CF.getFfcryptkey());
		String configKey = CF.getFfcryptkey();
		System.out.println(configKey);
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
