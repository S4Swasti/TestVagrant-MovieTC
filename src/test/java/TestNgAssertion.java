
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNgAssertion {
	ChromeDriver driver;
	public static void main() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();}

	@Test(priority = 0)
	public void DateAssertion() throws InterruptedException {
		Wiki_Test.main();
		IMDB_Test.main();
		Wiki_Test Date = new Wiki_Test();
		IMDB_Test Date2 = new IMDB_Test();
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(Date.DateWiki, Date2.DateIMBD);
		System.out.println("Release Date from Wiki: " + Date.DateWiki);
		System.out.println("Release Date from IMBD: " + Date2.DateIMBD);
		System.out.println("*** test case one executed successfully ***");
		softassert.assertAll();
	}

	@Test(priority = 1)
	public void CountryAssertion() throws InterruptedException {
		Wiki_Test.main();
		IMDB_Test.main();
		Wiki_Test Country = new Wiki_Test();
		IMDB_Test Country2 = new IMDB_Test();
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(Country.CountryWiki, Country2.CountryIMBD);
		System.out.println("Country from Wiki: " + Country.CountryWiki);
		System.out.println("Country from IMBD: " + Country2.CountryIMBD);
		System.out.println("*** test case two executed successfully ***");
		softassert.assertAll();
	}

}
