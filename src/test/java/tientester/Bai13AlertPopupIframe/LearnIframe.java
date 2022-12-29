package tientester.Bai13AlertPopupIframe;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import tientester.comon.BaseTestOLD;

public class LearnIframe extends BaseTestOLD {

    @Test
    public void handleIFrame01() throws InterruptedException {

        driver.navigate().to("https://anhtester.com/contact");
        Thread.sleep(10000);

        //1. Lấy ra tất cả các thẻ iframe tồn tại trong trang
        System.out.println("iframe total: " + driver.findElements(By.tagName("iframe")).size());
        Thread.sleep(1000);

        //2. Chuyển hướng theo vị trí của Iframe
        //----Switch to content of Messenger--------
        driver.switchTo().frame(0); // đến iframe đầu tiên(vì bắt đầu là 0)
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.tagName("strong")).getText());


        //----Switch to icon of Messenger---------

        //3. Switch to lớp đầu không phải iframe
        driver.switchTo().parentFrame();
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.xpath("//h1[normalize-space()='Contact Anh Tester']")).getText());

        System.out.println("iframe total: " + driver.findElements(By.tagName("iframe")).size());

        // Switch to iframe icon of Messenger
        driver.switchTo().frame(1); // chuyển hướng đến iframe thứ 2
        driver.findElement(By.tagName("svg")).click(); //Nhấn icon để ẩn messenger chat đi

        Thread.sleep(2000);
    }
}
