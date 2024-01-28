package com.steam.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultsPage {
    private final SelenideElement searchResultsBlock = $("#search_result_container");

    @Step("Check that '{gameName}' in Search results")
    public ResultsPage checkSearchResults(String gameName) {
        searchResultsBlock.shouldHave(text(gameName));
        return this;
    }

    @Step("Click '{gameName}' item")
    public ResultsPage clickGameItem(String gameName) {
        searchResultsBlock.$(byText(gameName)).click();
        return this;
    }
}