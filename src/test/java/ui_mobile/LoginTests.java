package ui_mobile;

import config.AppiumConfig;
import dto.UserDto;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.LoginScreen;
import screens.SearchScreen;
import screens.SplashScreens;

public class LoginTests extends AppiumConfig {

    LoginScreen loginScreen;

    @BeforeMethod
    public void beforeLogin(){
        new SplashScreens(driver);
        new SearchScreen(driver).goToLoginScreen();
    }

    @Test
    public void loginPositiveTest(){
        loginScreen = new LoginScreen(driver);
        loginScreen.login(UserDto.builder()
                .username("myphone@gmail.com")
                .password("German1234!")
                .build());
    }

}
