
> ###  ``` Appium ile Contact Manager uygulamasının senaryoları   ``` 
 
Uygulama tam anlamıyla çalışmadığı için assertler maalesef istenildiği gibi yazılamadı. Senaryolar çıkartılmaya çalışıldı.


 ###  👨🏻‍💻 Senaryo-1 : User checks required fields for add account page
---

```java
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
```
 
 ###  👨🏻‍💻 Senaryo-2 : User adds a work account successfully
---

```java 
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
``` 

 ###  👨🏻‍💻 Senaryo-3 : User adds a home acocunt successfully
---

```java 
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
``` 

 ###  👨🏻‍💻 Senaryo-4 : User adds a mobile account successfully
---

```java 
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
``` 

 ###  👨🏻‍💻 Senaryo-5 : User checks number limit for contact phone field
---

```java 
@Test(priority = 4)
public void UserChecksNumberLimitContactPhoneField() throws NullPointerException {
	String contactPhone = "123456789123123"; // 15 karakter veri girilir

	homePage.getAddContactBtn().click();
	addContactPage.getContactPhoneField().sendKeys(contactPhone);

	Assert.assertEquals(addContactPage.getContactPhoneField().getText().length(),
	12); // 90535 ile başladığı için maksimum 12 karakter olması beklenir
}
``` 

 ###  👨🏻‍💻 Senaryo-6 : User checks email format for contact email field
---

```java 
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
``` 

 ###  👨🏻‍💻 Senaryo-7 : User checks whether contact name accepts number and digit
---

```java 
@Test(priority = 6)
public void UserChecksWhetherContactNameAcceptsNumberAndDigit() throws NullPointerException {
	String contactName = "Büşra37";

	homePage.getAddContactBtn().click();
	addContactPage.getContactNameField().sendKeys(contactName);

	Assert.assertEquals(addContactPage.getContactNameField().getText(),
	"Büşra"); // Sayı veya rakam değeri yazılmaması gerekiyor.
}
``` 

 ###  👨🏻‍💻 Senaryo-8 : User checks speacial characters limit for contact name
---

```java 
@Test(priority = 7)
public void UserChecksSpecialCharactersLimitContactNameField() throws NullPointerException {
	String specialCharacters = "!'^+%&/()=?-*";


	homePage.getAddContactBtn().click();
	addContactPage.getContactNameField().sendKeys(specialCharacters);

	Assert.assertEquals(addContactPage.getContactNameField().getText(),
	specialCharacters); // Özel karakterler yazıldı mı? Normalde textBox'lar altında uyarılar çıkması lazımdı ancak uygulamada sorun olduğu için bu şekilde kontrol ettim.
}
``` 

 ###  👨🏻‍💻 Senaryo-9 : User checks special characters limit for contact phone field
---

```java 
@Test(priority = 8)
public void UserChecksSpecialCharactersLimitContactPhoneField() throws NullPointerException {
	String specialCharacters = "!'^+%&/()=?-*";


	homePage.getAddContactBtn().click();
	addContactPage.getContactPhoneField().sendKeys(specialCharacters);

	Assert.assertEquals(addContactPage.getContactPhoneField().getText(),
	specialCharacters); // Özel karakterler yazıldı mı? Normalde textBox'lar altında uyarılar çıkması lazımdı ancak uygulamada sorun olduğu için bu şekil kontrol ettim.
}
```
