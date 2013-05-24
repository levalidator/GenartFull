package commons;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * Tool class
 * Toolbox
 * @author The GenArt Team
 *
 */
public class Tools {
	
	/**
	 * Returns an md5 encrypted version from a string
	 */
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
