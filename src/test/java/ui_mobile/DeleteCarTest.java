package ui_mobile;

import config.AppiumConfig;
import config.CarController;
import dto.CarsDto;
import dto.UserDto;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.LoginScreen;
import screens.MyCarsScreen;
import screens.SearchScreen;
import screens.SplashScreens;

public class DeleteCarTest extends AppiumConfig {

    SearchScreen searchScreen;
    LoginScreen loginScreen;
    MyCarsScreen myCarsScreen;

    @BeforeMethod
    public void login(){
        new SplashScreens(driver);
        searchScreen = new SearchScreen(driver);
        searchScreen.goToLoginScreen();
        loginScreen = new LoginScreen(driver);
        loginScreen.login(UserDto.builder()
                .username("myphone@gmail.com")
                .password("German1234!")
                .build());
        searchScreen.goToMyCarsScreen();
    }
    @Test
    public void deleteFirstCarPositiveTest(){
        CarController carController = new CarController();
        carController.login();
        Response responseBeforeTest = carController.getUserCars(carController.tokenDto.getAccessToken());
        int quantityCarBeforeDelete = responseBeforeTest.body().as(CarsDto.class).getCars().length;
        myCarsScreen = new MyCarsScreen(driver);
        myCarsScreen.deleteFirstCar();
        Response responseAfterTest = carController.getUserCars(carController.tokenDto.getAccessToken());
        int quantityCarAfterDelete = responseAfterTest.body().as(CarsDto.class).getCars().length;
        System.out.println(quantityCarBeforeDelete+"X"+quantityCarAfterDelete);
        Assert.assertEquals(quantityCarBeforeDelete-1, quantityCarAfterDelete);
    }
}
