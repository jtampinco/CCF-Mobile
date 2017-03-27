package ph.com.bilinear.ccf_mobile.view.events;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import ph.com.bilinear.ccf_mobile.R;
import ph.com.bilinear.ccf_mobile.data.vo.Event;

/**
 * Created by jtampinco on 3/21/2017.
 */

public class EventListFragment extends Fragment {

    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events_list, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = (ListView) view.findViewById(R.id.list_events);
        listView.setAdapter(new EventListAdapter(getActivity(), R.layout.item_events, generateSampleData(), this));
    }

    private ArrayList<Event> generateSampleData(){
        ArrayList<Event> events = new ArrayList<>();
        events.add(new Event(null, null, ContextCompat.getDrawable(getActivity(), R.drawable.iv_temp_events_1), "CCF Center", "NOVEMBER 5", "8:00 AM", null, null, null, null));
        events.add(new Event(null, null, ContextCompat.getDrawable(getActivity(), R.drawable.iv_temp_events_2), "CCF Center", "OCTOBER 20", "7:00 PM - 10:00 PM", null, null, null, null));
        events.add(new Event(null, null, ContextCompat.getDrawable(getActivity(), R.drawable.iv_temp_events_3), "CCF Center", "OCTOBER 21-23", "8:00 AM", null, null, null, null));
        events.add(new Event(null, null, ContextCompat.getDrawable(getActivity(), R.drawable.iv_temp_events_4), "CCF Center", "OCTOBER 21-23", "8:00 AM", null, null, null, null));
        events.add(new Event(null, null, ContextCompat.getDrawable(getActivity(), R.drawable.iv_temp_events_5), "CCF Center", "OCTOBER 21-23", "8:00 AM", null, null, null, null));
        return events;
    }

    public void replaceFragment(Event event){
        ((EventFragment)getParentFragment()).showEventDetails(event);
    }

}