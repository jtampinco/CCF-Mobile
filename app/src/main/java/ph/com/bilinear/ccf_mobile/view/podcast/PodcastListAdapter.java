package ph.com.bilinear.ccf_mobile.view.podcast;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ph.com.bilinear.ccf_mobile.R;
import ph.com.bilinear.ccf_mobile.data.vo.Podcast;

/**
 * Created by jtampinco on 3/20/2017.
 */

public class PodcastListAdapter extends ArrayAdapter<Podcast> {

    private Context context;
    private ArrayList<Podcast> objects;
    private int resource;


    public PodcastListAdapter(Context context, int resource, ArrayList<Podcast> objects){
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //get the inflater and inflate the XML layout for each item
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(resource, null);

        Podcast podcast = objects.get(position);

        switch(resource){
            case R.layout.item_podcast_latest:
                ImageView ivThumbnail = (ImageView) view.findViewById(R.id.iv_thumbnail);
                TextView tvTitle = (TextView) view.findViewById(R.id.tv_title);
                TextView tvDetails = (TextView) view.findViewById(R.id.tv_details);
                TextView tvSpeaker = (TextView) view.findViewById(R.id.tv_speaker);
                TextView tvDate = (TextView) view.findViewById(R.id.tv_date);
                ivThumbnail.setImageDrawable(podcast.getThumbnail());
                tvTitle.setText(podcast.getTitle());
                tvDetails.setText(podcast.getContent());
                tvSpeaker.setText(podcast.getSpeaker());
                tvDate.setText(podcast.getDate());
                break;
            case R.layout.item_podcast_categories:
                ImageView ivBanner = (ImageView) view.findViewById(R.id.iv_banner);
                ivBanner.setImageDrawable(podcast.getBanner());
                break;
            default:
                break;
        }

        return view;
    }
}
