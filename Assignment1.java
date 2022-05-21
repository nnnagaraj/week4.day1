package week4.day1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {

		// Program to ensure whether there are duplicate Security names

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Launch the URL https://www.chittorgarh.com/
		driver.get("https://www.chittorgarh.com/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		
		// Click on stock market
		driver.findElement(By.xpath("//a[@title='Stock Market']")).click();
		Thread.sleep(2000);
		
        //Click on NSE bulk Deals
		driver.findElement(By.xpath("(//a[text()='NSE Bulk Deals'])[1]")).click();		
		Thread.sleep(2000);

		// Locate the webtable using xpath
		WebElement table = driver
				.findElement(By.xpath("//table[@class='table table-bordered table-condensed table-striped']"));
		System.out.println(table);
		
        //Locate the row of the table using tagname
		List<WebElement> rows = table.findElements(By.tagName("tr"));

		// print the Size of the row
		System.out.println(rows.size());
		
		// print the Size of the column
		List<WebElement> column = table.findElements(By.tagName("th"));		
		System.out.println(column.size());

        //Declare List variable
		List<String> list = new ArrayList<String>();

		// Get the security name from the table and add the it to List
		for (int i = 1; i < rows.size(); i++)
		{
			List<WebElement> column1 = rows.get(i).findElements(By.tagName("td"));
			String securityName = column1.get(2).getText();
			System.out.println(securityName);
			list.add(securityName);
		}
		
		// get the size of the list
		int listSize = list.size();
		System.out.println("List size:" + listSize);
		
		// copy the values in the List to Set
		Set<String> set = new HashSet(list);
		
		// get the size of the Set
		System.out.println("Set size:"+ set.size());
		
		// compare the size of the List with Set
		if (listSize == set.size())

		{
			System.out.println("No duplicates found in Security Name");
		} else {
			System.out.println("Duplicates found in Security Name");
		}

	}

}

