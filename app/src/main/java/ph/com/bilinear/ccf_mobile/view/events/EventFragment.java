package ph.com.bilinear.ccf_mobile.view.events;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ph.com.bilinear.ccf_mobile.R;
import ph.com.bilinear.ccf_mobile.data.vo.Event;

/**
 * Created by jtampinco on 3/16/2017.
 */

public class EventFragment extends Fragment {

    private ViewPager viewPager;

    public EventFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        viewPager = (ViewPager) container;
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        showEventList();
    }

    public void showEventList(){
        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        EventListFragment eventListFragment = new EventListFragment();
        fragmentTransaction.replace(R.id.fragment_container, eventListFragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_NONE);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void showEventDetails(Event event){
        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        EventDetailsFragment eventDetailsFragment = new EventDetailsFragment().newInstance(event);
        fragmentTransaction.replace(R.id.fragment_container, eventDetailsFragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.disallowAddToBackStack();
        fragmentTransaction.commit();
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
