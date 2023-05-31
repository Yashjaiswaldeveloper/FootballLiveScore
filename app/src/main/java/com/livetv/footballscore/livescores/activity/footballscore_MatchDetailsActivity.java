package com.livetv.footballscore.livescores.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.livetv.footballscore.livescores.R;
import com.livetv.footballscore.livescores.fragments.LineupsFragment;
import com.livetv.footballscore.livescores.fragments.MatchInfoFragment;
import com.livetv.footballscore.livescores.model.MatchDetails;
import com.livetv.footballscore.livescores.service.DefaultMessageHandler;
import com.livetv.footballscore.livescores.service.NetworkService;
import com.pesonal.adsdk.AppManage;
import com.squareup.picasso.Picasso;

public class footballscore_MatchDetailsActivity extends AppCompatActivity {
    LinearLayout adView;
    public TextView date;
    public TextView localTeam;
    public ImageView localTeamLogo;
    public SectionsPagerAdapter mSectionsPagerAdapter;
    public ViewPager mViewPager;
    public MatchDetails matchDetails;
    private String matchId;
    private NetworkService networkService = new NetworkService();
    public TextView scoreline;
    public TabLayout tabLayout;
    public TextView time;
    String[] titleText = {"Match Info", "Lineups"};
    public TextView visitorTeam;
    public ImageView visitorTeamLogo;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.footballscore_activity_match_details);
        this.matchId = getIntent().getStringExtra("matchId");
        this.mViewPager = (ViewPager) findViewById(R.id.pager);
        this.tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        this.localTeam = (TextView) findViewById(R.id.tv_local_team);
        this.date = (TextView) findViewById(R.id.tv_date);
        this.localTeamLogo = (ImageView) findViewById(R.id.logo_local_team);
        this.visitorTeamLogo = (ImageView) findViewById(R.id.logo_visitor_team);
        this.scoreline = (TextView) findViewById(R.id.tv_score);
        this.time = (TextView) findViewById(R.id.tv_time);
        this.visitorTeam = (TextView) findViewById(R.id.tv_visitor_team);
        loadData();
    }

    private void loadData() {
        Log.d("Constants.TAG", "http://holoduke.nl/footapi/matches/" + this.matchId + ".json");


        this.networkService.fetchMatchDetails(this.matchId, new DefaultMessageHandler(this, true) {
            public void onSuccess(Message message) {
                footballscore_MatchDetailsActivity.this.matchDetails = (MatchDetails) message.obj;
                footballscore_MatchDetailsActivity footthrd_matchdetailsactivity = footballscore_MatchDetailsActivity.this;
                footthrd_matchdetailsactivity.setTitle(footballscore_MatchDetailsActivity.this.matchDetails.getLocalTeam() + " vs " + footballscore_MatchDetailsActivity.this.matchDetails.getVisitorTeam());
                Log.d("Constants.TAG", footballscore_MatchDetailsActivity.this.matchDetails.toString());
                footballscore_MatchDetailsActivity.this.localTeam.setText(footballscore_MatchDetailsActivity.this.matchDetails.getLocalTeam());
                footballscore_MatchDetailsActivity.this.visitorTeam.setText(footballscore_MatchDetailsActivity.this.matchDetails.getVisitorTeam());
                footballscore_MatchDetailsActivity.this.date.setText(footballscore_MatchDetailsActivity.this.matchDetails.getDate());
                footballscore_MatchDetailsActivity.this.scoreline.setText(footballscore_MatchDetailsActivity.this.matchDetails.getScoreLine());
                if (footballscore_MatchDetailsActivity.this.matchDetails.getStatus().equals("HT") || footballscore_MatchDetailsActivity.this.matchDetails.getStatus().equals("FT")) {
                    footballscore_MatchDetailsActivity.this.time.setText(footballscore_MatchDetailsActivity.this.matchDetails.getStatus());
                } else {
                    TextView textView = footballscore_MatchDetailsActivity.this.time;
                    textView.setText(footballscore_MatchDetailsActivity.this.matchDetails.getStatus() + "'");
                }
                footballscore_MatchDetailsActivity.this.time.setTextColor(ContextCompat.getColor(footballscore_MatchDetailsActivity.this, R.color.Green));

                Picasso get = Picasso.get();
                get.load("http://static.holoduke.nl/footapi/images/teams_gs/" + footballscore_MatchDetailsActivity.this.matchDetails.getLocalTeamId() + "_small.png").into(footballscore_MatchDetailsActivity.this.localTeamLogo);

                Picasso get2 = Picasso.get();
                get2.load("http://static.holoduke.nl/footapi/images/teams_gs/" + footballscore_MatchDetailsActivity.this.matchDetails.getVisitorTeamId() + "_small.png").into(footballscore_MatchDetailsActivity.this.visitorTeamLogo);

                footballscore_MatchDetailsActivity.this.localTeamLogo.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Intent intent = new Intent(footballscore_MatchDetailsActivity.this, footballscore_TeamDetailsActivity.class);
                        intent.putExtra("teamKey", footballscore_MatchDetailsActivity.this.matchDetails.getLocalTeamId());
                        footballscore_MatchDetailsActivity.this.startActivity(intent);
                    }
                });
                footballscore_MatchDetailsActivity.this.visitorTeamLogo.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Intent intent = new Intent(footballscore_MatchDetailsActivity.this, footballscore_TeamDetailsActivity.class);
                        intent.putExtra("teamKey", footballscore_MatchDetailsActivity.this.matchDetails.getVisitorTeamId());
                        footballscore_MatchDetailsActivity.this.startActivity(intent);
                    }
                });
                footballscore_MatchDetailsActivity footthrd_matchdetailsactivity2 = footballscore_MatchDetailsActivity.this;
                footthrd_matchdetailsactivity2.mSectionsPagerAdapter = new SectionsPagerAdapter(footthrd_matchdetailsactivity2.getSupportFragmentManager());
                footballscore_MatchDetailsActivity.this.mViewPager.setAdapter(footballscore_MatchDetailsActivity.this.mSectionsPagerAdapter);
                footballscore_MatchDetailsActivity.this.tabLayout.setupWithViewPager(footballscore_MatchDetailsActivity.this.mViewPager);
            }
        });
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        public SectionsPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        public Fragment getItem(int i) {
            if (i == 0) {
                MatchInfoFragment matchInfoFragment = new MatchInfoFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("matchdetails", footballscore_MatchDetailsActivity.this.matchDetails);
                matchInfoFragment.setArguments(bundle);
                return matchInfoFragment;
            }
            LineupsFragment lineupsFragment = new LineupsFragment();
            Bundle bundle2 = new Bundle();
            bundle2.putSerializable("matchdetails", footballscore_MatchDetailsActivity.this.matchDetails);
            lineupsFragment.setArguments(bundle2);
            return lineupsFragment;
        }

        public int getCount() {
            return footballscore_MatchDetailsActivity.this.titleText.length;
        }

        public CharSequence getPageTitle(int i) {
            return footballscore_MatchDetailsActivity.this.titleText[i];
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.refresh_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            finish();
            return true;
        } else if (itemId != R.id.action_load) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            loadData();
            return true;
        }
    }

    @Override
    public void onBackPressed() {
        AppManage.getInstance(footballscore_MatchDetailsActivity.this).showBackPressAd(footballscore_MatchDetailsActivity.this, new AppManage.MyCallback() {
            @Override
            public void callbackCall() {
                Intent intent = new Intent(footballscore_MatchDetailsActivity.this, footballscore_LeagueDetailsActivity.class);
                finish();
            }
        });
    }
}
