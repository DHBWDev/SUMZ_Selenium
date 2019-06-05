package sumz_selenium.sumz_selenium;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

	public BaseTest() {
		
		System.setProperty("webdriver.chrome.driver", "./web.Driver/chromedriver.exe");
	}
	
	  public WebDriver driver;
	  public Map<String, Object> vars;
	  JavascriptExecutor js;
	 
	  @Before
	  public void setUp() {
	    driver = new ChromeDriver();
	    js = (JavascriptExecutor) driver;
	    vars = new HashMap<String, Object>();
	  }

	  @After
	  public void tearDown() {
	    driver.quit();
	  }
	
}
