package screens.android;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static io.appium.java_client.AppiumBy.*;

public class MainScreen {
    private SelenideElement falseSearch = $(accessibilityId("Search Wikipedia")),
                            trueSearch = $(id("org.wikipedia.alpha:id/search_src_text"));


    public MainScreen tapOnFalseSearch(){
        falseSearch.click();
        return this;
    }

    public SearchScreen setSearchQuery(String query){
        trueSearch.sendKeys(query);
        return page(SearchScreen.class);
    }

}
