package tests;

import dto.UserDTO;
import dto.UserDTOLombok;
import dto.UserDTOWith;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
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
    public void positiveLogin(){
        UserDTOLombok userLombok = UserDTOLombok.builder().email("qwerty1@gmail.com").password("User#12345").build();
        app.getUserHelper().loginUserDTOLombok(userLombok);
        Assert.assertTrue(app.getUserHelper().validatePopUpMessageSuccessAfterLogin());


    }
}
