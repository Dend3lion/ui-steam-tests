package com.steam.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultsPage {
    private final SelenideElement searchResultsBlock = $("#search_result_container");

    public ResultsPage checkSearchResults(String gameName) {
        searchResultsBlock.shouldHave(text(gameName));
        return this;
    }

    public ResultsPage clickGameItem(String gameName) {
        searchResultsBlock.$(byText(gameName)).click();
        return this;
    }
}