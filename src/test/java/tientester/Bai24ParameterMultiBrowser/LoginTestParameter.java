package tientester.Bai24ParameterMultiBrowser;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tientester.Bai20_21_ThucHanhPOMPart_1_2.pages.CommonPage;
import tientester.Bai20_21_ThucHanhPOMPart_1_2.pages.LoginPage;
import tientester.comon.BaseTestOLD;
import tientester.datatest.ConstantData;

public class LoginTestParameter extends BaseTestOLD {

   public LoginPage loginPage;
   public CommonPage commonPage;

   @BeforeMethod
   public void SiginTest(){
       loginPage = new LoginPage(driver); // Truyền driver từ BaseTesst sang các class Page
        commonPage = new CommonPage(driver);
   }

    @Test (priority = 1)
    @Parameters({"username", "password"})
    public void testLogin(String userName, String password){

//        siginPage = new SiginPage(driver); // Truyền driver từ BaseTesst sang các class Page

        loginPage.logIn(userName,password);
        commonPage.Logout();
    }

    @Test (priority = 2)
    @Parameters({"username", "password"})
    public void loginInvalidEmail(String userName, String password){
        loginPage.loginWithUsernameInvalid(userName,password);
    }

}
