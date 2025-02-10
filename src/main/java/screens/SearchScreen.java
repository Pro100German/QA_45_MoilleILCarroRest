package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.time.Month;
import java.util.Locale;

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
    @FindBy(id = "android:id/button1")
    AndroidElement btnOk;
    @FindBy(id = "com.telran.ilcarro:id/searchBtn")
    AndroidElement btnYalla;
    @FindBy(id ="android:id/next")
    AndroidElement btnMonthNext;
    @FindBy(id ="android:id/prev")
    AndroidElement btnMonthPrev;
    @FindBy(id = "android:id/date_picker_header_year")
    AndroidElement btnYear;

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

    public void typeCarWithCalendar(String city, String dateStart, String toData) {
        clickWait(inputLocation, 5);
        inputLocation.sendKeys(city);
        inputFrom.click();
        setDateCalendar(dateStart);
        inputTo.click();
        setDateCalendar(toData);


    }
    private void setDateCalendar(String dateStart) {
        //pause(3);
        String[] arrayData = dateStart.split(" ");
        int month = returnNumOfMonth(arrayData[1]);
        int currentMonth = LocalDate.now().getMonthValue()+1;
        int quantityClick = Math.abs(month - currentMonth);
        if(quantityClick>0)
            for (int i = 0; i < quantityClick; i++) {
                clickWait(btnMonthNext, 3);
            }
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable
                        (By.xpath("//*[@content-desc='"+dateStart+"']")))
                .click();
        btnOk.click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.invisibilityOfElementLocated
                        (By.id("android:id/button1")));
    }
    private int returnNumOfMonth(String month){
        Month month1 = Month.valueOf(month.toLowerCase(Locale.ENGLISH));
        return month1.getValue();
    }

}
