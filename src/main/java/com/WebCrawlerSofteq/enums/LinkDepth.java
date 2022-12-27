package com.WebCrawlerSofteq.enums;

public enum LinkDepth {
    LINK_DEPTH(8);

    private final int value;

    LinkDepth(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
