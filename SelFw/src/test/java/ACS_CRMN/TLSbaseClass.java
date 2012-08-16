package ACS_CRMN;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class TLSbaseClass extends UtilitiesBaseClass {
	
  
	
	Properties properties = new Properties();
	
	static String date =  date();
	static String email =  emailid();  
	
	String password = "Password123";
	String title = "Mr";
	String firstName =   "F_" + date;
	String lastName =   "L_" + date;
	String day = "03";
	String month = "Jan";
	String year = "1990";
	String dob = year +"-"+ "01" +"-"+ day ;
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
	String u_dob = year +"-"+ "02" +"-"+ day ;
	String u_postcode = "HA99UB";
	String u_city = "Wembley Park";
	String u_DispName = u_firstName+" "+u_lastName; 
 
 
 
	public void TLSwebjourney1(String email) throws InterruptedException, IOException {
		 
		driver.get("http://www.uat-the-tls.co.uk/tls/");
		driver.findElement(By.cssSelector("img[alt=\"Log in to the TLS\"]")).click();
		 
			 

 
		driver.findElement(By.id("tls_voucher_text")).sendKeys("1111-111111");
		driver.findElement(By.id("mfa4")).click();
 
		driver.findElement(By.id("j_id0:j_id1:personal_details_form:user_email")).sendKeys(email);
		 
		driver.findElement(By.id("j_id0:j_id1:personal_details_form:user_password")).sendKeys(password);
 
		driver.findElement(By.id("j_id0:j_id1:personal_details_form:user_confirm_password")).sendKeys(password);
		new Select(driver.findElement(By.id("j_id0:j_id1:personal_details_form:user_title"))).selectByVisibleText(title);
 
		driver.findElement(By.id("j_id0:j_id1:personal_details_form:user_first_name")).sendKeys(firstName);
 
		driver.findElement(By.id("j_id0:j_id1:personal_details_form:user_last_name")).sendKeys(lastName);
		new Select(driver.findElement(By.id("j_id0:j_id1:personal_details_form:lstDateofBirthDays"))).selectByVisibleText(day);
		new Select(driver.findElement(By.id("j_id0:j_id1:personal_details_form:lstDateofBirthMonths"))).selectByVisibleText(month);
		new Select(driver.findElement(By.id("j_id0:j_id1:personal_details_form:lstDateofBirthYears"))).selectByVisibleText(year);
 
		
		 
		
		driver.findElement(By.id("j_id0:j_id1:personal_details_form:user_postcode")).sendKeys(postcode);
 
		driver.findElement(By.id("j_id0:j_id1:personal_details_form:user_address_line_1")).sendKeys("Flat 1");
 
		driver.findElement(By.id("j_id0:j_id1:personal_details_form:user_address_line_2")).sendKeys("Forum House");
 
		driver.findElement(By.id("j_id0:j_id1:personal_details_form:user_city")).sendKeys(city);
 
		driver.findElement(By.id("j_id0:j_id1:personal_details_form:user_county")).sendKeys("wembley");
		
		driver.findElement(By.id("j_id0:j_id1:personal_details_form:user_accept_tAndCs")).click();
		driver.findElement(By.id("ni-reg-btn-register")).click();
		driver.findElement(By.cssSelector("h3")).click();
		driver.findElement(By.cssSelector("img[alt=\"Log in to the TLS\"]")).click();
 
		driver.findElement(By.id("username")).sendKeys(email);
 
		driver.findElement(By.id("password")).sendKeys("Password123");
		driver.findElement(By.id("Submit")).click();
		driver.findElement(By.linkText("Log out")).click();
 
		}
	 
}

 
 
