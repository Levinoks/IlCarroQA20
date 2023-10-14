package manager;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class BaseHelper {

    WebDriver driver;

    public BaseHelper(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement findElementBase(By locator) {
        System.out.println(locator);
        return driver.findElement(locator);
    }

    private List<WebElement> findElementsBase(By locator) {
        System.out.println(locator);
        return driver.findElements(locator);
    }

    public boolean isElementExist(By locator){
        return findElementsBase(locator).size()>0;
    }

    public void clickBase(By locator) {
        WebElement el = findElementBase(locator);
        el.click();
    }

    public String getTextBase(By locator) {
        WebElement el = findElementBase(locator);
        return el.getText().trim().toUpperCase();
    }

    public void typeTextBase(By locator, String text) {
        WebElement el = findElementBase(locator);
        el.click();
        el.clear();
        el.sendKeys(text);
    }

    public boolean isTextEqual(By locator, String expectedResult) {
        String actualResult = getTextBase(locator);
        expectedResult = expectedResult.toUpperCase();
        if (expectedResult.equals(actualResult)) {
            return true;
        } else {
            System.out.println("expected result: " + expectedResult + "actual result: " + actualResult);
            return false;

        }

    }
    public void pause(int second) {
        try {
            Thread.sleep(second * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void jsClickBase(String locator){
        JavascriptExecutor js = (JavascriptExecutor) driver ;
        js.executeScript(locator);
        System.out.println(locator);
    }


    public void clickByXY(By locator, double down, int right){
        Rectangle rect = findElementBase(locator).getRect();
        int x = rect.getX() + (rect.getWidth() / right);
        double y = (int) rect.getY() + (rect.getHeight() / down);
        Actions actions = new Actions(driver);
        actions.moveByOffset(x, (int) y).click().perform();
        }

    public void refresh(){
       driver.navigate().refresh();
    }


}
