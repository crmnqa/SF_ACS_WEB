package ACS_CRMN;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

public class runner {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UniformInterfaceException 
	 */
	public static void main(String[] args) throws UniformInterfaceException, IOException {
		// TODO Auto-generated method stub
		
		String endpoint = "https://acs-staging.newsint.co.uk/profile/getUserProfile" ;
		String	 email = 	"cwebsel_08_09_09_42_21@zaqwsx.com" ;
				String content = "{\"tenantId\":\"TNL\",\"username\":\"" + email +"\"}" ;
			
		String output =    restful(content, endpoint);
		
		System.out.println("Tikium Tikkum" + output);

	}
	
	
	 public static String restful(String content, String endpoint) throws UniformInterfaceException, IOException {
		  
		  Client client = new Client();
		   WebResource resource = client.resource(endpoint);
		    
		 		   ClientResponse response =resource
		 		  .header("X-NI-signatureType", "2")
		 		  .header("X-NI-apiVersion", "1")
		 		  .header("X-NI-signatureHash", "dummy") 
		 		  .header("X-NI-apiKey", "a3a0a84318e06c048a8bdb56c966f060")
		 		  .type("application/json")
		 		  .accept("application/json")
		 		  .post(ClientResponse.class,content);
				return response.getEntity(String.class);
			 
		   		   
		  }
	 
	 
	 
	 public static String[] custProfile(String content, String endpoint) throws JSONException, UniformInterfaceException, IOException{
		   
		   	String output =    restful(content, endpoint);
		  
		     String[ ] profile = new String[12];
		    
		       JSONObject jo = new JSONObject(output);   
	   
		  	  profile[0] = jo.get( "tenantId").toString();
		  	  profile[1] = jo.get( "username").toString();
		      profile[2] = jo.get( "externalId").toString();
		  	   
		     	JSONObject jos = new JSONObject(jo.get( "profileData").toString()); 
		  	  
		  	  profile[3] = jos.get( "lastName").toString();
		  	  profile[4] = jos.get( "email").toString();
		  	  profile[5] = jos.get( "displayName").toString();
		  	  profile[6] = jos.get( "firstName").toString();
		  	 
		  	  profile[7] = jos.get( "city").toString();
		  	  profile[8] = jos.get( "country").toString();
		  	  profile[9] = jos.get( "dateOfBirth").toString();
		  	 profile[10] = jos.get( "postcode").toString();
		  	 // profile[11] = jos.get( "postcode").toString();

		    return profile;
		   	   
	  }       
	 	

}
