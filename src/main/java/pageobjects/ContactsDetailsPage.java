package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class ContactsDetailsPage extends BasePage {

    @iOSFindBy(accessibility = "contact_details")
    @AndroidFindBy(id = "detail_icon")
    private MobileElement userImage;

    @iOSFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeStaticText[1]")
    @AndroidFindBy(id = "detail_name")
    private MobileElement userName;

    @iOSFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeStaticText[3]")
    @AndroidFindBy(id = "phonenumber")
    private MobileElement userPhone;

    @iOSFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeStaticText[5]")
    @AndroidFindBy(id = "email")
    private MobileElement userEmail;

    @iOSFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeStaticText[7]")
    @AndroidFindBy(id = "street1")
    private MobileElement userStreet;

    @iOSFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeStaticText[8]")
    @AndroidFindBy(id = "street2")
    private MobileElement userCity;

    public boolean isImageDisplayed() {
        return userImage.isDisplayed();
    }

    public String getUserName() {
        return userName.getText();
    }

    public String getUserPhone() {
        return userPhone.getText();
    }

    public String getUserEmail() {
        return userEmail.getText();
    }

    public String getUserStreet() {
        return userStreet.getText();
    }

    public String getUserCity() {
        return userCity.getText();
    }

    public ContactsDetailsPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        initializePage();
    }

    public ContactsDetailsPage initializePage() {
        waitForElement(userImage);
        return this;
    }

}
