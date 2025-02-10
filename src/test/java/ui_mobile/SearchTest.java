package ui_mobile;

import config.AppiumConfig;
import org.testng.annotations.Test;
import screens.SearchScreen;
import screens.SplashScreens;


public class SearchTest extends AppiumConfig {

    SearchScreen searchScreen;
    @Test
    public void goToSearchScreen(){
       new SplashScreens(driver).goToSearchScreen();

    }



    @Test
    public void typeSearchTestPositive(){
        searchScreen = new SearchScreen(driver);
         searchScreen.typeSearchCalendar("Tel Aviv", "05/03/25","09/03/25");
    }
    @Test
    public void typeCarWithCalendarTestPositive(){
        searchScreen = new SearchScreen(driver);
        searchScreen.typeCarWithCalendar("Tel Aviv", "05 March 2025","12 June 2025");
    }

}
