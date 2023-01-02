package tientester.Bai15Wait;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import tientester.comon.BaseTestOLD;

import java.time.Duration;

public class LearnexplicitWait extends BaseTestOLD {

    @Test(priority = 1)
    public void ExplicitWaitDemo1() {

        driver.get("https://app.hrsale.com/");


        driver.findElement(By.id("iusername")).sendKeys("frances.burns");
        driver.findElement(By.id("ipassword")).sendKeys("frances.burns");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Click menu dự án

        //chờ đợi đến khi element tìm thấy trong DOM và sẵn sàng hiễn thị để thao tác
        //Đối tượng By
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Projects']")));

        driver.findElement(By.xpath("//span[normalize-space()='Projects']")).click();
    }

    @Test(priority = 2)
    public void ExplicitWaitDemo2() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://cms.anhtester.com/");

        driver.findElement(By.xpath("//i[@class='la la-close fs-20']")).click();

        WebElement element = driver.findElement(By.xpath("//div[normalize-space()='Demo category 2']"));

        element.click();
    }

    @Test(priority = 3)
    public void ExplicitWaitDemo3() {

        driver.get("https://cms.anhtester.com/");

        waitForElementVisible(By.xpath("//i[@class='la la-close fs-20']"), 5).click();

        waitForElementPressent(By.xpath("//div[normalize-space()='Demo category 2']"), 2).click();

    }


}
