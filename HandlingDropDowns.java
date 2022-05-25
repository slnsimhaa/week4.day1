package week4.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingDropDowns {

	public static void main(String[] args)
	{
		//Classroom Session-1
		// Driver Setup
		WebDriverManager.chromedriver().setup();

		// Launch Chrome Browser
		ChromeDriver driver = new ChromeDriver();

		// Launch Url
		driver.get("http://leaftaps.com/opentaps/control/main");

		// maximize the browser window
		driver.manage().window().maximize();

		// find username textbox and enter username
		WebElement eleUserName = driver.findElement(By.id("username"));
		eleUserName.sendKeys("DemoSalesManager");

		// find password textbox and enter password
		driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");

		// click login button
		driver.findElement(By.className("decorativeSubmit")).click();

		// click link
		driver.findElement(By.linkText("CRM/SFA")).click();

		// click Leads Tab
		driver.findElement(By.linkText("Leads")).click();

		// click create lead link
		driver.findElement(By.linkText("Create Lead")).click();
		
		//Code for Source dropdown in Create Lead page
		WebElement sourceDropdown = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select select1 = new Select(sourceDropdown);
		select1.selectByIndex(1);
		
		//Code for Marketing Campaign dropdown in Create Lead page
		WebElement marketingCampaignDropdown = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select select2 = new Select(marketingCampaignDropdown);
		select2.selectByValue("9002");
		
		//Code for Preferred Currency dropdown in Create Lead page
		WebElement preferredCurrency = driver.findElement(By.id("createLeadForm_currencyUomId"));
		Select select3 = new Select(preferredCurrency);
		select3.selectByVisibleText("GBP - British Pound");
		
		//Code to get all the values from Industry dropdown
		WebElement industryName = driver.findElement(By.id("createLeadForm_industryEnumId"));
		Select select4 = new Select(industryName);
		List <WebElement> options = select4.getOptions();
		for(WebElement eachOption : options)
		{
			System.out.println(eachOption.getText());
		}
		
		//Code for getting last value in Ownership drop down
		WebElement ownerShip = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select select5 = new Select(ownerShip);
		List <WebElement> options2 = select5.getOptions();
		select5.selectByIndex(options2.size()-1);
		
		//Closing driver
		driver.close();

	}

}
