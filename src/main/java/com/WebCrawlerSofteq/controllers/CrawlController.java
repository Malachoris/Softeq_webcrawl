package com.WebCrawlerSofteq.controllers;

import com.WebCrawlerSofteq.interfaces.PageRepository;
import com.WebCrawlerSofteq.model.Page;
import com.WebCrawlerSofteq.services.CrawlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/crawl")
public class CrawlController {
    @Autowired
    private CrawlService crawlService;
    @Autowired
    private PageRepository pageRepository;

    // Endpoint for submitting search criteria
    @PostMapping
    public ResponseEntity<Void> startCrawl(@RequestParam("seedUrl") String seedUrl, @RequestParam("terms") List<String> terms) {
        crawlService.startCrawl(seedUrl, terms);
        return ResponseEntity.ok().build();
    }

    // Endpoint for retrieving all stats data
    @GetMapping("/all")
    public ResponseEntity<Map<String, int[]>> getStats() {
        return ResponseEntity.ok(crawlService.getStats());
    }

    // Endpoint for retrieving top N results
    @GetMapping("/top/{n}")
    public ResponseEntity<List<Page>> getTopNResults(@PathVariable int n) {
        // Retrieve all pages from the database
        List<Page> pages = pageRepository.findAll();

        // Sort the pages by their total term count in descending order
        pages.sort((p1, p2) -> {
            int count1 = 0;
            for (int c : p1.getTermCounts()) {
                count1 += c;
            }
            int count2 = 0;
            for (int c : p2.getTermCounts()) {
                count2 += c;
            }
            return count2 - count1;
        });

        // Return the top N pages
        return ResponseEntity.ok(pages.subList(0, n));
    }
}


