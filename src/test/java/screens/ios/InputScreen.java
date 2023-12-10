package screens.ios;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class InputScreen {
    private SelenideElement textInput = $(AppiumBy.name("Text Input")),
                            outputResult = $(AppiumBy.name("Text Output"));

    public InputScreen tapTextInput(){
        textInput.click();
        return this;
    }

    public InputScreen enterText(String text){
        textInput.sendKeys(text);
        textInput.pressEnter();
        return this;
    }

    public void verifyTextWritten(String textWritten){
        outputResult.shouldHave(text(textWritten));
    }
}
