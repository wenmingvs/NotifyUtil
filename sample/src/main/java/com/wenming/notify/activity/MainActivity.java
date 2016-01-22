package com.wenming.notify.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.wenming.notify.R;
import com.wenming.notify.adapter.ViewPagerAdapter;
import com.wenming.notify.fragment.OneFragment;
import com.wenming.notify.fragment.ProfileFragment;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;
        initToolBar();
        initTabViewPager();
    }

    private void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setVisibility(View.GONE);
    }

    private void initTabViewPager() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new OneFragment(mContext), getString(R.string.tab2));
        adapter.addFragment(new ProfileFragment(), getString(R.string.tab3));
        viewPager.setAdapter(adapter);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setCurrentItem(0, false);

    }

}
