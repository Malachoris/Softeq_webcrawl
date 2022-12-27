package com.WebCrawlerSofteq.services;

import com.WebCrawlerSofteq.model.Page;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

@Service
public class GeneratorCSV {
    public void writeTopTenToCsv(Map<String, int[]> stats) {
        // Create a list of page objects from the stats map
        List<Page> pages = new ArrayList<>();
        for (Map.Entry<String, int[]> entry : stats.entrySet()) {
            String url = entry.getKey();
            int[] counts = entry.getValue();
            int totalHits = Arrays.stream(counts).sum();
            Page page = new Page();
            pages.add(page);
        }

        // Sort the pages by total hits in descending order
        pages.sort(Comparator.comparingInt(Page::getTotalHits).reversed());

        // Write the top 10 pages to a CSV file
        try {
            File file = new File("top_10_pages.csv");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write("URL,Hits");
            writer.newLine();
            for (int i = 0; i < 10 && i < pages.size(); i++) {
                Page page = pages.get(i);
                writer.write(page.getUrl() + "," + page.getTotalHits());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToCsv(Set<String> visitedUrls, Map<String, int[]> stats) {
        try {
            // Create a File object for the CSV file
            File csvFile = new File("visited_urls.csv");

            // Create a FileWriter object for the CSV file
            FileWriter fileWriter = new FileWriter(csvFile);

            // Create a BufferedWriter object for the CSV file
            BufferedWriter writer = new BufferedWriter(fileWriter);

            // Write the header row to the CSV file
            writer.write("URL,Term Counts");
            writer.newLine();

            // Iterate over the visited URLs and write each URL and its corresponding term counts to the CSV file
            for (String url : visitedUrls) {
                StringBuilder sb = new StringBuilder();
                sb.append(url);
                sb.append(",");
                int[] counts = stats.get(url);
                for (int count : counts) {
                    sb.append(count);
                    sb.append(",");
                }
                // Remove the last comma
                sb.deleteCharAt(sb.length() - 1);
                writer.write(sb.toString());
                writer.newLine();
            }

            // Close the BufferedWriter
            writer.close();
        } catch (IOException e) {
            // Log the exception or handle it in some other way
        }
    }
}
