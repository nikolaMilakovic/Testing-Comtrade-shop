package TestoviJul;

import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;

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
public class PerfomanceTest {
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
  public final TestName name = new TestName();

  Logger l = Logger.getLogger(PerfomanceTest.class.getName());
	
  String output = "";
  String testName = "";
  String testDesc = "";
  String testTime = "";
  boolean testPassed = false;
  
  static long vremeMS, prosekMS, vremeS, prosekS;
  
    static long START_TIME;
	static long END_TIME;
	static long TOTAL_TIME1, TOTAL_TIME2, TOTAL_TIME3, TOTAL_TIME4;
    
    @Test
    public void Dostava() throws InterruptedException {
    	testName = name.getMethodName();
		testDesc = "Ucitavanje Dostava";
			
		START_TIME = System.currentTimeMillis();
		driver.get("https://www.ctshop.rs/");
	    driver.manage().window().maximize();
	    Thread.sleep(1000);
	    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    driver.findElement(By.linkText("Dostava")).click();
	    Thread.sleep(1000);
	    assertThat(driver.findElement(By.cssSelector("h1")).getText(), is("Dostava od vrata do vrata"));
	    driver.close();
		END_TIME = System.currentTimeMillis();
		TOTAL_TIME1 = END_TIME - START_TIME;
		testTime = "Vreme ucitavanja stranice: " + TOTAL_TIME1 + "ms";

		testPassed = true;
	  }
    
    @Test
	  public void Prodavnice() throws InterruptedException {
		testName = name.getMethodName();
		testDesc = "Ucitavanje Prodavnice";
			
		START_TIME = System.currentTimeMillis();
		driver.get("https://www.ctshop.rs/");
	    driver.manage().window().maximize();
	    Thread.sleep(1000);
	    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    driver.findElement(By.linkText("Prodavnice")).click();
	    Thread.sleep(2000);
	    assertThat(driver.findElement(By.cssSelector("h1")).getText(), is("Prodavnice"));
	    driver.close();
		END_TIME = System.currentTimeMillis();
		TOTAL_TIME2 = END_TIME - START_TIME;
		testTime = "Vreme ucitavanja stranice: " + TOTAL_TIME2 + "ms";

		testPassed = true;
	  }
    
    @Test
	  public void OtvoriNalog() throws InterruptedException {
		testName = name.getMethodName();
		testDesc = "Ucitavanje OtvoriNalog";
			
		START_TIME = System.currentTimeMillis();
		driver.get("https://www.ctshop.rs/");
	    driver.manage().window().maximize();
	    Thread.sleep(2000);
	    driver.findElement(By.linkText("Otvori nalog")).click();
	    Thread.sleep(2000);
	    assertThat(driver.findElement(By.cssSelector(".text-uppercase > strong")).getText(), is("KREIRAJTE NALOG"));
	    driver.close();
		END_TIME = System.currentTimeMillis();
		TOTAL_TIME3 = END_TIME - START_TIME;
		testTime = "Vreme ucitavanja stranice: " + TOTAL_TIME3 + "ms";

		testPassed = true;
	  }
    
    @Test
	  public void Korpa() throws InterruptedException {
		testName = name.getMethodName();
		testDesc = "Ucitavanje Korpe";
			
		START_TIME = System.currentTimeMillis();
		driver.get("https://www.ctshop.rs/");
	    driver.manage().window().maximize();
	    Thread.sleep(1000);
	    driver.findElement(By.cssSelector(".widget-header > .fa-shopping-cart")).click();
	    Thread.sleep(2000);
	    assertThat(driver.findElement(By.cssSelector("h1")).getText(), is("Vaša korpa"));
	    driver.close();
		END_TIME = System.currentTimeMillis();
		TOTAL_TIME4 = END_TIME - START_TIME;
		testTime = "Vreme ucitavanja stranice: " + TOTAL_TIME4 + "ms";

		testPassed = true;
	  }
    
    @AfterClass
	public static void Kalkulacije() {
		System.out.println();
		long totalTestsTime = TOTAL_TIME1 + TOTAL_TIME2 + TOTAL_TIME3 + TOTAL_TIME4;
		System.out.println("Ukupno vreme otvaranja stranica i browsera [ms]: " + totalTestsTime + "ms");
		System.out.println("Proseèno vreme otvaranja stranica i browsera [ms]: " + totalTestsTime / 5 + "ms");
		System.out.println("Ukupno vreme otvaranja stranica i browsera [s]: " + totalTestsTime / 1000 + "s");
	}
    
    @After
	public void WriteSingleTest() {
 		output += "Testiranje metode " + testName;
		output += "\n\tNaziv testa: " + testName;
		output += "\n\tOpis testa: " + testDesc;
		output += "\n\tTest je uspesno prosao: " + testPassed + "\n";
		output += "\n\t" + testTime + "\n\n";
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
   
    
  
