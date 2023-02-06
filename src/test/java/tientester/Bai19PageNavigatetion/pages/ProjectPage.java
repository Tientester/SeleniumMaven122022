package tientester.Bai19PageNavigatetion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import tientester.com.utils.WebUI;

public class ProjectPage {

    WebDriver driver;
    public ProjectPage( WebDriver driver){
      this.driver = driver;
      new WebUI(driver);
    }

    By butonAddProject = By.xpath("//a[normalize-space()='Add Project']");
    By  inputTitle = By.xpath("//input[@placeholder='Title']");

    By dropDownCustommer = By.xpath("//span[@id='select2-client_id-container']");
    By inputCustommer = By.xpath("//span[@class='select2-search select2-search--dropdown']//input[@role='searchbox']");

    By inputNote = By.id("summary");

    By buttonSave = By.xpath("//span[normalize-space()='Save']");
    public void clickButtonAdd(){
        WebUI.clickElement(butonAddProject);

    }

    public void enterData(){
        WebUI.setText(inputTitle, "Project Tien");
        WebUI.clickElement(dropDownCustommer);
        WebUI.setText(inputCustommer,"Cedric Kelly");
        driver.findElement(inputCustommer).sendKeys(Keys.ENTER);

        WebUI.sleep(1);

        driver.findElement(By.xpath("//label[@for='start_date']/following-sibling::div")).click();

        driver.findElement(By.xpath("//a[normalize-space()='21']")).click();

        driver.findElement(By.xpath("(//button[normalize-space()='OK'])[1]")).click();

        WebUI.sleep(1);

        driver.findElement(By.xpath("//label[@for='end_date']/following-sibling::div")).click();

        driver.findElement(By.xpath("(//a[normalize-space()='25'])[2]")).click();

        driver.findElement(By.xpath("(//button[normalize-space()='OK'])[2]")).click();

        WebUI.setText(inputNote, "note");

        WebUI.clickElement(buttonSave);
    }
    public void addProject(){
        clickButtonAdd();
        enterData();
    }


}
