package ACS_CRMN;

import javax.crypto.spec.SecretKeySpec;

 

public class AALabMain {

	 
	
	private static final String ALGORITHM = "HmacSHA1";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static String calculateRFC2104HMAC(String data, String key)
			throws java.security.SignatureException
			{
			    String result;
			    try
			 
			    {
			        // get an hmac_sha1 key from the raw key bytes
			        SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), ALGORITHM); 
			 
			 
			        // get an hmac_sha1 Mac instance and initialize with the signing key 
			        Mac mac = Mac.getInstance(ALGORITHM); 
			        mac.init(signingKey); 
			 
			 
			        // compute the hmac on input data 
			        bytes byte[] rawHmac = mac.doFinal(data.getBytes()); 
			 
			 
			        // base64-encode the hmac 
			        result = EncodeBase64(rawHmac); 
			    }
			    catch (Exception e){ 
			        throw new SignatureException("Failed to generate HMAC : " + e.getMessage()); 
			    }
			    return result;
			}
	
	
	
	public static String EncodeBase64(byte[] rawData){ 
	    return Base64.encodeBytes(rawData); }
	}
	
	
	
	
	

}
