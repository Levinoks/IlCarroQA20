package manager;

import dto.UserDTO;
import dto.UserDTOLombok;
import dto.UserDTOWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

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
    String btnOkPopUpStr = "document.querySelector(\"[type='button']\").click();";
    By checkBoxReg = By.xpath("//label[@for='terms-of-use']");
    By btnLogout = By.xpath("//a[contains(@href,'/logout')]");
    By btnOkPopUp = By.xpath("//button[@type='button']");
    By textincorectLoginPopUp = By.xpath("//div[@class='dialog-container']/h1[@class='title']");
    By errorMessageWrongEmailRegForm = By.xpath("//input[@autocomplete='email']/..//div//div");
    By errorMessageWrongPassRegForm = By.xpath("//input[@autocomplete='new-password']/..//div//div");//"div.input-container:nth-child(4) div div");
    By errorMessageEmptyEmailRegForm = By.xpath("//input[@autocomplete='email']/..//div//div");


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
        clickBase(btnYallaLoginForm);


    }

    public void fillNegativeRegistrationForm(UserDTOLombok user) {
        clickBase(btnRegistrationNavigatorMenu);
        typeTextBase(inputNameRegForm, user.getName());
        typeTextBase(inputLastNameRegForm, user.getLastName());
        typeTextBase(inputEmailLoginForm, user.getEmail());
        typeTextBase(inputPasswordLoginForm, user.getPassword());
        Actions act = new Actions(driver);
       act.sendKeys(Keys.TAB).perform();
        jsClickBase(checkBox);

    }

    public boolean validatePopUpMessageSuccessAfterRegistration() {

        return isTextEqual(textSuccessfulRegPopUp, "Registered");
    }

    public boolean btnLogOutExist() {
        return isElementExist(btnLogout);

    }

    public void logout() {
        clickBase(btnLogout);
    }

    public void clickOkSuccessLogin() {
        clickBase(btnOkPopUp);

    }

    public boolean validatePopUpMessageLoginIncorrect() {
        return isTextEqual(textincorectLoginPopUp, "Login failed");
    }

    public boolean validateMessageWrongEmail() {
        return isTextEqual(errorMessageWrongEmailRegForm, "Wrong email format");
    }


    public boolean validateMessageWrongPassword() {
        String exResult = "PASSWORD MUST CONTAIN 1 UPPERCASE LETTER, 1 LOWERCASE LETTER, 1 NUMBER AND ONE SPECIAL SYMBOL OF [@$#^&*!]";
        return isTextEqual(errorMessageWrongPassRegForm, exResult);
    }

    public boolean validateErrorEmptyEmail() {
        return isTextEqual(errorMessageEmptyEmailRegForm, "Email is required");
    }

    public boolean popUpMessageSuccessAfterRegistrationExist() {
        return isElementExist(btnOkPopUp);
    }
}

