package com.apiwiz.Social.Media.enums;

public enum PrivacyStatus {
    PUBLIC("Public"),
    PRIVATE("Private");

    private final String displayName;

    PrivacyStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
