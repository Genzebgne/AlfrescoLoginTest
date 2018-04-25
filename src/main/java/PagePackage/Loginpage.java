package PagePackage;
//



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Base.baseclassA;

public class Loginpage extends baseclassA 
{
	
	
	public static void Repository() throws Exception
	{	
		
		System.out.println("=======Title before Login ==== " + driver.getTitle());
	    
	    driver.findElement(By.xpath(com.getProperty("user_xpath"))).sendKeys(com.getProperty("user"));
	    driver.findElement(By.xpath(com.getProperty("pwd_xpath"))).sendKeys(com.getProperty("pwd"));
	    driver.findElement(By.cssSelector("#page_x002e_components_x002e_slingshot-login_x0023_default-submit-button")).click();
	    System.out.println("========Title After login ====== " + driver.getTitle());

		
	}


}
