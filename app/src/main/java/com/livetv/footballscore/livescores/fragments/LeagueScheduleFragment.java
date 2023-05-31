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

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.livetv.footballscore.livescores.R;
import com.livetv.footballscore.livescores.activity.footballscore_MatchDetailsActivity;
import com.livetv.footballscore.livescores.adapter.BasicListAdapter;
import com.livetv.footballscore.livescores.model.MatchSummary;
import com.livetv.footballscore.livescores.service.DefaultMessageHandler;
import com.livetv.footballscore.livescores.service.NetworkService;
import com.livetv.footballscore.livescores.util.ViewHolder;
import com.pesonal.adsdk.AppManage;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class LeagueScheduleFragment extends Fragment {
    private NetworkService networkService = new NetworkService();
    public RecyclerView scheduleList;
    RelativeLayout native_ads;
    public BasicListAdapter<MatchSummary, ScheduleVieaHolder> scheduleListAdapter;
    public ArrayList<MatchSummary> schedules = new ArrayList<>();
    public MatchSummary templiveMatch;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.footballscore_schedule_list, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.scheduleList = (RecyclerView) view.findViewById(R.id.list);
        this.native_ads = view.findViewById(R.id.native_ads);
        AppManage.getInstance(getActivity().getApplicationContext()).showNative((ViewGroup) view.findViewById(R.id.native_ads), ADMOB_N[0], FACEBOOK_N[0]);
        BasicListAdapter r4 = new BasicListAdapter<MatchSummary, ScheduleVieaHolder>(this.schedules) {
            public ScheduleVieaHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
                return new ScheduleVieaHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.footballscore_match_list_item, viewGroup, false));
            }

            public void onBindViewHolder(ScheduleVieaHolder scheduleVieaHolder, int i) {
                final MatchSummary matchSummary = LeagueScheduleFragment.this.schedules.get(i);
                scheduleVieaHolder.leagueName.setText(matchSummary.getDate());
                scheduleVieaHolder.leagueName.setTextSize(12.0f);
                scheduleVieaHolder.localTeam.setText(matchSummary.getLocalTeam());
                scheduleVieaHolder.visitorTeam.setText(matchSummary.getVisitorTeam());
                scheduleVieaHolder.scoreLine.setText(matchSummary.getScoreTime());
                if (matchSummary.getStatus().equals("HT") || matchSummary.getStatus().equals("FT")) {
                    scheduleVieaHolder.minute.setText(matchSummary.getStatus());
                } else {
                    TextView textView = scheduleVieaHolder.minute;
                    textView.setText(matchSummary.getStatus() + "'");
                }

                scheduleVieaHolder.minute.setTextColor(ContextCompat.getColor(LeagueScheduleFragment.this.getContext(), R.color.Green));

                Picasso.get().load("http://static.holoduke.nl/footapi/images/teams_gs/" + matchSummary.getLocalTeamId() + "_small.png").into(scheduleVieaHolder.localTeamLogo);

                Picasso.get().load("http://static.holoduke.nl/footapi/images/teams_gs/" + matchSummary.getVisitorTeamId() + "_small.png").into(scheduleVieaHolder.visitorTeamLogo);
                scheduleVieaHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        MatchSummary unused = LeagueScheduleFragment.this.templiveMatch = matchSummary;
                        Intent intent = new Intent(LeagueScheduleFragment.this.getActivity(), footballscore_MatchDetailsActivity.class);
                        intent.putExtra("matchId", matchSummary.getId());
                        LeagueScheduleFragment.this.startActivity(intent);
                    }
                });
            }
        };
        this.scheduleListAdapter = r4;
        this.scheduleList.setAdapter(r4);
        this.scheduleList.setLayoutManager(new LinearLayoutManager(getContext()));
        Log.d("Constants.TAG", "http://static.holoduke.nl/footapi/fixtures/" + getArguments().getString("key") + "_small.json");
        this.networkService.fetchLeagueSchedule(getArguments().getString("key"), new DefaultMessageHandler(getContext(), true) {
            public void onSuccess(Message message) {
                LeagueScheduleFragment.this.schedules.addAll((List) message.obj);
                LeagueScheduleFragment.this.scheduleListAdapter.notifyDataSetChanged();
                int size = LeagueScheduleFragment.this.schedules.size() - 1;
                int size2 = LeagueScheduleFragment.this.schedules.size() - 1;
                while (true) {
                    if (size2 < 0) {
                        break;
                    } else if (LeagueScheduleFragment.this.schedules.get(size2).getStatus().equals("FT")) {
                        size = size2;
                        break;
                    } else {
                        size2--;
                    }
                }
                LeagueScheduleFragment.this.scheduleList.scrollToPosition(size);
            }
        });
    }

    private static class ScheduleVieaHolder extends RecyclerView.ViewHolder {
        protected TextView leagueName;
        protected LinearLayout linearLayout;
        protected TextView localTeam;
        protected ImageView localTeamLogo;
        protected TextView minute;
        protected TextView scoreLine;
        protected TextView visitorTeam;
        protected ImageView visitorTeamLogo;

        public ScheduleVieaHolder(View view) {
            super(view);
            this.leagueName = (TextView) ViewHolder.get(view, R.id.tv_league_name);
            this.localTeam = (TextView) ViewHolder.get(view, R.id.tv_local_team);
            this.localTeamLogo = (ImageView) ViewHolder.get(view, R.id.logo_local_team);
            this.visitorTeam = (TextView) ViewHolder.get(view, R.id.tv_visitor_team);
            this.visitorTeamLogo = (ImageView) ViewHolder.get(view, R.id.logo_visitor_team);
            this.scoreLine = (TextView) ViewHolder.get(view, R.id.tv_score);
            this.minute = (TextView) ViewHolder.get(view, R.id.tv_minute);
            this.linearLayout = (LinearLayout) ViewHolder.get(view, R.id.linear_layout);
        }
    }
}
