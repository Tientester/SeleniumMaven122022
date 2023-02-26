package tientester.Bai20_21_ThucHanhPOMPart_1_2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import tientester.com.utils.WebUI;

import java.time.Duration;

public class LoginPage extends CommonPage {

    WebDriver driver;

    private WebDriverWait wait;


    //hàm xây dựng
    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        new WebUI(driver);
    }
    //login
    public String pageText = "Welcome to HRSALE";
    private By inputUsername = By.xpath("//input[@id='iusername']");
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
    public DashboardPage logIn(String username, String password){
//        driver.get("https://app.hrsale.com/erp/login");
        WebUI.openURL("https://app.hrsale.com/erp/login");
        WebUI.setText(inputUsername,username);
        WebUI.setText(inputPassword, password);
        WebUI.clickElement(inputButton);
        WebUI.sleep(5);
        //Wait for page loaded
        //xử lý Assert
//        wait.until(ExpectedConditions.presenceOfElementLocated(dashboardPage.menuHome));
        boolean checkMenu = WebUI.checkElementExist(getDashboardPage().menuHome);
        Assert.assertTrue(checkMenu, "Login faild! Không tìm thấy menu Home.");

        return new DashboardPage(driver); //Khởi tạo trang Dashboard
    }

    public void loginWithUsernameInvalid(String username, String password){
//        driver.get("https://app.hrsale.com/erp/login");
        WebUI.openURL("https://app.hrsale.com/erp/login");
        WebUI.setText(inputUsername,username);
        WebUI.setText(inputPassword, password);
        WebUI.clickElement(inputButton);
        boolean checkAlertError = WebUI.checkElementExist(getAlertMessageLogin);
        Assert.assertTrue(checkAlertError, "Fail. Error alert not display.");
        WebUI.verifyEquals(WebUI.getElementText( getAlertMessageLogin), "Invalid Login Credentials.", "Fail text not match.");

    }

    public void loginWithPasswordInvalid(String username, String password){
//        driver.get("https://app.hrsale.com/erp/login");
        WebUI.openURL( "https://app.hrsale.com/erp/login");
        WebUI.setText(inputUsername,username);
        WebUI.setText(inputPassword, password);
        WebUI.clickElement(inputButton);

        boolean checkAlertError = WebUI.checkElementExist(getAlertMessageLogin);
        Assert.assertTrue(checkAlertError, "Fail. Error alert not display.");
        Assert.assertEquals(WebUI.getElementText( getAlertMessageLogin), "Invalid Login Credentials.", "Fail text not match.");

    }

    public void resetPassword(String emailForgotPassword){
        WebUI.openURL( "https://app.hrsale.com/erp/login");
        WebUI.clickElement( linkForgotPassword);
       WebUI.verifyEquals(WebUI.getElementText( pageTextForgotPassword),"Reset your password");
        WebUI.setText( inputEmailForgotPassword, emailForgotPassword);
        WebUI.clickElement( ButtonResetPassword);

        //Assert cái massage hiển thị thành công
       WebUI.verifyEquals(WebUI.getElementText( alertMessageResetPassword), "Main.xin_error_msg__available");

        WebUI.clickElement( linkClickhere);

    }

}
