package com.livetv.footballscore.livescores.activity;

import static com.pesonal.adsdk.AppManage.ADMOB_N;
import static com.pesonal.adsdk.AppManage.FACEBOOK_N;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.livetv.footballscore.livescores.R;
import com.livetv.footballscore.livescores.adapter.BasicListAdapter;
import com.livetv.footballscore.livescores.model.Player;
import com.livetv.footballscore.livescores.model.Statistic;
import com.livetv.footballscore.livescores.service.DefaultMessageHandler;
import com.livetv.footballscore.livescores.service.NetworkService;
import com.livetv.footballscore.livescores.util.ViewHolder;
import com.pesonal.adsdk.AppManage;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class footballscore_PlayerInfoActivity extends AppCompatActivity {
    LinearLayout adView;
    public TextView age;
    public TextView birthPlace;
    public TextView height;
    public TextView nationality;

    private NetworkService networkService = new NetworkService();
    public ImageView playerImage;
    private RecyclerView playerStatList;
    public BasicListAdapter<Statistic, PlayerStatViewHolder> playerStatListAdapter;
    public ArrayList<Statistic> playerStats = new ArrayList<>();
    public TextView position;
    public TextView team;
    public TextView weight;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.footballscore_activity_player_info);
        AppManage.getInstance(footballscore_PlayerInfoActivity.this).showNative((ViewGroup) findViewById(R.id.native_ads), ADMOB_N[0], FACEBOOK_N[0]);
        this.age = (TextView) findViewById(R.id.tv_player_age);
        this.birthPlace = (TextView) findViewById(R.id.tv_player_birthplace);
        this.height = (TextView) findViewById(R.id.tv_player_height);
        this.nationality = (TextView) findViewById(R.id.tv_player_nationality);
        this.playerImage = (ImageView) findViewById(R.id.img_player);
        this.playerStatList = (RecyclerView) findViewById(R.id.player_stat_list);
        this.position = (TextView) findViewById(R.id.tv_player_position);
        this.team = (TextView) findViewById(R.id.tv_player_team);
        this.weight = (TextView) findViewById(R.id.tv_player_weight);
        BasicListAdapter r4 = new BasicListAdapter<Statistic, PlayerStatViewHolder>(this.playerStats) {
            public PlayerStatViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
                return new PlayerStatViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.footballscore_player_stat_list_item, viewGroup, false));
            }

            public void onBindViewHolder(PlayerStatViewHolder playerStatViewHolder, int i) {
                Statistic statistic = footballscore_PlayerInfoActivity.this.playerStats.get(i);
                playerStatViewHolder.season.setText(statistic.getSeason());
                playerStatViewHolder.goals.setText(statistic.getGoals());
                playerStatViewHolder.yellowCards.setText(statistic.getYellowCards());
                playerStatViewHolder.redCards.setText(statistic.getRedCards());
                playerStatViewHolder.time.setText(statistic.getMinutes());
                playerStatViewHolder.subIn.setText(statistic.getSubstituteIn());
                playerStatViewHolder.subOut.setText(statistic.getSubstituteOut());
                playerStatViewHolder.lineups.setText(statistic.getLineups());
                playerStatViewHolder.sidelined.setText(statistic.getSubstitutesOnBench());
                playerStatViewHolder.country.setText(statistic.getName());
                playerStatViewHolder.leagueName.setText(statistic.getLeague());

                Picasso.get().load("http://static.holoduke.nl/footapi/images/teams_gs/" + statistic.getTeamId() + "_small.png").into(playerStatViewHolder.teamImage);
                playerStatViewHolder.playerStatCard.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                    }
                });
            }
        };
        this.playerStatListAdapter = r4;
        this.playerStatList.setAdapter(r4);
        this.playerStatList.setLayoutManager(new LinearLayoutManager(this));
        Log.d("Constants.TAG", "http://static.holoduke.nl/footapi/players/" + getIntent().getStringExtra("playerId") + ".json");
        this.networkService.fetchPlayerCareer(getIntent().getStringExtra("playerId"), new DefaultMessageHandler(this, true) {
            public void onSuccess(Message message) {
                Player player = (Player) message.obj;
                Log.d("Constants.TAG", player.toString());
                footballscore_PlayerInfoActivity.this.setTitle(player.getName());
                footballscore_PlayerInfoActivity footthrd_playerinfoactivity = footballscore_PlayerInfoActivity.this;
                footthrd_playerinfoactivity.setBasicInfo(footthrd_playerinfoactivity.age, "Age", player.getAge());
                footballscore_PlayerInfoActivity footthrd_playerinfoactivity2 = footballscore_PlayerInfoActivity.this;
                footthrd_playerinfoactivity2.setBasicInfo(footthrd_playerinfoactivity2.nationality, "Nationality", player.getNationality());
                footballscore_PlayerInfoActivity footthrd_playerinfoactivity3 = footballscore_PlayerInfoActivity.this;
                footthrd_playerinfoactivity3.setBasicInfo(footthrd_playerinfoactivity3.birthPlace, "Birth Place", player.getBirthPlace());
                footballscore_PlayerInfoActivity footthrd_playerinfoactivity4 = footballscore_PlayerInfoActivity.this;
                footthrd_playerinfoactivity4.setBasicInfo(footthrd_playerinfoactivity4.position, "Position", player.getPosition());
                footballscore_PlayerInfoActivity footthrd_playerinfoactivity5 = footballscore_PlayerInfoActivity.this;
                footthrd_playerinfoactivity5.setBasicInfo(footthrd_playerinfoactivity5.team, "Team", player.getTeam());
                footballscore_PlayerInfoActivity footthrd_playerinfoactivity6 = footballscore_PlayerInfoActivity.this;
                footthrd_playerinfoactivity6.setBasicInfo(footthrd_playerinfoactivity6.weight, "Weight", player.getWeight());
                footballscore_PlayerInfoActivity footthrd_playerinfoactivity7 = footballscore_PlayerInfoActivity.this;
                footthrd_playerinfoactivity7.setBasicInfo(footthrd_playerinfoactivity7.height, "Height", player.getHeight());
                try {

                   Picasso.get().load("http://static.holoduke.nl/footapi/images/playerimages/" + player.getId() + ".png").into(footballscore_PlayerInfoActivity.this.playerImage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                footballscore_PlayerInfoActivity.this.playerStats.addAll(player.getStatistics());
                footballscore_PlayerInfoActivity.this.playerStats.addAll(player.getStatisticsCups());
                footballscore_PlayerInfoActivity.this.playerStats.addAll(player.getStatisticsCupsIntl());
                footballscore_PlayerInfoActivity.this.playerStats.addAll(player.getStatisticsIntl());
                footballscore_PlayerInfoActivity.this.playerStatListAdapter.notifyDataSetChanged();
            }
        });
    }

    public void setBasicInfo(TextView textView, String str, String str2) {
        if (str2 != null) {
            textView.setText(Html.fromHtml("<b>" + str + ":</b> " + str2));
            return;
        }
        textView.setText(Html.fromHtml("<b>" + str + ":</b> "));
    }

    private static class PlayerStatViewHolder extends RecyclerView.ViewHolder {
        protected TextView country;
        protected TextView goals;
        protected TextView leagueName;
        protected TextView lineups;
        protected CardView playerStatCard;
        protected TextView redCards;
        protected TextView season;
        protected TextView sidelined;
        protected TextView subIn;
        protected TextView subOut;
        protected ImageView teamImage;
        protected TextView time;
        protected TextView yellowCards;

        public PlayerStatViewHolder(View view) {
            super(view);
            this.season = (TextView) ViewHolder.get(view, R.id.tv_season);
            this.goals = (TextView) ViewHolder.get(view, R.id.tv_goals);
            this.yellowCards = (TextView) ViewHolder.get(view, R.id.tv_yellowCards);
            this.redCards = (TextView) ViewHolder.get(view, R.id.tv_redCards);
            this.time = (TextView) ViewHolder.get(view, R.id.tv_time);
            this.subIn = (TextView) ViewHolder.get(view, R.id.tv_sub_in);
            this.subOut = (TextView) ViewHolder.get(view, R.id.tv_sub_out);
            this.lineups = (TextView) ViewHolder.get(view, R.id.tv_lineup);
            this.sidelined = (TextView) ViewHolder.get(view, R.id.tv_sidelined);
            this.teamImage = (ImageView) ViewHolder.get(view, R.id.img_team);
            this.country = (TextView) ViewHolder.get(view, R.id.tv_country);
            this.leagueName = (TextView) ViewHolder.get(view, R.id.tv_league_name);
            this.playerStatCard = (CardView) ViewHolder.get(view, R.id.player_stat_card);
        }
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
        AppManage.getInstance(footballscore_PlayerInfoActivity.this).showBackPressAd(footballscore_PlayerInfoActivity.this, new AppManage.MyCallback() {
            @Override
            public void callbackCall() {
                Intent intent = new Intent(footballscore_PlayerInfoActivity.this, footballscore_MatchDetailsActivity.class);
                finish();
            }
        });
    }
}
