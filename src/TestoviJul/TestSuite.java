package TestoviJul;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	SignUpTest.class,
	LoginTest.class,
	CheckValidationTest.class,
	AddProductsTest.class,
	EqualsValueTest.class,
	PerfomanceTest.class,
	FilterProductTest.class,
	SearchProductTest.class,
	SortProductTest.class,
	TestRunner.class
})

public class TestSuite {

}