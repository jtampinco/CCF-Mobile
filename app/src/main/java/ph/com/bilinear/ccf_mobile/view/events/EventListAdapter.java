package ph.com.bilinear.ccf_mobile.view.events;

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
import ph.com.bilinear.ccf_mobile.data.vo.Event;

/**
 * Created by jtampinco on 3/21/2017.
 */

public class EventListAdapter extends ArrayAdapter<Event> {

    private Context context;
    private int resource;
    private ArrayList<Event> objects;
    private EventListFragment baseFragment;

    public EventListAdapter(Context context, int resource, ArrayList<Event> objects, EventListFragment baseFragment){
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
        this.baseFragment = baseFragment;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //get the inflater and inflate the XML layout for each item
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(resource, null);

        ImageView ivBanner = (ImageView) view.findViewById(R.id.iv_banner);
        final TextView tvLocation = (TextView) view.findViewById(R.id.tv_location);
        TextView tvDate = (TextView) view.findViewById(R.id.tv_date);
        TextView tvTime = (TextView) view.findViewById(R.id.tv_time);

        final Event event = objects.get(position);
        ivBanner.setImageDrawable(event.getBanner());
        tvLocation.setText(event.getLocation());
        tvDate.setText(event.getDate());
        tvTime.setText(event.getTime());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                baseFragment.replaceFragment(event);
            }
        });

        return view;
    }


}
