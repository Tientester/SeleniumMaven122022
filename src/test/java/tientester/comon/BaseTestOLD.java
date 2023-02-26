package tientester.comon;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTestOLD {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeMethod
    @Parameters("browser")
    public static void createDriver(@Optional("chrome") String browser) {
        setupDriver(browser);
    }

    //Viết hàm trung gian để lựa chọn Browser cần chạy với giá trị tham số "browser" bên trên truyền vào
    public static WebDriver setupDriver(String browserName){
        switch (browserName.trim().toLowerCase()){
            case "chrome":
                driver = intitChromeDriver();
                break;
            case "firefox":
                driver = intitFirefoxDriver();
                break;
            case "edge":
                driver = intitEdgeDriver();
                break;
            default:
                System.out.println("Browser:" + browserName + " is invalid, Launching Chrome as browser of choice...");
                driver = intitChromeDriver();

        }
        return driver;
    }

    //Viết hàm khởi tạo
    private static WebDriver intitChromeDriver() {
        System.out.println("Launching Chrome browser...");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver intitFirefoxDriver() {
        System.out.println("Launching Firefox browser...");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver intitEdgeDriver() {
        System.out.println("Launching Edge browser...");
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        return driver;
    }


    @AfterMethod
    public static void closeDriver() {
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0)); //Reset timeout
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if(driver != null) {
            driver.quit();
        }
    }

    public WebElement waitForElementVisible(By by, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));

        return driver.findElement(by);
    }

    public WebElement waitForElementPressent(By by, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));

        return driver.findElement(by);
    }
}
