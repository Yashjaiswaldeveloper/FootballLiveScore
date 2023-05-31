package com.livetv.footballscore.livescores.fragments;

import static com.pesonal.adsdk.AppManage.ADMOB_N;
import static com.pesonal.adsdk.AppManage.FACEBOOK_N;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.livetv.footballscore.livescores.R;
import com.livetv.footballscore.livescores.activity.footballscore_TeamDetailsActivity;
import com.livetv.footballscore.livescores.adapter.BasicListAdapter;
import com.livetv.footballscore.livescores.model.PointTable;
import com.livetv.footballscore.livescores.model.TeamStanding;
import com.livetv.footballscore.livescores.service.DefaultMessageHandler;
import com.livetv.footballscore.livescores.service.NetworkService;
import com.livetv.footballscore.livescores.util.ViewHolder;
import com.pesonal.adsdk.AppManage;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class StandingFragment extends Fragment {
    private NetworkService networkService = new NetworkService();
    private RecyclerView standingList;
    RelativeLayout native_ads;
    public BasicListAdapter<TeamStanding, StandingViewHolder> standingListAdapter;
    public ArrayList<TeamStanding> standings = new ArrayList<>();
    /* access modifiers changed from: private */
    public TeamStanding tempTeamStanding;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.footballscore_standing_list, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.standingList = (RecyclerView) view.findViewById(R.id.list);
        this.native_ads = view.findViewById(R.id.native_ads);
        AppManage.getInstance(getActivity().getApplicationContext()).showNative((ViewGroup) view.findViewById(R.id.native_ads), ADMOB_N[0], FACEBOOK_N[0]);
        BasicListAdapter r4 = new BasicListAdapter<TeamStanding, StandingViewHolder>(this.standings) {
            public StandingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
                return new StandingViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.footballscore_standing_list_item, viewGroup, false));
            }

            public void onBindViewHolder(StandingViewHolder standingViewHolder, int i) {
                final TeamStanding teamStanding = StandingFragment.this.standings.get(i);
                standingViewHolder.localTeamName.setText(teamStanding.getTeam());
                standingViewHolder.localTeamGp.setText(teamStanding.getTotalPlayed());
                standingViewHolder.localTeamWins.setText(teamStanding.getTotalWon());
                standingViewHolder.localTeamDraws.setText(teamStanding.getTotalDraw());
                standingViewHolder.localTeamLoss.setText(teamStanding.getTotalLost());
                standingViewHolder.localTeamGd.setText(teamStanding.getGoalDifference());
                standingViewHolder.localTeamPts.setText(teamStanding.getPoints());

                if (i != 0) {
                    Picasso.get().load("http://static.holoduke.nl/footapi/images/teams_gs/" + teamStanding.getTeamId() + "_small.png").into(standingViewHolder.logo);
                }
                standingViewHolder.standingsLayout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        TeamStanding unused = StandingFragment.this.tempTeamStanding = teamStanding;
                        Intent intent2 = new Intent(StandingFragment.this.getContext(), footballscore_TeamDetailsActivity.class);
                        intent2.putExtra("teamKey", teamStanding.getTeamId());
                        StandingFragment.this.getActivity().startActivity(intent2);
                    }
                });
            }
        };
        this.standingListAdapter = r4;
        this.standingList.setAdapter(r4);
        this.standingList.setLayoutManager(new LinearLayoutManager(getContext()));
        Log.d("Constants.TAG", "http://static.holoduke.nl/footapi/tables/" + getArguments().getString("key") + ".json");
        this.networkService.fetchLeagueStandings(getArguments().getString("key"), new DefaultMessageHandler(getContext(), true) {
            public void onSuccess(Message message) {
                PointTable pointTable = (PointTable) message.obj;
                TeamStanding teamStanding = new TeamStanding();
                teamStanding.setTeamId("");
                teamStanding.setPosition("");
                teamStanding.setTeam("Team");
                teamStanding.setTotalPlayed("GP");
                teamStanding.setTotalWon("W");
                teamStanding.setTotalDraw("D");
                teamStanding.setTotalLost("L");
                teamStanding.setTotalGoalsFor("");
                teamStanding.setTotalGoalsAgainst("");
                teamStanding.setGoalDifference("GD");
                teamStanding.setPoints("Pts");
                teamStanding.setDescription("");
                StandingFragment.this.standings.add(teamStanding);
                for (int i = 0; i < pointTable.getGroups().size(); i++) {
                    StandingFragment.this.standings.addAll(pointTable.getGroups().get(i).getTeams());
                }
                StandingFragment.this.standingListAdapter.notifyDataSetChanged();
            }
        });
    }

    private static class StandingViewHolder extends RecyclerView.ViewHolder {
        public TextView localTeamDraws;
        public TextView localTeamGd;
        public TextView localTeamGp;
        public TextView localTeamLoss;
        public TextView localTeamName;
        public TextView localTeamPts;
        public TextView localTeamWins;
        public ImageView logo;
        public LinearLayout standingsLayout;

        public StandingViewHolder(View view) {
            super(view);
            this.localTeamName = (TextView) ViewHolder.get(view, R.id.tv_local_team_name);
            this.localTeamGp = (TextView) ViewHolder.get(view, R.id.tv_local_team_gp);
            this.localTeamWins = (TextView) ViewHolder.get(view, R.id.tv_local_team_wins);
            this.localTeamDraws = (TextView) ViewHolder.get(view, R.id.tv_local_team_draw);
            this.localTeamLoss = (TextView) ViewHolder.get(view, R.id.tv_local_team_loss);
            this.localTeamGd = (TextView) ViewHolder.get(view, R.id.tv_local_team_gd);
            this.localTeamPts = (TextView) ViewHolder.get(view, R.id.tv_local_team_pts);
            this.logo = (ImageView) ViewHolder.get(view, R.id.img_team_logo);
            this.standingsLayout = (LinearLayout) ViewHolder.get(view, R.id.standings_layout);
        }
    }
}
