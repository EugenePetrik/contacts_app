import enums.Platform;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.ContactsDetailsPage;
import pageobjects.ContactsListPage;

import static pageobjects.BasePage.platform;

public class DetailsContacts extends AbstractTest {

    @Test(description = "Displaying contact information")
    public void testContactInfo() throws Exception {
        ContactsDetailsPage contactsListPage = new ContactsListPage(driver)
                .searchByName("Byron Workman")
                .clickToContactName();

        Assert.assertTrue(contactsListPage.isImageDisplayed());
        Assert.assertEquals(contactsListPage.getUserName(), "Byron Workman");
        Assert.assertEquals(contactsListPage.getUserPhone(), "+1(656)-6779916");
        Assert.assertEquals(contactsListPage.getUserEmail(), "ggbyron6@yopmail.com");
        Assert.assertEquals(contactsListPage.getUserStreet(), "413 Wescam Drive");
        Assert.assertEquals(contactsListPage.getUserCity(), "43115 Miami");
    }

    @Test(description = "Find five elements")
    public void testFindFiveElements() throws Exception {

        for (int i = 0; i < 5; i++) {

            new ContactsListPage(driver).clickToContact(i);

            ContactsDetailsPage contactsDetailsPage = new ContactsDetailsPage(driver);

            if (platform.equals(Platform.ANDROID)) {

                switch (contactsDetailsPage.getUserName()) {

                    case "Jenny Cherry": {
                        Assert.assertTrue(contactsDetailsPage.isImageDisplayed());
                        Assert.assertTrue(contactsDetailsPage.getUserPhone().equals("+1(959)-1775994"));
                        Assert.assertTrue(contactsDetailsPage.getUserEmail().equals("jqjenny16@yopmail.com"));
                        Assert.assertTrue(contactsDetailsPage.getUserStreet().equals("201 Metz Bates"));
                        Assert.assertTrue(contactsDetailsPage.getUserCity().equals("15840 New York"));
                        break;
                    }

                    case "Garance Epperson": {
                        Assert.assertTrue(contactsDetailsPage.isImageDisplayed());
                        Assert.assertTrue(contactsDetailsPage.getUserPhone().equals("+1(747)-8330134"));
                        Assert.assertTrue(contactsDetailsPage.getUserEmail().equals("duepperson20@gmail.com"));
                        Assert.assertTrue(contactsDetailsPage.getUserStreet().equals("542 American Circle"));
                        Assert.assertTrue(contactsDetailsPage.getUserCity().equals("49100 Washington"));
                        break;
                    }

                    case "Nadia Patten": {
                        Assert.assertTrue(contactsDetailsPage.isImageDisplayed());
                        Assert.assertTrue(contactsDetailsPage.getUserPhone().equals("+1(131)-9550402"));
                        Assert.assertTrue(contactsDetailsPage.getUserEmail().equals("jnnadia13@gmail.com"));
                        Assert.assertTrue(contactsDetailsPage.getUserStreet().equals("791 Bombardier Court"));
                        Assert.assertTrue(contactsDetailsPage.getUserCity().equals("93809 New York"));
                        break;
                    }

                    case "Jennifer Krantz": {
                        Assert.assertTrue(contactsDetailsPage.isImageDisplayed());
                        Assert.assertTrue(contactsDetailsPage.getUserPhone().equals("+1(656)-6779916"));
                        Assert.assertTrue(contactsDetailsPage.getUserEmail().equals("eekrantz4@yopmail.com"));
                        Assert.assertTrue(contactsDetailsPage.getUserStreet().equals("413 Wescam Drive"));
                        Assert.assertTrue(contactsDetailsPage.getUserCity().equals("43115 Miami"));
                        break;
                    }

                    case "Christin Steinberg": {
                        Assert.assertTrue(contactsDetailsPage.isImageDisplayed());
                        Assert.assertTrue(contactsDetailsPage.getUserPhone().equals("+1(656)-1115633"));
                        Assert.assertTrue(contactsDetailsPage.getUserEmail().equals("awchristin22@yahoo.com"));
                        Assert.assertTrue(contactsDetailsPage.getUserStreet().equals("412 Barfield Trail"));
                        Assert.assertTrue(contactsDetailsPage.getUserCity().equals("53713 Houston"));
                        break;
                    }

                    default: {
                        System.out.println("I didn't find this element");
                        break;
                    }

                }

            } else if (platform.equals(Platform.IOS)) {

                switch (contactsDetailsPage.getUserName()) {

                    case "Byron Workman": {
                        Assert.assertTrue(contactsDetailsPage.isImageDisplayed());
                        Assert.assertTrue(contactsDetailsPage.getUserPhone().equals("+1(656)-6779916"));
                        Assert.assertTrue(contactsDetailsPage.getUserEmail().equals("ggbyron6@yopmail.com"));
                        Assert.assertTrue(contactsDetailsPage.getUserStreet().equals("413 Wescam Drive"));
                        Assert.assertTrue(contactsDetailsPage.getUserCity().equals("43115 Miami"));
                        break;
                    }

                    case "Chris Heavener": {
                        Assert.assertTrue(contactsDetailsPage.isImageDisplayed());
                        Assert.assertTrue(contactsDetailsPage.getUserPhone().equals("+1(959)-1775994"));
                        Assert.assertTrue(contactsDetailsPage.getUserEmail().equals("ischris18@outlook.com"));
                        Assert.assertTrue(contactsDetailsPage.getUserStreet().equals("201 Metz Bates"));
                        Assert.assertTrue(contactsDetailsPage.getUserCity().equals("15840 New York"));
                        break;
                    }

                    case "Christin Steinberg": {
                        Assert.assertTrue(contactsDetailsPage.isImageDisplayed());
                        Assert.assertTrue(contactsDetailsPage.getUserPhone().equals("+1(656)-1115633"));
                        Assert.assertTrue(contactsDetailsPage.getUserEmail().equals("awchristin22@yahoo.com"));
                        Assert.assertTrue(contactsDetailsPage.getUserStreet().equals("412 Barfield Trail"));
                        Assert.assertTrue(contactsDetailsPage.getUserCity().equals("53713 Houston"));
                        break;
                    }

                    case "Dulcie Moller": {
                        Assert.assertTrue(contactsDetailsPage.isImageDisplayed());
                        Assert.assertTrue(contactsDetailsPage.getUserPhone().equals("+1(555)-9779202"));
                        Assert.assertTrue(contactsDetailsPage.getUserEmail().equals("eimoller8@yopmail.com"));
                        Assert.assertTrue(contactsDetailsPage.getUserStreet().equals("52 Woodside Way"));
                        Assert.assertTrue(contactsDetailsPage.getUserCity().equals("58193 New Jersey"));
                        break;
                    }

                    case "Duane Cedillo": {
                        Assert.assertTrue(contactsDetailsPage.isImageDisplayed());
                        Assert.assertTrue(contactsDetailsPage.getUserPhone().equals("+1(141)-1779583"));
                        Assert.assertTrue(contactsDetailsPage.getUserEmail().equals("hxduane23@gmail.com"));
                        Assert.assertTrue(contactsDetailsPage.getUserStreet().equals("438 Ethels Lane"));
                        Assert.assertTrue(contactsDetailsPage.getUserCity().equals("24456 Houston"));
                        break;
                    }

                    default: {
                        System.out.println("I didn't find this element");
                        break;
                    }

                }

            }

            contactsDetailsPage.returnBack();

        }

    }

}
