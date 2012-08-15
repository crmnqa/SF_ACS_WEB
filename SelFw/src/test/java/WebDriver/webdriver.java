package WebDriver;



import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;


public class webdriver{
	
	public static void main(String args[]) throws InterruptedException{
  
		
		WebDriver driver = new InternetExplorerDriver();
		
		
		
		
		
		
		
		
		
		
		
 	
 	
 	
 	//DEAL WITH CHROME 
		  
		  /* System.setProperty( "webdriver.chrome.driver","/ChromeDriver/chromedriver.exe");

		  WebDriver driver = new ChromeDriver();
		  driver.get("http://www.google.com/xhtml"); */
 	
 	
 	//DEAL WITH FLASH ---------------------------- http://code.google.com/p/flash-selenium/
 	
 	//DEAL WITH AJAX AND ASYNS   http://blog.activelylazy.co.uk/2010/05/05/testing-asynchronous-applications-with-webdriver/
 	
 	
 	//DEAL WITH DRAG AND DROP
 /*	Actions builder = new Actions(driver);
    Action dragAndDrop = builder.clickAndHold(someElement).moveToElement(otherElement).release(otherElement).build();
    dragAndDrop.perform();*/
 	
 	   //DEAL WITH FIREFOX PROFILE
 	   
 	/*FirefoxProfile profile = new FirefoxProfile();
 	profile.addExtension("");	WebDriver driver = new FirefoxDriver(profile); */
 	
 	
 	//DEAL WITH ALERTS
 	// Get a handle to the open alert, prompt or confirmation
 	/*Alert alert = driver.switchTo().alert(); 	alert.getText();	alert.accept();*/
 	
 	//DEAL WITH ALL LINKS or ALL CONTROLS
 	/*List  links = driver.findElements(By.tagName("a"));
 	System.out.println(links.size());
 	for(int i=0;i<links.size();i++){System.out.println(((WebElement) links.get(i)).getText()); System.out.println(links.get(i).getAttribute("href"));}
 	
 	System.out.println("Extract all links from the part of the webpage using selenium webdriver-----------------------------");
	List myList = driver.findElement(By.xpath("//*[@id='Flot']")).findElements(By.tagName("a")); */
	
 	
 	
 	
	//DEAL WITH WebDriverBackedSelenium :)
	/*	WebDriverBackedSelenium selenium = new WebDriverBackedSelenium(driver,"http://www.google.com");
	selenium.open("/"); */
	
	//DEAL WITH FRAMES
	/*	JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		System.out.println("1...." + jsExecutor.executeScript("return self.name"));	
		System.out.println("2...." + jsExecutor.executeScript("return self.location.toString()"));
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));
		System.out.println("3...." + jsExecutor.executeScript("return self.name"));
		System.out.println("4...." + jsExecutor.executeScript("return self.location.toString()")); */
		
		
	//Deal with List Box or DropDown  EX: Amazon 
		 
/*	 Select select = new Select(driver.findElement(By.xpath(".//*[@id='searchDropdownBox']")));				
	 List<WebElement> options = select.getOptions(); 
	 System.out.println(options.size());
	 for(int i = 0; i<=5;i++){
	 System.out.println(options.get(i).getText()); } //HELP http://stackoverflow.com/questions/858572/how-to-make-a-new-list-in-java*/
		
	//DEAL WITH DB TESTING DATA BASE   http://selftechy.com/2011/11/26/selenium-access-database-using-jdbc
		
		
	//DEAL FRAMEWORK PROJECTS https://github.com/Ardesco/Ebselen/wiki   AND 		https://github.com/freynaud/testng-support/wiki
		
 	}
	
	
	
	
	
	
	
	
}