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
import static helper.RandomUtils.*;

public class RegistrationTests extends AppiumConfig {

    RegistrationScreen registrationScreen;

    @BeforeMethod
    public void beforeTest() {
        new SplashScreens(driver);
        new SearchScreen(driver).goToRegistrationScreen();
    }

    @Test
    public void registrationPositiveTest() {
        int i = new Random().nextInt(1000) + 1000;
        UserDto userDto = UserDto.builder()
                .firstName(generateString(5))
                .lastName(generateString(10))
                .username("novigod" + i + "@mail.com")
                .password("Novigod123!")
                .build();
        registrationScreen = new RegistrationScreen(driver);
        registrationScreen.typeRegistrationForm(userDto);
        Assert.assertTrue(registrationScreen.validateMassageSuccess("Registration success!"));

    }

    @Test
    public void registrationNegativeTestWrongEmail() {
        int i = new Random().nextInt(1000) + 1000;
        UserDto userDto = UserDto.builder()
                .firstName(generateString(5))
                .lastName(generateString(10))
                .username("novigod" + i + "mail.com")
                .password("Novigod123!")
                .build();
        registrationScreen = new RegistrationScreen(driver);
        registrationScreen.typeRegistrationForm(userDto);
        Assert.assertTrue(registrationScreen.validateMassageErrorEmail("{username=must be a well-formed email address}"));
    }
    @Test
    public void registrationNegativeTestWrongPassword() {
        int i = new Random().nextInt(1000) + 1000;
        UserDto userDto = UserDto.builder()
                .firstName(generateString(5))
                .lastName(generateString(10))
                .username("novigod" + i + "mail.com")
                .password("novigod123!")
                .build();
        registrationScreen = new RegistrationScreen(driver);
        registrationScreen.typeRegistrationForm(userDto);
        Assert.assertTrue(registrationScreen.validateMassageErrorEmail("{password= At least 8 characters; Must contain at least 1 uppercase letter, 1 lowercase letter, and 1 number; Can contain special characters [@$#^&*!], username=must be a well-formed email address}"));
    }

}
