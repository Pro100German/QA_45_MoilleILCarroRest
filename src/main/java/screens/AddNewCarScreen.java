package screens;

import dto.CarDto;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddNewCarScreen extends BaseScreen {
    public AddNewCarScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(id = "com.telran.ilcarro:id/editSerial")
    AndroidElement inputSerialNumber;
    @FindBy(id = "com.telran.ilcarro:id/editMan")
    AndroidElement inputManufacture;
    @FindBy(id = "com.telran.ilcarro:id/editModel")
    AndroidElement inputModel;
    @FindBy(id = "com.telran.ilcarro:id/editCity")
    AndroidElement inputCity;
    @FindBy(id = "com.telran.ilcarro:id/editPrice")
    AndroidElement inputPrice;
    @FindBy(id = "com.telran.ilcarro:id/editCarClass")
    AndroidElement inputCarClass;
    @FindBy(id = "com.telran.ilcarro:id/text1")
    AndroidElement inputFuel;
    @FindBy(id = "com.telran.ilcarro:id/editYear")
    AndroidElement inputYear;
    @FindBy(id = "com.telran.ilcarro:id/editSeats")
    AndroidElement inputSeats;
    @FindBy(id = "com.telran.ilcarro:id/editAbout")
    AndroidElement inputAbout;
    @FindBy(id = "com.telran.ilcarro:id/addCarBtn")
    AndroidElement btnAddCar;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView\n")
    AndroidElement popUpMessageError;

    public void addNewCar(CarDto car) {
        inputSerialNumber.sendKeys(car.getSerialNumber());
        inputManufacture.sendKeys(car.getManufacture());
        inputModel.sendKeys(car.getModel());
        inputCity.sendKeys(car.getCity());
        inputPrice.sendKeys(Double.toString(car.getPricePerDay()));
        //scroll
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();
        System.out.println(height + "X" +width);
        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(5, height / 6 * 5))
                .moveTo(PointOption.point(5, height / 6))
                .release().perform();


        inputCarClass.sendKeys(car.getCarClass());
        //===============================
        //inputFuel.sendKeys(car.getFuel());
        typeFuel(car.getFuel());

        inputYear.sendKeys(car.getYear());
        inputSeats.sendKeys(car.getSeats() + "");
        inputAbout.sendKeys(car.getAbout());
        btnAddCar.click();
    }

    private void typeFuel(String fuel) {
        inputFuel.click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable
                        (By.xpath("//*[@text='"+fuel+"']"))).click();
        //     "//*[@text='"+  fuel +"']"

    }
    public boolean validateMassageSuccess(String message) {
        return textInElementPresent(popUpMessageError, message, 5);
    }
}