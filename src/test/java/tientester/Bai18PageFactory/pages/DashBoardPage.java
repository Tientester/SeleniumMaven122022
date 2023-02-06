package tientester.Bai18PageFactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {
    WebDriver driver;

    @FindBy(xpath = "(//a[normalize-space()='Logout'])[2]")
    private WebElement buttonLogout;

    public DashBoardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, LoginPageFactory.class);
    }

    public void clickLogout(){
        buttonLogout.click();
    }
}
