package tientester.Bai20_21_ThucHanhPOMPart_1_2.testcase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tientester.Bai20_21_ThucHanhPOMPart_1_2.pages.DashboardPage;
import tientester.Bai20_21_ThucHanhPOMPart_1_2.pages.LoginPage;
import tientester.Bai20_21_ThucHanhPOMPart_1_2.pages.ProjectPage;
import tientester.comon.BaseTestOLD;
import tientester.datatest.ConstantData;

public class ProjectTest extends BaseTestOLD {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    private ProjectPage projectPage;

    @BeforeMethod
    public void setUp(){
        //lúc nào cũng sẽ khởi tạo trước
        // vì nó là hành động đầu tiên
        loginPage = new LoginPage(driver);
    }
    @Test
    public void testOpenProject(){
        //Login
        //Nhấn menuProject tại trang DashBoard

        //Tạo sự liên kết trang thông qua gán dấu = từ đối tượng trang = hàm đã liên kết
        //Không cần khởi tạo trang từ đầu (dashboardPage = new DashboardPage(driver);)
        //Dashboard sẽ được khởi tạo luôn khi login thành công
        dashboardPage = loginPage.logIn("frances.burns","frances.burns"); // dashboardPage = new DashboardPage(driver);
        dashboardPage.openProject();
    }

    @Test
    public void testAddProject(){
        dashboardPage = loginPage.logIn(ConstantData.USERNAME,ConstantData.PASSWORD);
        projectPage = dashboardPage.openProject();
        projectPage.addProject(ConstantData.PROJECTNAME);
    }
    @Test(priority = 2)
    public void testNavigatetoTask(){
        dashboardPage = loginPage.logIn(ConstantData.USERNAME,ConstantData.PASSWORD);
        projectPage = dashboardPage.openProject();
        projectPage.openTask();
    }
}
