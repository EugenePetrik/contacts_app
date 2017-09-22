import enums.Platform;
import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.ContactsListPage;

import java.util.ArrayList;

import static pageobjects.BasePage.platform;

public class SearchContacts extends AbstractTest {

    @Test(description = "Search by full name")
    public void testSearchContact() throws Exception {
        boolean searchSuccessful = new ContactsListPage(driver)
                .searchByName("Byron Workman")
                .isSearchSuccessful();

        Assert.assertTrue(searchSuccessful);
    }

    @Test(description = "Search by part name")
    public void testSearchByPartName() throws Exception {
        ArrayList<MobileElement> findAllNames = new ContactsListPage(driver)
                .searchByName("Li")
                .getAllActiveNames();

        Assert.assertEquals(findAllNames.size(), 2);

        Assert.assertEquals(new ContactsListPage(driver)
                .selectContact("Lily Barnhill"), "Lily Barnhill");
        Assert.assertEquals(new ContactsListPage(driver)
                .selectContact("Philippe Meyerson"), "Philippe Meyerson");
    }

    @Test(description = "Negative Search")
    public void testNegativeSearch() throws Exception {
        ArrayList<MobileElement> findAllNames = new ContactsListPage(driver)
                .searchByName("123")
                .getAllActiveNames();

        Assert.assertEquals(findAllNames.size(), 0);

        if (platform.equals(Platform.ANDROID)) Assert.assertEquals(new ContactsListPage(driver)
                    .getErorrMessageText(), "No contacts found with \"123\" in the name");
    }

}
