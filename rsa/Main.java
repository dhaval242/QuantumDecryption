package rsa;

import java.math.BigInteger;

public class Main {

	private static String bytesToString(byte[] encrypted)
	{
	        String test = "";
	        for (byte b : encrypted)
	        {
	            test += Byte.toString(b);
	        }
	        return test;
	}
    

	
	public static void main(String args[])
	{
		
	
		RSA rsa = new RSA();
	    String teststring ;
	    
	    teststring = "hello";
//	    byte[] arr = teststring.getBytes();
//	    System.out.println(arr[0]);
//	    double en = (rsa.encrypt(teststring));
//	    System.out.println(rsa.decrypt(en));
//	    
	    
	    
	    System.out.println("Encrypting String: " + teststring);
	    System.out.println("String in Bytes: "
	            +bytesToString(teststring.getBytes()));
	    // encrypt
	    byte[] encrypted = rsa.encrypt(teststring.getBytes());
	    // decrypt
	    System.out.println(bytesToString(encrypted));
	    byte[] decrypted = rsa.decrypt(encrypted);
	    System.out.println("Decrypting Bytes: " + bytesToString(decrypted));
	    System.out.println("Decrypted String: " + new String(decrypted));
	}
}
