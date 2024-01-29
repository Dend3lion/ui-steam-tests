package com.steam.tests;

import com.steam.pages.GamePage;
import com.steam.pages.MainPage;
import com.steam.pages.SearchPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SearchTests extends TestBase {
    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();
    GamePage gamePage = new GamePage();

    @CsvSource({
            "sea of, Sea of Stars",
            "armored core, ARMORED CORE™ VI FIRES OF RUBICON™",
    })
    @Feature("Store")
    @Story("Search")
    @Owner("Denis Bashkatov")
    @Severity(SeverityLevel.CRITICAL)
    @ParameterizedTest(name = "Search dropdown contains {1} when entering {0}")
    @DisplayName("Search dropdown contains searched game")
    void searchGameInDropdownTest(
            String inputText,
            String gameName
    ) {
        mainPage.fillSearchInput(inputText)
                .checkSearchDropdownList(gameName);
    }

    @CsvSource({
            "disco, Disco Elysium - The Final Cut",
            "robocop, RoboCop: Rogue City",
    })
    @Feature("Store")
    @Story("Search")
    @Owner("Denis Bashkatov")
    @Severity(SeverityLevel.CRITICAL)
    @ParameterizedTest(name = "Search page contains {1} when entering {0}")
    @DisplayName("Search page contains searched game")
    void searchGameInResultsTest(
            String inputText,
            String gameName
    ) {
        mainPage.fillSearchInput(inputText)
                .clickSearchButton();
        searchPage.checkGameInSearchResults(gameName);
    }

    @Test
    @Feature("Store")
    @Story("Search")
    @Owner("Denis Bashkatov")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Go to game page from search results")
    void goToGamePageFromResultsTest() {
        mainPage.fillSearchInput("stellaris")
                .clickSearchButton();
        searchPage.clickGameItem("Stellaris");
        gamePage.checkGameTitle("Stellaris");
    }
}
