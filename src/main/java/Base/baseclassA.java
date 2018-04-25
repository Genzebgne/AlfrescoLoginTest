package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class baseclassA
{	//mvn clean test -DenvName=stg -Dbrowser=firefox

	public static Properties com = null;
	public static WebDriver driver;
	public static FileInputStream src = null;
	private static String environmentName = null;
	private static String browserName=null;
	
	public baseclassA()
	{
		environmentName = System.getProperty("envName");
		browserName = System.getProperty("browser");
		com = new Properties();
		try {
			
			System.out.println("base class hello world");
								
			String filePath= "."+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"prop"+File.separator+"config_"+ environmentName +".properties";
			//String filePath = "src\\main\\resources\\prop\\config_"+environmentName+".properties";
			
			System.out.println("File taken from : =============================== " + filePath);
			
			src = new FileInputStream(System.getProperty("user", filePath));
			com.load(src);     // get me the value fromm the property file env1
			
			System.out.println("File is loaded ================================");
		}catch(FileNotFoundException e) {
			System.out.println("File not Found here ");
		}	catch (Exception e) {
			System.out.println("File not exist");
		}
	}

	@BeforeClass
	public void openapp( ) throws Exception 
	{
		if(browserName.equals("firefox"))
		{
		//System.setProperty("webdriver.gecko.driver","src\\main\\resources\\driver_Repo\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\driver_Repo\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if(browserName.equals("ie")) {
			System.setProperty("webdriver.ie.driver", "src\\main\\resources\\driver_Repo\\IEDriverServer.exe");
			driver = new InternetExplorerDriver(); 
		}
		else {
		
			ChromeOptions options = new ChromeOptions();
			options.setHeadless(true);
			WebDriver driver = new ChromeDriver(options);
			driver = new ChromeDriver(options);
			
		}
		
		driver.get(com.getProperty("url"));
		System.out.println("here is the url ============" + com.getProperty("url"));
		driver.manage().window().maximize();
		Thread.sleep(5000);

}
}





