package sumz_selenium.sumz_selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Date;

public class AllgemeinTest extends BaseTest {

	@Test
	public void lizenzen_anzeigen() {
		
		driver.get("http://sumz1718.dh-karlsruhe.de/login");
		driver.manage().window().setSize(new Dimension(1500, 849));
		driver.findElement(By.cssSelector("#ellipsis-menu-btn .mat-icon")).click();
		driver.findElement(By.id("lizenzen-btn")).click();
		
		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe("http://sumz1718.dh-karlsruhe.de/credits"));
		} catch (Exception e) {

		}

		Assert.assertTrue(driver.getCurrentUrl().equals("http://sumz1718.dh-karlsruhe.de/credits"));
	}
	
	@Test
	public void github_anzeigen() {
		
		driver.get("http://sumz1718.dh-karlsruhe.de/login");
		driver.manage().window().setSize(new Dimension(1500, 849));
		driver.findElement(By.cssSelector("#ellipsis-menu-btn .mat-icon")).click();
		driver.findElement(By.id("github-btn")).click();
		
		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe("https://github.com/johanngoltz/sumz-ui/"));
		} catch (Exception e) {

		}

		Assert.assertFalse(driver.getCurrentUrl().equals("https://github.com/johanngoltz/sumz-ui/"));
	}
	
	@Test
	public void abmelden() {
		
		anmeldung();
		abmeldung();
		
		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe("http://sumz1718.dh-karlsruhe.de/login"));
		} catch (Exception e) {

		}

		Assert.assertTrue(driver.getCurrentUrl().equals("http://sumz1718.dh-karlsruhe.de/login"));
	}

	
	
}
