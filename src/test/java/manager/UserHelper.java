package manager;

import dto.UserDTO;
import dto.UserDTOLombok;
import dto.UserDTOWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper {
    public UserHelper(WebDriver driver) {
        super(driver);
    }

    By btnLoginNavigatorMenu = By.xpath("//a[contains(@href, '/login')]");
    By btnRegistrationNavigatorMenu = By.xpath("//a[contains(@href, '/registration')]");
    By inputEmailLoginForm = By.xpath("//input[@id='email']");
    By inputLastNameRegForm = By.xpath("//input[@id='lastName']");
    By inputNameRegForm = By.xpath("//input[@id='name']");
    By inputPasswordLoginForm = By.xpath("//input[@id='password']");
    By btnYallaLoginForm = By.xpath("//button[@type='submit']");
    By textSuccessfulLoginPopUp = By.xpath("//h2[@class='message']");
    By textSuccessfulRegPopUp = By.xpath("//div[@class='dialog-container']/h1[@class='title']");
    String checkBox = "document.querySelector('#terms-of-use').click();";
    By checkBoxReg = By.xpath("//label[@for='name']");


    public void login(UserDTO userDTO) {
        clickBase(btnLoginNavigatorMenu);
        typeTextBase(inputEmailLoginForm, userDTO.getEmail());
        typeTextBase(inputPasswordLoginForm, userDTO.getPassword());
        clickBase(btnYallaLoginForm);
    }

    public void login(UserDTOWith userDTO) {
        clickBase(btnLoginNavigatorMenu);
        typeTextBase(inputEmailLoginForm, userDTO.getEmail());
        typeTextBase(inputPasswordLoginForm, userDTO.getPassword());
        clickBase(btnYallaLoginForm);
    }

    public void loginUserDTOLombok(UserDTOLombok userDTO) {
        clickBase(btnLoginNavigatorMenu);
        typeTextBase(inputEmailLoginForm, userDTO.getEmail());
        typeTextBase(inputPasswordLoginForm, userDTO.getPassword());
        clickBase(btnYallaLoginForm);
    }


    public boolean validatePopUpMessageSuccessAfterLogin() {
        return isTextEqual(textSuccessfulLoginPopUp, "Logged in success");
    }

    public void fillRegistrationForm(UserDTOLombok user) {
        clickBase(btnRegistrationNavigatorMenu);
        typeTextBase(inputNameRegForm, user.getName());
        typeTextBase(inputLastNameRegForm, user.getLastName());
        typeTextBase(inputEmailLoginForm, user.getEmail());
        typeTextBase(inputPasswordLoginForm, user.getPassword());
        jsClickBase(checkBox);
        //clickByXY(checkBoxReg, 8,2);
        clickBase(btnYallaLoginForm);

    }

    public boolean validatePopUpMessageSuccessAfterRegistration() {

        return isTextEqual(textSuccessfulRegPopUp, "Registered");
    }
}
