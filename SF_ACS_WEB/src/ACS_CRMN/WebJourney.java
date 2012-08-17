package ACS_CRMN;

import ACS_CRMN.WebJourneyBaseClass;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class  WebJourney extends WebJourneyBaseClass {
 
	AcsCalls acs=new AcsCalls();
 
       
   	@BeforeClass(groups = "a") 
 	public void setUp() throws Exception {
 	 ffsetup(); 
 	 
 	}
	    
  	@Test (groups = "a") 
	public void A_WebJourney1() throws Exception {
 	System.out.println("Step 1:-- Web journey - PART-1 started...stops beofre filling payment details....... " + "User ID is:---" + email); 	  	  
 	 webjourney1(email);
 	}
 	 
 	
 	@Test (groups = "a") 
	public static void B_CheckProfile() throws Exception {
 		Thread.sleep(5000) ;
 		System.out.println("Step 2:-- Call out ACS to compare values entered in web journey....." ); 	
  
 		String[] exp =  {"tnl", email,"External_ID", lastName, email, DispName, firstName, city, country, dob, postcode} ;
 		
 		
 		String content = "{\"tenantId\":\"TNL\",\"username\":\"" + email +"\"}" ;
 		
 		
 		String[] profile  = AcsCalls.custProfile(content,getProp("profile"))  ;
 		
 		
 		Assert.assertEquals( ProfileMatch(exp, profile),true,"Profile before updation........");
 		
 		B_Assert_CheckProfile(profile);
 		Thread.sleep(5000);
 		}
 	 	 	
 	@Test (groups = "a") 
	public void C_WebJourney2() throws Exception {
 	 	System.out.println("Step 3 :-- Web journey PART-2 fill payment details and save......." ); 	 
 		 webjourney2(email);
 		Thread.sleep(5000);

 	}  
 	
	@Test (groups = "a") 
	public void D_CheckEntitlement() throws Exception {
	 
 		System.out.println("Step 4:-- Call out ACS to check entitlements....." ); 		
 		String content = "{\"tenantId\":\"TNL\",\"username\":\"" + email +"\"}" ;
 		String[] entitlement = AcsCalls.custEntitlements(content,getProp("entitlements"))  ;	
 		
 	   Assert.assertEquals( EntitlementMatch(entitlement),false,"Entitlements  before updation...should be zero......."); 
 	  Thread.sleep(5000);
 	}
 	
 	 
 	@Test  
	public void E_WebJourneyEdit() throws Exception {
 		Thread.sleep(5000);
 	 	System.out.println("Step 5:--- Editing user detals in middle of journey........." ); 	 
 		 webjourneyEdit();
 	}
 	 	
 	@Test  
	public void F_Check_ACS_EditJourney_Profile() throws Exception {
 		Thread.sleep(5000);
 		System.out.println("Step 6:-- Call out ACS to compare updated values in web journey....." ); 		
 		String[] exp =  {"tnl", email,"External_ID", u_lastName, email, u_DispName, u_firstName, u_city, country, u_dob, postcode } ;
 		String content = "{\"tenantId\":\"TNL\",\"username\":\"" + email +"\"}" ;
 		String[] profile2  = AcsCalls.custProfile(content,getProp("profile"))  ;	
 	    Assert.assertEquals( ProfileMatch(exp, profile2),true,"Profile after updation........");
 		E_Assert_checkProfile(profile2) ; 
 	}
 	 	
 	@Test  
	public void G_CheckEntitlement() throws Exception {
 		  
 		System.out.println("Step 7:-- Call out ACS to check entitlements..Should exist now..." ); 		
 		String content = "{\"tenantId\":\"TNL\",\"username\":\"" + email +"\"}" ;
 		String[] entitlement =AcsCalls.custEntitlements(content,getProp("entitlements"))  ;	
 		System.out.println(EntitlementMatch(entitlement)); 
 	    Assert.assertEquals( EntitlementMatch(entitlement),true,"Entitlements  before updation...should be zero......."); 
 	}
 	
 	 //
  
 	
 
 	// END
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	// WILL BE MOVED TO UTILITIES LATER
 	
 	
 	public static boolean ProfileMatch(String[] exp, String[] prof){
 		boolean flag = true;

	   	  for ( int i = 0 ; i<=10; i ++)
		  {//System.out.println("ALL!!!!!!!!!!!!!!!!!!!!!!!!!!!!!:"+prof[i]  );
	   	  if  (exp[i].equals(prof[i])  )  {
	   	  System.out.println("Matched    :"+prof[i]+ "  :------------:   " +exp[i]); }	
	   	  else if ((exp[i].equals("External_ID")) )  {
	  	    	if (prof[i] != null){
	   		    System.out.println("Not Null    :"+prof[i]+"  :------------:   "+exp[i]);}
	   			else {
	   			System.out.println("Null    :    "+prof[i]+"  :------------:   "+exp[i]);}
	   		}
	   		  
	   	    else{
	  		System.out.println("MisMatched    :  "+prof[i]+"  :------------:   "+exp[i]);
	  		flag = false;  	}
	   		  
	  }
		
	if (flag == false) {
		
		System.out.println("Please check logs");
	}
	   	  
	   	  return flag;	
		
	
 	}
 	
 	

	public static void B_Assert_CheckProfile(String[] profile) throws Exception {
		Assert.assertEquals( profile[0],"tnl","Tenant ID Verification");
	    Assert.assertEquals( profile[1], email,"User Name Verification");
	   	Assert.assertEquals( profile[2] != null,true,"External ID Verification"); 
	  	Assert.assertEquals( profile[3], lastName,"lastname Verification");
	  	Assert.assertEquals( profile[4], email,"email Verification");
	    Assert.assertEquals( profile[5], DispName,"DisplayName Verification");
	  	Assert.assertEquals( profile[6],  firstName,"FirstName Verification");
	  //	Assert.assertEquals( profile[7] != null,true,"IAM ID Verification");
	  	Assert.assertEquals( profile[7], city,"City Verification");  	
	    Assert.assertEquals( profile[8], country,"Country verification");
	   Assert.assertEquals( profile[9], dob,"dob verification");
	  Assert.assertEquals( profile[10], postcode,"PostCode verification");
}    
	
 	public void E_Assert_checkProfile(String[] profile2) throws Exception {
 		
		Assert.assertEquals( profile2[0],"tnl","Tenant ID Verification");
	    Assert.assertEquals( profile2[1], email,"User Name Verification");
	    Assert.assertEquals( profile2[2] != null,true,"External ID Verification");
	  	Assert.assertEquals( profile2[3], u_lastName,"lastname Verification");
	  	Assert.assertEquals( profile2[4], email,"email Verification");
	    Assert.assertEquals( profile2[5], u_DispName,"DisplayName Verification");
	   	Assert.assertEquals( profile2[6],  u_firstName,"FirstName Verification");
	  	//Assert.assertEquals( profile2[7] != null,"IAM ID Verification");
	  	Assert.assertEquals( profile2[7], u_city,"City Verification");  
	  	Assert.assertEquals( profile2[8], country,"Country Verification");
	   
	    Assert.assertEquals( profile2[9], u_dob,"dob verification");
	    Assert.assertEquals( profile2[10], u_postcode,"Postcode verification");
	  	
 	}
 	
 	

 	// Entitlement Verification and Validation
	
	public boolean EntitlementMatch(String[] enti) {
 		
 		boolean flag = true;
 		
 		//System.out.println(enti[0].length());
 		
 		if ( enti[0].length() == 2  ) {
 			
 			flag = false;
 		
 		}
 		
 		return flag;
 	}
 	
		
}

 
	
 
 
	 
 
