package tests;

import dto.UserDTOLombok;
import manager.ApplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.RandomUtils;

public class BaseTest {

    static ApplicationManager app = new ApplicationManager();
    RandomUtils random = new RandomUtils();
    UserDTOLombok userLombok = UserDTOLombok.builder().email("qwerty1@gmail.com").password("User#12345").build();

    @BeforeSuite
    public void setUp(){
        app.init();
    }

    @AfterSuite
    public void stop (){
        app.tearDown();
    }


    public void logoutIfLogin(){
        if(app.getUserHelper().btnLogOutExist()){
            app.getUserHelper().logout();
        }
    }

    public void clickOkIfRegistered(){
        if(app.getUserHelper().popUpMessageSuccessAfterRegistrationExist())
            app.getUserHelper().clickOkSuccessLogin();
    }

}
