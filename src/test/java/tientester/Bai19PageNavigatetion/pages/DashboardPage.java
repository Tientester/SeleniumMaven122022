package tientester.Bai19PageNavigatetion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tientester.com.utils.WebUI;
import tientester.comon.BaseTestOLD;

public class DashboardPage{

    WebDriver driver;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
        new WebUI(driver);
    }

    private By menuProject = By.xpath("//span[normalize-space()='Projects']");
    private By menuTask = By.xpath("//span[normalize-space()='Tasks']");

    private By buttonLogout = By.xpath("//a[@class='btn btn-smb btn-outline-primary rounded-pill']");


    public ProjectPage openProject(){
        WebUI.clickElement(menuProject);

        return new ProjectPage(driver);
    }

    public void openTask(){
        WebUI.clickElement(menuTask);
    }

    public void logOut(){
        WebUI.clickElement(buttonLogout);


    }
}
