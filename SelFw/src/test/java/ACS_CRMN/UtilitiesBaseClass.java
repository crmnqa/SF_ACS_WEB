package ACS_CRMN;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

public class UtilitiesBaseClass {
	
	WebDriver driver;

	public static String emailid()
	
	{
				
		String email1 = "websel";
		String email2 = "@zaqwsx.com" ;
		return email1 + date() + email2 ;
		
	} 
	
	public static String date()
	
	{
		DateFormat dateFormat = new SimpleDateFormat("_MM_dd_HH_mm_ss");
		Date date = new Date();
		return dateFormat.format(date);
		
	}
	
	
	
	  
	  public static String restful(String content, String endpoint) throws UniformInterfaceException, IOException {
			  
			  Client client = new Client();
			   WebResource resource = client.resource(endpoint);
			    
			 		   ClientResponse response =resource
			 		  .header("X-NI-signatureType", "2")
			 		  .header("X-NI-apiVersion", "1")
			 		  .header("X-NI-signatureHash", "dummy") 
			 		  .header("X-NI-apiKey", getProp("apikey"))
			 		  .type("application/json")
			 		  .accept("application/json")
			 		  .post(ClientResponse.class,content);
					return response.getEntity(String.class);
				 
			   		   
			  }
			  
	  
	  
	  public void click(String type, String Locator) {
		  
	 
		  if(type.equals("xpath")) { 
			  driver.findElement(By.xpath(Locator )).click();
		  }
		  
		    
		  if(type.equals("id")) { 
			  driver.findElement(By.id(Locator )).click();
		  }
		  
		  }
	 
	  

	  
	  
	  
	  public void type(String type, String Locator, String val) {
		  
			 
		  if(type.equals("xpath")) { 
			  driver.findElement(By.xpath(Locator)).sendKeys(val);
		  }
		  
		    
		  if(type.equals("id")) { 
			  driver.findElement(By.id(Locator)).sendKeys(val);
		  }
		  
		  }
	  
 
	  
		public static  String getProp( String prop) throws IOException {   
		    	String versionString = null;
			   Properties mainProperties = new Properties();
			    FileInputStream file;
			    String path = "./crmn.properties";
			    file = new FileInputStream(path);
			    mainProperties.load(file);
			    file.close();
			    versionString = mainProperties.getProperty(prop);

			
			
		return versionString ;
		
		}
		
	  
	  
	  
	public void ffsetup( ) throws InterruptedException {
	 		
  	 		
		 FirefoxProfile profile= new FirefoxProfile(); 
		 profile.setAcceptUntrustedCertificates(true);
		 profile.setAssumeUntrustedCertificateIssuer(false);
		 
	 	driver = new FirefoxDriver(profile);
		driver.manage().deleteAllCookies(); 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		 
 		}
	  
	  
	public void iesetup( ) throws InterruptedException {
 		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);  
 		driver = new InternetExplorerDriver(capabilities);
 	   driver.manage().deleteAllCookies(); 
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 
		}
  

 
	
	
}
