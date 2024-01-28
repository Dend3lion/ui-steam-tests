package com.steam.tests;

import com.steam.config.Locale;
import com.steam.pages.MainPage;
import io.qameta.allure.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class LocalizationTests {
    MainPage mainPage = new MainPage();

    static Stream<Arguments> mainNavbarButtons() {
        return Stream.of(
                Arguments.of(Locale.EN, List.of("STORE", "COMMUNITY", "ABOUT", "SUPPORT")),
                Arguments.of(Locale.IT, List.of("NEGOZIO", "COMUNITÀ", "Informazioni", "ASSISTENZA")),
                Arguments.of(Locale.RU, List.of("МАГАЗИН", "СООБЩЕСТВО", "О STEAM", "ПОДДЕРЖКА"))
        );
    }

    @Feature("Common")
    @Story("Localization")
    @Owner("Denis Bashkatov")
    @Severity(SeverityLevel.CRITICAL)
    @MethodSource
    @ParameterizedTest(name = "For '{0}' locale main navbar buttons are '{1}'")
    void mainNavbarButtons(
            Locale locale,
            List<String> navbarButtons
    ) {
        mainPage.clickLanguageButton()
                .selectLanguage(locale)
                .checkNavbarButtons(navbarButtons);
    }
}
