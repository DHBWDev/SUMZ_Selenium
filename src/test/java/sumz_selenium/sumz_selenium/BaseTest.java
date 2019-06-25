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
		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe("http://sumz1718.dh-karlsruhe.de/"));
		} catch (Exception e) {

		}

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
	
	public void passwort_aenderung(String altes_passwort, String neues_passwort1, String neues_passwort2){


		driver.findElement(By.id("user-menu-btn")).click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.id("change-btn")).click();
	    //driver.findElement(By.id("passwordold")).click();
	    driver.findElement(By.id("passwordold")).sendKeys(altes_passwort);
	    //driver.findElement(By.id("passwordnew")).click();
	    driver.findElement(By.id("passwordnew")).sendKeys(neues_passwort1);
	    driver.findElement(By.id("passwordnew2")).sendKeys(neues_passwort2);
	    driver.findElement(By.id("change-btn")).click();


	}
	
	public int szenario_anlegung(String name, String beschr, String eigenkapitalzinsen, String verbzinsen, String koerperschaftssteuersatz,String gewerbesteuersatz, String soli){

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	    driver.findElement(By.id("newSzenario")).click();
	    
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    
	    driver.findElement(By.id("name")).click();
	    driver.findElement(By.id("name")).sendKeys(name);
	    driver.findElement(By.id("beschreibung")).click();
	    driver.findElement(By.id("beschreibung")).sendKeys(beschr);
	    driver.findElement(By.id("blue")).click();	    
	    
	    driver.findElement(By.id("submit1")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    driver.findElement(By.id("eigenkapitalzinsen")).sendKeys(eigenkapitalzinsen);
	    driver.findElement(By.id("verbzinsen")).sendKeys(verbzinsen);
	    driver.findElement(By.id("gewerbesteuersatz")).sendKeys(gewerbesteuersatz);
	    driver.findElement(By.id("koerperschaftssteuersatz")).sendKeys(koerperschaftssteuersatz);
	    driver.findElement(By.id("soli")).sendKeys(soli);
	    driver.findElement(By.id("submit2")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    driver.findElement(By.id("submit3")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String url = driver.getCurrentUrl();
		String[] werte = url.split("/");
		
		return Integer.parseInt(werte[werte.length-1]);

	}
	
	public int szenario_anlegung(){
		
		return szenario_anlegung("TestSzenario", "Testbeschreibung", "1", "2", "3", "4", "5");
	}
	
	public void szenario_loeschung_v1(int id){
		driver.get("http://sumz1718.dh-karlsruhe.de/");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.id("" + id)).click();
		driver.findElement(By.id("Sdelete")).click();
		driver.findElement(By.id("delete")).click();
	}
	
	public void szenario_bearbeiten_v1(int id){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get("http://sumz1718.dh-karlsruhe.de/");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.id("" + id)).click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		js.executeScript("window.scrollTo(0, 0)");
		driver.findElement(By.id("Sedit")).click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.id("Ssave")).click();
	}
	
	public void szenario_loeschung_v2(int id){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get("http://sumz1718.dh-karlsruhe.de/");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(By.id(""+id+"menu")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.id("delete")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.id("delete")).click();
	}
	
	public void szenario_bearbeiten_v2(int id){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get("http://sumz1718.dh-karlsruhe.de/");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(By.id(""+id+"menu")).click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.id("edit")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		js.executeScript("window.scrollTo(0, 0)");
		driver.findElement(By.id("Ssave")).click();
	}

}
