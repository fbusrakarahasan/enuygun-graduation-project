package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.support.PageFactory;
import testng.ContactManagerTestNG;

@Data
public class AddContactPage {
    public AddContactPage(){
        PageFactory.initElements(new AppiumFieldDecorator(ContactManagerTestNG.Driver), this);
    }

    @AndroidFindBy(id = "android:id/title")
    private MobileElement title;

    @AndroidFindBys({@AndroidFindBy(id="title"),@AndroidFindBy(tagName = "title")})
    private MobileElement titleBys;

    @AndroidFindBy(id = "accountSpinner")
    private MobileElement targetAccountField;

    @AndroidFindBy(id = "contactNameEditText")
    private MobileElement contactNameField;

    @AndroidFindBy(id = "contactPhoneEditText")
    private MobileElement contactPhoneField;

    @AndroidFindBy(id = "contactPhoneTypeSpinner")
    private MobileElement contactPhoneDrop;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[1]")
    private MobileElement contactPhoneDropHome;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[2]")
    private MobileElement contactPhoneDropWork;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[3]")
    private MobileElement contactPhoneDropMobile;

    @AndroidFindBy(id = "contactEmailEditText")
    private MobileElement contactEmailField;

    @AndroidFindBy(id = "contactEmailTypeSpinner")
    private MobileElement contactEmailDrop;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[1]")
    private MobileElement contactEmailDropHome;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[2]")
    private MobileElement contactEmailDropWork;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[3]")
    private MobileElement contactEmailDropMobile;

    @AndroidFindBy(id = "contactSaveButton")
    private MobileElement contactSaveBtn;

    @AndroidFindBy(id = "android:id/alertTitle")
    private MobileElement alertTitle;
}
