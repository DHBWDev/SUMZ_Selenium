package sumz_selenium.sumz_selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AnmeldenTest extends BaseTest{
  
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
	    
	    Assert.assertTrue(driver.getCurrentUrl().equals("http://sumz1718.dh-karlsruhe.de/"));
  }
  
  @Test
  public void registrieren() {
	 
  }
}
