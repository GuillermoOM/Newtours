package tests;

import pageObjects.FlightFinderPage;
import pageObjects.HomePage;
import utils.ExcelUtils;
import config.Setup;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class FlightBooker extends Setup {
	Object[][] testObjArray;
	String testCaseWorkBook = System.getProperty("user.dir") + "/resources/FlightRegisterData.xls";

	public void navigateTo(){
		driver.navigate().to("http://newtours.demoaut.com/mercurywelcome.php");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@DataProvider(name = "UserRegistration")
	public Object[][] userRegister() throws Exception{
		testObjArray = ExcelUtils.getTableArray(testCaseWorkBook, "RegisterUser");
		return (testObjArray);
	}

	@BeforeTest
	public void setUp(){
		navigateTo();
	}
	
	@Test(dataProvider = "UserRegistration", description="Test Case to Register an user")
	public void registerUserInformation(String ... registerInfo) throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.SignIn(registerInfo[1], registerInfo[2]);
		FlightFinderPage FlightFinder = new FlightFinderPage(driver);
		FlightFinder.inputContent(registerInfo);
		//FlightFinder.clickContinue();

		Thread.sleep(5000);

		//Adding Contact Information


	}
}
