package tientester.Bai20_21_ThucHanhPOMPart_1_2.testcase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tientester.Bai20_21_ThucHanhPOMPart_1_2.pages.DashboardPage;
import tientester.Bai20_21_ThucHanhPOMPart_1_2.pages.LoginPage;
import tientester.comon.BaseTestOLD;

public class DashboardTest extends BaseTestOLD {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    @BeforeMethod
    public void setUp(){
        loginPage = new LoginPage(driver);
    }

    @Test(priority = 1)
    public void testOpenProjectPage(){
        dashboardPage = loginPage.logIn("joe.larson","joe.larson");
        dashboardPage.openProject();
    }
    @Test(priority = 2)
   public void testNavigatetoProject(){
        dashboardPage = loginPage.logIn("joe.larson","joe.larson");
        dashboardPage.openProject();
    }
}
