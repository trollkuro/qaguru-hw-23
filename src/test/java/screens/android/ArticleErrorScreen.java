package screens.android;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class ArticleErrorScreen {
    private SelenideElement errorText = $(id("org.wikipedia.alpha:id/view_wiki_error_text"));

    public ArticleErrorScreen errorTextIsDisplayed(){
        errorText.shouldBe(visible);
        return this;
    }
}
