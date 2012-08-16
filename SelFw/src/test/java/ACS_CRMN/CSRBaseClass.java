package ACS_CRMN;
 

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CSRBaseClass extends UtilitiesBaseClass {
	
	Properties properties = new Properties();
	String date =  date();
	String email = "csr_" +  emailid();  
	String gender = "Male";
	String password = "Password123";
	String title = "Mr";
	String firstName =   "F_" + date;
	String lastName =   "L_" + date;
	String day = "01";
	String month = "Jan";
	String year = "1990";
	String dob = day +"/"+ "03" +"/"+ year ;
	String postcode = "HA90AB";
	String city = "Wembley";
	String country = "United Kingdom";
	String DispName = firstName+" "+lastName; 
	//Updated
	
	String u_title = "Mrs";
	String u_firstName =   "1F_" + date ;
	String u_lastName =   "1L_" + date;
	String u_day = "03";
	String u_month = "Feb";
	String u_year = "1990";
	String u_dob = day +"/"+ "03" +"/"+ year ;
	String u_postcode = "HA99UB";
	String u_city = "Wembley Park";
	String u_DispName = u_firstName+" "+u_lastName;  
	
	String dobresp = year +"-"+ "03" +"-"+ day ;
	
	 
	public void custCreation() throws InterruptedException, IOException{
	
		driver.manage().deleteAllCookies(); 
 		 
		 
		driver.get(getProp("sfurl"));
		
		Thread.sleep(5000);
		driver.findElement(By.id("username")).sendKeys(getProp("sfuid"));
		 
		driver.findElement(By.id("password")).sendKeys(getProp("sfpass"));
		driver.findElement(By.id("Login")).click();
		Thread.sleep(10000);
		
		
		
		
		driver.findElement(By.cssSelector("img.allTabsArrow")).click();
		driver.findElement(By.linkText("Customers")).click();
		driver.findElement(By.name("new")).click();
		driver.findElement(By.cssSelector("#bottomButtonRow > input[name=\"save\"]")).click();
 

		
		driver.findElement(By.id("PersonEmail")).sendKeys(email);
		
		
		
	 
		driver.findElement(By.id("name_firstacc2")).sendKeys(firstName);
 
		driver.findElement(By.id("name_lastacc2")).sendKeys(lastName);
	
		new Select(driver.findElement(By.xpath("//div[@id='ep']/div[2]/div[3]/table/tbody/tr[4]/td[2]/select"))).selectByVisibleText(title);
		
		new Select(driver.findElement(By.id("00N20000003Ag9N"))).selectByVisibleText(gender);
 
		driver.findElement(By.id("00N20000003Ag9M")).sendKeys(DispName);
 
		driver.findElement(By.id("00N20000003B43e")).sendKeys("Flat 1");
 
		driver.findElement(By.id("00N20000003B43f")).sendKeys("Forum House");
 
		driver.findElement(By.id("00N20000003B43g")).sendKeys("Empire Way");
 
		driver.findElement(By.id("00N20000003B43l")).sendKeys(postcode);
 
		driver.findElement(By.id("00N20000003B43h")).sendKeys(city);
 
		driver.findElement(By.id("00N20000003B43j")).sendKeys("Wembley");
		
		driver.findElement(By.id("PersonBirthdate")).sendKeys(dob);
		
		new Select(driver.findElement(By.id("00N20000003Ajpc"))).selectByVisibleText("TNL");
		
		driver.findElement(By.cssSelector("#bottomButtonRow > input[name=\"save\"]")).click();
		
		driver.findElement(By.name("subscribe")).click();
		

}


public void BankDetails(){
	

driver.findElement(By.xpath("(//button[@type='button'])[10]")).click();
driver.findElement(By.id("dd-mandate-close")).click();

driver.findElement(By.id("dd_account_name")).sendKeys("CSRAccountHoler");

driver.findElement(By.id("dd_bank_name")).sendKeys("CSRBankName");

driver.findElement(By.id("dd_account_number")).sendKeys("12345678");

driver.findElement(By.id("dd_account_sort_1")).sendKeys("11");

driver.findElement(By.id("dd_account_sort_2")).sendKeys("11");

driver.findElement(By.id("dd_account_sort_3")).sendKeys("11");
driver.findElement(By.id("csr-paynow-dd")).click();


}




	public boolean ProfileMatch(String[] exp, String[] prof){
		boolean flag = true;

   	  for ( int i = 0 ; i<=10; i ++)
	  {//System.out.println("ALL!!!!!!!!!!!!!!!!!!!!!!!!!!!!!:"+prof[i]  );
   	  if  (exp[i].equals(prof[i])  )  {
   	  System.out.println("Matched    :"+prof[i]+ "  :------------:   " +exp[i]); }	
   	  else if ((exp[i].equals("External_ID")))   {
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
	
	
	
	
	public void Assert_CheckProfile(String[] profile) throws Exception {
		Assert.assertEquals( profile[0],"tnl","Tenant ID Verification");
	    Assert.assertEquals( profile[1],email,"User Name Verification");
	   	Assert.assertEquals( profile[2] != null,true,"External ID Verification"); 
	  	Assert.assertEquals( profile[3],lastName,"lastname Verification");
	  	Assert.assertEquals( profile[4],email,"email Verification");
	    Assert.assertEquals( profile[5],DispName,"DisplayName Verification");
	  	Assert.assertEquals( profile[6], firstName,"FirstName Verification");
	  //	Assert.assertEquals( profile[7] != null,true,"IAM ID Verification");
	  	Assert.assertEquals( profile[7],city,"email Verification");  	
	    Assert.assertEquals( profile[8],country,"Country verification");
	   Assert.assertEquals( profile[9],dobresp,"dob verification");
	  Assert.assertEquals( profile[10],postcode,"PostCode verification");
}  

	
	
	
	// Entitlement Verification and Validation
	
		public boolean EntitlementMatch(String[] enti) {
	 		
	 		boolean flag = true;
	 		
	 		 System.out.println(enti[0].length());
	 		
	 		if ( enti[0].length() == 2  ) {
	 			
	 			flag = false;
	 		
	 		}
	 		
	 		return flag;
	 	}
	 	
	
	
		public void webjourney1(String email) throws InterruptedException, IOException {
			
			 driver.manage().deleteAllCookies(); 
			 
	 
	 		driver.get(getProp("weburl"));  
	 		Thread.sleep(5000);
	 
	 		
	 		click("xpath", ".//*[@id='prenav']/div[1]/ul/li[2]/a");
	 		click("xpath", ".//*[@id='j_id0:j_id3:j_id11:j_id22:0:btnTopSubscribe']");
	 	 
	 	
	 		type("id", "j_id0:j_id1:personal_details_form:user_email", email);
	 		type("id", "j_id0:j_id1:personal_details_form:user_password", "password");
	 		type("id", "j_id0:j_id1:personal_details_form:user_confirm_password", "password");
		 
		 
			new Select(driver.findElement(By.id("j_id0:j_id1:personal_details_form:user_title"))).selectByVisibleText(title);
			
			type("id", "j_id0:j_id1:personal_details_form:user_first_name", firstName);
			
			type("id", "j_id0:j_id1:personal_details_form:user_last_name", lastName);
	 
			
			new Select(driver.findElement(By.id("j_id0:j_id1:personal_details_form:lstDateofBirthDays"))).selectByVisibleText(day);
			new Select(driver.findElement(By.id("j_id0:j_id1:personal_details_form:lstDateofBirthMonths"))).selectByVisibleText(month);
			new Select(driver.findElement(By.id("j_id0:j_id1:personal_details_form:lstDateofBirthYears"))).selectByVisibleText(year);
			driver.findElement(By.id("j_id0:j_id1:personal_details_form:user_postcode")).sendKeys(postcode);
			driver.findElement(By.id("j_id0:j_id1:personal_details_form:user_address_line_1")).sendKeys("Flat 1");
			driver.findElement(By.id("j_id0:j_id1:personal_details_form:user_address_line_2")).sendKeys("Forum House");
			driver.findElement(By.id("j_id0:j_id1:personal_details_form:user_address_line_3")).sendKeys("Empire Way");
			driver.findElement(By.id("j_id0:j_id1:personal_details_form:user_city")).sendKeys(city);
			
	 
			click("id", "j_id0:j_id1:personal_details_form:user_accept_tAndCs");
			
			driver.findElement(By.id("ni-reg-btn-register")).submit();
			Thread.sleep(10000);
		}
		
		



	}
 
        

 