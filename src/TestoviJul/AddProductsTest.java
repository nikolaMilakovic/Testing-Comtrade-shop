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
public class AddProductsTest {
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
	
  Logger l = Logger.getLogger(AddProductsTest.class.getName());
	
  String output = "";
  String testName = "";
  String testDesc = "";
  boolean testPassed = false;
  @Test
  public void addProducts() throws InterruptedException {
		testName = name.getMethodName();
		testDesc = "Testiranje dodavanja proizvoda u korpu";
		
	  driver.get("https://www.ctshop.rs/");
	    driver.manage().window().setSize(new Dimension(1696, 1026));
	    {
	      WebElement element = driver.findElement(By.cssSelector(".am-opener"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).perform();
	    }
	    {
	      WebElement element = driver.findElement(By.id("akcija"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).perform();
	    }
	    Thread.sleep(1000);        
	    driver.findElement(By.linkText("Laptopovi")).click();
	    js.executeScript("window.scrollBy(0, 300)");
	    Thread.sleep(1000);
	    {
	      WebElement element = driver.findElement(By.cssSelector(".col-xs-12:nth-child(1) .main"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).perform();
	    }
	    Thread.sleep(1000);        
	    driver.findElement(By.linkText("Dodaj u korpu")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.cssSelector(".btn-default:nth-child(2)")).click();
	    {
	      WebElement element = driver.findElement(By.cssSelector(".col-xs-12:nth-child(2) > .product-list-grid-box li:nth-child(2) > img"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).perform();
	    }
	    Thread.sleep(1000);
	    driver.findElement(By.linkText("Dodaj u korpu")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.cssSelector(".btn-default:nth-child(2)")).click();
	    {
	      WebElement element = driver.findElement(By.cssSelector(".col-xs-12:nth-child(3) .main"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).perform();
	    }
	    Thread.sleep(1000);
	    driver.findElement(By.linkText("Dodaj u korpu")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.cssSelector(".btn-default:nth-child(2)")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.cssSelector(".widget-header > .fa-shopping-cart")).click();
	    Thread.sleep(1000);
	    assertThat(driver.findElement(By.cssSelector(".ganalytics:nth-child(1) .product-name > a")).getText(), is("HP 255 G8 (3V5F3EA) LAPTOP 15.6\" FHD RYZEN 3 5300U 8GB 256GB SSD RADEON GRAPHICS CRNI"));
	    assertThat(driver.findElement(By.cssSelector(".ganalytics:nth-child(1) > .a-right:nth-child(5) .price")).getText(), is("49.999 din"));
	    assertThat(driver.findElement(By.cssSelector(".ganalytics:nth-child(2) .product-name > a")).getText(), is("HP 15S-EQ1089NM (350F0EA/8) LAPTOP 15.6\" FHD AMD RYZEN 3 3250U 8GB 512GB RADEON GRAPHICS WIN10 BELI"));
	    assertThat(driver.findElement(By.cssSelector(".ganalytics:nth-child(2) > .a-right:nth-child(5) .price")).getText(), is("49.999 din"));
	    assertThat(driver.findElement(By.cssSelector(".ganalytics:nth-child(3) .product-name > a")).getText(), is("HP 255 G8 (3V5F1EA) LAPTOP 15.6\" FHD AMD RYZEN 3 5300U 8GB 256GB SSD RADEON GRAPHICS WIN10 CRNI"));
	    assertThat(driver.findElement(By.cssSelector(".ganalytics:nth-child(3) > .a-right:nth-child(5) .price")).getText(), is("54.999 din"));
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
  