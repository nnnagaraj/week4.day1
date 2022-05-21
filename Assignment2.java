package week4.day1;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 {

	// Print no of rows and columns from table

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Launch the URL https://html.com/tags/table/
		driver.get("https://html.com/tags/table");

		// To Maximize the browser
		driver.manage().window().maximize();
		Thread.sleep(2000);

		// Locate the table using xpath
		WebElement table1 = driver.findElement(By.xpath("(//table)[1]"));

		// Locate the row of the table using tagname and get the size of the row
		List<WebElement> rows = table1.findElements(By.tagName("tr"));
		System.out.println("No of rows: " + rows.size());

		// Locate the first row of the table and get the size of the column
		List<WebElement> columns = rows.get(0).findElements(By.tagName("th"));
		System.out.println("No of columns: " + columns.size());

	}

}
