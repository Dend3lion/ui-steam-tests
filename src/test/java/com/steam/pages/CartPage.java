package com.steam.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {
    private final SelenideElement checkoutBlock = $(".checkout_content_box");
    private final SelenideElement purchaseSelfButton = checkoutBlock.$("#btn_purchase_self");
    private final SelenideElement purchaseGiftButton = checkoutBlock.$("#btn_purchase_gift");
    private final SelenideElement removeGameFromCartButton = checkoutBlock.$$(".remove_link").first();
    private final SelenideElement removeAllFromCartButton = checkoutBlock.$$(".remove_link").last();
    private final ElementsCollection cartItemsList = checkoutBlock.$$(".cart_item");


    @Step("Click 'Remove' button")
    public CartPage removeGameFromCart() {
        removeGameFromCartButton.click();
        return this;
    }

    @Step("Click 'Remove all items' button")
    public CartPage removeAllFromCart() {
        removeAllFromCartButton.click();
        return this;
    }

    @Step("Check that game '{gameName}' is in cart")
    public CartPage checkGameInCart(String gameName) {
        checkoutBlock.shouldHave(text(gameName));
        purchaseSelfButton.shouldNotHave(cssClass("disabled"));
        purchaseGiftButton.shouldNotHave(cssClass("disabled"));
        return this;
    }

    @Step("Check that game '{gameName}' is not in cart")
    public CartPage checkGameNotInCart(String gameName) {
        checkoutBlock.shouldNotHave(text(gameName));
        purchaseSelfButton.shouldHave(cssClass("disabled"));
        purchaseGiftButton.shouldHave(cssClass("disabled"));
        return this;
    }

    @Step("Check that cart is empty")
    public CartPage checkCartIsEmpty() {
        cartItemsList.shouldBe(CollectionCondition.empty);
        purchaseSelfButton.shouldHave(cssClass("disabled"));
        purchaseGiftButton.shouldHave(cssClass("disabled"));
        return this;
    }
}