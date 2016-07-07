package xyz.lklinker.giphy_api;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GiphySearchQueryBuilderTest {

    private static final String BASE_URI = "http://api.giphy.com/v1/gifs/search?api_key=dc6zaTOxFJmzC";

    private GiphyQueryBuilder.EndPoint endPoint = GiphyQueryBuilder.EndPoint.SEARCH;
    private GiphyQueryBuilder queryBuilder = new GiphyQueryBuilder(endPoint);

    @Test(expected = IllegalArgumentException.class)
    public void test_searchQuery_noArgs() {
        // we need a query arg
        queryBuilder.build();
    }

    @Test
    public void test_searchQuery() {
        queryBuilder.setQuery("test");
        assertEquals(BASE_URI + "&q=test", queryBuilder.build());
    }

    @Test
    public void test_trendQuery_limit() {
        queryBuilder.setQuery("test")
                .setLimit(100);
        assertEquals(BASE_URI + "&q=test&limit=100", queryBuilder.build());
    }

}
