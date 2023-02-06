package tientester.Bai18PageFactory.testcase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tientester.Bai18PageFactory.pages.DashBoardPage;
import tientester.Bai18PageFactory.pages.LoginPageFactory;
import tientester.com.utils.WebUI;
import tientester.comon.BaseTestOLD;

public class LoginTestFactory extends BaseTestOLD {

    private LoginPageFactory loginPageFactory;
    private DashBoardPage dashBoardPage;

    @BeforeMethod
    public void setUp(){
        loginPageFactory = new LoginPageFactory(driver);
        dashBoardPage = new DashBoardPage(driver);
    }
    @Test
    public void testLoginFactory(){
        loginPageFactory.login("frances.burns", "frances.burns");
        WebUI.sleep(6);
        dashBoardPage.clickLogout();

    }

}
