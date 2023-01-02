package tientester.Bai15Wait;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import tientester.comon.BaseTestOLD;

import java.time.Duration;

public class LearnimplicitWait extends BaseTestOLD {

    @Test(priority = 1)
    public void ImplicitWaitDemo() {

        driver.get("https://app.hrsale.com/");

        driver.findElement(By.id("iusername")).sendKeys("frances.burns");
        driver.findElement(By.id("ipassword")).sendKeys("frances.burns");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Click menu dự án
        driver.findElement(By.xpath("//span[contains(text(),'Projects')]")).click();
    }

    @Test(priority = 2)
    public void ImplicitWaitDemo2() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://app.hrsale.com/");

        driver.findElement(By.id("iusername")).sendKeys("frances.burns");
        driver.findElement(By.id("ipassword")).sendKeys("frances.burns");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Click menu dự án
        driver.findElement(By.xpath("//span[contains(text(),'Projects123')]")).click();
    }
}
