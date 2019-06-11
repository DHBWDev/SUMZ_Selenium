package sumz_selenium.sumz_selenium;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

	public void anmeldung() {

		anmeldung("olistraub@web.de", "12345678aA#");
		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe("http://sumz1718.dh-karlsruhe.de/"));
		} catch (Exception e) {

		}

	}

	public void anmeldung(String mail, String passwort) {

		driver.get("http://sumz1718.dh-karlsruhe.de/login");
		driver.manage().window().setSize(new Dimension(1500, 849));
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).sendKeys(mail);
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).sendKeys(passwort);
		driver.findElement(By.cssSelector(".login-btn")).click();

	}

	public void registrierung(String mail, String passwort1, String passwort2) {

		driver.get("http://sumz1718.dh-karlsruhe.de/login");
		driver.manage().window().setSize(new Dimension(945, 1020));
		driver.findElement(By.cssSelector(".signup-btn > .mat-button-wrapper")).click();
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).sendKeys(mail);
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).sendKeys(passwort1);
		driver.findElement(By.id("passwordrepeat")).click();
		driver.findElement(By.id("passwordrepeat")).sendKeys(passwort2);
		driver.findElement(By.cssSelector(".register-btn > .mat-button-wrapper")).click();

	}

	public void passwort_vergessen(String mail) {

		driver.get("http://sumz1718.dh-karlsruhe.de/login");
		driver.manage().window().setSize(new Dimension(945, 1020));
		driver.findElement(By.cssSelector(".forgot-btn > .mat-button-wrapper")).click();
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).sendKeys(mail);
		driver.findElement(By.id("new-btn")).click();

	}

	public void abmeldung(){

		driver.findElement(By.id("user-menu-btn")).click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.id("logout-btn")).click();

	}

}
