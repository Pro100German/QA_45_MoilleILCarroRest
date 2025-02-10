package api_rest;

import config.AuthenticationController;
import dto.UserDto;
import helper.BaseApi;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Random;

import static helper.RandomUtils.*;

public class ApiRegistrationTest extends AuthenticationController implements BaseApi {

    @Test
    public void registrationPositiveTest(){
        int i = new Random().nextInt(1000) + 1000;
        UserDto user = UserDto.builder()
                .firstName(generateString(10))
                .lastName(generateString(10))
                .username("okhttp" + "mail.com")
                .password("German123456!")
                .build();
        Response response = requestRegLogin(user, REGISTRATION);
        System.out.println(requestRegLogin(user,REGISTRATION).getStatusCode());
    }
}
