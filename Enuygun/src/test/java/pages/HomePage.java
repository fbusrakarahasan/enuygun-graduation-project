package pages;

import framework.Helper;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class HomePage {

    //WebDriver setups
    WebDriver driver;
    Helper elementHelper;
    //login page constructor
    public HomePage(WebDriver driver)
    {
        this.driver=driver;
        this.elementHelper=new Helper(driver);
    }
}
