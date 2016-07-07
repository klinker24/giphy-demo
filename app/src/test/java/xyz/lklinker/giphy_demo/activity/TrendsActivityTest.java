package xyz.lklinker.giphy_demo.activity;

import android.support.v7.widget.GridLayoutManager;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import xyz.lklinker.giphy_demo.BuildConfig;

import static org.junit.Assert.*;


@RunWith(RobolectricGradleTestRunner.class)
@Config(sdk = 21, constants = BuildConfig.class)
public class TrendsActivityTest {

    private TrendsActivity activity;

    @Before
    public void setup() {
        activity = Robolectric.buildActivity(TrendsActivity.class).create().get();
    }

    @Test
    public void test_viewsCreated() {
        assertNotNull(activity.getRecyclerView());
    }

    @Test
    public void test_queryUri() {
        assertEquals("http://api.giphy.com/v1/gifs/trending?api_key=dc6zaTOxFJmzC", activity.getGiphyQueryUrl());
    }

    @Test
    public void test_layoutManager() {
        assertThat(activity.getRecyclerView().getLayoutManager(), CoreMatchers.instanceOf(GridLayoutManager.class));
    }

    @Test
    public void test_adapterSet() {
        assertNotNull(activity.getRecyclerView().getAdapter());
        assertEquals(activity.getAdapter(), activity.getRecyclerView().getAdapter());
    }
}