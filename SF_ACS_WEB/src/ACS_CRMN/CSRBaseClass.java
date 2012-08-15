package ACS_CRMN;
import ACS_CRMN.UtilitiesBaseClass; 

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.Properties;

public class CSRBaseClass extends UtilitiesBaseClass {
	 
 
 static CSRBaseClass csrl = new CSRBaseClass();
		WebDriver driver;
		String baseUrl;
		
		static String date =  date();
  		static String email = "c"+ emailid();  
		
		String gender = "Male";
		String title = "Mr";
		String firstName =   "F_" + date;
		String lastName =   "L_" + date;
		String day = "01";
		String month = "Jan";
		String year = "1990";
		String dob = day +"/"+ "02" +"/"+ year ;
		String postcode = "HA90AB";
		String city = "Wembley";
		String country = "United Kingdom";
		String DispName = firstName+" "+lastName; 
		//Updated
		
		String u_title = "Mrs";
		String u_firstName =   "1F_" + date ;
		String u_lastName =   "1L_" + date;
		String u_day = "02";
		String u_month = "Feb";
		String u_year = "1980";
		String u_dob = day +"/"+ "03" +"/"+ year ;
		String u_postcode = "HA99UB";
		String u_city = "Wembley Park";
		String u_DispName = u_firstName+" "+u_lastName; 
	
		//Get these from Envi
		//String csrUrl  = "https://test.salesforce.com/" ; 
	 	//String uid = "crm.admin@newsint.co.uk.uat" ;
		//String pass = "England2012";
		
		
	 

	public void custCreation() throws InterruptedException, IOException {
	
		driver.manage().deleteAllCookies(); 
		driver.get(getProp("sfurl"));
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
	    Assert.assertEquals( profile[1],csrl.email,"User Name Verification");
	   	Assert.assertEquals( profile[2] != null,true,"External ID Verification"); 
	  	Assert.assertEquals( profile[3],csrl.lastName,"lastname Verification");
	  	Assert.assertEquals( profile[4],csrl.email,"email Verification");
	    Assert.assertEquals( profile[5],csrl.DispName,"DisplayName Verification");
	  	Assert.assertEquals( profile[6], csrl.firstName,"FirstName Verification");
	  //	Assert.assertEquals( profile[7] != null,true,"IAM ID Verification");
	  	Assert.assertEquals( profile[7],csrl.city,"email Verification");  	
	    Assert.assertEquals( profile[8],csrl.country,"Country verification");
	   Assert.assertEquals( profile[9],csrl.dob,"dob verification");
	  Assert.assertEquals( profile[10],csrl.postcode,"PostCode verification");
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
	 	
	
	
	


	}
 
        

 