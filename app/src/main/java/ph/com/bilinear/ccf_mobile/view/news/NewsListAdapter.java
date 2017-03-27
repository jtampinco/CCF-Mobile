package ph.com.bilinear.ccf_mobile.view.news;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import ph.com.bilinear.ccf_mobile.R;
import ph.com.bilinear.ccf_mobile.data.vo.Event;
import ph.com.bilinear.ccf_mobile.data.vo.Podcast;

/**
 * Created by jtampinco on 3/20/2017.
 */

public class NewsListAdapter extends ArrayAdapter<Object> {

    private Context context;
    private ArrayList<Object> objects;

    public NewsListAdapter(Context context, int resource, ArrayList<Object> objects){
        super(context, resource, objects);
        this.context = context;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //get the inflater and inflate the XML layout for each item
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_news, null);

        TextView tvDate = (TextView) view.findViewById(R.id.tv_date);
        TextView tvMonth = (TextView) view.findViewById(R.id.tv_month);
        TextView tvTitle = (TextView) view.findViewById(R.id.tv_title);
        TextView tvDescription = (TextView) view.findViewById(R.id.tv_description);
        LinearLayout holderLinks = (LinearLayout) view.findViewById(R.id.holder_links);
        TextView tvType = (TextView) view.findViewById(R.id.tv_type);

        Object object = objects.get(position);
        if(object instanceof Event){
            Event event = (Event) object;
            tvDate.setText(event.getTimestampDay());
            tvMonth.setText(event.getTimestampMonth());
            tvTitle.setText(event.getTitle());
            tvDescription.setText(event.getContent());
            if(!event.getLocation().equals("")){
                TextView location = new TextView(context);
                formatLinkTextView(location, event.getLocation(), ContextCompat.getDrawable(context, R.drawable.ic_place_grey_10dp));
                holderLinks.addView(location);
            }if(!event.getDate().equals("")){
                TextView date = new TextView(context);
                formatLinkTextView(date, event.getDate(), ContextCompat.getDrawable(context, R.drawable.ic_date_grey_10dp));
                holderLinks.addView(date);
            }if(!event.getTime().equals("")){
                TextView time = new TextView(context);
                formatLinkTextView(time, event.getTime(), ContextCompat.getDrawable(context, R.drawable.ic_time_grey_10dp));
                holderLinks.addView(time);
            }
            tvType.setText("EVENTS");
        }else if(object instanceof Podcast){
            Podcast podcast = (Podcast) object;
            tvDate.setText(podcast.getTimestampDay());
            tvMonth.setText(podcast.getTimestampMonth());
            tvTitle.setText(podcast.getTitle());
            tvDescription.setText(podcast.getContent());
            if(!podcast.getSpeaker().equals("")){
                TextView speaker = new TextView(context);
                formatLinkTextView(speaker, podcast.getSpeaker(), ContextCompat.getDrawable(context, R.drawable.ic_mic_grey_10dp));
                holderLinks.addView(speaker);
            }
            tvType.setText("PODCAST");
        }

        return view;
    }

    private void formatLinkTextView(TextView view, String text, Drawable drawable){
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        int margin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, context.getResources().getDisplayMetrics());
        params.setMargins(0, 0, margin, 0);
        view.setLayoutParams(params);

        view.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
        view.setCompoundDrawablePadding(4);

        view.setText(text.toUpperCase());
        view.setTextColor(ContextCompat.getColor(context, R.color.text_grey));
        view.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);

        int maxWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 140, context.getResources().getDisplayMetrics());
        view.setMaxWidth(maxWidth);
        view.setMaxLines(1);
        view.setEllipsize(TextUtils.TruncateAt.END);
    }

}
