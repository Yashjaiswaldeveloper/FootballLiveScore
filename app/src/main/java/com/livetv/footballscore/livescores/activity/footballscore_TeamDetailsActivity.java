package com.livetv.footballscore.livescores.activity;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.MenuItem;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.livetv.footballscore.livescores.R;
import com.livetv.footballscore.livescores.fragments.SquadFragment;
import com.livetv.footballscore.livescores.fragments.TeamInfoFragment;
import com.livetv.footballscore.livescores.fragments.TransferFragment;
import com.livetv.footballscore.livescores.model.Team;
import com.livetv.footballscore.livescores.service.DefaultMessageHandler;
import com.livetv.footballscore.livescores.service.NetworkService;

public class footballscore_TeamDetailsActivity extends AppCompatActivity {
    LinearLayout adView;
    public SectionsPagerAdapter mSectionsPagerAdapter;
    public ViewPager mViewPager;
    private NetworkService networkService = new NetworkService();
    public TabLayout tabLayout;
    public Team team;
    String[] titleText = {"Team Info", "Squad", "Transfers"};

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.footballscore_activity_league_details);
        this.mViewPager = (ViewPager) findViewById(R.id.pager);
        this.tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        Log.d("Constants.TAG", "http://static.holoduke.nl/footapi/team_gs/" + getIntent().getStringExtra("teamKey") + ".json");
        this.networkService.fetchTeamDetails(getIntent().getStringExtra("teamKey"), new DefaultMessageHandler(this, true) {
            public void onSuccess(Message message) {
                footballscore_TeamDetailsActivity.this.team = (Team) message.obj;
                footballscore_TeamDetailsActivity footthrd_teamdetailsactivity = footballscore_TeamDetailsActivity.this;
                footthrd_teamdetailsactivity.setTitle(footthrd_teamdetailsactivity.team.getTeamName());
                footballscore_TeamDetailsActivity footthrd_teamdetailsactivity2 = footballscore_TeamDetailsActivity.this;
                footthrd_teamdetailsactivity2.mSectionsPagerAdapter = new SectionsPagerAdapter(footthrd_teamdetailsactivity2.getSupportFragmentManager());
                footballscore_TeamDetailsActivity.this.mViewPager.setAdapter(footballscore_TeamDetailsActivity.this.mSectionsPagerAdapter);
                footballscore_TeamDetailsActivity.this.tabLayout.setupWithViewPager(footballscore_TeamDetailsActivity.this.mViewPager);
            }
        });
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        public SectionsPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        public Fragment getItem(int i) {
            if (i == 0) {
                TeamInfoFragment teamInfoFragment = new TeamInfoFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("teamDetails", footballscore_TeamDetailsActivity.this.team);
                teamInfoFragment.setArguments(bundle);
                return teamInfoFragment;
            } else if (i == 1) {
                SquadFragment squadFragment = new SquadFragment();
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("teamDetails", footballscore_TeamDetailsActivity.this.team);
                squadFragment.setArguments(bundle2);
                return squadFragment;
            } else {
                TransferFragment transferFragment = new TransferFragment();
                Bundle bundle3 = new Bundle();
                bundle3.putSerializable("teamDetails", footballscore_TeamDetailsActivity.this.team);
                transferFragment.setArguments(bundle3);
                return transferFragment;
            }
        }

        public int getCount() {
            return footballscore_TeamDetailsActivity.this.titleText.length;
        }

        public CharSequence getPageTitle(int i) {
            return footballscore_TeamDetailsActivity.this.titleText[i];
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }
}
