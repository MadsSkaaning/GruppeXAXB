package logic;
import javax.xml.bind.ParseConversionEvent;

//Bruges ikke - det var meningen at klassen skulle bruges i forbindelse med selve TcpClient klassen, for at kryptere beskeder mellem server og klient.

//Det er ikke blevet nået, men det skulle havet været gjort ved at serveren sendte en krypteret streng, og så skulle klassen decrypterer den med den krypterings key, der findes i configurations filen.

public class encryption {
//	Decryption path
	public String decrypt(byte[] b)
	{
		Configurations CF = new Configurations();
		
		//Først fås krypterings nøglen fra konfigurations filen
		
		String crypKey = CF.getFfcryptkey();
		
		
		double doubleCryptKey = Double.parseDouble(crypKey);
		
		byte ff = (byte) doubleCryptKey;
		
//		Så laver vi et for loop går hele det byte array, som metoden bliver kaldt med igennem.
		for(int i = 0 ; i<b.length ; i++)
		{
			b[i] = (byte)(b[i]^ff);
		}
//		Laver en ny streng, hvor alle whites spaces er fjernet og retunerer den.
		String encrypted = new String(b).trim();

		return encrypted;
	}
}
