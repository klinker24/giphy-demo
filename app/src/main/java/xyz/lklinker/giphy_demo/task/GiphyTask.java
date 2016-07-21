package xyz.lklinker.giphy_demo.task;

import android.os.AsyncTask;

import java.util.List;

import xyz.lklinker.giphy_api.Gif;
import xyz.lklinker.giphy_api.GiphyApi;

public class GiphyTask extends AsyncTask<Void, Void, List<Gif>> {

    public interface Callback {
        void onResponse(List<Gif> gifs);
    }

    private GiphyApi api;

    private String queryUri;
    private Callback callback;

    public GiphyTask(String queryUri, Callback callback) {
        this.queryUri = queryUri;
        this.callback = callback;
        this.api = new GiphyApi();
    }

    // android will crash if you try to perform network calls on the UI thread. Since these calls are
    // blocking, they would force the app to be suspended, which isn't something the system allows

    // we want to add a doInBackground method and an onPostExecute method
    // these two methods are used in an async task to perform callbacks to the UI.
    // after your background method finishes, it will return whatever arguments it has created
    // to the onPostExecute method.

    // the return for the doInBackground method is defined by the last argument of the templated AsyncTask implementation
    // The arguments for the onPostExecute method correspond to what is returned by the background method.


    // use the api and the callback objects to implement these two methods.
}