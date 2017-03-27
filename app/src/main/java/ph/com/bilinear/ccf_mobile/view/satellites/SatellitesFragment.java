package ph.com.bilinear.ccf_mobile.view.satellites;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ph.com.bilinear.ccf_mobile.R;

/**
 * Created by jtampinco on 3/16/2017.
 */

public class SatellitesFragment extends Fragment {

    public SatellitesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_satellites, container, false);
    }

}
