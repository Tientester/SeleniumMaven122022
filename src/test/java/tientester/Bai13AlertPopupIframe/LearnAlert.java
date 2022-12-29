package tientester.Bai13AlertPopupIframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import tientester.comon.BaseTestOLD;

public class LearnAlert extends BaseTestOLD {

    @Test
    public void testAlert_01() throws InterruptedException {
        driver.get("https://demo.seleniumeasy.com/javascript-alert-box-demo.html");
        Thread.sleep(100);

        driver.findElement(By.xpath("(//button[normalize-space()='Click me!'])[1]")).click();
        Thread.sleep(100);
        System.out.println(driver.switchTo().alert().getText());
        Thread.sleep(200);
        driver.switchTo().alert().accept(); //Nhấn nút OK hoặc Yes
//        Thread.sleep(200);
//        driver.switchTo().alert().dismiss();//Nhấn nút Cancel
    }

    @Test
    public void testAlert_02() throws InterruptedException {
        driver.get("https://demo.seleniumeasy.com/javascript-alert-box-demo.html");
        Thread.sleep(100);
        //check nut oke
        driver.findElement(By.xpath("(//button[normalize-space()='Click me!'])[2]")).click();
        Thread.sleep(100);
        System.out.println(driver.switchTo().alert().getText());
        Assert.assertEquals(driver.switchTo().alert().getText(), "Press a button!", "Text on Alert not make");
        Thread.sleep(200);

        driver.switchTo().alert().accept(); //Nhấn nút OK hoặc Yes
        Thread.sleep(1000);
        WebElement textConfirm = driver.findElement(By.xpath("//p[@id='confirm-demo']"));

        Assert.assertEquals(textConfirm.getText(), "You pressed OK!", "Text không chính xác");
        //Check nut cancel
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//button[normalize-space()='Click me!'])[2]")).click();
        Thread.sleep(100);
        System.out.println(driver.switchTo().alert().getText());
        Assert.assertEquals(driver.switchTo().alert().getText(), "Press a button!", "Text on Alert not make");
        Thread.sleep(200);

        driver.switchTo().alert().dismiss();//Nhấn nút Cancel
        Thread.sleep(100);
        WebElement textConfirm1 = driver.findElement(By.xpath("//p[@id='confirm-demo']"));
        Assert.assertEquals(textConfirm1.getText(), "You pressed Cancel!", "Text không chính xác");

    }

    @Test
    public void testAlert_03() throws InterruptedException {
        driver.get("https://demo.seleniumeasy.com/javascript-alert-box-demo.html");
        Thread.sleep(100);
        //check nut oke
        driver.findElement(By.xpath("//button[normalize-space()='Click for Prompt Box']")).click();
        Thread.sleep(100);
        System.out.println(driver.switchTo().alert().getText());
        Assert.assertEquals(driver.switchTo().alert().getText(), "Please enter your name", "Text on Alert not make");
        Thread.sleep(200);

        //Sendky một giá tr vào ô input
        driver.switchTo().alert().sendKeys("Tien Tester");
        Thread.sleep(100);

        driver.switchTo().alert().accept(); //Nhấn nút OK hoặc Yes
        Thread.sleep(1000);
        WebElement promptdemo = driver.findElement(By.xpath("//p[@id='prompt-demo']"));

        Assert.assertEquals(promptdemo.getText(), "You have entered 'Tien Tester' !", "Data input not make");
//        //Check nut cancel
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("(//button[normalize-space()='Click me!'])[2]")).click();
//        Thread.sleep(100);
//        System.out.println(driver.switchTo().alert().getText());
//        Assert.assertEquals(driver.switchTo().alert().getText(), "Press a button!", "Text on Alert not make");
//        Thread.sleep(200);
//
//        driver.switchTo().alert().dismiss();//Nhấn nút Cancel
//        Thread.sleep(100);
//        WebElement textConfirm1 = driver.findElement(By.xpath("//p[@id='confirm-demo']"));
//        Assert.assertEquals(textConfirm1.getText(), "You pressed Cancel!", "Text không chính xác");

    }

}
