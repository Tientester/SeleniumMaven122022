package tientester.Bai20ThucHanhPOMPart1.testcase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tientester.Bai20ThucHanhPOMPart1.pages.DashboardPage;
import tientester.Bai20ThucHanhPOMPart1.pages.LoginPage;
import tientester.comon.BaseTestOLD;

public class DashboardTest extends BaseTestOLD {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    @BeforeMethod
    public void setUp(){
        loginPage = new LoginPage(driver);
    }
    @Test
    public void testLoguot(){
       dashboardPage = loginPage.logIn("frances.burns","frances.burns");
       dashboardPage.logOut();
    }
}
