package sumz_selenium.sumz_selenium;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;



public class Anmelden extends BaseTest{
  private WebDriver driver;
  private Map<String, Object> vars;
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
  @Test
  public void anmelden(){
	    driver.get("http://sumz1718.dh-karlsruhe.de/login");
	    driver.manage().window().setSize(new Dimension(1500, 849));
	    driver.findElement(By.id("email")).click();
	    driver.findElement(By.id("email")).sendKeys("olistraub@web.de");
	    driver.findElement(By.id("password")).click();
	    driver.findElement(By.id("password")).sendKeys("12345678aA#");
	    driver.findElement(By.cssSelector(".login-btn")).click();
	    
	    new WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe("http://sumz1718.dh-karlsruhe.de/"));
	    
	    assertTrue(driver.getCurrentUrl().equals("http://sumz1718.dh-karlsruhe.de/"));
  }
  
  @Test
  public void registrieren() {
	  
  }
}
