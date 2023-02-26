package tientester.Bai24ParameterMultiBrowser;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParameter {

    @Test
    @Parameters({"Number1", "Number2","Message"})
    public void SumNumber(@Optional("12") int a, int b, String message) {
        System.out.println(message +": " + (a + b));
    }

}
