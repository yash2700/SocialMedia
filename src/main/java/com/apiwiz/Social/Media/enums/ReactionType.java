package com.apiwiz.Social.Media.enums;

public enum ReactionType {
    LIKE("Like"),
    LOVE("Love"),
    HAHA("Haha"),
    WOW("Wow"),
    SAD("Sad"),
    ANGRY("Angry");

    private final String displayName;

    ReactionType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

