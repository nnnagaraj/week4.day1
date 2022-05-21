package week4.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3 {

	public static void main(String[] args) {

		// Print the column values based on Library
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Declare library value in string variable
		String library = "Market Share";

		// Get the URL
		driver.get("https://html.com/tags/table");

		// Maximise the window
		driver.manage().window().maximize();

		// Locate the table using xpath
		WebElement table1 = driver.findElement(By.xpath("(//table)[1]"));

		// Locate the row of the table and get the size of the row
		List<WebElement> rows = table1.findElements(By.tagName("tr"));
		System.out.println("No of rows: " + rows.size());

		// print the values of Library
		if (library == "Market Share") {
			System.out.println(rows.get(1).getText());
		} else {
			System.out.println(rows.get(2).getText());
		}

		// close the browser
		driver.quit();
	}

}
