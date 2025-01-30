package ui_mobile;

import config.AppiumConfig;
import dto.UserDto;
import org.testng.Assert;
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
        Assert.assertTrue(new SearchScreen(driver).validateMassageSuccess("Login success"));
    }
    @Test
    public void loginNegativeTestWrongEmailSpase(){
        loginScreen = new LoginScreen(driver);
        loginScreen.login(UserDto.builder()
                .username(" ")
                .password("German1234!")
                .build());
        Assert.assertTrue(loginScreen.validateMassageSuccess("All fields must be filled and agree terms"));
    }
    @Test
    public void loginNegativeTestWrongPasswordIncorrect(){
        loginScreen = new LoginScreen(driver);
        loginScreen.login(UserDto.builder()
                .username("myphone@gmail.com")
                .password("German1234@")
                .build());
        Assert.assertTrue(loginScreen.validateMassagePasswordIncorrect("Login or Password incorrect"));
    }


}
