package com.steam.pages;

import com.codeborne.selenide.SelenideElement;

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

    public CommunityPage hoverCommunityOption() {
        communityNavButton.hover();
        return this;
    }

    public CommunityPage selectCommunityDropdownItem(String dropdownItem) {
        communityDropdown.$(byText(dropdownItem)).click();
        return this;
    }

    public CommunityPage checkActivityTitle() {
        activityTitle.shouldHave(text("Community Activity"));
        return this;
    }

    public CommunityPage checkDiscussionsTitle() {
        discussionsTitle.shouldHave(text("Welcome to the Steam Discussions"));
        return this;
    }

    public CommunityPage checkWorkshopTitle() {
        workshopTitle.shouldHave(text("Workshop Home"));
        return this;
    }

    public CommunityPage checkMarketTitle() {
        marketTitle.shouldHave(text("Community Market"));
        return this;
    }

    public CommunityPage isBroadcastsTabActive() {
        activeCommunityTab.shouldHave(text("Broadcasts"));
        return this;
    }
}