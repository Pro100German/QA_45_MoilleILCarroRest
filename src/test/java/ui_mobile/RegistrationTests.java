package ui_mobile;

import config.AppiumConfig;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.SearchScreen;
import screens.SplashScreens;

public class RegistrationTests extends AppiumConfig {
    @BeforeMethod
    public void beforeTest(){
        new SplashScreens(driver);
        new SearchScreen(driver).goToRegistrationScreen();
    }
    @Test
    public void registrationPositiveTest(){

    }
}
