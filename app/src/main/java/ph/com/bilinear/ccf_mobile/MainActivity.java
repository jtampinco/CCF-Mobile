package ph.com.bilinear.ccf_mobile;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import ph.com.bilinear.ccf_mobile.view.events.EventFragment;
import ph.com.bilinear.ccf_mobile.view.news.NewsFragment;
import ph.com.bilinear.ccf_mobile.view.podcast.PodcastFragment;
import ph.com.bilinear.ccf_mobile.view.satellites.SatellitesFragment;

/**
 * Created by jtampinco 3/16/2017
 */
public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        viewPager = (ViewPager)findViewById(R.id.ViewPager);
        Adapter adapter = new Adapter(getSupportFragmentManager());
        adapter.addFragment(new NewsFragment(), "News");
        adapter.addFragment(new PodcastFragment(), "Podcast");
        adapter.addFragment(new EventFragment(), "Events");
        adapter.addFragment(new SatellitesFragment(), "Satellites");
        adapter.addFragment(new NewsFragment(), "Live");
        adapter.addFragment(new NewsFragment(), "Downloads");
        adapter.addFragment(new NewsFragment(), "Settings");
        viewPager.setAdapter(adapter);


        tabLayout = (TabLayout)findViewById(R.id.TabLayout);
        tabLayout.setupWithViewPager(viewPager);


        // Simple fix to not allow the user to go to the Live, Downloads, and Settings fragments
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position > 3){
                    viewPager.setCurrentItem(0);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    public static class Adapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public Adapter(FragmentManager manager){
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }

        public void addFragment(Fragment fragment, String title){
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

    }

}
