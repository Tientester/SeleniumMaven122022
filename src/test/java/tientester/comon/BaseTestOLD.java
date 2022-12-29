package tientester.comon;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTestOLD {
    public static WebDriver driver;

    @BeforeMethod
    public static void createDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Set timeout cho chờ đợi ngầm định 10s
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Bổ trợ cho ổn định hơn
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

        System.out.println("createDriver: " + driver);

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
}
