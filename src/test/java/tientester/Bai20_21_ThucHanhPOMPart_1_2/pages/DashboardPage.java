package tientester.Bai20_21_ThucHanhPOMPart_1_2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import tientester.com.utils.WebUI;

public class DashboardPage extends CommonPage{

    WebDriver driver;



    public DashboardPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        new WebUI(driver);
    }

    public By menuHome = By.xpath("//span[normalize-space()='Home']");


}
