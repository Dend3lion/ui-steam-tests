package com.steam.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {
    private final SelenideElement checkoutBlock = $(".checkout_content_box");
    private final SelenideElement purchaseSelfButton = checkoutBlock.$(byText("Purchase as a gift")).parent();
    private final SelenideElement purchaseGiftButton = checkoutBlock.$(byText("Purchase for myself")).parent();
    private final SelenideElement removeGameFromCartButton = checkoutBlock.$$(".remove_link").first();
    private final SelenideElement removeAllFromCartButton = $(".checkout_notes_and_continue_shopping_ctn .remove_link");
    private final SelenideElement modalAcceptButton = $(".newmodal_buttons .btn_green_steamui");
    private final ElementsCollection cartItemsList = checkoutBlock.$$(".cart_item");


    @Step("Click 'Remove' button")
    public CartPage removeGameFromCart() {
        removeGameFromCartButton.click();
        return this;
    }

    @Step("Click 'Remove all items' button")
    public CartPage removeAllFromCart() {
        removeAllFromCartButton.click();
        modalAcceptButton.click();
        return this;
    }

    @Step("Check that game '{gameName}' is in cart")
    public CartPage checkGameInCart(String gameName) {
        checkoutBlock.shouldHave(text(gameName));
        purchaseSelfButton.shouldNotHave(cssClass("btn_disabled"));
        purchaseGiftButton.shouldNotHave(cssClass("btn_disabled"));
        return this;
    }

    @Step("Check that game '{gameName}' is not in cart")
    public CartPage checkGameNotInCart(String gameName) {
        checkoutBlock.shouldNotHave(text(gameName));
        purchaseSelfButton.shouldHave(cssClass("btn_disabled"));
        purchaseGiftButton.shouldHave(cssClass("btn_disabled"));
        return this;
    }

    @Step("Check that cart is empty")
    public CartPage checkCartIsEmpty() {
        cartItemsList.shouldBe(CollectionCondition.empty);
        purchaseSelfButton.shouldHave(cssClass("btn_disabled"));
        purchaseGiftButton.shouldHave(cssClass("btn_disabled"));
        return this;
    }
}