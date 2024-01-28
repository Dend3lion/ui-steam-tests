package com.steam.pages;

import com.codeborne.selenide.SelenideElement;
import com.steam.config.Locale;

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

    public MainPage clickLanguageButton() {
        languageButton.click();
        return this;
    }

    public MainPage selectLanguage(Locale locale) {
        languageDropdown.$(byText((locale.getDesc()))).click();
        return this;
    }

    public MainPage checkButtons(List<String> buttons) {
        $$(".supernav_container a").filter(visible).shouldHave(texts(buttons));
        return this;
    }

    public MainPage selectGenre(String categories) {
        genresBlock.$(byText(categories)).click();
        return this;
    }

    public MainPage fillSearchInput(String gameName) {
        searchInput.setValue(gameName);
        return this;
    }

    public MainPage clickSearchButton() {
        searchButton.click();
        return this;
    }

    public MainPage clickGameItem(String gameName) {
        searchDropdown.$(byText(gameName)).click();
        return this;
    }

    public MainPage checkDropdownList(String gameName) {
        searchDropdown.shouldHave(text(gameName));
        return this;
    }
}