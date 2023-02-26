package tientester.Bai20_21_ThucHanhPOMPart_1_2.testcase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tientester.Bai20_21_ThucHanhPOMPart_1_2.pages.CommonPage;
import tientester.Bai20_21_ThucHanhPOMPart_1_2.pages.LoginPage;
import tientester.comon.BaseTestOLD;
import tientester.datatest.ConstantData;

public class LoginTest extends BaseTestOLD {

   public LoginPage loginPage;
   public CommonPage commonPage;

   @BeforeMethod
   public void SiginTest(){
       loginPage = new LoginPage(driver); // Truyền driver từ BaseTesst sang các class Page
        commonPage = new CommonPage(driver);
   }

    @Test (priority = 1)
    public void testLogin(){

//        siginPage = new SiginPage(driver); // Truyền driver từ BaseTesst sang các class Page

        loginPage.logIn(ConstantData.USERNAME,ConstantData.PASSWORD);
        commonPage.Logout();
    }

    @Test (priority = 2)
    public void loginInvalidEmail(){
        loginPage.loginWithUsernameInvalid("joe.larson1","joe.larson");
    }

    @Test (priority = 3)
    public void loginInvalidPassword(){
       loginPage.loginWithPasswordInvalid("joe.larson","joe.larson11");
    }

    @Test (priority = 4)
    public void testForgotPassword(){
//        siginPage = new SiginPage(driver); // Truyền driver từ BaseTesst sang các class Page
        loginPage.resetPassword("cedric.kelly@hrsale.com");

    }



}
