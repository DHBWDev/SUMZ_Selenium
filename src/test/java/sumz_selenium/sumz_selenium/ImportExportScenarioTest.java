package sumz_selenium.sumz_selenium;

import java.io.File;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ImportExportScenarioTest extends BaseTest {

	@Test
	public void export_scenario_scenarioview() throws InterruptedException {
		
		anmeldung();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		WebElement scenario = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-card[@id='1172']")));
		scenario.click();
		
		WebElement export = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*/button/span[text()=' Szenario exportieren ']")));
		export.click();
		
		WebElement download = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//app-export-scenario/mat-nav-list/a")));
		download.click();
		
		Thread.sleep(2000);

		Assert.assertTrue(true);
	}
	
	
	@Test
	public void export_scenario() throws InterruptedException {
		
		anmeldung();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-card[@id='1172']/mat-card-title/button")));
		menu.click();
	
		WebElement export = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*/div[contains(@class, 'mat-menu-content')]/button[2]")));
		export.click();
		WebElement download = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//app-export-scenario/mat-nav-list/a")));
		download.click();
		Thread.sleep(2000);
		
		Assert.assertTrue(true);
	}

	@Test
	public void import_scenario_valid() throws InterruptedException {
		anmeldung();
		
		driver.findElement(By.id("ellipsis-menu-btn")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement importScenarioButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("import-btn")));
		importScenarioButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("select-button")));
		
		driver.findElement(By.xpath("//app-import-scenario/div[1]/input")).sendKeys(System.getProperty("user.dir") +"\\importFiles\\validScenario.json");
		System.out.println("1");
		WebElement importButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("importScenario")));
		importButton.click();
		System.out.println("2");
		WebElement scenario = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[mat-card-title/text()=' ImportScenarioTest ']")));
		System.out.println(scenario.getAttribute("id"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-card[@id='"+scenario.getAttribute("id")+"']/mat-card-title/button")));
		menu.click();
		System.out.println("3");
		WebElement delete = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*/div[contains(@class, 'mat-menu-content')]/button[3]")));
		delete.click();
		
		WebElement confirm = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".mat-warn > .mat-button-wrapper")));
		confirm.click();

		Thread.sleep(2000);
	}
	
	@Test
	public void import_scenario_invalid() throws InterruptedException {
		anmeldung();
		
		driver.findElement(By.id("ellipsis-menu-btn")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement importScenarioButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("import-btn")));
		importScenarioButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("select-button")));
		
		driver.findElement(By.xpath("//app-import-scenario/div[1]/input")).sendKeys(System.getProperty("user.dir") +"\\importFiles\\invalidScenario.json");
		
		wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.id("importScenario"))));
		
		WebElement message = driver.findElement(By.xpath("//app-import-scenario/div[1]/div/p"));
		
		Assert.assertTrue(message.getText().equals("Die importierte Datei scheint kein valides Szenario zu sein."));
		
	}
	
}
