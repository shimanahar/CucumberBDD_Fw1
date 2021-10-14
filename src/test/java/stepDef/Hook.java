package stepDef;

import base.Setup;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook extends Setup {

    public static String env = System.getProperty("env");
    public static String driverType = System.getProperty("browser");
    public static String url;
    // qa.taltektc.com
    // stage.taltektc.com
    // prod.taltektc.com
    // if/else or switch state

    @Before
    public void startTest(){
        // happen before each test scenario
    }

    @After
    public void endTest(){
        // happen after each test
        // what happen if test fails? what you will do for the  failing test case? screenshot? logs? ??
    }

}
