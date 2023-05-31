package com.livetv.footballscore.livescores.activity;

import static com.pesonal.adsdk.AppManage.ADMOB_N;
import static com.pesonal.adsdk.AppManage.FACEBOOK_N;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.livetv.footballscore.livescores.R;
import com.livetv.footballscore.livescores.adapter.BasicListAdapter;
import com.livetv.footballscore.livescores.model.CountryAppStart;
import com.livetv.footballscore.livescores.model.LeagueAppStart;
import com.livetv.footballscore.livescores.util.DividerItemDecoration;
import com.livetv.footballscore.livescores.util.ViewHolder;
import com.pesonal.adsdk.AppManage;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import cz.msebera.android.httpclient.message.TokenParser;

public class footballscore_LeagueListActivity extends AppCompatActivity {
    /* access modifiers changed from: private */
    LinearLayout adView;
    public CountryAppStart country;
    /* access modifiers changed from: private */
    private RecyclerView leagueList;
    public ArrayList<LeagueAppStart> leagues = new ArrayList<>();
    private BasicListAdapter<LeagueAppStart, LeagueListViewHolder> leaguesListAdapter;

    public int pos;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.footballscore_list);
        AppManage.getInstance(footballscore_LeagueListActivity.this).showNative((ViewGroup) findViewById(R.id.native_ads), ADMOB_N[0], FACEBOOK_N[0]);
        this.leagueList = (RecyclerView) findViewById(R.id.list);
        this.country = (CountryAppStart) getIntent().getSerializableExtra("country");
        BasicListAdapter r4 = new BasicListAdapter<LeagueAppStart, LeagueListViewHolder>(this.leagues) {
            public LeagueListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
                return new LeagueListViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.footballscore_list_item_country, viewGroup, false));
            }

            public void onBindViewHolder(LeagueListViewHolder leagueListViewHolder, final int i) {
                leagueListViewHolder.countryName.setText(footballscore_LeagueListActivity.this.leagues.get(i).getLeagueName());

                StringBuilder sb = new StringBuilder();
                sb.append("http://static.holoduke.nl/footapi/images/flags/");
                footballscore_LeagueListActivity footthrd_leaguelistactivity = footballscore_LeagueListActivity.this;
                sb.append(footthrd_leaguelistactivity.prepareCountryName(footthrd_leaguelistactivity.country.getCountry()));
                sb.append(".png");
                Picasso.get().load(sb.toString()).into(leagueListViewHolder.countryImage);


                leagueListViewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Intent intent = new Intent(footballscore_LeagueListActivity.this, footballscore_LeagueDetailsActivity.class);
                        intent.putExtra("leagueKey", footballscore_LeagueListActivity.this.leagues.get(i).getKey());
                        footballscore_LeagueListActivity.this.startActivity(intent);
                    }
                });
            }
        };
        this.leaguesListAdapter = r4;
        this.leagueList.setAdapter(r4);
        this.leagueList.setLayoutManager(new LinearLayoutManager(this));
        this.leagueList.addItemDecoration(new DividerItemDecoration(this, 1));
        this.leagues.addAll(this.country.getLeagues());
        this.leaguesListAdapter.notifyDataSetChanged();
    }

    private static class LeagueListViewHolder extends RecyclerView.ViewHolder {
        protected ImageView countryImage;
        protected TextView countryName;
        protected LinearLayout linearLayout;

        public LeagueListViewHolder(View view) {
            super(view);
            this.countryImage = (ImageView) ViewHolder.get(view, R.id.img_team);
            this.countryName = (TextView) ViewHolder.get(view, R.id.tv_team_name);
            this.linearLayout = (LinearLayout) ViewHolder.get(view, R.id.country_layout);
        }
    }

    public String prepareCountryName(String str) {
        return str.replace(TokenParser.SP, '-').toLowerCase();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(footballscore_LeagueListActivity.this, footballscore_MainActivity.class);
        finish();
    }
}
