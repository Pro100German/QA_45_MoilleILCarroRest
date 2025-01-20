package ui_mobile;

import config.AppiumConfig;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.SearchScreen;
import screens.SplashScreens;

public class SplashTests extends AppiumConfig {

    @Test
    public void validateVersionApp(){
        Assert.assertTrue(new SplashScreens(driver).validateVersion("Version 1.0.0"));
    }
}
