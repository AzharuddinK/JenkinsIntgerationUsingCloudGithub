package utility;
import org.apache.commons.codec.binary.Base64;

public class EncryptUtils {
	
	public static String encodeString(String text) {
		byte[] encodeString = Base64.encodeBase64(text.getBytes());
		return new String(encodeString);
	}
	
	public static String decodeString(String text) {
		byte[] decodeString = Base64.decodeBase64(text.getBytes());
		return new String(decodeString);
	}
	
	
}
