package com.core.erp.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArticleTest {

    @Test
    public void shouldFallback_WhenCsvLineIsMissingFields() {
        // Testing with a broken string (only 2 fields instead of 5)
        String corruptedCsv = "ART-999;JEANS";

        Article article = new Article(corruptedCsv);

        // It shouldn't crash, it should just set default error values
        assertEquals("ERR-404", article.getId());
        assertEquals("INVALID", article.getName());
        assertEquals(0.0, article.getPrice());
    }

    @Test
    public void shouldFallback_WhenCsvLineIsNull() {
        // Testing what happens if the input is completely null
        String nullCsv = null;

        Article article = new Article(nullCsv);

        // Make sure it doesn't throw a NullPointerException
        assertEquals("ERR-404", article.getId());
        assertEquals("UNKNOWN", article.getColor());
        assertEquals(0.0, article.getPrice());
    }
}