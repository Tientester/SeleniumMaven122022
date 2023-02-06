package tientester.com.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebUI {

    private static int TIMEOUT = 10;

    private static double STEP_TIMEOUT = 0;

    private final static int PAGE_LOAD_TIMEOUT = 20;

    private static WebDriver driver;
    public WebUI(WebDriver driver){
        this.driver = driver;
    }

    public static void sleep(double second){
        try {
            Thread.sleep((long) (1000 * second));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void logConsole(Object message){
        System.out.println(message);
    }

    public static WebElement getWebElement(By by){
        return driver.findElement(by);
    }

    public static List<WebElement> getWebElements(By by) {
        return driver.findElements(by);
    }

    public static void openURL(String url){
        driver.get(url);
        sleep(STEP_TIMEOUT);
        logConsole("Open URL: " +url);
    }

    public static void clickElement(By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        sleep(STEP_TIMEOUT);
        getWebElement(by).click();
        logConsole("Click element: " +by);
    }

    public static void clickElement(WebDriver driver,By by, long timeout){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        sleep(STEP_TIMEOUT);
        driver.findElement(by).click();
        logConsole("Click element: " +by);
    }

    public static void setText(By by, String value){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        sleep(STEP_TIMEOUT);
        getWebElement(by).sendKeys(value);
        logConsole("Set text on: " +value + "on element: " +by);
    }

    public static String getElementText(By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        sleep(STEP_TIMEOUT);
        String text = getWebElement(by).getText();
        logConsole("Get text: " +text);

        return text; //Trả về giá trị kiểu String

    }

    public static void waitForElementClickable(WebDriver driver,By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void waitForElementVisible(WebDriver driver,By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

}

