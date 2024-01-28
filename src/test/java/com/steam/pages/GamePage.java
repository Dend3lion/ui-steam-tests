package com.steam.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GamePage {
    private final SelenideElement gameTitle = $("#appHubAppName");
    private final SelenideElement addToCartButton = $$(".btn_addtocart .btn_green_steamui").first();

    @Step("Check that '{gameName}' page is open")
    public GamePage checkGameTitle(String gameName) {
        gameTitle.shouldBe(text(gameName));
        return this;
    }

    @Step("Add game to cart")
    public GamePage clickAddToCart() {
        addToCartButton.click();
        return this;
    }
}
