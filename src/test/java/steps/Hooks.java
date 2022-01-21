package steps;

import Utils.CommonMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends CommonMethods {


    @Before
    public void start(){
        openBrowserAndLaunchApplication();
    }
    @After
    public void end(){
        closeBrowser();
    }
}
