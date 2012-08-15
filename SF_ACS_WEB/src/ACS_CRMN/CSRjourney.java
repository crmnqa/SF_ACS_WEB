package ACS_CRMN;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class  CSRjourney extends UtilitiesBaseClass  {
	
	 CSRBaseClass csr = new CSRBaseClass();
 
	AcsCalls acs=new AcsCalls();
    String email = csr.email;	 
     
       
   	@BeforeClass(groups = "a") 
 	public void setUp() throws Exception {
 	csr.ffsetup();
 	 
 	}
	    
 	@Test (groups = "a") 
	public void A_custCreation() throws Exception {
 		System.out.println("Step 1:-- CSR journey started.......... " + "User ID is:---" + email);
 		csr.custCreation();
 	}
 	
 	@Test (groups = "a") 
	public void B_custBankDetails() throws Exception {
 		csr. BankDetails();
 		Thread.sleep(5000) ;
 	}

 	
	
		@Test (groups = "a") 
		public void C_CheckProfile() throws Exception , IOException{
	 		Thread.sleep(5000) ;
	 		System.out.println("Step 2:-- Call out ACS to compare values entered in web journey....." ); 	
	 	 
	 		String[] exp =  {"tnl",csr.email,"External_ID",csr.lastName,csr.email,csr.DispName,csr.firstName,csr.city,csr.country,csr.dob,csr.postcode} ;
	 		String content = "{\"tenantId\":\"TNL\",\"username\":\"" + email +"\"}" ;
	 		String[] profile  = AcsCalls.custProfile(content,getProp("profile") )  ;
	 		Assert.assertEquals( csr.ProfileMatch(exp, profile),true,"Profile before updation........");
	 		csr.Assert_CheckProfile(profile);
	 		}
		
		
		@Test (groups = "a") 
	
		public void D_CheckEntitlement() throws Exception {
			Thread.sleep(5000) ;
			String email = "websel_08_01_11_38_43@zaqwsx.com" ;
	 		System.out.println("Step 4:-- Call out ACS to check entitlements....." ); 		
	 		String content = "{\"tenantId\":\"TNL\",\"username\":\"" + email +"\"}" ;
	 		String[] entitlement = acs.custEntitlements(content,getProp("entitlements"));	
	 		
	 	   Assert.assertEquals( csr.EntitlementMatch(entitlement),true,"Entitlements  before updation...should be zero......."); 
	 	}

 	

 
 	// END
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	

 	
		
}

 
	
 
 
	 
 
