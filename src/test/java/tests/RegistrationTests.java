package tests;

import dto.UserDTOLombok;
import org.testng.Assert;
import org.testng.annotations.*;

public class RegistrationTests extends BaseTest {

    @BeforeMethod
    public void preconditionsRegistration() {
        logoutIfLogin();
    }

    @AfterMethod
    public void postconditionsRegistration() {
        clickOkIfRegistered();
        app.getUserHelper().refresh();
    }

    @Test
    public void positiveRegistration() {
        String email = random.generateEmail(6);
        UserDTOLombok user = UserDTOLombok.builder().email(email).password("User#12345").lastName("Asdfqe").name("test").build();
        app.getUserHelper().fillRegistrationForm(user);
        Assert.assertTrue(app.getUserHelper().validatePopUpMessageSuccessAfterRegistration());
    }

    @Test
    public void negativeRegistrationWrongEmail() {
        UserDTOLombok user = UserDTOLombok.builder().email("email@").password("User#12345").lastName("Asdfqe").name("test").build();
        app.getUserHelper().fillNegativeRegistrationForm(user);
        Assert.assertTrue(app.getUserHelper().validateMessageWrongEmail());
    }

    @Test
    public void negativeRegistrationWrongPassword() {
        UserDTOLombok user = UserDTOLombok.builder().email("email@gmail.com").password("123456Aa").lastName("Asdfqe").name("test").build();
        app.getUserHelper().fillNegativeRegistrationForm(user);
        Assert.assertTrue(app.getUserHelper().validateMessageWrongPassword());

    }

    @Test
    public void negativeRegistrationBlankEmail() {
        UserDTOLombok user = UserDTOLombok.builder().email("").password("ser12345").lastName("Asdfqe").name("test").build();
        app.getUserHelper().fillNegativeRegistrationForm(user);
        Assert.assertTrue(app.getUserHelper().validateErrorEmptyEmail());
    }

}
