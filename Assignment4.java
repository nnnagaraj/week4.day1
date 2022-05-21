package week4.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Launch the URL
		driver.get("http://www.leafground.com/pages/table.html");

		// Maximize the window
		driver.manage().window().maximize();

		// Locate the table
		WebElement table = driver.findElement(By.xpath("//table"));

		// Locate the row of the table and get the size of the row
		List<WebElement> rows = table.findElements(By.tagName("tr"));

		// Get size of the row
		System.out.println(rows.size());

		// Get the size of the column
		List<WebElement> columns = rows.get(0).findElements(By.tagName("th"));
		System.out.println("No of columns: " + columns.size());

		// Get the progress value of 'Learn to interact with Elements
		for (int i = 1; i < rows.size(); i++) {
			List<WebElement> column = rows.get(i).findElements(By.tagName("td"));
			String selLernDetail = (column.get(0).getText());
			if (selLernDetail.equals("Learn to interact with Elements")) {

				System.out.println("progress value of 'Learn to inteact with Element'::" + column.get(1).getText());

			}

		}
		
		//close the browser
        driver.quit();
	}

}
