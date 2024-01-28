package com.steam.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GamePage {
    private final SelenideElement gameTitle = $("#appHubAppName");
    private final SelenideElement addToCartButton = $$(".btn_addtocart .btn_green_steamui").first();

    public GamePage checkSearchResults(String gameName) {
        gameTitle.shouldBe(text(gameName));
        return this;
    }

    public GamePage clickAddToCart() {
        addToCartButton.click();
        return this;
    }
}
