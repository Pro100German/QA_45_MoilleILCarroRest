package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

public class SplashScreens extends BaseScreen{
    public SplashScreens(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(id = "com.telran.ilcarro:id/versionText")
    AndroidElement versionApp;

    public boolean validateVersion(String version){
        return textInElementPresent(versionApp, version, 5);
    }
}
