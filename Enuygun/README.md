```java
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
        flightTicketPage.typeFlightFromField(properties.getProperty("origin")); // resources/config.properties'ten gelen origin bilgisi "Nereden" alanına girilir
        flightTicketPage.clickByFirstFlightFromResult(); // İlk öneri seçilir
        flightTicketPage.typeFlightToField(properties.getProperty("destination")); // resources/config.properties'ten gelen destination bilgisi "Nereye" alanına girilir
        flightTicketPage.clickByFirstFlightToResult(); // İlk öneri seçilir
        flightTicketPage.clickDepartureDate(); // Gidiş tarihi alanına tıklanır
        flightTicketPage.selectDepartureDate(Integer.parseInt(properties.getProperty("departureDay"))); // resources/config.properties'ten gelen departureDay bilgisi ile "Gidiş Tarihi" seçilir 
        flightTicketPage.clickReturnDate(); // Dönüş tarihi alanına tıklanır
        flightTicketPage.selectReturnDate(Integer.parseInt(properties.getProperty("returnDay"))); // resources/config.properties'ten gelen returnDay bilgisi ile "Dönüş Tarihi" seçilir 
        flightTicketPage.clickFindBestDealsBtn(); // Ucuz bilet bul butonuna tıklanır 
 
        ticketListPage.ClickDeparture(properties.getProperty("provider")); // resources/config.properties'ten gelen provider bilgisi ile uçak bileti seçilir
        Thread.sleep(3000);
        ticketListPage.ClickArrival(properties.getProperty("provider"));
        ticketListPage.SelectFlightBtn();
    }

    @AfterClass
    public void teardown() {
        driver.close();
    }
}
```
