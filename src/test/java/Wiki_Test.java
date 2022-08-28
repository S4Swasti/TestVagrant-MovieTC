import java.util.List;
import java.util.Scanner;
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

public class Wiki_Test {

	public static String DateWiki;
	public static String CountryWiki;

	@SuppressWarnings("deprecation")
	public static void main() {
		// xpaths of Wiki Page
		
		String Site = "https://www.wikipedia.org/";
		String Search = "//*[@id=\"searchInput\"]";
		
		// opening browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get(Site);
		driver.manage().window().maximize();
				
		//Navigating to search box and Sending value as Pushpa

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement search = driver.findElement(By.xpath("//*[@id=\"searchInput\"]"));
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Actions ac = new Actions(driver);
		ac.moveToElement(search).click().build().perform();
		search.sendKeys("Pushpa: The Rise");
		search.sendKeys(Keys.DOWN);
		search.sendKeys(Keys.ENTER);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Scrolling Down to get details of Date and Country

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)", "");

		// Release Date

		WebElement base = driver.findElement(By.id("mw-content-text"));
		List<WebElement> tableRows = base.findElements(By.tagName("tr"));
		List<WebElement> tableCols = tableRows.get(11).findElements(By.tagName("td"));
		DateWiki = tableCols.get(0).getText();
		// System.out.println(DateWiki);

		// Country

		WebElement base2 = driver.findElement(By.id("mw-content-text"));
		List<WebElement> tableRows2 = base2.findElements(By.tagName("tr"));
		List<WebElement> tableCols2 = tableRows2.get(13).findElements(By.tagName("td"));
		CountryWiki = tableCols2.get(0).getText();
		// System.out.println(CountryWiki);
		driver.close();

	}

}
