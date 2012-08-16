package ACS_CRMN;
 

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;



public class WebJourneyBaseClass extends UtilitiesBaseClass {
	 
	Properties properties = new Properties();
			
		static String date =  date();
  		static String email =  emailid();  
		
		String password = "Password123";
		String title = "Mr";
		static String firstName =   "F_" + date;
		static String lastName =   "L_" + date;
		static String day = "03";
		String month = "Jan";
		static String year = "1990";
		static String dob = year +"-"+ "01" +"-"+ day ;
		static String postcode = "HA90AB";
		static String city = "Wembley";
		static String country = "United Kingdom";
		static String DispName = firstName+" "+lastName; 
		//Updated
		
		String u_title = "Mrs";
		String u_firstName =   "1F_" + date ;
		String u_lastName =   "1L_" + date;
		String u_day = "02";
		String u_month = "Feb";
		String u_year = "1980";
		String u_dob = year +"-"+ "02" +"-"+ day ;
		String u_postcode = "HA99UB";
		String u_city = "Wembley Park";
		String u_DispName = u_firstName+" "+u_lastName; 
	 
 

	public void webjourney1(String email) throws InterruptedException, IOException {
		
		 driver.manage().deleteAllCookies(); 
		 
		// driver.get(getProp("sfurl"));
 		driver.get(getProp("weburl"));  
 		Thread.sleep(5000);
 
 		
 		click("xpath", ".//*[@id='prenav']/div[1]/ul/li[2]/a");
 		click("xpath", ".//*[@id='j_id0:j_id3:j_id11:j_id22:0:btnTopSubscribe']");
 	 
 	
 		type("id", "j_id0:j_id1:personal_details_form:user_email", email);
 		type("id", "j_id0:j_id1:personal_details_form:user_password", password);
 		type("id", "j_id0:j_id1:personal_details_form:user_confirm_password", password);
	 
	 
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
	
	

	
	
	public void webjourney2(String email) throws InterruptedException {
		
		driver.findElement(By.id("j_id0:j_id1:direct_debit_form:user_dd_account_name")).sendKeys("AccountHolderWebSel");
		driver.findElement(By.id("j_id0:j_id1:direct_debit_form:user_bank_name")).sendKeys("BankNameWebSel");
		driver.findElement(By.id("j_id0:j_id1:direct_debit_form:user_dd_account_number")).sendKeys("12345678");
		driver.findElement(By.id("j_id0:j_id1:direct_debit_form:user_dd_account_sort_1")).sendKeys("11");
		driver.findElement(By.id("j_id0:j_id1:direct_debit_form:user_dd_account_sort_2")).sendKeys("11");
		driver.findElement(By.id("j_id0:j_id1:direct_debit_form:user_dd_account_sort_3")).sendKeys("11");
 		driver.findElement(By.id("j_id0:j_id1:direct_debit_form:user_dd_authorised")).click();
 		driver.findElement(By.id("ni-pay-btn-dd")).submit();
 		Thread.sleep(5000);
 		
  
		
	}
	
	
	public void webjourneyEdit() throws InterruptedException {
				 
		driver.findElement(By.xpath(".//*[@id='j_id0:j_id1:j_id9']/div[2]/fieldset/input")).click();
		new Select(driver.findElement(By.id("j_id0:j_id1:personal_details_form:user_title"))).selectByVisibleText(u_title);
		driver.findElement(By.id("j_id0:j_id1:personal_details_form:user_first_name")).clear();
		driver.findElement(By.id("j_id0:j_id1:personal_details_form:user_first_name")).sendKeys(u_firstName);
		driver.findElement(By.id("j_id0:j_id1:personal_details_form:user_last_name")).clear();
		driver.findElement(By.id("j_id0:j_id1:personal_details_form:user_last_name")).sendKeys(u_lastName);
		new Select(driver.findElement(By.id("j_id0:j_id1:personal_details_form:lstDateofBirthDays"))).selectByVisibleText(u_day);
		new Select(driver.findElement(By.id("j_id0:j_id1:personal_details_form:lstDateofBirthMonths"))).selectByVisibleText(u_month);
		new Select(driver.findElement(By.id("j_id0:j_id1:personal_details_form:lstDateofBirthYears"))).selectByVisibleText(u_year);
		driver.findElement(By.id("j_id0:j_id1:personal_details_form:user_postcode")).clear();
		driver.findElement(By.id("j_id0:j_id1:personal_details_form:user_postcode")).sendKeys(u_postcode);
		driver.findElement(By.id("j_id0:j_id1:personal_details_form:user_address_line_1")).sendKeys("Flat 1");
		driver.findElement(By.id("j_id0:j_id1:personal_details_form:user_address_line_2")).sendKeys("Forum House");
		driver.findElement(By.id("j_id0:j_id1:personal_details_form:user_address_line_3")).sendKeys("Empire Way");
		driver.findElement(By.id("j_id0:j_id1:personal_details_form:user_city")).clear();
		driver.findElement(By.id("j_id0:j_id1:personal_details_form:user_city")).sendKeys(u_city);
		driver.findElement(By.id("j_id0:j_id1:personal_details_form:user_accept_tAndCs")).click();
		driver.findElement(By.id("ni-reg-btn-register")).submit();
		Thread.sleep(5000);
	    driver.findElement(By.xpath(".//*[@id='ni-pay-btn-dd']")).click();
	    driver.findElement(By.xpath(".//*[@id='ni-pay-btn-bottom']")).click();
	    driver.findElement(By.xpath(".//*[@id='j_id0:j_id1:j_id3:ni-webj-page-thankyou-continue']")).click();
	  //  Thread.sleep(10000); 
	  //  driver.findElement(By.xpath(".//*[@id='j_id0:j_id1:j_id3:ni-webj-page-thankyou-continue']")).click();
	   // driver.findElement(By.xpath(".//*[@id='j_id0:j_id1:j_id3:ni-webj-page-thankyou-continue']")).click();
	}
		
public void testCSRNEWCUST() throws InterruptedException {
		
		driver.manage().deleteAllCookies(); 
		driver.get("https://test.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("crm.admin@newsint.co.uk.staging");
		 
		driver.findElement(By.id("password")).sendKeys("England2012");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(10000);
		driver.findElement(By.cssSelector("img.allTabsArrow")).click();
		driver.findElement(By.linkText("Customers")).click();
		driver.findElement(By.name("new")).click();
		driver.findElement(By.cssSelector("#bottomButtonRow > input[name=\"save\"]")).click();
 
		driver.findElement(By.id("PersonEmail")).sendKeys(email);
	 
		driver.findElement(By.id("name_firstacc2")).sendKeys("CSR FIRST");
 
		driver.findElement(By.id("name_lastacc2")).sendKeys("Last CSR");
		new Select(driver.findElement(By.xpath("//div[@id='ep']/div[2]/div[3]/table/tbody/tr[4]/td[2]/select"))).selectByVisibleText("Mr");
		new Select(driver.findElement(By.id("00N20000003Ag9N"))).selectByVisibleText("Male");
 
		driver.findElement(By.id("00N20000003Ag9M")).sendKeys("DisplayName");
 
		driver.findElement(By.id("00N20000003B43e")).sendKeys("Flat 1");
 
		driver.findElement(By.id("00N20000003B43f")).sendKeys("Forum House");
 
		driver.findElement(By.id("00N20000003B43g")).sendKeys("Empire Way");
 
		driver.findElement(By.id("00N20000003B43l")).sendKeys("HA9 0AB");
 
		driver.findElement(By.id("00N20000003B43h")).sendKeys("London");
 
		driver.findElement(By.id("00N20000003B43j")).sendKeys("Wembley");
		driver.findElement(By.id("PersonBirthdate")).click();
 
		driver.findElement(By.id("PersonBirthdate")).sendKeys("12/07/1990");
		new Select(driver.findElement(By.id("00N20000003Ajpc"))).selectByVisibleText("TNL");
		driver.findElement(By.cssSelector("#bottomButtonRow > input[name=\"save\"]")).click();
		
		

}


public void subscribe(){
	
driver.findElement(By.name("subscribe")).click();
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


	}
 
        

 