package tientester.Bai13AlertPopupIframe;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import tientester.comon.BaseTestOLD;

import java.util.ArrayList;
import java.util.Set;

public class LearnPopupWindow extends BaseTestOLD {

    @Test
    public void TestPoup01() throws InterruptedException {
        driver.get("https://demo.guru99.com/popup.php");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("emailid")).sendKeys("abc@gmail.com");
        driver.findElement(By.name("btnLogin")).click();

        Thread.sleep(2000);
    }

    @Test
    public void TestPoup02() throws InterruptedException {
        driver.get("https://demo.guru99.com/popup.php");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();
        Thread.sleep(1000);

        //Switch to new tab
        //1. Lưu lại mã định danh tab đầu tiên
        String mainWindow = driver.getWindowHandle();
        //2.Lấy ra tất cả các Tab hiện tại
        Set<String> windows = driver.getWindowHandles();
//        ArrayList<String> tabs = new ArrayList (driver.getWindowHandles());
//
//        System.out.println(tabs.get(0));
//
//        System.out.println(tabs.get(1)); //Lấy tab thứ 2( bì ArrayList bắt đầu từ 0)
//        driver.switchTo().window(tabs.get(1));
//        Thread.sleep(1000);
//        driver.findElement(By.name("emailid")).sendKeys("abc@gmail.com");
//        driver.findElement(By.name("btnLogin")).click();


       // 3.Duyệt SET trên với For để kiểm tra từng Tab
//        for (String window : windows) {
//            System.out.println(window);
//            if (!mainWindow.equals(window)) {
//                //So sánh nếu thằng nào khác thằng Chính (đầu tiên) thì chuyển hướng qua nó mới thao tác được
//                //Switch to new tab window
//                driver.switchTo().window(window);
//                Thread.sleep(2000);
//                //Get title của tab
//                System.out.println(driver.switchTo().window(window).getTitle());
//                if (driver.switchTo().window(window).getTitle().equals("Guru99 Bank Home Page")){
//                    Thread.sleep(1000);
//                    driver.findElement(By.name("emailid")).sendKeys("abc@gmail.com");
//                    driver.findElement(By.name("btnLogin")).click();
//                }
//                System.out.println("Đã chuyển đến new tab Window" + window);
//            }
//        }

        // 3.Duyệt SET trên với For để kiểm tra từng Tab và chuyển hướng theo Title của Tab
//        for (String window : windows){
//            System.out.println(window);
//            Thread.sleep(2000);
//            //Get title của tab
//            System.out.println(driver.switchTo().window(window).getTitle());
//            //So sánh title của từng tab
//            if (driver.switchTo().window(window).getTitle().equals("Guru Bank Home Page")){
//                //switch to đến chính cái tab có title như ý muốn
//                driver.switchTo().window(window);
//                System.out.println("Đã chuyển đến new tab window: " +window);
//
//                //code auto
//                Thread.sleep(1000);
////                    driver.findElement(By.name("emailid")).sendKeys("abc@gmail.com");
////                    driver.findElement(By.name("btnLogin")).click();
//            }
//        }

        //4. Cách chuyển hướng theo vị trí
        ArrayList<String> tabs = new ArrayList (driver.getWindowHandles());

        System.out.println(tabs.get(0));

        System.out.println(tabs.get(1)); //Lấy tab thứ 2( bì ArrayList bắt đầu từ 0)
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(1000);
        driver.findElement(By.name("emailid")).sendKeys("abc@gmail.com");
        driver.findElement(By.name("btnLogin")).click();
        driver.switchTo().window(mainWindow); //chuyển hướng về tab đầu



        Thread.sleep(2000);
    }

}
