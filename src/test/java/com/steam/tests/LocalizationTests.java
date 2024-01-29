package com.steam.tests;

import com.steam.pages.MainPage;
import io.qameta.allure.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class LocalizationTests extends TestBase {
    MainPage mainPage = new MainPage();

    static Stream<Arguments> mainNavbarButtons() {
        return Stream.of(
                Arguments.of("English (английский)", List.of("STORE", "COMMUNITY", "ABOUT", "SUPPORT")),
                Arguments.of("Italiano (итальянский)", List.of("NEGOZIO", "COMUNITÀ", "Informazioni", "ASSISTENZA")),
                Arguments.of("Русский (Russian)", List.of("МАГАЗИН", "СООБЩЕСТВО", "О STEAM", "ПОДДЕРЖКА"))

        );
    }

    @Feature("Common")
    @Story("Localization")
    @Owner("Denis Bashkatov")
    @Severity(SeverityLevel.CRITICAL)
    @MethodSource
    @ParameterizedTest(name = "For '{0}' locale main navbar buttons are '{1}'")
    void mainNavbarButtons(
            String language,
            List<String> navbarButtons
    ) {
        mainPage.clickLanguageButton()
                .selectLanguage(language)
                .checkNavbarButtons(navbarButtons);
    }
}
