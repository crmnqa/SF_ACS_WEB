package ACS_CRMN;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class  CSRjourney extends CSRBaseClass {
  
 
      
	@BeforeClass(groups = "a") 
 	public void setUp() throws Exception {
		 
    ffsetup(); 
	 	  
 	}
	
	    
 	@Test (groups = "a") 
	public void A_custCreation() throws Exception {
 		System.out.println("Step 1:-- CSR journey started.......... " + "User ID is:---" + email);
 		 
 		 custCreation();
 		 
		  
 	}
 	
  	
 	
 	@Test (groups = "a") 
	public void B_custBankDetails() throws Exception {
 		 BankDetails();
 		Thread.sleep(5000) ;
 	}

 	
	
		@Test (groups = "a") 
		public void C_CheckProfile() throws Exception , IOException{
	 		Thread.sleep(5000) ;
	 		System.out.println("Step 2:-- Call out ACS to compare values entered in web journey....." ); 	
	 		String dob = dobresp;
	 		String[] exp =  {"tnl", email,"External_ID", lastName, email, DispName, firstName, city, country, dob, postcode} ;
	 		String content = "{\"tenantId\":\"TNL\",\"username\":\"" + email +"\"}" ;
	 		String[] profile  = AcsCalls.custProfile(content,getProp("profile") )  ;
	 		Assert.assertEquals(  ProfileMatch(exp, profile),true,"Profile before updation........");
	 		 Assert_CheckProfile(profile);
	 		}
		
		
		@Test (groups = "a") 
	
		public void D_CheckEntitlement() throws Exception {
			 
			 
	 		System.out.println("Step 4:-- Call out ACS to check entitlements....." ); 		
	 		String content = "{\"tenantId\":\"TNL\",\"username\":\"" + email +"\"}" ;
	 		String[] entitlement = AcsCalls.custEntitlements(content,getProp("entitlements"));	
	 		
	 	   Assert.assertEquals(  EntitlementMatch(entitlement),true,"Entitlements  before updation...should be zero......."); 
	 	}

 	

 
 	// END
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	

 	
		
}

 
	
 
 
	 
 
