package pageobjects;

import enums.Platform;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindAll;
import io.appium.java_client.pagefactory.iOSFindBy;

import java.util.ArrayList;

public class ContactsListPage extends BasePage {

    @iOSFindBy(accessibility = "Search for contact")
    private MobileElement searchForContact;

    @iOSFindAll(@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@visible=\"true\"]"))
    private ArrayList<MobileElement> contactsCollection;

    @AndroidFindBy(id = "main_text")
    private MobileElement errorMessageForAndroid;

    private String fullName;

    public ContactsListPage searchByName(String searchVal) {
        searchForContact.setValue(searchVal);
        this.fullName = searchVal;
        return this;
    }

    public boolean isSearchSuccessful() {
        boolean equals = contactsCollection.get(0).getText().equals(fullName);
        boolean size = contactsCollection.size() == 1;
        if (equals && size) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<MobileElement> getAllActiveNames() {
        return contactsCollection;
    }

    public String selectContact(String fullName) {
        String locator = "";

        if (BasePage.platform.equals(Platform.ANDROID)) {
            locator = String.format("//android.widget.TextView[@text='%s']", fullName);
        } else if (BasePage.platform.equals(Platform.IOS)) {
            locator = String.format("//XCUIElementTypeStaticText[@name='%s']", fullName);
        }

        return driver.findElementByXPath(locator).getText();
    }

    public String getErorrMessageText() {
        return errorMessageForAndroid.getText();
    }

    public ContactsListPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public BasePage initializePage() {
        return null;
    }

}
