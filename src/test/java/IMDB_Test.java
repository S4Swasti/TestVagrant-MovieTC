import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IMDB_Test {
	public static String DateIMBD;
	public static String CountryIMBD;

	public static void main() {
		
		//xpaths of IMDB Page
		
		String Site = "https://www.imdb.com/";
		String Search = "//*[@id=\"suggestion-search\"]";
		String DateOfIMDB = "//li[@data-testid=\"title-details-releasedate\"]/div/ul";
		String CountryOfIMDB = "//li[@data-testid=\"title-details-origin\"]/div";
		
		// opening browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get(Site);
		driver.manage().window().maximize();
		
		//Navigating to search box and Sending value as Pushpa

		WebElement search = driver.findElement(By.xpath(Search));
		Actions ac = new Actions(driver);
		ac.moveToElement(search).click().build().perform();
		search.sendKeys("Pushpa: The Rise");
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait1.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"react-autowhatever-1--item-0\"]/a")));

		search.sendKeys(Keys.DOWN);
		search.sendKeys(Keys.ENTER);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Scrolling Down to get details of Date and Country

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath(DateOfIMDB));
		js.executeScript("arguments[0].scrollIntoView();", Element);

		WebElement Date = driver.findElement(By.xpath(DateOfIMDB));
		DateIMBD = Date.getText();
		// System.out.println(DateIMBD);

		WebElement Country = driver.findElement(By.xpath(CountryOfIMDB));
		CountryIMBD = Country.getText();
		// System.out.println(CountryIMBD);
		driver.close();
	}

}
