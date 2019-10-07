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
        Assert.assertTrue(bookFlightPage.verifyDepartTrip(registerInfo), "El viaje de salida no es correcto!");
        Assert.assertTrue(bookFlightPage.verifyDepartDate(registerInfo), "La fecha de salida no es correcta!");
        Assert.assertTrue(bookFlightPage.verifyDepartFlight(selectFlight.departFlight), "El vuelo de salida no es correcto!");
        Assert.assertTrue(bookFlightPage.verifyDepartClass(registerInfo), "La clase de salida no es correcta!");
        Assert.assertTrue(bookFlightPage.verifyDepartPrice(selectFlight.departFlight), "La fecha de salida no es correcta!");
        Assert.assertTrue(bookFlightPage.verifyReturnTrip(registerInfo), "El viaje de regreso no es correcto!");
        Assert.assertTrue(bookFlightPage.verifyReturnDate(registerInfo), "La fecha de regreso no es correcta!");
        Assert.assertTrue(bookFlightPage.verifyReturnFlight(selectFlight.returnFlight), "El vuelo de regreso no es correcto!");
        Assert.assertTrue(bookFlightPage.verifyReturnClass(registerInfo), "La clase de regreso no es correcta!");
        Assert.assertTrue(bookFlightPage.verifyReturnPrice(selectFlight.returnFlight), "La fecha de regreso no es correcta!");
        Assert.assertTrue(bookFlightPage.verifyPassengerNum(registerInfo), "El numero de pasageros no es correcto!");
		bookFlightPage.inputContent(registerInfo);
		bookFlightPage.clickContinue();

		//Flight Confirmation
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		FlightConfPage flightConfPage = new FlightConfPage(driver);
		Assert.assertTrue(flightConfPage.verifyFlightConf(), "No se encontro la pagina!");
        System.out.println("\nINFORMACION DE VIAJE:");
		//Depart
        Assert.assertTrue(flightConfPage.verifyDepartTrip(registerInfo), "El viaje de salida no es correcto!");
        Assert.assertTrue(flightConfPage.verifyDepartDate(registerInfo), "La fecha de salida no es correcta!");
        Assert.assertTrue(flightConfPage.verifyDepartFlight(selectFlight.departFlight), "El vuelo de salida no es correcto!");
        Assert.assertTrue(flightConfPage.verifyDepartClass(registerInfo), "La clase de salida no es correcta!");
        Assert.assertTrue(flightConfPage.verifyDepartTime(selectFlight.departFlight), "El tiempo de salida no es correcto!");
        Assert.assertTrue(flightConfPage.verifyDepartPrice(selectFlight.departFlight), "El precio de salida no es correcto!");
        //Return
        Assert.assertTrue(flightConfPage.verifyReturnTrip(registerInfo), "El viaje de regreso no es correcto!");
        Assert.assertTrue(flightConfPage.verifyReturnDate(registerInfo), "La fecha de regreso no es correcta!");
        Assert.assertTrue(flightConfPage.verifyReturnFlight(selectFlight.returnFlight), "El vuelo de regreso no es correcto!");
        Assert.assertTrue(flightConfPage.verifyReturnClass(registerInfo), "La clase de regreso no es correcta!");
        Assert.assertTrue(flightConfPage.verifyReturnTime(selectFlight.returnFlight), "El tiempo de regreso no es correcto!");
        Assert.assertTrue(flightConfPage.verifyReturnPrice(selectFlight.returnFlight), "El precio de regreso no es correcto!");
        //Passengers
        Assert.assertTrue(flightConfPage.verifyPassengerNum(registerInfo), "El numero de pasajeros no es correcto!");
        //Billing
        Assert.assertTrue(flightConfPage.verifyBillingAddress(registerInfo), "La direccion de facturacion no es correcta!");
        Assert.assertTrue(flightConfPage.verifyBillingCity(registerInfo), "La ciudad de facturacion no es correcta!");
        Assert.assertTrue(flightConfPage.verifyBillingState(registerInfo), "El estado de facturacion no es correcto!");
        Assert.assertTrue(flightConfPage.verifyBillingZip(registerInfo), "El codigo postal de facturacion no es correcto!");
        //Delivery
        Assert.assertTrue(flightConfPage.verifyDeliveryAddress(registerInfo), "La direccion de envio no es correcta!");
        Assert.assertTrue(flightConfPage.verifyDeliveryCity(registerInfo), "La ciudad de envio no es correcta!");
        Assert.assertTrue(flightConfPage.verifyDeliveryState(registerInfo), "El estado de envio no es correcto!");
        Assert.assertTrue(flightConfPage.verifyDeliveryZip(registerInfo), "El codigo postal de envio no es correcto!");
        //Price
        Assert.assertTrue(flightConfPage.verifyTotalCost(selectFlight.departFlight, selectFlight.returnFlight, registerInfo), "El precio total no es correcto!");

        Thread.sleep(10000);
		driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/a")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
