package Symmetric_Encryption_Cryptography;

import java.security.SecureRandom;
//import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class Symmetric_Encryption_Decryption {
	private static final String AES = "AES";
	private static final String AES_CIPHER_ALGORITHM = "AES/CBC/PKCS5PADDING";
	
//	private static Scanner message;
	
	// Function to create a secret key
	public static SecretKey createAESKey() throws Exception {
		SecureRandom secureRandom = new SecureRandom();
		
		KeyGenerator keyGenerator = KeyGenerator.getInstance(AES);
		keyGenerator.init(256, secureRandom);
		
		// Generate key
		SecretKey key = keyGenerator.generateKey();
		return key;
	}
	
	// Function to initialize a vector with an arbitrary value
	public static byte[] createInitializationVector() {
		// Used with encryption
		byte[] initializationVector = new byte[16];
		SecureRandom secureRandom = new SecureRandom();
		secureRandom.nextBytes(initializationVector);
		
		return initializationVector;
	}
	
	// This function to take a plaintext,
	// The key with an initialization
	// Vector to convert plaintext into CipherText
	public static byte[] do_AESEncryption(String plainText, SecretKey secretKey, byte[] initializationVector) throws Exception {
		Cipher cipher = Cipher.getInstance(AES_CIPHER_ALGORITHM);
		
		IvParameterSpec ivParameterSpec = new IvParameterSpec(initializationVector);
		
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
		
		return cipher.doFinal(plainText.getBytes());
	}
	
	/**
	 * This function performs the reverse operation of the do_AESEncryption function
	 * It converts ciphertext to the plaintext using the key
	 * @param args
	 */
	public static String do_AESDecryption(byte[] cipherText, SecretKey secretKey, byte[] initializationVector) throws Exception {
		Cipher cipher = Cipher.getInstance(AES_CIPHER_ALGORITHM);
		
		IvParameterSpec ivParameterSpec = new IvParameterSpec(initializationVector);
		
		cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
		
		byte[] result = cipher.doFinal(cipherText);
		
		return new String(result);
	}

	// Driver code
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		SecretKey Symmetrickey = createAESKey();
		
		System.out.println("The symmetric key is: " + Generate_Symmatric_Key.printHexValue(Symmetrickey));
		
		byte[] initializationVector = createInitializationVector();
		
		String plainText = "This is the message." + " I want to Encrypt";
		
		// Encryption - Symmetrickey
		byte[] cipherText = do_AESEncryption(plainText, Symmetrickey, initializationVector);
		
		System.out.println("The cipher text or Encrypted message is: " + Generate_Symmatric_Key.printCipherText(cipherText));
		
		// Decryption message
		String decryptedText = do_AESDecryption(cipherText, Symmetrickey, initializationVector);
		System.out.println("Original message is: " + decryptedText);
	}

}
