package tientester.Bai14JavaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import tientester.comon.BaseTestOLD;

public class LearnJavaScriptExecutor extends BaseTestOLD {
    JavascriptExecutor js; //khai báo

    @Test
    public void jsExecutorDemo01() throws InterruptedException {

        driver.get("https://anhtester.com/");
        Thread.sleep(1000);

        js = (JavascriptExecutor) driver; //Khởi tạo giá trị

        // Click on "Website Testing" module using JavascriptExecutor
        WebElement button = driver.findElement(By.xpath("//h3[normalize-space()='Website Testing']"));
        js.executeScript("arguments[0].click();", button); //Click ngầm
        Thread.sleep(1000);

        // Get page title and Domain using JavascriptExecutor
        String titleText = js.executeScript("return document.title;").toString();
        System.out.println("Page Title is: " + titleText);

        String domainName = js.executeScript("return document.URL;").toString();
        System.out.println("Domain is: " + domainName);

        //cuộn trang theo chiều dọc 100px
        js.executeScript("window.scrollTo(0,1000)");

        // Add Alert window using JavascriptExecutor
        js.executeScript("alert('Successfully Logged In');");

        Thread.sleep(2000);
    }

    @Test
    public void jsExecutorDemo02() throws InterruptedException {

        driver.get("https://anhtester.com/");
        Thread.sleep(1000);

        js = (JavascriptExecutor) driver; //Khởi tạo giá trị

        WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Tất Cả Khóa Học')]"));

        js.executeScript("arguments[0].scrollIntoView(false);", element);// Hàm cuộn chuột này hay
        Thread.sleep(2000);

        js.executeScript("arguments[0].scrollIntoView(true);", element);// Hàm cuộn chuột này hay

//        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");// cuộn chuột đến cuối trang


        Thread.sleep(2000);
//        js.executeScript("window.scrollTo(0,0)");
    }

    @Test
    public void jsExecutorDemo03() throws InterruptedException {

        driver.get("https://anhtester.com/");
        Thread.sleep(1000);

        js = (JavascriptExecutor) driver; //Khởi tạo giá trị

        WebElement element = driver.findElement(By.xpath("(//a[@class='category-content'])[1]"));

        js.executeScript("arguments[0].style.border='3px solid red'", element);

        String innerhtml = js.executeScript("return arguments[0].innerHTML;", element).toString();
        System.out.println(innerhtml);

        String innerText = js.executeScript("return arguments[0].innerText;", element).toString();
        System.out.println(innerText);

        Thread.sleep(2000);

    }

    @Test
    public void jsExecutorDemo04() throws InterruptedException {

        driver.get("https://cms.anhtester.com/");
        Thread.sleep(1000);

        js = (JavascriptExecutor) driver; //Khởi tạo giá trị

        WebElement element = driver.findElement(By.xpath("//div[normalize-space()='Demo category 2']"));
        Thread.sleep(2000);


        js.executeScript("arguments[0].click();", element);

        Thread.sleep(2000);

    }
}
