package com.livetv.footballscore.livescores.fragments;
import static com.pesonal.adsdk.AppManage.ADMOB_N;
import static com.pesonal.adsdk.AppManage.FACEBOOK_N;
import android.annotation.SuppressLint;
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
import com.livetv.footballscore.livescores.model.CountryLeague;
import com.livetv.footballscore.livescores.model.MatchSummary;
import com.livetv.footballscore.livescores.model.Player;
import com.livetv.footballscore.livescores.model.Team;
import com.livetv.footballscore.livescores.service.DefaultMessageHandler;
import com.livetv.footballscore.livescores.service.NetworkService;
import com.livetv.footballscore.livescores.util.ViewHolder;
import com.pesonal.adsdk.AppManage;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class LiveScoreFragment extends Fragment {
    /* access modifiers changed from: private */
    public List<CountryLeague> countryLeagues = new ArrayList();
    public TextView emptyView;
    RelativeLayout native_ads;
    /* access modifiers changed from: private */
    public ArrayList<MatchSummary> liveMatches = new ArrayList<>();
    private RecyclerView liveMatchesList;
    public BasicListAdapter<MatchSummary, LiveMatchesVieaHolder> liveMatchesListAdapter;
    public MatchSummary matchSummary;
    private NetworkService networkService = new NetworkService();
    private Player player;
    private Team team;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.footballscore_livescore_list, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Log.d("Constants.TAG", "http://static.holoduke.nl/footapi/fixtures/feed_livenow.json");
        this.liveMatchesList = (RecyclerView) view.findViewById(R.id.list);
        this.emptyView = (TextView) view.findViewById(R.id.tv_empty);
        this.native_ads = view.findViewById(R.id.native_ads);
        AppManage.getInstance(getActivity().getApplicationContext()).showNative((ViewGroup) view.findViewById(R.id.native_ads), ADMOB_N[0], FACEBOOK_N[0]);
        this.liveMatchesListAdapter = new BasicListAdapter<MatchSummary, LiveMatchesVieaHolder>(this.liveMatches) {
            public LiveMatchesVieaHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
                return new LiveMatchesVieaHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.footballscore_match_list_item, viewGroup, false));
            }

            public void onBindViewHolder(LiveMatchesVieaHolder liveMatchesVieaHolder, final int i) {
                final MatchSummary matchSummary = LiveScoreFragment.this.liveMatches.get(i);
                TextView textView = liveMatchesVieaHolder.leagueName;
                textView.setText(matchSummary.getFileGroup() + " - " + matchSummary.getLeagueName());
                liveMatchesVieaHolder.localTeam.setText(matchSummary.getLocalTeam());
                liveMatchesVieaHolder.visitorTeam.setText(matchSummary.getVisitorTeam());
                liveMatchesVieaHolder.scoreLine.setText(matchSummary.getScoreTime());
                if (matchSummary.getStatus().equals("HT") || matchSummary.getStatus().equals("FT")) {
                    liveMatchesVieaHolder.minute.setText(matchSummary.getStatus());
                } else {
                    TextView textView2 = liveMatchesVieaHolder.minute;
                    textView2.setText(matchSummary.getStatus() + "'");
                }

                liveMatchesVieaHolder.minute.setTextColor(ContextCompat.getColor(LiveScoreFragment.this.getContext(), R.color.Green));

               Picasso.get().load("http://static.holoduke.nl/footapi/images/teams_gs/" + matchSummary.getLocalTeamId() + "_small.png").into(liveMatchesVieaHolder.localTeamLogo);

                Picasso.get().load("http://static.holoduke.nl/footapi/images/teams_gs/" + matchSummary.getVisitorTeamId() + "_small.png").into(liveMatchesVieaHolder.visitorTeamLogo);
                liveMatchesVieaHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        LiveScoreFragment.this.matchSummary = LiveScoreFragment.this.liveMatches.get(i);
                        Intent intent = new Intent(LiveScoreFragment.this.getContext(), footballscore_MatchDetailsActivity.class);
                        intent.putExtra("matchId", matchSummary.getId());
                        LiveScoreFragment.this.startActivity(intent);
                    }
                });
            }
        };
        this.networkService.fetchLiveNow(new DefaultMessageHandler(getContext(), true) {
            @SuppressLint("WrongConstant")
            public void onSuccess(Message message) {
                LiveScoreFragment.this.countryLeagues = (List) message.obj;
                LiveScoreFragment.this.liveMatches.clear();
                for (int i = 0; i < LiveScoreFragment.this.countryLeagues.size(); i++) {
                    for (int i2 = 0; i2 < LiveScoreFragment.this.countryLeagues.get(i).getLeagues().size(); i2++) {
                        LiveScoreFragment.this.liveMatches.addAll(LiveScoreFragment.this.countryLeagues.get(i).getLeagues().get(i2).getMatches());
                    }
                }
                LiveScoreFragment.this.liveMatchesListAdapter.notifyDataSetChanged();
                if (LiveScoreFragment.this.liveMatches.size() > 0) {
                    LiveScoreFragment.this.emptyView.setVisibility(8);
                    return;
                }
                LiveScoreFragment.this.emptyView.setVisibility(0);
                LiveScoreFragment.this.emptyView.setText("No live matches ongoing");
            }
        });
        this.liveMatchesList.setAdapter(this.liveMatchesListAdapter);
        this.liveMatchesList.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private static class LiveMatchesVieaHolder extends RecyclerView.ViewHolder {
        protected TextView leagueName;
        protected LinearLayout linearLayout;
        protected TextView localTeam;
        protected ImageView localTeamLogo;
        protected TextView minute;
        protected TextView scoreLine;
        protected TextView visitorTeam;
        protected ImageView visitorTeamLogo;

        public LiveMatchesVieaHolder(View view) {
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
