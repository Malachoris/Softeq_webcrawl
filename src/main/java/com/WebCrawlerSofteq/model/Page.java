package com.WebCrawlerSofteq.model;

import jakarta.persistence.*;

import java.util.Arrays;

@Entity
@Table(name = "pages")
public class Page {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "term_counts", nullable = false)
    private int[] termCounts;
    
    //private final int depthLevel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int[] getTermCounts() {
        return termCounts;
    }

    public void setTermCounts(int[] termCounts) {
        this.termCounts = termCounts;
    }

    public int getTotalHits() {
        int totalHits = 0;
        for (int count : termCounts) {
            totalHits += count;
        }
        return totalHits;
    }

    @Override
    public String toString() {
        return "Page{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", termCounts=" + Arrays.toString(termCounts) +
                '}';
    }

}

