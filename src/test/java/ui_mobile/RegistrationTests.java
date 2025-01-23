package ui_mobile;

import config.AppiumConfig;
import dto.UserDto;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.RegistrationScreen;
import screens.SearchScreen;
import screens.SplashScreens;

import java.util.Random;

public class RegistrationTests extends AppiumConfig {

    RegistrationScreen registrationScreen;

    @BeforeMethod
    public void beforeTest(){
        new SplashScreens(driver);
        new SearchScreen(driver).goToRegistrationScreen();
    }
    @Test
    public void registrationPositiveTest(){
        int i  = new Random().nextInt(1000)+1000;
        UserDto userDto = UserDto.builder()
                .firstName("Ger")
                .lastName("Kogan")
                .username("novigod"+i+"@mail.com")
                .password("Novigod123!")
                .build();
        registrationScreen = new RegistrationScreen(driver);
        registrationScreen.typeRegistrationForm(userDto);

    }
}
