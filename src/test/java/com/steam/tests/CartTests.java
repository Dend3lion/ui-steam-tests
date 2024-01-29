package com.steam.tests;

import com.steam.pages.CartPage;
import com.steam.pages.GamePage;
import com.steam.pages.MainPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CartTests extends TestBase {
    MainPage mainPage = new MainPage();
    CartPage cartPage = new CartPage();
    GamePage gamePage = new GamePage();

    @ValueSource(
            strings = {"COCOON", "Cities: Skylines II", "Citizen Sleeper"}
    )
    @Feature("Store")
    @Story("Cart")
    @Owner("Denis Bashkatov")
    @Severity(SeverityLevel.BLOCKER)
    @ParameterizedTest(name = "Add game '{0}' to cart")
    void addToCartTest(String gameName) {
        mainPage.fillSearchInput(gameName)
                .clickGameItem(gameName);
        gamePage.clickAddToCart();
        cartPage.checkGameInCart(gameName)
                .checkPurchaseButtonsEnabled();
    }

    @ValueSource(
            strings = {"COCOON", "Cities: Skylines II", "Citizen Sleeper"}
    )
    @Feature("Store")
    @Story("Cart")
    @Owner("Denis Bashkatov")
    @Severity(SeverityLevel.CRITICAL)
    @ParameterizedTest(name = "Remove game '{0}' from cart")
    void removeFromCartTest(String gameName) {
        mainPage.fillSearchInput(gameName)
                .clickGameItem(gameName);
        gamePage.clickAddToCart();
        cartPage.checkGameInCart(gameName)
                .removeGameFromCart()
                .checkGameNotInCart(gameName)
                .checkPurchaseButtonsDisabled();
    }

    @Test
    @Feature("Store")
    @Story("Cart")
    @Owner("Denis Bashkatov")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Remove all items from cart")
    void removeAllFromCartTest() {
        mainPage.fillSearchInput("COCOON")
                .clickGameItem("COCOON");
        gamePage.clickAddToCart();
        mainPage.fillSearchInput("Cities: Skylines II")
                .clickGameItem("Cities: Skylines II");
        gamePage.clickAddToCart();
        cartPage.checkGameInCart("COCOON")
                .checkGameInCart("Cities: Skylines II")
                .checkPurchaseButtonsEnabled()
                .clickRemoveAllButton()
                .confirmGamesRemoval()
                .checkCartIsEmpty()
                .checkPurchaseButtonsDisabled();
    }
}
