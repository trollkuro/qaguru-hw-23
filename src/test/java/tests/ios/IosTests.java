package tests.ios;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.ios.InputScreen;
import screens.ios.MainScreen;
import tests.TestBase;

import static io.qameta.allure.Allure.step;


public class IosTests extends TestBase {
    private MainScreen mainScreen = new MainScreen();
    private InputScreen inputScreen = new InputScreen();
    private final static String TEXT = "Appium";

    @Test
    @Tag("ios")
    @Owner("kegorova")
    @DisplayName("Check visibility of elements in the main screen")
    void elementsIsVisibleTest(){
        step("Check visibility of elements", () -> {
            mainScreen.uiElementsIsVisible()
                      .textButtonIsVisible()
                      .alertButtonIsVisible()
                      .webViewTabIsVisible()
                      .localTestingTabIsVisible();
        });
    }

    @Test
    @Tag("ios")
    @Owner("kegorova")
    @DisplayName("Check text input")
    void inputTextTest(){
        step("Tap on text button", () -> {
            mainScreen.tapTextButton();
        });
        step("Tap on the text input", () -> {
            inputScreen.tapTextInput();
        });
        step("Enter text", () -> {
            inputScreen.enterText(TEXT);
        });
        step("Verify the result", () -> {
            inputScreen.verifyTextWritten(TEXT);
        });
    }
}
