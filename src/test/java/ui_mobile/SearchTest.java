package ui_mobile;

import config.AppiumConfig;
import org.testng.annotations.Test;
import screens.SearchScreen;


public class SearchTest extends AppiumConfig {

    SearchScreen searchScreen;



    @Test
    public void typeSearchTestPositive(){
        searchScreen = new SearchScreen(driver);
        searchScreen.typeSearchCalendar("Tel Aviv", "05/03/25","09/03/25");
    }

}
