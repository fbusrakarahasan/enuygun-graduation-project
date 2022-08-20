package pages;

import framework.ConfigReader;
import framework.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

public class FlightTicketPage {

    //WebDriver setups
    WebDriver driver;
    static Properties properties;
    Helper elementHelper;
    By fromForFlightSearch = By.id("OriginInput");
    By firstFromFlightResult = By.id("react-autowhatever-OriginInput-section-0-item-0");
    By toForFlightSearch = By.id("DestinationInput");
    By firstToFlightResult = By.id("react-autowhatever-DestinationInput-section-0-item-0");
    By departureDateInput = By.id("DepartureDate");
    By returnDate = By.id("ReturnDate");
    By findBestDealsBtn = By.xpath("//button[@data-testid='formSubmitButton']");

    //flight ticket page constructor
    public FlightTicketPage(WebDriver driver) {
        this.driver = driver;
        this.elementHelper = new Helper(driver);
        properties = ConfigReader.initialize_Properties();
    }


    public void typeFlightFromField(String origin) {
        this.elementHelper.sendKey(fromForFlightSearch, origin);
    }

    public void clickByFirstFlightFromResult() {
        this.elementHelper.click(firstFromFlightResult);
    }

    public void typeFlightToField(String destination) {
        this.elementHelper.sendKey(toForFlightSearch, destination);
    }

    public void clickByFirstFlightToResult() {
        this.elementHelper.click(firstToFlightResult);
    }

    public void clickDepartureDate() {
        this.elementHelper.click(departureDateInput);
    }

    public void selectDepartureDate(Integer departureDay) {
        /* Bugünün tarihine verilen gün süresi kadar eklenir */
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, departureDay);
        date = c.getTime();
        SimpleDateFormat objSDF = new SimpleDateFormat("EEEE, d MMMM yyyy");

        By locator = By.xpath("//td[@aria-label='" + objSDF.format(date) + "']"); // Bugünün tarihine eklendi aria label içerisinde aranacak
        this.elementHelper.click(locator);
    }

    public void clickReturnDate() {
        this.elementHelper.click(returnDate);
    }

    public void selectReturnDate(Integer returnDay) {
        /* Bugünün tarihine verilen gün süresi kadar eklenir */
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, Integer.parseInt(properties.getProperty("departureDay")) + returnDay);
        date = c.getTime();

        SimpleDateFormat objSDF = new SimpleDateFormat("EEEE, d MMMM yyyy");

        By locator = By.xpath("//td[@aria-label='" + objSDF.format(date) + "']"); // Bugünün tarihine eklendi aria label içerisinde aranacak

        this.elementHelper.click(locator);
    }

    public void clickFindBestDealsBtn() {
        this.elementHelper.click(findBestDealsBtn);
    }

}
