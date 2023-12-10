package screens.ios;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class MainScreen {

    private SelenideElement uiElemets = $(AppiumBy.name("UI Elements")),
                            textButton = $(AppiumBy.name("Text Button")),
                            alertButton = $(AppiumBy.name("Alert Button")),
                            webViewTab = $(AppiumBy.name("Web View")),
                            localTestingTab = $(AppiumBy.name("Local Testing"));

    public MainScreen uiElementsIsVisible(){
        uiElemets.shouldBe(visible);
        return this;
    }

    public MainScreen textButtonIsVisible(){
        textButton.shouldBe(visible);
        return this;
    }

    public MainScreen alertButtonIsVisible(){
        alertButton.shouldBe(visible);
        return this;
    }

    public MainScreen webViewTabIsVisible(){
        webViewTab.shouldBe(visible);
        return this;
    }

    public MainScreen localTestingTabIsVisible(){
        localTestingTab.shouldBe(visible);
        return this;
    }

    public InputScreen tapTextButton(){
        textButton.click();
        return page(InputScreen.class);
    }

}
