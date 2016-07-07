package xyz.lklinker.giphy_api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GiphyTrendsQueryBuilderTest {

    private static final String BASE_URI = "http://api.giphy.com/v1/gifs/trending?api_key=dc6zaTOxFJmzC";

    private GiphyQueryBuilder.EndPoint endPoint = GiphyQueryBuilder.EndPoint.TRENDS;
    private GiphyQueryBuilder queryBuilder = new GiphyQueryBuilder(endPoint);

    @Test
    public void test_trendQuery_noArgs() {
        assertEquals(BASE_URI, queryBuilder.build());
    }

    @Test
    public void test_trendQuery_limit() {
        queryBuilder.setLimit(100);
        assertEquals(BASE_URI + "&limit=100", queryBuilder.build());
    }
}