package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

public class SearchScreen extends BaseScreen{
    public SearchScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }
    @FindBy(xpath = "//android.widget.ImageView[@content-desc='More options']")
    AndroidElement btnMoreOptions;
    @FindBy(xpath = "//*[@text='Registration']")
    AndroidElement btnRegistration;
    @FindBy(xpath = "//*[@text='Login']")
    AndroidElement btnLogin;
    @FindBy(xpath = "//*[@text='My Cars']")
    AndroidElement btnMyCars;
    @FindBy(id = "com.telran.ilcarro:id/editLocation")
    AndroidElement inputLocation;
    @FindBy(id = "com.telran.ilcarro:id/editFrom")
    AndroidElement inputFrom;
    @FindBy(id = "com.telran.ilcarro:id/editTo")
    AndroidElement inputTo;
    @FindBy(id = "id\tandroid:id/button1")
    AndroidElement btnOk;
    @FindBy(id = "com.telran.ilcarro:id/searchBtn")
    AndroidElement btnYalla;

    public void goToRegistrationScreen(){
        clickWait(btnMoreOptions, 5);
        clickWait(btnRegistration, 5);
    }
    public void goToMyCarsScreen(){
        clickWait(btnMoreOptions, 5);
        clickWait(btnMyCars, 5);
    }

    public void goToLoginScreen() {
        clickWait(btnMoreOptions,5);
        clickWait(btnLogin,5);
    }
    public boolean validateMassageSuccess(String message){
        return textInElementPresent(popUpMessageSuccess,message,5);
    }

    public void typeSearchCalendar(String locationCity, String fromData, String toData) {
        clickWait(inputLocation,5);
        inputLocation.sendKeys(locationCity);
        inputFrom.sendKeys(fromData);
        inputTo.sendKeys(toData);
        btnYalla.click();
    }
}
