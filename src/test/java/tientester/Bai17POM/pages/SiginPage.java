package tientester.Bai17POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tientester.com.utils.ObjectRepository;
import tientester.com.utils.WebUI;

public class SiginPage {

    WebDriver driver;
    //hàm xây dựng
    public SiginPage(WebDriver driver){
        this.driver = driver;
    }

    public String pageText = "Welcome to HRSALE";
    private By inputEmail = By.xpath("//input[@id='iusername']");
    private By inputPassword = By.xpath("//input[@id='ipassword']");
    private By inputButton = By.xpath("//button[@type='submit']");

    public void  signIn(String email, String password){
        driver.get("https://app.hrsale.com/erp/login");
        driver.findElement(inputEmail).sendKeys(email);
        driver.findElement(inputPassword).sendKeys(password);
        driver.findElement(inputButton).click();
    }
    public void  signIn01(String email, String password){
        driver.get("https://app.hrsale.com/erp/login");
        driver.findElement(inputEmail).sendKeys(email);
        driver.findElement(inputPassword).sendKeys(password);
        driver.findElement(inputButton).click();
        WebUI.sleep(6);

    }


}
