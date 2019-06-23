package sumz_selenium.sumz_selenium;


import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ScenarioTest extends BaseTest {

	@Test
	public void szenario_anlegen_richtig() {

		anmeldung();
		szenario_anlegung("TestSzenario", "Testbeschreibung", "1", "2", "3", "4", "5");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(!driver.getCurrentUrl().equals("http://sumz1718.dh-karlsruhe.de/create"));
	}
	
	@Test
	public void szenario_anlegen_kein_name() {

		anmeldung();
		
		try {
			szenario_anlegung("", "Testbeschreibung", "1", "2", "3", "4", "5");
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(driver.getCurrentUrl().equals("http://sumz1718.dh-karlsruhe.de/create"));
		}
		
	}
	
	@Test
	public void szenario_anlegen_keine_numerischen_werte() {

		anmeldung();
		
		try {
			szenario_anlegung("TestSzenario", "Testbeschreibung", "1", "2", "3", "4", "e");
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(driver.getCurrentUrl().equals("http://sumz1718.dh-karlsruhe.de/create"));
		}
		
	}
	
	@Test
	public void szenario_anlegen_wert_vergessen() {

		anmeldung();
		
		try {
			szenario_anlegung("TestSzenario", "Testbeschreibung", "1", "", "3", "4", "5");
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(driver.getCurrentUrl().equals("http://sumz1718.dh-karlsruhe.de/create"));
		}
		
	}
	
}
