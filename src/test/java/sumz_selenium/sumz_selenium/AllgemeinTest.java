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
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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

	@Test
	public void passwort_aendern() {

		anmeldung("olistraub@web.de", "12345678aA#");
		passwort_aenderung("12345678aA#", "12345678aA#", "12345678aA#");

		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String erfolgsmeldung = "Ihr Passwort wurde erfolgreich geändert! Bitte melden Sie sich mit dem neuen Passwort an.";

		Assert.assertTrue(driver.findElement(By.className("snackbar-message")).getText().equals(erfolgsmeldung));
	}

}
