package com.steam.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {
    private final SelenideElement checkoutBlock = $(".checkout_content_box");
    private final SelenideElement purchaseSelfButton = checkoutBlock.$("#btn_purchase_self");
    private final SelenideElement purchaseGiftButton = checkoutBlock.$("#btn_purchase_gift");
    private final SelenideElement deleteFromCartButton = checkoutBlock.$$(".remove_link").first();

    public CartPage deleteGameFromCart() {
        deleteFromCartButton.click();
        return this;
    }

    public CartPage checkGameInCart(String gameName) {
        checkoutBlock.shouldHave(text(gameName));
        purchaseSelfButton.shouldNotHave(cssClass("disabled"));
        purchaseGiftButton.shouldNotHave(cssClass("disabled"));
        return this;
    }

    public CartPage checkGameNotInCart(String gameName) {
        checkoutBlock.shouldNotHave(text(gameName));
        purchaseSelfButton.shouldHave(cssClass("disabled"));
        purchaseGiftButton.shouldHave(cssClass("disabled"));
        return this;
    }
}