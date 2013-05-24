package commons;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Tools {
	
	public static String encryptPassword(String passw){
		MessageDigest encryptedPass;
		try {
			encryptedPass = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			encryptedPass = null;
			e.printStackTrace();
		} 
		
		encryptedPass.update(passw.getBytes(), 0, passw.length());
		String md5 = new BigInteger(1, encryptedPass.digest()).toString(16);
		return md5;
	}
	
}
