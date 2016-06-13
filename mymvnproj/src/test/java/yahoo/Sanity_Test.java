package yahoo;

import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class,MethodListener.class })
public class Sanity_Test 
{
  WebDriver driver;	
  {
	 System.setProperty("atu.reporter.config", "e:/7amapril16/myproj/atu.properties");
  }
  
  @Test	
  @Parameters({"browser"})
  public void testing(String br) throws Exception
  {
	  if(br.matches("ff"))
	  {
		  driver=new FirefoxDriver();
	  }
	  if(br.matches("chrome"))
	  {
		 System.setProperty("webdriver.chrome.driver","c:\\chromedriver.exe");
		 driver=new ChromeDriver();
	  }
	     
	  Home h=new Home(driver);
	  h.validate_links();
	  h.createacc();
	  h.login();
	  
	  Compose c=new Compose(driver);
	  c.sendmail();
	  c.signout();	  
  }
}
