package testscenarios;


import framework.ConfigReader;
import framework.DriverSetup;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.FlightTicketPage;
import pages.HomePage;
import pages.TicketListPage;

import java.util.Properties;

public class Enuygun {

    static WebDriver driver;
    static Properties properties;
    HomePage homePage;
    FlightTicketPage flightTicketPage;
    TicketListPage ticketListPage;

    @BeforeClass
    public void setup() {
        properties = ConfigReader.initialize_Properties();
        driver = DriverSetup.initialize_Driver("chrome");
        homePage = new HomePage(driver);
        flightTicketPage = new FlightTicketPage(driver);
        ticketListPage = new TicketListPage(driver);
    }

    @Test(priority = 1)
    public void searchForKeyword() throws InterruptedException {
        flightTicketPage.typeFlightFromField(properties.getProperty("origin"));
        flightTicketPage.clickByFirstFlightFromResult();
        flightTicketPage.typeFlightToField(properties.getProperty("destination"));
        flightTicketPage.clickByFirstFlightToResult();
        flightTicketPage.clickDepartureDate();
        flightTicketPage.selectDepartureDate(Integer.parseInt(properties.getProperty("departureDay")));
        flightTicketPage.clickReturnDate();
        flightTicketPage.selectReturnDate(Integer.parseInt(properties.getProperty("returnDay")));
        flightTicketPage.clickFindBestDealsBtn();

        ticketListPage.ClickDeparture(properties.getProperty("provider"));
        Thread.sleep(3000);
        ticketListPage.ClickArrival(properties.getProperty("provider"));
        ticketListPage.SelectFlightBtn();
    }

    @AfterClass
    public void teardown() {
        driver.close();
    }
}
