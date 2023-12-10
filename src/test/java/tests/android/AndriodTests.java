package tests.android;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.android.ArticleErrorScreen;
import screens.android.MainScreen;
import screens.android.SearchScreen;
import tests.TestBase;

import static io.qameta.allure.Allure.step;

public class AndriodTests extends TestBase {
    private MainScreen mainScreen = new MainScreen();
    private SearchScreen searchScreen = new SearchScreen();
    private ArticleErrorScreen articleScreen = new ArticleErrorScreen();
    private final static String SEARCH_QUERY = "Appium";
    private final static int RESULT_SIZE = 0;
    private final static String SEARCH_QUERY_ARTICLE = "Selenide";
    private final static String ARTICLE_DESCRIPTION = "Class of chemical compounds";


    @Test
    @Tag("android")
    @Owner("kegorova")
    @DisplayName("successful search: results are returned in the list")
    void successfulSearchTest(){
        step("Type search", () -> {
            mainScreen.tapOnFalseSearch()
                      .setSearchQuery(SEARCH_QUERY);
        });
        step("Verify content found", () -> {
               searchScreen.searchResultIsGreaterThan(RESULT_SIZE);
        });
    }


    @Test
    @Tag("android")
    @Owner("kegorova")
    @DisplayName("search: open article by description and get error")
    void openArticleAndGetErrorTest(){
        step("Type search", () -> {
            mainScreen.tapOnFalseSearch()
                      .setSearchQuery(SEARCH_QUERY_ARTICLE);
        });
        step("Select article by description", () -> {
            searchScreen.selectArticleByDescription(ARTICLE_DESCRIPTION);
        });
        step("Checking for error text", () -> {
            articleScreen.errorTextIsDisplayed();
        });
    }
}
