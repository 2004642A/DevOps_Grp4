//package com.sddevops.selenium_maven.eclipse;
import org.openqa.selenium.By;
//import necessary Selenium WebDriver classes
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NewTest {
  //declare Selenium WebDriver
  private WebDriver webDriver;		
  

  @Test
  public void checkTitle() {
	  //Load website as a new page
	  webDriver.navigate().to("http://localhost:8090/DevOps_eCommerce/");
	  
	  //Assert the title to check that we are indeed in the correct website
	  Assert.assertEquals(webDriver.getTitle(), "DevOps e-Commerce");
	  
	  System.out.println("title: "+webDriver.getTitle());
	
  }
  
  
  @Test
  public void checkAddButtonId()
  {
	  webDriver.navigate().to("http://localhost:8090/DevOps_eCommerce/ProductServlet");
	  WebElement we =  webDriver.findElement(By.id("addnew"));
  }  
  
  @Test
  public void checkAddProduct() {
	  webDriver.navigate().to("http://localhost:8090/DevOps_eCommerce/addProduct.jsp");
	  WebElement nameField = webDriver.findElement(By.id("name"));
	  WebElement categoryField = webDriver.findElement(By.id("category"));
	  WebElement priceField = webDriver.findElement(By.id("price"));
	  WebElement imageField = webDriver.findElement(By.id("image"));
	  WebElement submitButton = webDriver.findElement(By.id("submit"));
	  
	  nameField.sendKeys("Name1");
	  categoryField.sendKeys("Category1");
	  priceField.sendKeys("23");
	  imageField.sendKeys("image.png");
	  
	  submitButton.click();

  
  }
  
  @BeforeTest
  public void beforeTest() {
	  //Setting system properties of ChromeDriver
	  //to amend directory path base on your local file path
	  String chromeDriverDir = "C:\\Users\\ASUS\\Downloads\\chromedriver_win32\\chromedriver.exe";

	  System.setProperty("webdriver.chrome.driver", chromeDriverDir);

	  //initialize FirefoxDriver at the start of test
	  webDriver = new ChromeDriver();  
  }

  @AfterTest
  public void afterTest() {
	  //Quit the ChromeDriver and close all associated window at the end of test
//	  webDriver.quit();			
  }

}