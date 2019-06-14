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
	public void export_scenario() throws InterruptedException {
		
		anmeldung();
		
		driver.findElement(By.xpath("//mat-card[@id='455']/mat-card-title/button")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement export = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".cdk-focused")));
		export.click();
		WebElement download = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//app-export-scenario/mat-nav-list/a")));
		download.click();
		Thread.sleep(2000);
		
		String downloadLocation = System.getProperty("user.home")+ "\\Downloads";	
		File file = new File(downloadLocation + "\\scenario.json");
		Assert.assertTrue(file.exists());
		file.delete();
		
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
		
		WebElement importButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("importScenario")));
		importButton.click();
		
		WebElement scenario = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[mat-card-title/text()=' ImportScenarioTest ']")));
		System.out.println(scenario.getAttribute("id"));
			
		driver.findElement(By.xpath("//mat-card[@id='"+scenario.getAttribute("id")+"']/mat-card-title/button")).click();
		
		WebElement delete = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".mat-menu-item:nth-child(2)")));
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