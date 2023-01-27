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
public class FilterProductTest {
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
	
  Logger l = Logger.getLogger(FilterProductTest.class.getName());
	
  String output = "";
  String testName = "";
  String testDesc = "";
  boolean testPassed = false;
  
  @Test
  public void filterProductTest() {
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
    driver.findElement(By.linkText("Laptopovi")).click();
    js.executeScript("window.scrollBy(0, 300)");
    driver.findElement(By.cssSelector("#mCSB_1_container .no-active:nth-child(1) > .no-active")).click();
    js.executeScript("window.scrollTo(0,217)");
    assertThat(driver.findElement(By.linkText("Lenovo IdeaPad 3 15ALC6 (82KU006RYA/12) 15.6\" FHD AMD Ryzen 7 5700U 12GB 512GB SSD Radeon Graphics sivi")).getText(), is("Lenovo IdeaPad 3 15ALC6 (82KU006RYA/12) 15.6\" FHD AMD Ryzen 7 5700U 12GB 512GB SSD Radeon Graphics sivi"));
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
