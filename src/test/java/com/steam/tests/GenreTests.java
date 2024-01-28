package com.steam.tests;

import com.steam.pages.MainPage;
import com.steam.pages.SearchPage;
import io.qameta.allure.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GenreTests extends TestBase {
    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();

    @CsvSource({
            "Free to Play, FREE TO PLAY GAMES",
            "Early Access, EARLY ACCESS TITLES",
            "Action, ACTION"
    })
    @Feature("Store")
    @Story("Genres menu")
    @Owner("Denis Bashkatov")
    @Severity(SeverityLevel.NORMAL)
    @ParameterizedTest(name = "By clicking genre '{0}' go to page '{1}'")
    void checkGenre(
            String genre,
            String pageTitle
    ) {
        mainPage.selectGenre(genre);
        searchPage.checkPageTitle(pageTitle)
                .goToMainPage();
    }
}
