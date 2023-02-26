package tientester.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import tientester.com.utils.WebUI;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class UploadfileCMSPage {

    WebDriver driver;

    private WebDriverWait wait;

    public UploadfileCMSPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        new WebUI(driver);
    }

    //Login
    private By buttonCopy = By.xpath("//button[normalize-space()='Copy']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");

    //Category
    private By menuProducts = By.xpath("//span[normalize-space()='Products']");
    private By menuCategory = By.xpath("//span[normalize-space()='Category']");
    private By butttonAddNewCategory = By.xpath("//span[normalize-space()='Add New category']");
    private By chooseFile = By.xpath("//label[normalize-space()='Banner (200x200)']/following-sibling::div//div[normalize-space()='Choose File']");
    private By buttonUploadNew = By.xpath("//a[normalize-space()='Upload New']");
    private By buttonBrowse = By.xpath("//button[normalize-space()='Browse']");
    private By buttonAddFiles = By.xpath("//button[normalize-space()='Add Files']");
    private By messageComplete = By.xpath("//div[@class='uppy-StatusBar-statusPrimary']");

    private By buttonSelectFile = By.xpath("//a[normalize-space()='Select File']");
    private By inputSearchFile = By.xpath("//input[@placeholder='Search your files']");
    private By itemFile = By.xpath("(//div[@class='card-body']//h6)[1]");

    public void loginCMS(){
        WebUI.openURL( "https://cms.anhtester.com/login" );
        WebUI.clickElement(buttonCopy);
        WebUI.clickElement(buttonLogin);

    }

    public void uploadFileInCategory(){
        WebUI.clickElement(menuProducts);
        WebUI.clickElement(menuCategory);
        WebUI.clickElement(butttonAddNewCategory);
        WebUI.clickElement(chooseFile);
        WebUI.clickElement(buttonUploadNew);
        WebUI.clickElement(buttonBrowse);

        // Khởi tạo Robot class
        Robot rb = null;
        try {
            rb = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        // Copy File path vào Clipboard
        StringSelection str = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

        WebUI.sleep(1);

        // Nhấn Control+V để dán
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);

        // Xác nhận Control V trên
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);

        WebUI.sleep(2);

        // Nhấn Enter
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);

        WebUI.sleep(3);
        WebUI.clickElement(buttonSelectFile);

    }
}
