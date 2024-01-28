package com.steam.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultsPage {
    private final SelenideElement pageTitle = $(".pageheader");
    private final SelenideElement searchResultsBlock = $("#search_result_container");
    private final SelenideElement steamLogo = $(".logo");

    @Step("Check that '{gameName}' in Search results")
    public ResultsPage checkPageTitle(String title) {
        pageTitle.shouldHave(text(title));
        return this;
    }

    @Step("Go to main page")
    public ResultsPage goToMainPage() {
        steamLogo.click();
        return this;
    }

    @Step("Check that '{gameName}' in Search results")
    public ResultsPage checkGameInSearchResults(String gameName) {
        searchResultsBlock.shouldHave(text(gameName));
        return this;
    }

    @Step("Click '{gameName}' item")
    public ResultsPage clickGameItem(String gameName) {
        searchResultsBlock.$(byText(gameName)).click();
        return this;
    }
}