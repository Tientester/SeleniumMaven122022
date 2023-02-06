package tientester.Bai19PageNavigatetion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import tientester.com.utils.WebUI;
import tientester.comon.BaseTestOLD;

public class LoginPage  {

    WebDriver driver;
    //hàm xây dựng
    public LoginPage(WebDriver driver){
        this.driver = driver;
        new WebUI(driver);
    }
    //login
    public String pageText = "Welcome to HRSALE";
    private By inputEmail = By.xpath("//input[@id='iusername']");
    private By inputPassword = By.xpath("//input[@id='ipassword']");
    private By inputButton = By.xpath("//button[@type='submit']");
    //Forgot password
    private By linkForgotPassword = By.xpath("//a[normalize-space()='Forgot password?']");

    private By pageTextForgotPassword = By.xpath("//h4[normalize-space()='Reset your password']");

    private By inputEmailForgotPassword = By.xpath("//input[@placeholder='Email address']");

    private By ButtonResetPassword = By.xpath("//button[@type='submit']");

    private By linkClickhere = By.xpath("//a[normalize-space()='Click here']");

    private By alertMessageResetPassword = By.xpath("//div[@class='toast-message']");

    private By getAlertMessageLogin = By.xpath("//div[@class='toast-message']");
    public DashboardPage logIn(String email, String password){
//        driver.get("https://app.hrsale.com/erp/login");
        WebUI.openURL("https://app.hrsale.com/erp/login");
        WebUI.setText( inputEmail,email);
        WebUI.setText(inputPassword, password);
        WebUI.clickElement(inputButton);
        return new  DashboardPage(driver); //Khởi tạo trang Dashboard
    }

    public void logInInvalidEmail(String email, String password){
//        driver.get("https://app.hrsale.com/erp/login");
        WebUI.openURL("https://app.hrsale.com/erp/login");
        WebUI.setText(inputEmail,email);
        WebUI.setText(inputPassword, password);
        WebUI.clickElement(inputButton);
        Assert.assertEquals(WebUI.getElementText( getAlertMessageLogin), "Invalid Login Credentials.");

    }

    public void logInInvalidPassword(String email, String password){
//        driver.get("https://app.hrsale.com/erp/login");
        WebUI.openURL( "https://app.hrsale.com/erp/login");
        WebUI.setText(inputEmail,email);
        WebUI.setText(inputPassword, password);
        WebUI.clickElement(inputButton);
        Assert.assertEquals(WebUI.getElementText( getAlertMessageLogin), "Invalid Login Credentials.");
    }

    public void resetPassword(String emailForgotPassword){
        WebUI.openURL( "https://app.hrsale.com/erp/login");
        WebUI.clickElement( linkForgotPassword);
        Assert.assertEquals(WebUI.getElementText( pageTextForgotPassword),"Reset your password");
        WebUI.setText( inputEmailForgotPassword, emailForgotPassword);
        WebUI.clickElement( ButtonResetPassword);

        //Assert cái massage hiển thị thành công
        Assert.assertEquals(WebUI.getElementText( alertMessageResetPassword), "Main.xin_error_msg__available");

        WebUI.clickElement( linkClickhere);

    }

}
