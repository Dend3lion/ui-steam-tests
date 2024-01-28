package com.steam.tests;

import com.steam.pages.MainPage;
import com.steam.pages.ResultsPage;
import io.qameta.allure.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GenreTests {
    MainPage mainPage = new MainPage();
    ResultsPage resultsPage = new ResultsPage();

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
        resultsPage.checkPageTitle(pageTitle)
                .goToMainPage();
    }
}
