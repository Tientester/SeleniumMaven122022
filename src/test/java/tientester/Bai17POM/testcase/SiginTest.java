package tientester.Bai17POM.testcase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tientester.Bai17POM.pages.SiginPage;
import tientester.comon.BaseTestOLD;

public class SiginTest extends BaseTestOLD {

   public SiginPage siginPage;

   @BeforeMethod
   public void SiginTest(){
       siginPage = new SiginPage(driver); // Truyền driver từ BaseTesst sang các class Page

   }

    @Test
    public void testSigin(){

//        siginPage = new SiginPage(driver); // Truyền driver từ BaseTesst sang các class Page

        siginPage.signIn("frances.burns","frances.burns");
    }

    @Test
    public void testSigin1(){
//        siginPage = new SiginPage(driver); // Truyền driver từ BaseTesst sang các class Page

        siginPage.signIn01("joe.larson","joe.larson");
    }

    @Test
    public void testSigin2(){
//        siginPage = new SiginPage(driver); // Truyền driver từ BaseTesst sang các class Page

        siginPage.signIn("cedric.kelly","cedric.kelly");
    }
}
