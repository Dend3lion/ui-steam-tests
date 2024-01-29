package com.steam.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage {
    private final SelenideElement pageTitle = $(".ContentHubTitleCtn");
    private final SelenideElement searchResultsBlock = $("#search_result_container");
    private final SelenideElement steamLogo = $(".logo");

    @Step("Check that '{gameName}' in Search results")
    public SearchPage checkPageTitle(String title) {
        pageTitle.shouldHave(text(title));
        return this;
    }

    @Step("Go to main page")
    public SearchPage goToMainPage() {
        steamLogo.click();
        return this;
    }

    @Step("Check that '{gameName}' in Search results")
    public SearchPage checkGameInSearchResults(String gameName) {
        searchResultsBlock.shouldHave(text(gameName));
        return this;
    }

    @Step("Click '{gameName}' item")
    public SearchPage clickGameItem(String gameName) {
        searchResultsBlock.$(byText(gameName)).click();
        return this;
    }
}