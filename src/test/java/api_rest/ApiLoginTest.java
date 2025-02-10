package api_rest;

import config.AuthenticationController;
import dto.ErrorMassegeDto;
import dto.UserDto;
import helper.BaseApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiLoginTest extends AuthenticationController implements BaseApi {

    @Test
    public void loginPositiveTest(){
        UserDto user = UserDto.builder()
                .username("myphone@gmail.com")
                .password("German1234!")
                .build();
        Response response = requestRegLogin(user, LOGIN);
        System.out.println(requestRegLogin(user,LOGIN).getStatusCode());
        Assert.assertEquals(response.getStatusCode(),200);

    }
    @Test
    public void loginNegativeTestWrong(){
        UserDto user = UserDto.builder()
                .username("myphone@gmail")
                .password("German1234!")
                .build();
        Response response = requestRegLogin(user, LOGIN);
        System.out.println(requestRegLogin(user,LOGIN).getStatusCode());
        ErrorMassegeDto errorMassegeDto = response.getBody().as(ErrorMassegeDto.class);
        System.out.println(errorMassegeDto.toString());
        Assert.assertTrue(errorMassegeDto.getMessage().toString().equals("Login or Password incorrect"));

    }

}
