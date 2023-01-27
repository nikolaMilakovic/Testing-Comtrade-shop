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
public class SignUpTest {
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
  public void signUpTest() throws Exception {
	testName = name.getMethodName();
	testDesc = "Testiranje registracije";
	
    driver.get("https://www.ctshop.rs/");
    driver.manage().window().setSize(new Dimension(1696, 1026));
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("button:nth-child(4)")).click();
    Thread.sleep(2000);
//    driver.findElement(By.id("popup-smart-root-38536")).click();
//    Thread.sleep(2000);
//    driver.findElement(By.id("popup-smart-root-37203")).click();
//    Thread.sleep(5000);
    driver.findElement(By.xpath("//a[contains(text(),\'Otvori nalog\')]")).click();
    driver.findElement(By.id("firstname")).click();
    driver.findElement(By.id("firstname")).sendKeys("Nikola");
    driver.findElement(By.id("lastname")).click();
    driver.findElement(By.id("lastname")).sendKeys("Milakovic");
    driver.findElement(By.id("email_address")).click();
    driver.findElement(By.id("email_address")).sendKeys("nikola.milakovic219s92@gmail.com");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("Nikola#99");
//    driver.findElement(By.cssSelector(".fieldset:nth-child(3) .col-md-12:nth-child(2)")).click();
    driver.findElement(By.id("confirmation")).click();
    driver.findElement(By.id("confirmation")).sendKeys("Nikola#99");
    Thread.sleep(2000);
    /*driver.findElement(By.xpath("//form[@id=\'form-validate\']/div[2]/p/button/span/span")).click();
    Thread.sleep(2000);
    assertEquals("Hvala na registraciji. Molimo proverite email i aktivirajte Vaš nalog.", driver.findElement(By.cssSelector(".alert > p")).getText());
    driver.close();*/
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