package ph.com.bilinear.ccf_mobile.view.events;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ph.com.bilinear.ccf_mobile.R;
import ph.com.bilinear.ccf_mobile.data.vo.Event;

/**
 * Created by jtampinco on 3/21/2017.
 */

public class EventDetailsFragment extends Fragment {

    private Event event;

    public EventDetailsFragment newInstance(Event event) {
        Bundle args = new Bundle();
        EventDetailsFragment fragment = new EventDetailsFragment();
        fragment.setArguments(args);
        this.event = event;
        return fragment;
    }
    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events_details, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
