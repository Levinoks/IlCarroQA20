package tests;

import dto.UserDTO;
import dto.UserDTOWith;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void positivePositiveUserDTO() {
        UserDTO userDTO = new UserDTO("qwerty1@gmail.com", "User#12345");
        app.getUserHelper().login(userDTO);
        Assert.assertTrue(app.getUserHelper().validatePopUpMessageSuccessAfterLogin());

    }

    @Test
    public void positivePositiveUserDTOWith() {
        UserDTOWith userDTOWith = new UserDTOWith().withEmail("qwerty1@gmail.com").withPassword("User#12345");
        app.getUserHelper().login(userDTOWith);
        Assert.assertTrue(app.getUserHelper().validatePopUpMessageSuccessAfterLogin());

    }
}
