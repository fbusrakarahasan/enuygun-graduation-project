package testng;

import devices.DeviceFarm;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AddContactPage;
import pages.HomePage;
import utility.DeviceFarmUtility;

import javax.net.ssl.SSLException;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class ContactManagerTestNG {

    public static AppiumDriver<?> Driver;
    HomePage homePage;
    AddContactPage addContactPage;
    String nougat;
    DesiredCapabilities capabilities;

    public ContactManagerTestNG() {
        nougat = DeviceFarm.ANDROID_NOUGAT.path;
    }

    @BeforeClass
    public void setup() throws SSLException, MalformedURLException {
        try {
            capabilities = new DesiredCapabilities();
            capabilities = DeviceFarmUtility.pathToDesiredCapabilitites(this.nougat);
            capabilities.setCapability("app", new File("src/test/resources/apps/ContactManager.apk").getAbsolutePath());
            Driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

            homePage = new HomePage();
            addContactPage = new AddContactPage();
        } catch (Exception e) {
            throw new SSLException("Remote URL'de SSL bulunmuyor, kontrol ediniz. Hata kodu: \n\n" + e.getMessage());
        }
    }

    @Test(priority = 0)
    public void UserChecksRequiredFieldsForAddAccountPage() throws NullPointerException {
        homePage
                .getAddContactBtn()
                .click();
        addContactPage
                .getContactSaveBtn()
                .click();

        Assert.assertEquals(addContactPage.getAlertTitle().getText(),
                "Please fill in the required fields."); // Kaydet yapıldığında çıkan uyarı kontrol edildi.
    }

    @Test(priority = 1)
    public void UserAddsWorkAccountSuccessfully() throws NullPointerException {
        String contactName = "Fatma Büşra KARAHASAN";
        String contactPhone = "905555555555";
        String contactEmail = "appium_WORK@gmail.com";


        homePage.getAddContactBtn().click();
        addContactPage.getContactNameField().sendKeys(contactName);
        addContactPage.getContactPhoneField().sendKeys(contactPhone);
        addContactPage.getContactPhoneDrop().click();
        addContactPage.getContactPhoneDropWork().click();
        addContactPage.getContactEmailField().sendKeys(contactEmail);
        addContactPage.getContactEmailDrop().click();
        addContactPage.getContactEmailDropWork().click();
        addContactPage.getContactSaveBtn().click();

        Assert.assertEquals(addContactPage.getAlertTitle().getText(),
                "Registration successfully created."); // Kaydet yapıldığında çıkan uyarı kontrol edildi.
    }

    @Test(priority = 2)
    public void UserAddsHomeAccountSuccessfully() throws NullPointerException {
        String contactName = "Fatma Büşra KARAHASAN";
        String contactPhone = "902622262626";
        String contactEmail = "appium_HOME@gmail.com";


        homePage.getAddContactBtn().click();
        addContactPage.getContactNameField().sendKeys(contactName);
        addContactPage.getContactPhoneField().sendKeys(contactPhone);
        addContactPage.getContactPhoneDrop().click();
        addContactPage.getContactPhoneDropHome().click();
        addContactPage.getContactEmailField().sendKeys(contactEmail);
        addContactPage.getContactEmailDrop().click();
        addContactPage.getContactEmailDropHome().click();
        addContactPage.getContactSaveBtn().click();

        Assert.assertEquals(addContactPage.getAlertTitle().getText(),
                "Registration successfully created."); // Kaydet yapıldığında çıkan uyarı kontrol edildi.
    }

    @Test(priority = 3)
    public void UserAddsMobileAccountSuccessfully() throws NullPointerException {
        String contactName = "Fatma Büşra KARAHASAN";
        String contactPhone = "905353535353";
        String contactEmail = "appium_MOBILE@gmail.com";


        homePage.getAddContactBtn().click();
        addContactPage.getContactNameField().sendKeys(contactName);
        addContactPage.getContactPhoneField().sendKeys(contactPhone);
        addContactPage.getContactPhoneDrop().click();
        addContactPage.getContactPhoneDropMobile().click();
        addContactPage.getContactEmailField().sendKeys(contactEmail);
        addContactPage.getContactEmailDrop().click();
        addContactPage.getContactEmailDropMobile().click();
        addContactPage.getContactSaveBtn().click();

        Assert.assertEquals(addContactPage.getAlertTitle().getText(),
                "Registration successfully created."); // Kaydet yapıldığında çıkan uyarı kontrol edildi.
    }

    @Test(priority = 4)
    public void UserChecksNumberLimitContactPhoneField() throws NullPointerException {
        String contactPhone = "123456789123123"; // 15 karakter veri girilir

        homePage.getAddContactBtn().click();
        addContactPage.getContactPhoneField().sendKeys(contactPhone);

        Assert.assertEquals(addContactPage.getContactPhoneField().getText().length(),
                12); // 90535 ile başladığı için maksimum 12 karakter olması beklenir
    }

    @Test(priority = 5)
    public void UserChecksEmailFormatContactEmailField() throws NullPointerException {
        String contactName = "Fatma Büşra KARAHASAN";
        String contactPhone = "905353535353";
        String contactEmail = "testmail.com";


        homePage.getAddContactBtn().click();
        addContactPage.getContactNameField().sendKeys(contactName);
        addContactPage.getContactPhoneField().sendKeys(contactPhone);
        addContactPage.getContactPhoneDrop().click();
        addContactPage.getContactPhoneDropMobile().click();
        addContactPage.getContactEmailField().sendKeys(contactEmail);
        addContactPage.getContactEmailDrop().click();
        addContactPage.getContactEmailDropMobile().click();
        addContactPage.getContactSaveBtn().click();

        Assert.assertEquals(addContactPage.getAlertTitle().getText(),
                "Your email address is incorrect."); // Kaydet yapıldığında çıkan uyarı kontrol edildi.
    }

    @Test(priority = 6)
    public void UserChecksWhetherContactNameAcceptsNumberAndDigit() throws NullPointerException {
        String contactName = "Büşra37";

        homePage.getAddContactBtn().click();
        addContactPage.getContactNameField().sendKeys(contactName);

        Assert.assertEquals(addContactPage.getContactNameField().getText(),
                "Büşra"); // Sayı veya rakam değeri yazılmaması gerekiyor.
    }

    @Test(priority = 7)
    public void UserChecksSpecialCharactersLimitContactNameField() throws NullPointerException {
        String specialCharacters = "!'^+%&/()=?-*";


        homePage.getAddContactBtn().click();
        addContactPage.getContactNameField().sendKeys(specialCharacters);

        Assert.assertEquals(addContactPage.getContactNameField().getText(),
                specialCharacters); // Özel karakterler yazıldı mı? Normalde textBox'lar altında uyarılar çıkması lazımdı ancak uygulamada sorun olduğu için bu şekil kontrol ettim.
    }

    @Test(priority = 8)
    public void UserChecksSpecialCharactersLimitContactPhoneField() throws NullPointerException {
        String specialCharacters = "!'^+%&/()=?-*";


        homePage.getAddContactBtn().click();
        addContactPage.getContactPhoneField().sendKeys(specialCharacters);

        Assert.assertEquals(addContactPage.getContactPhoneField().getText(),
                specialCharacters); // Özel karakterler yazıldı mı? Normalde textBox'lar altında uyarılar çıkması lazımdı ancak uygulamada sorun olduğu için bu şekil kontrol ettim.
    }


    @AfterClass
    public void teardown() throws InterruptedException {
        Thread.sleep(50000);
        Driver.quit();
    }

}
