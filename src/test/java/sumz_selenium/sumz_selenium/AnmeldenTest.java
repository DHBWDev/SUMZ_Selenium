package sumz_selenium.sumz_selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Date;

public class AnmeldenTest extends BaseTest {

	@Test
	public void anmelden_richtig() {

		anmeldung("yuhi@intempmail.com", "12345678aA#");

		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe("http://sumz1718.dh-karlsruhe.de/"));
		} catch (Exception e) {

		}

		Assert.assertTrue(driver.getCurrentUrl().equals("http://sumz1718.dh-karlsruhe.de/"));
	}

	@Test
	public void anmelden_falsche_mail() {

		anmeldung("diesemailgibtesnicht@sicher.de", "12345678aA#");

		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe("http://sumz1718.dh-karlsruhe.de/"));
		} catch (Exception e) {

		}

		Assert.assertFalse(driver.getCurrentUrl().equals("http://sumz1718.dh-karlsruhe.de/"));
	}
	
	@Test
	public void anmelden_falsches_passwort() {

		anmeldung("olistraub@web.de", "falschesPasswort");

		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe("http://sumz1718.dh-karlsruhe.de/"));
		} catch (Exception e) {

		}

		Assert.assertFalse(driver.getCurrentUrl().equals("http://sumz1718.dh-karlsruhe.de/"));
	}

	@Test
	public void registrieren_richtig() {

		Date date = new Date();

		long time = date.getTime();
		
		registrierung(time + "@hewfuhiweuhf.de", "Qwer1234#", "Qwer1234#");
		
		try {
			new WebDriverWait(driver, 300).until(ExpectedConditions.urlToBe("http://sumz1718.dh-karlsruhe.de/login"));
		} catch (Exception e) {

		}

		Assert.assertTrue(driver.getCurrentUrl().equals("http://sumz1718.dh-karlsruhe.de/login"));

	}
	
	@Test
	public void registrieren_besthende_mail() {
		
		registrierung("olistraub@web.de", "Qwer1234#", "Qwer1234#");
		
		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe("http://sumz1718.dh-karlsruhe.de/login"));
		} catch (Exception e) {

		}

		Assert.assertFalse(driver.getCurrentUrl().equals("http://sumz1718.dh-karlsruhe.de/login"));

	}
	
	@Test
	public void registrieren_schwaches_passwort() {
		
		Date date = new Date();

		long time = date.getTime();
		
		registrierung(time + "@hewfuhiweuhf.de", "12345678", "12345678");
		
		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe("http://sumz1718.dh-karlsruhe.de/login"));
		} catch (Exception e) {

		}

		Assert.assertFalse(driver.getCurrentUrl().equals("http://sumz1718.dh-karlsruhe.de/login"));

	}
	
	@Test
	public void registrieren_nicht_uebereinstimmende_passwoerter() {
		
		Date date = new Date();

		long time = date.getTime();
		
		registrierung(time + "@hewfuhiweuhf.de", "Qwer1234#", "anderesPasswort");
		
		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe("http://sumz1718.dh-karlsruhe.de/login"));
		} catch (Exception e) {

		}

		Assert.assertFalse(driver.getCurrentUrl().equals("http://sumz1718.dh-karlsruhe.de/login"));

	}
	
	@Test
	public void passwort_vergessen_richtig() {

	    passwort_vergessen("eui22791@cndps.com");

		try {
			new WebDriverWait(driver, 300).until(ExpectedConditions.urlToBe("http://sumz1718.dh-karlsruhe.de/login"));
		} catch (Exception e) {

		}

		Assert.assertTrue(driver.getCurrentUrl().equals("http://sumz1718.dh-karlsruhe.de/login"));

	}
	
	@Test
	public void passwort_vergessen_nicht_existierende_mail() {

	    passwort_vergessen("diesemailgibtesnicht@sicher.de");

		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe("http://sumz1718.dh-karlsruhe.de/login"));
		} catch (Exception e) {

		}

		Assert.assertFalse(driver.getCurrentUrl().equals("http://sumz1718.dh-karlsruhe.de/login"));

	}
	
	@Test
	public void passwort_vergessen_falsches_mailformat() {

	    passwort_vergessen("eui22791ATcndps.com");

		try {
			new WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe("http://sumz1718.dh-karlsruhe.de/login"));
		} catch (Exception e) {

		}

		Assert.assertFalse(driver.getCurrentUrl().equals("http://sumz1718.dh-karlsruhe.de/login"));

	}
	
	
}
