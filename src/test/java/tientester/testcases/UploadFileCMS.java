package tientester.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import tientester.comon.BaseTestOLD;
import tientester.pages.UploadfileCMSPage;

public class UploadFileCMS extends BaseTestOLD {


    @Test
    public void testUploadFileCategoryInCatehoryCMS(){
        UploadfileCMSPage uploadFileCMSPage = new UploadfileCMSPage(driver);
        uploadFileCMSPage.loginCMS();
        uploadFileCMSPage.uploadFileInCategory();
    }
}
