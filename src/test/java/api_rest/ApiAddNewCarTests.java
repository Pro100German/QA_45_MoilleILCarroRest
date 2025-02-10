package api_rest;

import config.CarController;
import dto.CarDto;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static helper.RandomUtils.generateNamber;

public class ApiAddNewCarTests extends CarController {

    @Test
    public void addNewCarPositiveTest(){
        CarDto car = CarDto.builder()
                .serialNumber("num-"+generateNamber(10))
                .manufacture("Volvo")
                .model("100")
                .city("Haifa")
                .pricePerDay(1000.10)
                .carClass("C")
                .fuel("Gas")
                .year("1999")
                .seats(5)
                .about("best of the best car volvo")
                .build();
        login();
        Response response = addUserCar(car, tokenDto.getAccessToken());
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}