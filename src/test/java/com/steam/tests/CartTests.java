package com.steam.tests;

import com.steam.pages.CartPage;
import com.steam.pages.GamePage;
import com.steam.pages.MainPage;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CartTests {
    MainPage mainPage = new MainPage();
    CartPage cartPage = new CartPage();
    GamePage gamePage = new GamePage();

    @ValueSource(
            strings = {"COCOON", "Cities: Skylines II", "Citizen Sleeper"}
    )
    @Owner("Denis Bashkatov")
    @Severity(SeverityLevel.CRITICAL)
    @ParameterizedTest(name = "Add game {0} to cart")
    void addToCartTest(String gameName) {
        mainPage.fillSearchInput(gameName)
                .clickGameItem(gameName);
        gamePage.clickAddToCart();
        cartPage.checkGameInCart(gameName);
    }

    @ValueSource(
            strings = {"COCOON", "Cities: Skylines II", "Citizen Sleeper"}
    )
    @Owner("Denis Bashkatov")
    @Severity(SeverityLevel.CRITICAL)
    @ParameterizedTest(name = "Remove game {0} from cart")
    void removeFromCartTest(String gameName) {
        mainPage.fillSearchInput(gameName)
                .clickGameItem(gameName);
        gamePage.clickAddToCart();
        cartPage.checkGameInCart(gameName)
                .removeGameFromCart()
                .checkGameNotInCart(gameName);
    }

    @Test
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
                .removeAllFromCart()
                .checkCartIsEmpty();
    }
}
