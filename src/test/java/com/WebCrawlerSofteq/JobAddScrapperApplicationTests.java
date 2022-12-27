/*
package com.JobWebScrapper.JobAddScrapper;

import com.JobWebScrapper.JobAddScrapper.services.WebCrawler;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;

//@SpringBootTest
class WebCrawlerTest {

    @Test
    void testSerializeStats() throws IOException {
        // Set up test data
        Map<String, int[]> stats = new LinkedHashMap<>();
        stats.put("https://example.com/page1", new int[] { 1, 2, 3 });
        stats.put("https://example.com/page2", new int[] { 4, 5, 6 });
        stats.put("https://example.com/page3", new int[] { 7, 8, 9 });
        List<String> terms = Arrays.asList("Term 1", "Term 2", "Term 3");

        // Serialize the stats to a temporary file
        File tempFile = File.createTempFile("stats", ".csv");
        tempFile.deleteOnExit();
        WebCrawler.serializeStats(tempFile.getAbsolutePath(), stats, terms, false);

        // Read the contents of the file and split it into lines
        String[] lines = new String(Files.readAllBytes(tempFile.toPath()), StandardCharsets.UTF_8).split("\n");

        // Verify the contents of the file
        assertEquals("URL,Term 1,Term 2,Term 3,Total", lines[0]);
        assertEquals("https://example.com/page1,1,2,3,6", lines[1]);
        assertEquals("https://example.com/page2,4,5,6,15", lines[2]);
        assertEquals("https://example.com/page3,7,8,9,24", lines[3]);
    }

    @Test
    void testGetTopPages() {
        // Set up test data
        Map<String, int[]> stats = new LinkedHashMap<>();
        stats.put("https://example.com/page1", new int[] { 1, 2, 3 });
        stats.put("https://example.com/page2", new int[] { 4, 5, 6 });
        stats.put("https://example.com/page3", new int[] { 7, 8, 9 });

        // Get the top 2 pages
        Map<String, int[]> topPages = WebCrawler.getTopPages(stats, 2);

        // Verify the contents of the top pages map
        assertEquals(2, topPages.size());
        assertArrayEquals(new int[] { 7, 8, 9 }, topPages.get("https://example.com/page3"));
        assertArrayEquals(new int[] { 4, 5, 6 }, topPages.get("https://example.com/page2"));
    }

    @Test
    void testSerializeStats_emptyStats() throws IOException {
        // Set up test data
        Map<String, int[]> stats = Collections.emptyMap();
        List<String> terms = Arrays.asList("Term 1", "Term 2", "Term 3");

        // Serialize the stats to a temporary file
        File tempFile = File.createTempFile("stats", ".csv");
        tempFile.deleteOnExit();
        WebCrawler.serializeStats(tempFile.getAbsolutePath(), stats, terms, false);

        // Read the contents of the file and split it into lines
        String[] lines = new String(Files.readAllBytes(tempFile.toPath()), StandardCharsets.UTF_8).split("\n");

        // Verify the contents of the file
        assertEquals("URL,Term 1,Term 2,Term 3,Total", lines[0]);
        assertEquals(1, lines.length);
    }

    @Test
    void testSerializeStats_emptyTerms() throws IOException {
        // Set up test data
        Map<String, int[]> stats = new LinkedHashMap<>();
        stats.put("https://example.com/page1", new int[] { 1, 2, 3 });
        List<String> terms = Collections.emptyList();

        // Serialize the stats to a temporary file
        File tempFile = File.createTempFile("stats", ".csv");
        tempFile.deleteOnExit();
        WebCrawler.serializeStats(tempFile.getAbsolutePath(), stats, terms, false);

        // Read the contents of the file and split it into lines
        String[] lines = new String(Files.readAllBytes(tempFile.toPath()), StandardCharsets.UTF_8).split("\n");

        // Verify the contents of the file
        assertEquals("URL,Total", lines[0]);
        assertEquals("https://example.com/page1,6", lines[1]);
        assertEquals(2, lines.length);
    }
    @Test
    void testSerializeStats_invalidFilename() throws IOException {
        // Set up test data
        Map<String, int[]> stats = new LinkedHashMap<>();
        stats.put("https://example.com/page1", new int[] { 1, 2, 3 });
        List<String> terms = Arrays.asList("Term 1", "Term 2", "Term 3");

        // Attempt to serialize the stats to a file with an invalid filename
        assertThrows(IOException.class, () -> WebCrawler.serializeStats(":invalid-filename:", stats, terms, false));
    }

    @Test
    void testGetTopPages_emptyStats() {
        // Set up test data
        Map<String, int[]> stats = Collections.emptyMap();

        // Get the top 10 pages
        Map<String, int[]> topPages = WebCrawler.getTopPages(stats, 10);

        // Verify the contents of the top pages map
        assertEquals(0, topPages.size());
    }

    @Test
    void testGetTopPages_countGreaterThanStatsSize() {
        // Set up test data
        Map<String, int[]> stats = new LinkedHashMap<>();
        stats.put("https://example.com/page1", new int[] { 1, 2, 3 });
        stats.put("https://example.com/page2", new int[] { 4, 5, 6 });

        // Get the top 3 pages
        Map<String, int[]> topPages = WebCrawler.getTopPages(stats, 3);

        // Verify the contents of the top pages map
        assertEquals(2, topPages.size());
        assertArrayEquals(new int[] { 4, 5, 6 }, topPages.get("https://example.com/page2"));
        assertArrayEquals(new int[] { 1, 2, 3 }, topPages.get("https://example.com/page1"));
    }

    @Test
    void testGetTopPages_equalCounts() {
        // Set up test data
        Map<String, int[]> stats = new LinkedHashMap<>();
        stats.put("https://example.com/page1", new int[] { 1, 2, 3 });
        stats.put("https://example.com/page2", new int[] { 3, 2, 1 });

        // Get the top 1 page
        Map<String, int[]> topPages = WebCrawler.getTopPages(stats, 1);

        // Verify the contents of the top pages map
        assertEquals(1, topPages.size());
        assertArrayEquals(new int[] { 1, 2, 3 }, topPages.get("https://example.com/page1"));
    }
}



*/
