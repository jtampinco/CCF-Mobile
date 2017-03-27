package ph.com.bilinear.ccf_mobile.view.news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import ph.com.bilinear.ccf_mobile.R;
import ph.com.bilinear.ccf_mobile.data.DataManager;
import ph.com.bilinear.ccf_mobile.data.vo.Event;
import ph.com.bilinear.ccf_mobile.data.vo.News;
import ph.com.bilinear.ccf_mobile.data.vo.Podcast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jtampinco 3/16/2017
 */
public class NewsFragment extends Fragment {

    private ListView listView;
    private DataManager dataManager;


    public NewsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        listView = (ListView) view.findViewById(R.id.list_news);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView.setAdapter(new NewsListAdapter(getActivity(), R.layout.item_news, generateSampleData()));

        dataManager = new DataManager();
        Call<News> callNews = dataManager.getNewsService().getNewsfeedItem(1);
        callNews.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                if(response.isSuccessful()){

                }
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {

            }
        });


    }

    private ArrayList<Object> generateSampleData(){
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(new Event("Youth Gathering", null, null, "CCF Center", "NOV 5", "8:00 AM",  getString(R.string.lorem_1), null, null, null));
        objects.add(new Podcast(getString(R.string.podcast_title_1), null, null, "Peter Tanchi", "CCF Center", null, null, getString(R.string.podcast_content_1), null, null, null));
        objects.add(new Podcast(getString(R.string.podcast_title_2), null, null, "Paultan Chi", "CCF Center", null, null,  getString(R.string.podcast_content_2), null, null, null));
        objects.add(new Podcast(getString(R.string.podcast_title_3), null, null, "Ricky Sarthough", "CCF Center", null, null, getString(R.string.podcast_content_3), null, null, null));
        objects.add(new Event("Youth Gathering", null, null, "CCF Center", "Nov 6", "8:00 AM", getString(R.string.lorem_1), null, null, null));
        objects.add(new Podcast(getString(R.string.podcast_title_1), null, null, "Peter Tanchi", "CCF Center", null, null,  getString(R.string.podcast_content_1), null, null, null));
        objects.add(new Podcast(getString(R.string.podcast_title_2), null, null, "Paultan Chi", "CCF Center", null, null,  getString(R.string.podcast_content_2), null, null, null));
        objects.add(new Podcast(getString(R.string.podcast_title_3), null, null, "Ricky Sarthough", "CCF Center", null, null,  getString(R.string.podcast_content_3), null, null, null));
        return objects;
    }

}
