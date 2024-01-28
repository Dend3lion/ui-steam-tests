package com.steam.config;

public enum Locale {
    EN("English (английский)"),
    IT("Italiano (итальянский)"),
    RU("Русский (Russian)");
    private final String desc;

    Locale(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
