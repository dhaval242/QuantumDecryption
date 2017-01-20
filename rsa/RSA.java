package rsa;

import java.math.BigInteger;
import java.util.Random;

public class RSA {
		
//	private int p ;
//	private int q ;
//	private int phi;
//	private int e ;
//	private int d ;
//	private int bitlen ;
//	private int n ;


	/* Code for smaller bits*/

	
	
//	public static int modinv(int a , int n){
//		
//		for (int i = 1 ; i < n ; i++){
//			
//			if((i*a)%n == 1){
//				return i;
//			}
//		}
//		return 0 ;
//	}
//	public RSA()
//	{
//		p = 3 ;
//		q = 11 ;
//		n = p*q;
//		phi = (p-1)*(q-1);
//		e = 7 ;
//		d = modinv(e, phi);
//		
//	}
//	
//	public double encrypt(String message)
//	{
//		System.out.println("Message is "+Integer.parseInt(message));
//		double temp =(Math.pow((double)Integer.parseInt(message) , (double)e));
//		
//		return temp%(double)n ;
//	}
//	
//	public double decrypt(double en)
//	{
//		return  Math.pow(en , (double)d)%n ;
//	}
	
	 	private BigInteger p;
	    private BigInteger q;
	    private BigInteger N;
	    private BigInteger phi;
	    private BigInteger e;
	    private BigInteger d;
	    private int bitlength = 128;
	    private Random r;
	    
	    public RSA()
	    {
	        r = new Random();
	        p = BigInteger.probablePrime(bitlength, r);
	        q = BigInteger.probablePrime(bitlength, r);
	        N = p.multiply(q);
	        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
	        e = BigInteger.probablePrime(bitlength / 2, r);
	        
	        System.out.println("Public Key is : "+e);
	        while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0)
	        {
	            e.add(BigInteger.ONE);
	        }
	        d = e.modInverse(phi);
	    }
	    
	    public RSA(BigInteger e, BigInteger d, BigInteger N)
	    {
	        this.e = e;
	        this.d = d;
	        this.N = N;
	    }
	    
	    public byte[] encrypt(byte[] message)
	    {
	        return (new BigInteger(message)).modPow(e, N).toByteArray();
	    }
	    
	    public byte[] decrypt(byte[] message)
	    {
	        return (new BigInteger(message)).modPow(d, N).toByteArray();
	    }
	 
}
