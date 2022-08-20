package pages;

import framework.ConfigReader;
import framework.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class TicketListPage {

    //WebDriver setups
    WebDriver driver;
    static Properties properties;
    Helper elementHelper;
    By locator;
    By selectBtn = By.cssSelector(".action-select-btn.active");

    //Ticket List Page constructor
    public TicketListPage(WebDriver driver) {
        this.driver = driver;
        this.elementHelper = new Helper(driver);
        properties = ConfigReader.initialize_Properties();
    }

    public void ClickDeparture(String provider) {
        locator = By.xpath("(//div[@data-booking-provider='" + provider + "'])[1]");
        this.elementHelper.click(locator);
    }

    public void ClickArrival(String provider) {
        locator = By.xpath("(//div[@data-booking-provider='" + provider + "'])[2]");
        this.elementHelper.click(locator);
    }

    public void SelectFlightBtn() {
        this.elementHelper.click(selectBtn);
    }

}
