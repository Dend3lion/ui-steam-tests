package com.steam.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.steam.config.Locale;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    private final SelenideElement searchInput = $("#store_nav_search_term");
    private final SelenideElement searchDropdown = $("#search_suggestion_contents");
    private final SelenideElement searchButton = $("#store_search_link");
    private final SelenideElement languageButton = $("#language_pulldown");
    private final SelenideElement languageDropdown = $("#language_dropdown");
    private final SelenideElement genresBlock = $(".home_page_gutter");
    private final ElementsCollection mainNavbarButtons = $$(".supernav_container a").filter(visible);

    @Step("Click 'Language' button")
    public MainPage clickLanguageButton() {
        languageButton.click();
        return this;
    }

    @Step("Click '{locale.getDesc()}' in Language dropdown")
    public MainPage selectLanguage(Locale locale) {
        languageDropdown.$(byText((locale.getDesc()))).click();
        return this;
    }

    @Step("Click '{genre}' genre")
    public MainPage selectGenre(String genre) {
        genresBlock.$(byText(genre)).click();
        return this;
    }

    @Step("Fill search bar with '{gameName}'")
    public MainPage fillSearchInput(String gameName) {
        searchInput.setValue(gameName);
        return this;
    }

    @Step("Click Search button")
    public MainPage clickSearchButton() {
        searchButton.click();
        return this;
    }

    @Step("Click '{gameName}' in Search dropdown")
    public MainPage clickGameItem(String gameName) {
        searchDropdown.$(byText(gameName)).click();
        return this;
    }

    @Step("Check that '{gameName}' is in Search dropdown")
    public MainPage checkDropdownList(String gameName) {
        searchDropdown.shouldHave(text(gameName));
        return this;
    }

    @Step("Check main navbar buttons")
    public MainPage checkNavbarButtons(List<String> navbarOptions) {
        mainNavbarButtons.shouldHave(texts(navbarOptions));
        return this;
    }
}