package starttesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import java.util.concurrent.TimeUnit;

public class LoginTests {

    WebDriver driver;
    @BeforeClass
    public void preconditions() {
        driver = new ChromeDriver();
        driver.navigate().to("https://ilcarro.web.app/search");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);


    }


public void loginPositive(){

//    /*
//    click log in
  // fill input email
  //          fill input password
    //press on button Yalla!
    //validate by text: Logged in success in the element    //h2[@class='message']
//    */


    WebElement btnLogin = driver.findElement(By.xpath("//a[contains(@href, '/login')]"));
    btnLogin.click();

    WebElement inputEmail = driver.findElement(By.xpath("//input[@id='email']"));
    inputEmail.click();
    inputEmail.clear();
    inputEmail.sendKeys("qwer1@hh.e");

    WebElement inputPassword = driver.findElement(By.xpath("//input[@id='password']"));
    inputPassword.click();
    inputPassword.clear();
    inputPassword.sendKeys("User#12345");

    WebElement btnYalla = driver.findElement(By.xpath("//button[@type='submit']"));
    btnYalla.click();

    WebElement textMessagePopUpH2 = driver.findElement(By.xpath("//h2[@class='message']"));
    String textMessageH2= textMessagePopUpH2.getText().trim().toUpperCase();
    String expectedResult = "Logged in success".toUpperCase();
    Assert.assertEquals(textMessageH2, expectedResult);


}


    @AfterClass
    public void postconditions() {
        driver.quit();
    }
}
