package screens;

import dto.UserDto;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationScreen extends BaseScreen{
    public RegistrationScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(id = "com.telran.ilcarro:id/editRegName")
    AndroidElement inputName;
    @FindBy(id = "com.telran.ilcarro:id/editRegLastName")
    AndroidElement inputLastName;
    @FindBy(id = "com.telran.ilcarro:id/editRegEmail")
    AndroidElement inputEmail;
    @FindBy(id = "com.telran.ilcarro:id/editRegPassword")
    AndroidElement inputPassword;
    @FindBy(id = "com.telran.ilcarro:id/checkBoxAgree")
    AndroidElement inputCheckBox;
    @FindBy(id = "com.telran.ilcarro:id/regBtn")
    AndroidElement inputBtnYalla;


    public void typeRegistrationForm(UserDto user){
        inputName.sendKeys(user.getFirstName());
        inputLastName.sendKeys(user.getLastName());
        inputEmail.sendKeys(user.getUsername());
        inputPassword.sendKeys(user.getPassword());
        inputCheckBox.click();
        inputBtnYalla.click();
    }


    public boolean validateMassageErrorEmail(String message){
        return textInElementPresent(popUpMessageErrorFillingTheField,message,5);
    }

}
