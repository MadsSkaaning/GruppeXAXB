package logic;
import javax.xml.bind.ParseConversionEvent;

//Bruges ikke - det var meningen at klassen skulle bruges i forbindelse med selve TcpClient klassen, for at kryptere beskeder mellem server og klient.

//Det er ikke blevet n�et, men det skulle havet v�ret gjort ved at serveren sendte en krypteret streng, og s� skulle klassen decrypterer den med den krypterings key, der findes i configurations filen.

public class encryption {
//	Decryption path
	public String decrypt(byte[] b)
	{
		Configurations CF = new Configurations();
		
		//F�rst f�s krypterings n�glen fra konfigurations filen
		
		String crypKey = CF.getFfcryptkey();
		
		
		double doubleCryptKey = Double.parseDouble(crypKey);
		
		byte ff = (byte) doubleCryptKey;
		
//		S� laver vi et for loop g�r hele det byte array, som metoden bliver kaldt med igennem.
		for(int i = 0 ; i<b.length ; i++)
		{
			b[i] = (byte)(b[i]^ff);
		}
//		Laver en ny streng, hvor alle whites spaces er fjernet og retunerer den.
		String encrypted = new String(b).trim();

		return encrypted;
	}
}
