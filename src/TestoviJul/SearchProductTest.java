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
public class SearchProductTest {
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
	
  Logger l = Logger.getLogger(SearchProductTest.class.getName());
	
  String output = "";
  String testName = "";
  String testDesc = "";
  boolean testPassed = false;
  @Test
  
  public void searchProductTest() throws InterruptedException {
    driver.get("https://www.ctshop.rs/");
    driver.manage().window().maximize();
    driver.findElement(By.id("search-input-header")).click();
    driver.findElement(By.id("search-input-header")).sendKeys("lenovo");
    driver.findElement(By.id("search-submit-header")).click();
    Thread.sleep(1000);
    assertThat(driver.findElement(By.linkText("Lenovo Tab M10+ LTE 4/64 (ZA5V0208RS) tablet 10.3\" Octa Core Mediatek MT6762 Helio P22T 4GB 64GB 8Mpx sivi")).getText(), is("Lenovo Tab M10+ LTE 4/64 (ZA5V0208RS) tablet 10.3\\\" Octa Core Mediatek MT6762 Helio P22T 4GB 64GB 8Mpx sivi"));
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