package config;

import dto.CarDto;
import dto.TokenDto;
import dto.UserDto;
import helper.BaseApi;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.given;

public class CarController implements BaseApi {
    public TokenDto tokenDto;

    @BeforeSuite
    public void login(){
        UserDto user = UserDto.builder()
                .username("myphone@gmail.com")
                .password("German1234!")
                .build();
        AuthenticationController authenticationController = new AuthenticationController();
        Response response = authenticationController.requestRegLogin(user, LOGIN);
        if (response.getStatusCode() == 200){
            tokenDto = response.getBody().as(TokenDto.class);
        }else
            System.out.println("Something went wrong "+ response.getStatusCode());
    }
    public Response getUserCars(String token){
        return given()
                .header("Authorization", token)
                .when()
                .get(BASE_URL + GET_USER_CARS)
                .thenReturn();
    }
    public Response addUserCar(CarDto car, String token){
        return given()
                .body(car)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .post(BASE_URL + ADD_NEW_CAR)
                .thenReturn();
    }

}
