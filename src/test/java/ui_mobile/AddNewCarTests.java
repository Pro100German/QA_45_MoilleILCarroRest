package ui_mobile;

import config.AppiumConfig;
import dto.CarDto;
import dto.UserDto;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.*;

import static helper.RandomUtils.*;

public class AddNewCarTests extends AppiumConfig {

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
    public void addNewCarPositiveTest(){
        CarDto car = CarDto.builder()
                .serialNumber("num-"+generateNamber(6))
                .manufacture("ZAZ")
                .model("969")
                .city("Haifa")
                .pricePerDay(333.33)
                .carClass("Hi")
                .fuel("Gas")
                .year("1975")
                .seats(4)
                .about("best of the best")
                .build();
        myCarsScreen = new MyCarsScreen(driver);
        myCarsScreen.goToAddNewCarScreen();
        new AddNewCarScreen(driver).addNewCar(car);
        Assert.assertTrue(myCarsScreen.validateMassageSuccess("Car was added"));
    }

    @Test
    public void addNewCarLisPositiveTest(){
        CarDto car = CarDto.builder()
                .serialNumber("num-"+generateNamber(6))
                .manufacture("ZAZ")
                .model("969")
                .city("Haifa")
                .pricePerDay(333.33)
                .carClass("Hi")
                .fuel("Gas")
                .year("1975")
                .seats(4)
                .about("best of the best")
                .build();
        myCarsScreen = new MyCarsScreen(driver);
        myCarsScreen.goToAddNewCarScreen();
        new AddNewCarScreen(driver).addNewCar(car);
        myCarsScreen.scrollToLastElementCar();
        Assert.assertEquals(myCarsScreen.scrollToLastElementCar(), car.getSerialNumber());
    }
    @Test
    public void addNewCarNegativeTestWrongCity(){
        CarDto car = CarDto.builder()
                .serialNumber("num-"+generateNamber(6))
                .manufacture("ZAZ")
                .model("969")
                .city("")
                .pricePerDay(333.33)
                .carClass("Hi")
                .fuel("Gas")
                .year("1975")
                .seats(4)
                .about("best of the best")
                .build();
        myCarsScreen = new MyCarsScreen(driver);
        myCarsScreen.goToAddNewCarScreen();
        new AddNewCarScreen(driver).addNewCar(car);
        Assert.assertTrue(new AddNewCarScreen(driver).validateMassageSuccess("Fields: Serial number, Manufacture, Model, City, Price per day is required!"));
    }

}
