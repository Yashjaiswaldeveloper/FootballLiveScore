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
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.livetv.footballscore.livescores.R;
import com.livetv.footballscore.livescores.activity.footballscore_LeagueDetailsActivity;
import com.livetv.footballscore.livescores.activity.footballscore_PlayerInfoActivity;
import com.livetv.footballscore.livescores.adapter.BasicListAdapter;
import com.livetv.footballscore.livescores.model.Commentary;
import com.livetv.footballscore.livescores.model.LiveTicker;
import com.livetv.footballscore.livescores.model.MatchDetails;
import com.livetv.footballscore.livescores.model.MatchEvent;
import com.livetv.footballscore.livescores.model.MatchTeamStat;
import com.livetv.footballscore.livescores.model.TeamStanding;
import com.livetv.footballscore.livescores.service.DefaultMessageHandler;
import com.livetv.footballscore.livescores.service.NetworkService;
import com.livetv.footballscore.livescores.util.ViewHolder;
import com.pesonal.adsdk.AppManage;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import de.hdodenhof.circleimageview.CircleImageView;

@SuppressLint("WrongConstant")

public class MatchInfoFragment extends Fragment {
    private CardView cardHead2Head;
    private CardView cardView;
    public ArrayList<LiveTicker> commentries = new ArrayList<>();
    public LinearLayout commentryLayout;
    private RecyclerView commentryList;
    public BasicListAdapter<LiveTicker, TickerViewHolder> commentryListAdapter;
    private LinearLayout head2headLayout;
    private LinearLayout keyEventsLayout;
    private TextView leagueName;
    private TextView localGoals;
    private TextView localTeamDraws;
    private TextView localTeamGd;
    private TextView localTeamGp;
    private TextView localTeamLoss;
    private TextView localTeamName;
    private TextView localTeamPts;
    private TextView localTeamRank;
    private TextView localTeamWins;
    private TextView localWins;
    public MatchDetails matchDetails;
    private RecyclerView matchEventList;
    private BasicListAdapter<MatchEvent, MatchEventViewHolder> matchEventListAdapter;
    public ArrayList<MatchEvent> matchEvents = new ArrayList<>();
    private RecyclerView matchStatsList;
    private BasicListAdapter<StatModel, StatsViewHolder> matchStatsListAdapter;
    private NetworkService networkService = new NetworkService();
    private TextView stadiumName;
    private TextView standings;
    private LinearLayout standingsLayout;
    private LinearLayout statisticsLayout;
    public ArrayList<StatModel> stats = new ArrayList<>();
    private TextView visitorGoals;
    private TextView visitorTeamDraws;
    private TextView visitorTeamGd;
    private TextView visitorTeamGp;
    private TextView visitorTeamLoss;
    private TextView visitorTeamName;
    private TextView visitorTeamPts;
    private TextView visitorTeamRank;
    private TextView visitorTeamWins;
    private TextView visitorWins;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view= layoutInflater.inflate(R.layout.footballscore_fragment_match_info, viewGroup, false);
        AppManage.getInstance(getActivity()).showNative((ViewGroup) view.findViewById(R.id.native_ads), ADMOB_N[0], FACEBOOK_N[0]);
        return view;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.cardHead2Head = (CardView) view.findViewById(R.id.card_head2head);
        this.cardView = (CardView) view.findViewById(R.id.card_view);
        this.commentryLayout = (LinearLayout) view.findViewById(R.id.commentry_layout);
        this.commentryList = (RecyclerView) view.findViewById(R.id.commentry_list);
        this.head2headLayout = (LinearLayout) view.findViewById(R.id.head2head_layout);
        this.keyEventsLayout = (LinearLayout) view.findViewById(R.id.key_events_layout);
        this.leagueName = (TextView) view.findViewById(R.id.tv_league_name);
        this.localGoals = (TextView) view.findViewById(R.id.tv_local_goals);
        this.localTeamDraws = (TextView) view.findViewById(R.id.tv_local_team_draw);
        this.localTeamGd = (TextView) view.findViewById(R.id.tv_local_team_gd);
        this.localTeamGp = (TextView) view.findViewById(R.id.tv_local_team_gp);
        this.localTeamLoss = (TextView) view.findViewById(R.id.tv_local_team_loss);
        this.localTeamName = (TextView) view.findViewById(R.id.tv_local_team_name);
        this.localTeamPts = (TextView) view.findViewById(R.id.tv_local_team_pts);
        this.localTeamRank = (TextView) view.findViewById(R.id.tv_local_team_rank);
        this.localTeamWins = (TextView) view.findViewById(R.id.tv_local_team_wins);
        this.localWins = (TextView) view.findViewById(R.id.tv_local_wins);
        this.matchEventList = (RecyclerView) view.findViewById(R.id.match_events_list);
        this.matchStatsList = (RecyclerView) view.findViewById(R.id.match_stats_list);
        this.stadiumName = (TextView) view.findViewById(R.id.tv_stadium_name);
        this.standings = (TextView) view.findViewById(R.id.tv_standings);
        this.standingsLayout = (LinearLayout) view.findViewById(R.id.standings_layout);
        this.statisticsLayout = (LinearLayout) view.findViewById(R.id.statistics_layout);
        this.visitorGoals = (TextView) view.findViewById(R.id.tv_visitor_goals);
        this.visitorTeamDraws = (TextView) view.findViewById(R.id.tv_visitor_team_draw);
        this.visitorTeamGd = (TextView) view.findViewById(R.id.tv_visitor_team_gd);
        this.visitorTeamGp = (TextView) view.findViewById(R.id.tv_visitor_team_gp);
        this.visitorTeamLoss = (TextView) view.findViewById(R.id.tv_visitor_team_loss);
        this.visitorTeamName = (TextView) view.findViewById(R.id.tv_visitor_team_name);
        this.visitorTeamPts = (TextView) view.findViewById(R.id.tv_visitor_team_pts);
        this.visitorTeamRank = (TextView) view.findViewById(R.id.tv_visitor_team_rank);
        this.visitorTeamWins = (TextView) view.findViewById(R.id.tv_visitor_team_wins);
        this.visitorWins = (TextView) view.findViewById(R.id.tv_visitor_wins);
        this.matchDetails = (MatchDetails) getArguments().getSerializable("matchdetails");
        this.matchEventList.setNestedScrollingEnabled(false);
        this.matchStatsList.setNestedScrollingEnabled(false);
        this.commentryList.setNestedScrollingEnabled(false);
        TextView textView = this.leagueName;
        textView.setText(this.matchDetails.getCountryOfLeague() + " - " + this.matchDetails.getLeagueName());
        this.stadiumName.setText(this.matchDetails.getVenue());
        this.leagueName.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MatchInfoFragment.this.getContext(), footballscore_LeagueDetailsActivity.class);
                intent.putExtra("leagueKey", MatchInfoFragment.this.matchDetails.getLeagueKey());
                MatchInfoFragment.this.startActivity(intent);
            }
        });
        BasicListAdapter r8 = new BasicListAdapter<MatchEvent, MatchEventViewHolder>(this.matchEvents) {
            public MatchEventViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
                return new MatchEventViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.footballscore_match_event_list_item, viewGroup, false));
            }

           
            public void onBindViewHolder(MatchEventViewHolder matchEventViewHolder, int i) {
                final MatchEvent matchEvent = MatchInfoFragment.this.matchEvents.get(i);
                if (matchEvent.getTeam().equals("localteam")) {
                    matchEventViewHolder.rightEvent.setVisibility(8);
                    matchEventViewHolder.rightPlayer.setVisibility(8);
                    matchEventViewHolder.rightPlayerName.setVisibility(8);

                    Picasso.get().load("http://static.holoduke.nl/footapi/images/playerimages/" + matchEvent.getPlayerId() + "_small.png").into((ImageView) matchEventViewHolder.leftPlayer);
                   // with.load("http://static.holoduke.nl/footapi/images/playerimages/" + matchEvent.getPlayerId() + "_small.png").into((ImageView) matchEventViewHolder.leftPlayer);
                    matchEventViewHolder.leftPlayerName.setText(matchEvent.getPlayer());
                    TextView textView = matchEventViewHolder.minute;
                    textView.setText(matchEvent.getMinute() + "'");
                    if (matchEvent.getType().equals("goal")) {
                        matchEventViewHolder.leftEvent.setImageDrawable(MatchInfoFragment.this.getActivity().getResources().getDrawable(R.drawable.football));
                    } else if (matchEvent.getType().equals("yellowcard")) {
                        matchEventViewHolder.leftEvent.setImageDrawable(MatchInfoFragment.this.getActivity().getResources().getDrawable(R.drawable.footballscore_yellowcard));
                    } else if (matchEvent.getType().equals("redcard")) {
                        matchEventViewHolder.leftEvent.setImageDrawable(MatchInfoFragment.this.getActivity().getResources().getDrawable(R.drawable.redcard));
                    }
                } else {
                    matchEventViewHolder.leftEvent.setVisibility(8);
                    matchEventViewHolder.leftPlayer.setVisibility(8);
                    matchEventViewHolder.leftPlayerName.setVisibility(8);
                    Picasso.get().load("http://static.holoduke.nl/footapi/images/playerimages/" + matchEvent.getPlayerId() + "_small.png").into((ImageView) matchEventViewHolder.rightPlayer);
                    //Picasso with2 = with(MatchInfoFragment.this.getContext());
                   // with2.load("http://static.holoduke.nl/footapi/images/playerimages/" + matchEvent.getPlayerId() + "_small.png").into((ImageView) matchEventViewHolder.rightPlayer);
                    matchEventViewHolder.rightPlayerName.setText(matchEvent.getPlayer());
                    TextView textView2 = matchEventViewHolder.minute;
                    textView2.setText(matchEvent.getMinute() + "'");
                    if (matchEvent.getType().equals("goal")) {
                        matchEventViewHolder.rightEvent.setImageDrawable(MatchInfoFragment.this.getActivity().getResources().getDrawable(R.drawable.football));
                    } else if (matchEvent.getType().equals("yellowcard")) {
                        matchEventViewHolder.rightEvent.setImageDrawable(MatchInfoFragment.this.getActivity().getResources().getDrawable(R.drawable.footballscore_yellowcard));
                    } else if (matchEvent.getType().equals("redcard")) {
                        matchEventViewHolder.rightEvent.setImageDrawable(MatchInfoFragment.this.getActivity().getResources().getDrawable(R.drawable.redcard));
                    }
                }
                matchEventViewHolder.leftLinearLayout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        MatchInfoFragment.this.startPlayerProfileActivity(matchEvent.getPlayerId());
                    }
                });
                matchEventViewHolder.rightLinearLayout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        MatchInfoFragment.this.startPlayerProfileActivity(matchEvent.getPlayerId());
                    }
                });
            }
        };
        this.matchEventListAdapter = r8;
        this.matchEventList.setAdapter(r8);
        this.matchEventList.setLayoutManager(new LinearLayoutManager(getContext()));
        BasicListAdapter r82 = new BasicListAdapter<StatModel, StatsViewHolder>(this.stats) {
            public StatsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
                return new StatsViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.footballscore_match_stat_list_item, viewGroup, false));
            }

            public void onBindViewHolder(StatsViewHolder statsViewHolder, int i) {
                StatModel statModel = MatchInfoFragment.this.stats.get(i);
                statsViewHolder.localTeamScore.setText(statModel.getLocalTeamScore());
                statsViewHolder.criteria.setText(statModel.getCriteria());
                statsViewHolder.visitorTeamScore.setText(statModel.getVisitorTeamScore());
            }
        };
        this.matchStatsListAdapter = r82;
        this.matchStatsList.setAdapter(r82);
        this.matchStatsList.setLayoutManager(new LinearLayoutManager(getContext()));
        BasicListAdapter r83 = new BasicListAdapter<LiveTicker, TickerViewHolder>(this.commentries) {
            public TickerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
                return new TickerViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.footballscore_commentry_list_item, viewGroup, false));
            }

            public void onBindViewHolder(TickerViewHolder tickerViewHolder, int i) {
                tickerViewHolder.time.setText(MatchInfoFragment.this.commentries.get(i).getMinute());
                tickerViewHolder.commentry.setText(MatchInfoFragment.this.commentries.get(i).getComment());
            }
        };
        this.commentryListAdapter = r83;
        this.commentryList.setAdapter(r83);
        this.commentryList.setLayoutManager(new LinearLayoutManager(getContext()));
        Log.d("Constants.TAG", "http://holoduke.nl/footapi/commentaries/" + this.matchDetails.getId() + ".json");
        this.networkService.fetchCommentry(this.matchDetails.getId(), new DefaultMessageHandler(getContext(), false) {
            public void onSuccess(Message message) {
                Commentary commentary = (Commentary) message.obj;
                Log.d("riponc", commentary.toString());
                MatchInfoFragment.this.commentries.clear();
                MatchInfoFragment.this.commentries.addAll(commentary.getLiveticker());
                MatchInfoFragment.this.commentryListAdapter.notifyDataSetChanged();
                if (MatchInfoFragment.this.commentries.size() == 0) {
                    MatchInfoFragment.this.commentryLayout.setVisibility(8);
                } else {
                    MatchInfoFragment.this.commentryLayout.setVisibility(0);
                }
            }
        });
        this.matchEvents.clear();
        this.matchEvents.addAll(this.matchDetails.getEvents());
        this.matchEventListAdapter.notifyDataSetChanged();
        if (this.matchEvents.size() == 0) {
            this.keyEventsLayout.setVisibility(8);
        } else {
            this.keyEventsLayout.setVisibility(0);
        }
        if (this.matchDetails.getCommentaries() != null) {
            Log.d("Constants.TAG", this.matchDetails.getCommentaries().toString());
            this.stats.clear();
            if (this.matchDetails.getCommentaries().getStats() != null) {
                MatchTeamStat localTeamStat = this.matchDetails.getCommentaries().getStats().getLocalTeamStat();
                MatchTeamStat visitorTeamStat = this.matchDetails.getCommentaries().getStats().getVisitorTeamStat();
                this.stats.add(new StatModel("Total Shots", localTeamStat.getTotalShots(), visitorTeamStat.getTotalShots()));
                this.stats.add(new StatModel("Shots on Goal", localTeamStat.getShotsToGoal(), visitorTeamStat.getShotsToGoal()));
                this.stats.add(new StatModel("Fouls", localTeamStat.getFouls(), visitorTeamStat.getFouls()));
                this.stats.add(new StatModel("Corners", localTeamStat.getCorners(), visitorTeamStat.getCorners()));
                this.stats.add(new StatModel("Offsides", localTeamStat.getOffsides(), visitorTeamStat.getOffsides()));
                this.stats.add(new StatModel("Possessation Time", localTeamStat.getPossessationTime(), visitorTeamStat.getPossessationTime()));
                this.stats.add(new StatModel("Yellow Cards", localTeamStat.getYellowCards(), visitorTeamStat.getYellowCards()));
                this.stats.add(new StatModel("Red Cards", localTeamStat.getRedCards(), visitorTeamStat.getRedCards()));
                this.stats.add(new StatModel("Saves", localTeamStat.getSaves(), visitorTeamStat.getSaves()));
                this.matchStatsListAdapter.notifyDataSetChanged();
                this.statisticsLayout.setVisibility(8);
                if (this.stats.size() > 0) {
                    this.statisticsLayout.setVisibility(0);
                }
            } else {
                this.statisticsLayout.setVisibility(8);
            }
        }
        if (this.matchDetails.getLocalTeamStanding() != null) {
            this.standings.setText(this.matchDetails.getLeagueName());
            TeamStanding localTeamStanding = this.matchDetails.getLocalTeamStanding();
            this.localTeamRank.setText(localTeamStanding.getPosition());
            this.localTeamName.setText(localTeamStanding.getTeam());
            this.localTeamGp.setText(localTeamStanding.getTotalPlayed());
            this.localTeamWins.setText(localTeamStanding.getTotalWon());
            this.localTeamDraws.setText(localTeamStanding.getTotalDraw());
            this.localTeamLoss.setText(localTeamStanding.getTotalLost());
            this.localTeamGd.setText(localTeamStanding.getGoalDifference());
            this.localTeamPts.setText(localTeamStanding.getPoints());
            this.standingsLayout.setVisibility(0);
            this.cardView.setVisibility(0);
        } else {
            this.standingsLayout.setVisibility(8);
            this.cardView.setVisibility(8);
        }
        if (this.matchDetails.getVisitorTeamStanding() != null) {
            TeamStanding visitorTeamStanding = this.matchDetails.getVisitorTeamStanding();
            this.visitorTeamRank.setText(visitorTeamStanding.getPosition());
            this.visitorTeamName.setText(visitorTeamStanding.getTeam());
            this.visitorTeamGp.setText(visitorTeamStanding.getTotalPlayed());
            this.visitorTeamWins.setText(visitorTeamStanding.getTotalWon());
            this.visitorTeamDraws.setText(visitorTeamStanding.getTotalDraw());
            this.visitorTeamLoss.setText(visitorTeamStanding.getTotalLost());
            this.visitorTeamGd.setText(visitorTeamStanding.getGoalDifference());
            this.visitorTeamPts.setText(visitorTeamStanding.getPoints());
        }
        if (this.matchDetails.getStats() != null) {
            this.localWins.setText(this.matchDetails.getStats().getTotal_localteam_won());
            this.visitorWins.setText(this.matchDetails.getStats().getTotal_visitorteam_won());
            this.localGoals.setText(this.matchDetails.getStats().getTotal_localteam_scored());
            this.visitorGoals.setText(this.matchDetails.getStats().getTotal_visitorteam_scored());
            this.head2headLayout.setVisibility(0);
            this.cardHead2Head.setVisibility(0);
            return;
        }
        this.head2headLayout.setVisibility(8);
        this.cardHead2Head.setVisibility(8);
    }

    public void startPlayerProfileActivity(String str) {
        if (!str.equals("")) {
            Intent intent = new Intent(getContext(), footballscore_PlayerInfoActivity.class);
            intent.putExtra("playerId", str);
            getActivity().startActivity(intent);
        }
    }

    private static class MatchEventViewHolder extends RecyclerView.ViewHolder {
        protected CircleImageView leftEvent;
        protected LinearLayout leftLinearLayout;
        protected CircleImageView leftPlayer;
        protected TextView leftPlayerName;
        protected TextView minute;
        protected CircleImageView rightEvent;
        protected LinearLayout rightLinearLayout;
        protected CircleImageView rightPlayer;
        protected TextView rightPlayerName;

        public MatchEventViewHolder(View view) {
            super(view);
            this.leftLinearLayout = (LinearLayout) ViewHolder.get(view, R.id.left_linear_layout);
            this.rightLinearLayout = (LinearLayout) ViewHolder.get(view, R.id.right_linear_layout);
            this.leftPlayer = (CircleImageView) ViewHolder.get(view, R.id.img_left_player);
            this.leftPlayerName = (TextView) ViewHolder.get(view, R.id.tv_left_player);
            this.leftEvent = (CircleImageView) ViewHolder.get(view, R.id.img_left_event);
            this.rightPlayer = (CircleImageView) ViewHolder.get(view, R.id.img_right_player);
            this.rightPlayerName = (TextView) ViewHolder.get(view, R.id.tv_right_player);
            this.rightEvent = (CircleImageView) ViewHolder.get(view, R.id.img_right_event);
            this.minute = (TextView) ViewHolder.get(view, R.id.tv_minute);
        }
    }

    private static class StatsViewHolder extends RecyclerView.ViewHolder {
        protected TextView criteria;
        protected TextView localTeamScore;
        protected TextView visitorTeamScore;

        public StatsViewHolder(View view) {
            super(view);
            this.localTeamScore = (TextView) ViewHolder.get(view, R.id.tv_local_team_score);
            this.criteria = (TextView) ViewHolder.get(view, R.id.tv_criteria);
            this.visitorTeamScore = (TextView) ViewHolder.get(view, R.id.tv_visitor_team_score);
        }
    }

    private static class TickerViewHolder extends RecyclerView.ViewHolder {
        public TextView commentry;
        public TextView time;

        public TickerViewHolder(View view) {
            super(view);
            this.time = (TextView) ViewHolder.get(view, R.id.tv_commentry_minute);
            this.commentry = (TextView) ViewHolder.get(view, R.id.tv_commentry);
        }
    }

    private class StatModel {
        private String criteria;
        private String localTeamScore;
        private String visitorTeamScore;

        public StatModel(String str, String str2, String str3) {
            this.criteria = str;
            this.localTeamScore = str2;
            this.visitorTeamScore = str3;
        }

        public String getCriteria() {
            return this.criteria;
        }

        public void setCriteria(String str) {
            this.criteria = str;
        }

        public String getLocalTeamScore() {
            return this.localTeamScore;
        }

        public void setLocalTeamScore(String str) {
            this.localTeamScore = str;
        }

        public String getVisitorTeamScore() {
            return this.visitorTeamScore;
        }

        public void setVisitorTeamScore(String str) {
            this.visitorTeamScore = str;
        }

        public String toString() {
            return "StatModel{criteria='" + this.criteria + '\'' + ", localTeamScore='" + this.localTeamScore + '\'' + ", visitorTeamScore='" + this.visitorTeamScore + '\'' + '}';
        }
    }
}
