package ph.com.bilinear.ccf_mobile.view.podcast;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import ph.com.bilinear.ccf_mobile.R;
import ph.com.bilinear.ccf_mobile.data.vo.Podcast;

/**
 * Created by jtampinco on 3/16/2017.
 */

public class PodcastFragment extends Fragment implements View.OnClickListener{

    private ListView listView;
    private TextView tvLatest;
    private TextView tvCategories;

    private int counter;

    public PodcastFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_podcast, container, false);
        listView = (ListView) view.findViewById(R.id.list_podcast);
        tvLatest = (TextView) view.findViewById(R.id.tv_latest);
        tvCategories = (TextView) view.findViewById(R.id.tv_categories);
        counter = 0;
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        refreshPodcastList();
        tvLatest.setOnClickListener(this);
        tvCategories.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.tv_latest:
                counter = 0;
                viewSelected(tvLatest);
                viewUnselected(tvCategories);
                break;
            case R.id.tv_categories:
                counter = 1;
                viewSelected(tvCategories);
                viewUnselected(tvLatest);
                break;
        }
        refreshPodcastList();
    }

    private void viewSelected(TextView view){
        view.setTextColor(Color.WHITE);
        view.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.colorAccent));
    }

    private void viewUnselected(TextView view){
        view.setTextColor(ContextCompat.getColor(getActivity(), R.color.colorAccent));
        view.setBackgroundResource(R.drawable.button_square_accent);
    }

    private void refreshPodcastList(){
        PodcastListAdapter adapter;
        if(counter == 0){
            adapter = new PodcastListAdapter(getActivity(), R.layout.item_podcast_latest,  generateSampleDataLatest());
        }else{
            adapter = new PodcastListAdapter(getActivity(), R.layout.item_podcast_categories, generateSampleDataCategories());
        }
        listView.setAdapter(adapter);
    }

    private ArrayList<Podcast> generateSampleDataLatest(){
        ArrayList<Podcast> objects = new ArrayList<>();
        objects.add(new Podcast(getString(R.string.podcast_title_1), ContextCompat.getDrawable(getActivity(), R.drawable.iv_temp_podcast_1), null, "Peter Tanchi", "CCF Center", "October 21", null, getString(R.string.podcast_content_1), null, null, null));
        objects.add(new Podcast(getString(R.string.podcast_title_2), ContextCompat.getDrawable(getActivity(), R.drawable.iv_temp_podcast_2), null, "Paultan Chi", "CCF Center", "October 21", null,  getString(R.string.podcast_content_2), null, null, null));
        objects.add(new Podcast(getString(R.string.podcast_title_3), ContextCompat.getDrawable(getActivity(), R.drawable.iv_temp_podcast_3), null, "Ricky Sarthough", "CCF Center", "October 21", null, getString(R.string.podcast_content_3), null, null, null));
        objects.add(new Podcast(getString(R.string.podcast_title_1), ContextCompat.getDrawable(getActivity(), R.drawable.iv_temp_podcast_1), null, "Peter Tanchi", "CCF Center", "October 21", null,  getString(R.string.podcast_content_1), null, null, null));
        objects.add(new Podcast(getString(R.string.podcast_title_2), ContextCompat.getDrawable(getActivity(), R.drawable.iv_temp_podcast_2), null, "Paultan Chi", "CCF Center", "October 21", null,  getString(R.string.podcast_content_2), null, null, null));
        objects.add(new Podcast(getString(R.string.podcast_title_3), ContextCompat.getDrawable(getActivity(), R.drawable.iv_temp_podcast_3), null, "Ricky Sarthough", "CCF Center", "October 21", null,  getString(R.string.podcast_content_3), null, null, null));
        return objects;
    }

    private ArrayList<Podcast> generateSampleDataCategories(){
        ArrayList<Podcast> objects = new ArrayList<>();
        objects.add(new Podcast("Jesus is Lord of Life: Trust him", null, ContextCompat.getDrawable(getActivity(), R.drawable.iv_temp_podcast_cat_1), "Peter Tanchi", "CCF Center", null, null, getString(R.string.lorem_1), null, null, null));
        objects.add(new Podcast("Jesus is the Sheperd: Depend on him", null, ContextCompat.getDrawable(getActivity(), R.drawable.iv_temp_podcast_cat_2), "Paultan Chi", "CCF Center", null, null,  getString(R.string.lorem_1), null, null, null));
        objects.add(new Podcast("Jesus is the Light: come and see", null, ContextCompat.getDrawable(getActivity(), R.drawable.iv_temp_podcast_cat_3), "Ricky Sarthough", "CCF Center", null, null, getString(R.string.lorem_1), null, null, null));
        objects.add(new Podcast("Jesus is Lord of Life: Trust him", null, ContextCompat.getDrawable(getActivity(), R.drawable.iv_temp_podcast_cat_1), "Peter Tanchi", "CCF Center", null, null,  getString(R.string.lorem_1), null, null, null));
        return objects;
    }
}
