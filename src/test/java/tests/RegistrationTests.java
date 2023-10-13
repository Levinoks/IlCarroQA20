package tests;

import dto.UserDTOLombok;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseTest{
    @Test
    public void positiveRegistration(){
        String email = random.generateEmail(6);
        UserDTOLombok user = UserDTOLombok.builder().email(email).password("User#12345").lastName("Asdfqe").name("test").build();
        app.getUserHelper().fillRegistrationForm(user);
        Assert.assertTrue(app.getUserHelper().validatePopUpMessageSuccessAfterRegistration());
    }

    @Test
    public void negativeRegistration(){

    }

}
