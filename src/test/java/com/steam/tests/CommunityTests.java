package com.steam.tests;

import com.steam.pages.CommunityPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CommunityTests extends TestBase {
    @Test
    @Feature("Community")
    @Story("Community menu")
    @Owner("Denis Bashkatov")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Go to Community pages from navbar menu")
    void dropdownTesting() {
        CommunityPage communityPage = new CommunityPage();

        communityPage.hoverCommunityNavItem()
                .selectCommunityDropdownItem("Home")
                .checkActivityTitle()
                .hoverCommunityNavItem()
                .selectCommunityDropdownItem("Discussions")
                .checkDiscussionsTitle()
                .hoverCommunityNavItem()
                .selectCommunityDropdownItem("Workshop")
                .checkWorkshopTitle()
                .hoverCommunityNavItem()
                .selectCommunityDropdownItem("Market")
                .checkMarketTitle()
                .hoverCommunityNavItem()
                .selectCommunityDropdownItem("Broadcasts")
                .isBroadcastsTabActive();
    }
}
