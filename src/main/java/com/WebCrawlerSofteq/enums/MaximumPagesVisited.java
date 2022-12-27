package com.WebCrawlerSofteq.enums;

public enum MaximumPagesVisited {
    MAX_VISITED_PAGES(10000);

    private final int value;

    MaximumPagesVisited(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
