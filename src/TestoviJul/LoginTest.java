package TestoviJul;

import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.Before;
import org.junit.Rule;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.util.logging.Logger;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class LoginTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  
  @Rule
  public final TestName name = new TestName();
	
  Logger l = Logger.getLogger(SignUpTest.class.getName());
	
  String output = "";
  String testName = "";
  String testDesc = "";
  boolean testPassed = false;
  
  @Test
  public void loginInTest() throws InterruptedException {
		testName = name.getMethodName();
		testDesc = "Testiranje logovanja";
		
    driver.get("https://www.ctshop.rs/");
    driver.manage().window().setSize(new Dimension(1696, 1026));
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("button:nth-child(4)")).click();
    Thread.sleep(5000);
   // driver.findElement(By.id("popup-smart-root-38536")).click();
    //Thread.sleep(2000);
    //driver.findElement(By.id("popup-smart-root-37203")).click();
    //Thread.sleep(5000);
    driver.findElement(By.linkText("Prijavi se")).click();
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("nikola.milakovic19954499@gmail.com");
    driver.findElement(By.id("pass")).click();
    driver.findElement(By.id("pass")).sendKeys("Nikola#99");
    {
      WebElement element = driver.findElement(By.id("send2"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    /*driver.findElement(By.id("send2")).click();
    driver.findElement(By.linkText("Izloguj se")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".owl-item:nth-child(1) picture > img"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }*/
    driver.close();
  }

  
	  @After
	  public void WriteSingleTest() {
	 		output += "Testiranje metode " + testName;
	  	output += "\n\tNaziv testa: " + testName;
	  	output += "\n\tOpis testa: " + testDesc;
	  	output += "\n\tTest je uspesno prosao: " + testPassed + "\n";
	  	output += "\n";
	  	l.info(output);
	  	try {
	  		FileWriter fw = new FileWriter("test-report.txt", true);
	  		fw.write(output);
	  		fw.flush();
	  		fw.close();
	  	} catch (IOException e) {
	  		e.printStackTrace();
	  	}
	  }
}