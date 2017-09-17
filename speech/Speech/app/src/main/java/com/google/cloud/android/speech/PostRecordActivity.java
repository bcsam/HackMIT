package com.google.cloud.android.speech;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brentsamuels on 9/16/17.
 */

public class PostRecordActivity extends AppCompatActivity {

    String transcript;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_record);
        transcript = getIntent().getStringExtra("transcript");
        //AnalyzerClient client = new AnalyzerClient();
        //client.getScores(transcript);

        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new TranscriptFragment(), "Transcript", "postRecord");
        adapter.addFrag(new KeywordFragment(), "Keywords", "postRecord");
        adapter.addFrag(new ConceptFragment(), "Concepts", "postRecord");
        adapter.addFrag(new EntitiesFragment(), "Entities", "postRecord");

        viewPager.setAdapter(adapter);
        TabLayout mTabLayout = (TabLayout) findViewById(R.id.pager_header);
        mTabLayout.setupWithViewPager(viewPager);
    }

    class ViewPagerAdapter extends FragmentStatePagerAdapter{
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title, String activity){
            Bundle bundle = new Bundle();
            bundle.putString("transcript", transcript);
            fragment.setArguments(bundle);
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }

    }
}
