package page;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class TestBase {

//public static WebDriver driver;
//	
//	public static void initDriver() {
//		System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
//		//driver.get("https://techfios.com/billing/?ng=login/");
//	}
	

	protected static WebDriver driver;
	
	static String browser;
	static String url;
	
	public static void readConfig() {
		
		Properties prop = new Properties();

		try {
			InputStream input = new FileInputStream("src\\main\\java\\config\\config.properties");
			prop.load(input);
			browser = prop.getProperty("browser");
			url = prop.getProperty("url");
			System.out.println("Browser used: " + browser);

		} catch (IOException e) {
			e.getStackTrace();
		}

	}
	
	public static WebDriver initDriver() {
		
		readConfig();
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver","drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver","drivers\\msedgedriver.exe");
			driver=new EdgeDriver();
		}
	 
	    driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://techfios.com/test/101/");
		return driver;
	}
	
public static void takeScreenShot(WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		String currentDirectory = System.getProperty("user.dir");
		SimpleDateFormat formatter = new SimpleDateFormat("MMddyy_HHmmss");
		Date date = new Date();
		String label = formatter.format(date);
		FileUtils.copyFile(sourceFile, new File(currentDirectory + "/screenshot/" + label + ".png"));
		
	}
	
}
