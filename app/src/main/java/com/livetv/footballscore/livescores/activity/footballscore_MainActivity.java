package com.livetv.footballscore.livescores.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.livetv.footballscore.livescores.R;
import com.livetv.footballscore.livescores.fragments.HomeFragment;
import com.livetv.footballscore.livescores.fragments.LiveScoreFragment;
import com.livetv.footballscore.livescores.fragments.NewsFragment;
import com.pesonal.adsdk.AppManage;

public class footballscore_MainActivity extends AppCompatActivity {
    LinearLayout adView;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private TabLayout tabLayout;
    String[] titleText = {"Home", "News", "Live Score"};
    Toolbar toolbar;
    private String version = "";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.footballscore_activity_main);
        Toolbar toolbar2 = (Toolbar) findViewById(R.id.toolbar);
        this.toolbar = toolbar2;
        setSupportActionBar(toolbar2);

        this.mViewPager = (ViewPager) findViewById(R.id.pager);
        this.tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        this.mSectionsPagerAdapter = sectionsPagerAdapter;
        this.mViewPager.setAdapter(sectionsPagerAdapter);
        this.tabLayout.setupWithViewPager(this.mViewPager);
        try {
            this.version = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        public SectionsPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        public Fragment getItem(int i) {
            if (i == 0) {
                return new HomeFragment();
            }
            if (i == 1) {
                return new NewsFragment();
            }
            return new LiveScoreFragment();
        }

        public int getCount() {
            return footballscore_MainActivity.this.titleText.length;
        }

        public CharSequence getPageTitle(int i) {
            return footballscore_MainActivity.this.titleText[i];
        }
    }

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        AppManage.getInstance(footballscore_MainActivity.this).showInterstitialAd(footballscore_MainActivity.this, new AppManage.MyCallback() {
            public void callbackCall() {
                startActivity(new Intent(getApplicationContext(), footballscore_FirstActivity.class));
            }
        }, "", AppManage.app_mainClickCntSwAd);
    }
}