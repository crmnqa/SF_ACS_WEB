package ACS_CRMN;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import com.sun.jersey.api.client.UniformInterfaceException;

public class AcsCalls extends UtilitiesBaseClass {

	 
	 
	
	//**** PROFILE *****
	
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
	 	

// **** ENTITLEMENTS *****
	 
	 public static String[] custEntitlements(String content, String endpoint) throws JSONException, UniformInterfaceException, IOException{
		   
		   	String output =    restful(content, endpoint);
		  
		     String[ ] entitlement = new String[12];
		    
		       JSONObject jo = new JSONObject(output);   
	   
		       entitlement[0] = jo.get("subscriptions").toString();
		  	  

		    return entitlement;
		   	  
	  }       
	 	


	
	
	
	
	
	
	
}
