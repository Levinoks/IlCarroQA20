package tests;

import dto.UserDTO;
import dto.UserDTOLombok;
import dto.UserDTOWith;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTests extends BaseTest {

    @BeforeMethod
    public void preconditionsLogin() {

        logoutIfLogin();

    }

    @AfterMethod
    public void postconditions() {
        app.getUserHelper().pause(3);
        clickOkIfRegistered();
        app.getUserHelper().pause(3);
        app.getUserHelper().refresh();
        app.getUserHelper().pause(3);

    }


    @Test
    public void positiveLoginUserDTO() {
        UserDTO userDTO = new UserDTO("qwerty1@gmail.com", "User#12345");
        app.getUserHelper().login(userDTO);
        Assert.assertTrue(app.getUserHelper().validatePopUpMessageSuccessAfterLogin());

    }

    @Test
    public void positiveLoginUserDTOWith() {
        UserDTOWith userDTOWith = new UserDTOWith().withEmail("qwerty1@gmail.com").withPassword("User#12345");
        app.getUserHelper().login(userDTOWith);
        Assert.assertTrue(app.getUserHelper().validatePopUpMessageSuccessAfterLogin());

    }


    @Test
    public void positiveLogin() {

        app.getUserHelper().loginUserDTOLombok(userLombok);
        Assert.assertTrue(app.getUserHelper().validatePopUpMessageSuccessAfterLogin());


    }


    @Test
    public void negativeLoginPasswordWithoutSymbol() {
        UserDTOLombok userLombok = UserDTOLombok.builder().email("qwerty1@gmail.com").password("Uuser12345").build();
        app.getUserHelper().loginUserDTOLombok(userLombok);
        Assert.assertTrue(app.getUserHelper().validatePopUpMessageLoginIncorrect());

    }
}

