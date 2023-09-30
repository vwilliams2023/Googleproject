package googleFinancePack;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleFinanceTest {
	
       public WebDriver driver;                           // declare driver
                                                          
	    @BeforeMethod                                     // Method to set path of Chrome Driver
	    public void setUp() {
	    System.setProperty("webdriver.chrome.driver", "/Users/business/Downloads/chromedriver-mac-x64 2/chromedriver");                                                      
	    driver = new ChromeDriver();                       // Create a new instance of the Chrome Driver
	    driver.get("https://www.google.com/finance");      // Launch website
	    }
	                                                              
	    @Test
	    public void testGoogleFinance() throws InterruptedException {
                                                        
	    WebElement searchBox = driver.findElement(By.xpath("//div[@class='L6J0Pc ZB3Ebc nz7KN']//input[@aria-label='Search for stocks, ETFs & more']"));
	    searchBox.sendKeys("GOOGL");                             // storing in webelement allows easy reuse in the future 
	    searchBox.sendKeys(Keys.ENTER);
	                                                               
	    WebDriverWait wait = new WebDriverWait(driver, 10);    // WebDriverWait to wait for the visibility of the element
	    WebElement closingPriceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pFZ9G']")));
                                                  
	    String closingPrice = closingPriceElement.getText();    // Retrieve text, store in closingPrice variable                                       
	    String numericalClosingPrice = closingPrice.replaceAll("[^0-9.]", "");// Extract the numerical part of the price, replace with empty string "")
                                                          
	    System.out.println("The previous closing price for Google is: "+ "$" + numericalClosingPrice); 
	    }
                                                                 
	    @AfterMethod                                             //Method to close the browser
	    public void closeBrowser() {
	                                                             // Close the browser if the driver is not null 
	       if (driver != null) {
	           driver.quit();}
	        }
	       }
	    
	