package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.*;
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
		//Home page
		HomePage homePage = new HomePage(driver);
		homePage.SignIn(registerInfo[0], registerInfo[1]);

		//Flight Finder
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		FlightFinderPage flightFinder = new FlightFinderPage(driver);
		Assert.assertTrue(flightFinder.verifyFlightFinder(), "No se encontro la pagina!");
		flightFinder.inputContent(registerInfo);
		flightFinder.clickContinue();

		//Select Flight
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		SelectFlightPage selectFlight = new SelectFlightPage(driver);
		Assert.assertTrue(selectFlight.verifySelectFlight(), "No se encontro la pagina!");
		Assert.assertTrue(selectFlight.verifyDepartTrip(registerInfo), "El viaje de salida es incorrecto!");
		Assert.assertTrue(selectFlight.verifyDepartDate(registerInfo), "La fecha de salida es incorrecta!");
		selectFlight.getDepartFlights(registerInfo);
		Assert.assertTrue(selectFlight.verifyReturnTrip(registerInfo), "El viaje de regreso es incorrecto!");
		Assert.assertTrue(selectFlight.verifyReturnDate(registerInfo), "La fecha de regreso es incorrecta!");
		selectFlight.getReturnFlights(registerInfo);
		selectFlight.clickContinue();

		//Book a Flight
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		BookFlightPage bookFlightPage = new BookFlightPage(driver);
		Assert.assertTrue(bookFlightPage.verifyBookFlight(), "No se encontro la pagina!");
		//TODO: Validar informacion de vuelo
		bookFlightPage.inputContent(registerInfo);
		bookFlightPage.clickContinue();

		//Flight Confirmation
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		FlightConfPage flightConfPage = new FlightConfPage(driver);
		Assert.assertTrue(flightConfPage.verifyFlightConf(), "No se encontro la pagina!");
		//TODO: Validar informacion de reserva

		Thread.sleep(10000);

		driver.findElement(By.xpath("//a[contains(text(), 'Home')]")).click();

	}
}
