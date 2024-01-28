package com.steam.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CommunityPage {
    private final SelenideElement communityNavButton = $("#global_header").$(byText("COMMUNITY"));
    private final SelenideElement communityDropdown = $(".supernav_content");
    private final SelenideElement activityTitle = $(".community_home_title");
    private final SelenideElement discussionsTitle = $(".large_title");
    private final SelenideElement workshopTitle = $(".homeTabSpacer");
    private final SelenideElement marketTitle = $("#BG_top");
    private final SelenideElement activeCommunityTab = $(".apphub_sectionTab.active");

    @Step("Hover over 'Community' navbar item")
    public CommunityPage hoverCommunityNavItem() {
        communityNavButton.hover();
        return this;
    }

    @Step("Click '{dropdownItem}' in Community dropdown")
    public CommunityPage selectCommunityDropdownItem(String dropdownItem) {
        communityDropdown.$(byText(dropdownItem)).click();
        return this;
    }

    @Step("Check that Activity is open")
    public CommunityPage checkActivityTitle() {
        activityTitle.shouldHave(text("Community Activity"));
        return this;
    }

    @Step("Check that Discussions is open")
    public CommunityPage checkDiscussionsTitle() {
        discussionsTitle.shouldHave(text("Welcome to the Steam Discussions"));
        return this;
    }

    @Step("Check that Workshop is open")
    public CommunityPage checkWorkshopTitle() {
        workshopTitle.shouldHave(text("Workshop Home"));
        return this;
    }

    @Step("Check that Market is open")
    public CommunityPage checkMarketTitle() {
        marketTitle.shouldHave(text("Community Market"));
        return this;
    }

    @Step("Check that Broadcasts are open")
    public CommunityPage isBroadcastsTabActive() {
        activeCommunityTab.shouldHave(text("Broadcasts"));
        return this;
    }
}