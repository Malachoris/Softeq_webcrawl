package com.WebCrawlerSofteq.services;

import java.util.*;

import com.WebCrawlerSofteq.enums.LinkDepth;
import com.WebCrawlerSofteq.enums.MaximumPagesVisited;
import com.WebCrawlerSofteq.interfaces.PageRepository;
import com.WebCrawlerSofteq.model.Page;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrawlService {

    @Autowired
    private PageRepository pageRepository;

    @Autowired
    private GeneratorCSV generator;

    // Set of URLs already crawled
    private Set<String> crawledUrls = new HashSet<>();
    // List of URLs to be crawled
    private Queue<String> todoUrls = new LinkedList<>();
    // Map of URL to statistics
    private Map<String, int[]> stats = new HashMap<>();

    // List of terms to search for
    private List<String> terms;


    public CrawlService() {
    }

    public void startCrawl(String seedUrl, List<String> terms) {
        this.terms = terms;
        // Add the seed URL to the list of URLs to be crawled
        todoUrls.add(seedUrl);

        while (!todoUrls.isEmpty() && crawledUrls.size() < MaximumPagesVisited.MAX_VISITED_PAGES.getValue()) {
            // Get the next URL to be crawled
            String url = todoUrls.remove();

            // Crawl the page
            crawlPage(url);
        }
    }

    private void crawlPage(String url) {
        try {
            // Connect to the URL and download the HTML content
            Connection connection = Jsoup.connect(url);
            Document doc = connection.get();

            // Find all the links on the page
            Elements links = doc.select("a[href]");

            // Add the links to the to-do list if they haven't been visited and are within the link depth
            for (Element link : links) {
                String linkUrl = link.absUrl("href");
                int depth = 0;
                if (!crawledUrls.contains(linkUrl) &&  depth < LinkDepth.LINK_DEPTH.getValue()) {
                    todoUrls.add(linkUrl);
                    depth++;
                }
            }

            Thread.sleep(100);
            //System.out.println(url);

            // Count the occurrences of the terms on the page
            int[] counts = new int[terms.size()];
            for (int i = 0; i < terms.size(); i++) {
                String term = terms.get(i);
                String text = doc.body().text();
                int index = 0;
                while (index != -1) {
                    index = text.indexOf(term, index);
                    if (index != -1) {
                        counts[i]++;
                        index += term.length();
                    }
                }
            }
            // Create a Page entity with the URL and term counts
            Page page = new Page();
            page.setUrl(url);
            page.setTermCounts(counts);

            // Save the Page entity to the database
            pageRepository.save(page);

            // Add the page to the crawled URLs set and stats map
            crawledUrls.add(url);
            stats.put(url, counts);
            generator.writeToCsv(crawledUrls, stats);
            generator.writeTopTenToCsv(stats);


        } catch (Exception e) {
            // Log the exception or handle it in some other way
        }
    }

    public Map<String, int[]> getStats() {
        return stats;
    }
}

