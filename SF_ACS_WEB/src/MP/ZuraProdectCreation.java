package MP;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ACS_CRMN.UtilitiesBaseClass;

public class  ZuraProdectCreation extends UtilitiesBaseClass  {
	WebDriver driver;
	 String Prodname = "Prodname_1";
	 String MP = "MPCODE_1";
	 String chargecode = "ChargeName_1";
	 String price = "8";
 
 	String 	  baseUrl = "https://apisandbox.zuora.com/";	
 	@Test 
 	
		public void testZura() throws Exception {
 		
 		 FirefoxProfile profile= new FirefoxProfile(); 
 		 profile.setAcceptUntrustedCertificates(true);
 		 profile.setAssumeUntrustedCertificateIssuer(false);
 		 
 	 	driver = new FirefoxDriver(profile);
 		driver.manage().deleteAllCookies(); 
 		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		//Zura Login
 			driver.get(baseUrl + "/login.html");
 	 Thread.sleep(15000);
 			driver.findElement(By.xpath(".//*[@id='id_username']")).sendKeys("uat-zuora.admin@newsint.co.uk");
 		 
 			driver.findElement(By.id("id_password")).sendKeys("Zadmin2014");
 			driver.findElement(By.id("login_button")).click();
 			 
 			
 			//Product Catalogue
 			
 			driver.findElement(By.cssSelector("dd.over > a > strong")).click();
 			driver.findElement(By.cssSelector("a.btn_style_1 > span")).click();
 
 			driver.findElement(By.name("productName")).sendKeys("ProdName");           // Parameter
 		 
 			driver.findElement(By.name("sku")).sendKeys("MP");                          //Parameter
  
 			driver.findElement(By.id("effectStartDate")).sendKeys("21/08/2012");
 
 			driver.findElement(By.id("effectEndDate")).sendKeys("21/08/2013");
 			
 			driver.findElement(By.linkText("add rate plan")).click();
 	 
 			driver.findElement(By.name("rateplan_name")).sendKeys("RatePlan");
 
 			driver.findElement(By.id("rateplan_startdate")).sendKeys("21/08/2012");
 
 			driver.findElement(By.id("rateplan_enddate")).sendKeys("21/08/2013");
 			driver.findElement(By.linkText("save")).click();
 			
 			
 			//Add Rate
 			driver.findElement(By.id("new_recurring_RatePlan")).click();
  
 			driver.findElement(By.name("charge_name")).sendKeys("ChargeName");                                       //Parameter
 			 
 			driver.findElement(By.name("_priceTables_[0].price")).sendKeys("9");                                      //Parameter
 			
 			new Select(driver.findElement(By.id("triggerDate"))).selectByVisibleText("Upon Service Activation");
 			driver.findElement(By.cssSelector("option[value=\"2\"]")).click();
 			new Select(driver.findElement(By.id("billingPeriod"))).selectByVisibleText("Month");
 			driver.findElement(By.cssSelector("#billingPeriod > option[value=\"1\"]")).click();
 			driver.findElement(By.linkText("save")).click();
 			
 			
 			//Sync
 			driver.findElement(By.linkText("Data Synchronization")).click();
 			driver.findElement(By.cssSelector("a.small-block-button > span")).click();
 			driver.findElement(By.cssSelector("a.button-formAction > span")).click();
 			driver.findElement(By.id("action_refresh")).click();
 			driver.findElement(By.id("rlink001")).click();
 			driver.findElement(By.cssSelector("#z-boxPopup-formAction-button-Cancel > span")).click();

 		
 		 
 		}
 	 	 	
}	 