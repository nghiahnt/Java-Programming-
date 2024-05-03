package Symmetric_Encryption_Cryptography;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class Generate_Symmatric_Key {
	public static final String AES = "AES";
	
	// Function to create a secret key
	public static SecretKey createAESKey() throws NoSuchAlgorithmException {
		SecureRandom secureRandom = new SecureRandom();
		
		// Passing the string to KeyGenerator
		KeyGenerator keyGenerator = KeyGenerator.getInstance(AES);
		
		// Initializing the keygenerator with 256 bits
		keyGenerator.init(256, secureRandom);
		SecretKey key = keyGenerator.generateKey();
		return key;
	}
	
	public static String printHexValue(SecretKey key) {
		byte[] keyBytes = key.getEncoded();
		String encodedKey = Base64.getEncoder().encodeToString(keyBytes);
		return encodedKey;
	}
	
	public static String printCipherText(byte[] key) {
		String encodedKey = Base64.getEncoder().encodeToString(key);
		return encodedKey;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		SecretKey symmetricKey = createAESKey();
		byte[] keyBytes = symmetricKey.getEncoded(); // Convert to byte array
		String encodedkey = Base64.getEncoder().encodeToString(keyBytes);
		
		System.out.println("Output");
//		System.out.println("The Symmectric Key is: " + DatatypeConverter.printHexBinary(symmetricKey.getEncoded()));
		System.out.println("The Symmectric Key is: " + encodedkey);
	}

}
