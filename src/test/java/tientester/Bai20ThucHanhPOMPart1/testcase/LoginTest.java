package tientester.Bai20ThucHanhPOMPart1.testcase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tientester.Bai20ThucHanhPOMPart1.pages.LoginPage;
import tientester.comon.BaseTestOLD;

public class LoginTest extends BaseTestOLD {

   public LoginPage loginPage;

   @BeforeMethod
   public void SiginTest(){
       loginPage = new LoginPage(driver); // Truyền driver từ BaseTesst sang các class Page

   }

    @Test (priority = 1)
    public void testLogin(){

//        siginPage = new SiginPage(driver); // Truyền driver từ BaseTesst sang các class Page

        loginPage.logIn("frances.burns","frances.burns");
    }

    @Test
    public void loginInvalidEmail(){
        loginPage.logInInvalidEmail("frances.burns1","frances.burns");
    }

    @Test
    public void loginInvalidPassword(){
       loginPage.logInInvalidPassword("frances.burns","frances.burn");
    }

    @Test (priority = 2)
    public void testForgotPassword(){
//        siginPage = new SiginPage(driver); // Truyền driver từ BaseTesst sang các class Page
        loginPage.resetPassword("cedric.kelly@hrsale.com");

    }

}
