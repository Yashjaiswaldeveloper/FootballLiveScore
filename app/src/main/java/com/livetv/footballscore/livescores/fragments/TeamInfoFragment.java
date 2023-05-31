package com.livetv.footballscore.livescores.fragments;

import static com.pesonal.adsdk.AppManage.ADMOB_N;
import static com.pesonal.adsdk.AppManage.FACEBOOK_N;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
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
import com.livetv.footballscore.livescores.activity.footballscore_MatchDetailsActivity;
import com.livetv.footballscore.livescores.adapter.BasicListAdapter;
import com.livetv.footballscore.livescores.model.MatchSummary;
import com.livetv.footballscore.livescores.model.Team;
import com.livetv.footballscore.livescores.model.TeamLeague;
import com.livetv.footballscore.livescores.util.ViewHolder;
import com.pesonal.adsdk.AppManage;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import cz.msebera.android.httpclient.message.TokenParser;
import de.hdodenhof.circleimageview.CircleImageView;

public class TeamInfoFragment extends Fragment {
    private TextView city;
    private TextView coach;
    private RecyclerView competitionList;
    private BasicListAdapter<TeamLeague, CompetitionsViewHolder> competitionListAdapter;
    public ArrayList<TeamLeague> competitions = new ArrayList<>();
    private TextView country;
    private TextView founded;
    private RecyclerView scheduleList;
    private BasicListAdapter<MatchSummary, ScheduleVieaHolder> scheduleListAdapter;
    public ArrayList<MatchSummary> schedules = new ArrayList<>();
    private Team team;
    private ImageView teamLogo;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view= layoutInflater.inflate(R.layout.footballscore_fragment_team_info, viewGroup, false);
        AppManage.getInstance(getActivity()).showNative((ViewGroup) view.findViewById(R.id.native_ads), ADMOB_N[0], FACEBOOK_N[0]);
        return view;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.team = (Team) getArguments().getSerializable("teamDetails");
        this.competitionList = (RecyclerView) view.findViewById(R.id.league_list);
        this.scheduleList = (RecyclerView) view.findViewById(R.id.match_list);
        this.city = (TextView) view.findViewById(R.id.tv_city);
        this.coach = (TextView) view.findViewById(R.id.tv_coach);
        this.country = (TextView) view.findViewById(R.id.tv_country);
        this.founded = (TextView) view.findViewById(R.id.tv_founded);
        this.teamLogo = (ImageView) view.findViewById(R.id.team_logo);
        this.competitionList.setNestedScrollingEnabled(false);
        this.scheduleList.setNestedScrollingEnabled(false);
        if (this.team.getFounded() != null) {
            TextView textView = this.founded;
            textView.setText(Html.fromHtml("<b>Founded: </b>" + this.team.getFounded()));
        } else {
            this.founded.setText(Html.fromHtml("<b>Founded: </b>"));
        }
        if (this.team.getCoach() != null) {
            TextView textView2 = this.coach;
            textView2.setText(Html.fromHtml("<b>Coach: </b>" + this.team.getCoach()));
        } else {
            this.coach.setText(Html.fromHtml("<b>Coach: </b>"));
        }
        if (this.team.getCountry() != null) {
            TextView textView3 = this.country;
            textView3.setText(Html.fromHtml("<b>Country: </b>" + this.team.getCountry()));
        } else {
            this.country.setText(Html.fromHtml("<b>Country: </b>"));
        }
        if (this.team.getVenueCity() != null) {
            TextView textView4 = this.city;
            textView4.setText(Html.fromHtml("<b>City: </b>" + this.team.getVenueCity()));
        } else {
            this.city.setText(Html.fromHtml("<b>City: </b>"));
        }

        Picasso.get().load("http://static.holoduke.nl/footapi/images/teams_gs/" + this.team.getId() + "_small.png").into(this.teamLogo);
        BasicListAdapter r2 = new BasicListAdapter<TeamLeague, CompetitionsViewHolder>(this.competitions) {
            public CompetitionsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
                return new CompetitionsViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.footballscore_list_item_team_squad, viewGroup, false));
            }

            public void onBindViewHolder(CompetitionsViewHolder competitionsViewHolder, int i) {
                TeamLeague teamLeague = TeamInfoFragment.this.competitions.get(i);
                competitionsViewHolder.name.setText(teamLeague.getLeague());
                if (teamLeague.getPosition() != null) {
                    TextView textView = competitionsViewHolder.description;
                    textView.setText(teamLeague.getCountry() + " - Position: " + teamLeague.getPosition());
                } else {
                    competitionsViewHolder.description.setText("");
                }
                Picasso.get().load("http://static.holoduke.nl/footapi/images/flags/" + TeamInfoFragment.this.prepareCountryName(teamLeague.getCountry()) + ".png").into((ImageView) competitionsViewHolder.imageView);
            }
        };
        this.competitionListAdapter = r2;
        this.competitionList.setAdapter(r2);
        this.competitionList.setLayoutManager(new LinearLayoutManager(getContext()));
        if (this.team.getLeagues() != null) {
            this.competitions.clear();
            this.competitions.addAll(this.team.getLeagues());
            this.competitionListAdapter.notifyDataSetChanged();
        }
        BasicListAdapter r22 = new BasicListAdapter<MatchSummary, ScheduleVieaHolder>(this.schedules) {
            public ScheduleVieaHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
                return new ScheduleVieaHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.footballscore_match_list_item, viewGroup, false));
            }

            public void onBindViewHolder(ScheduleVieaHolder scheduleVieaHolder, int i) {
                final MatchSummary matchSummary = TeamInfoFragment.this.schedules.get(i);
                scheduleVieaHolder.localTeam.setText(matchSummary.getLocalTeam());
                scheduleVieaHolder.visitorTeam.setText(matchSummary.getVisitorTeam());
                scheduleVieaHolder.leagueName.setTextSize(12.0f);
                TextView textView = scheduleVieaHolder.leagueName;
                textView.setText(matchSummary.getDate() + " - " + matchSummary.getLeagueName());
                scheduleVieaHolder.scoreLine.setText(matchSummary.getScoreTime());
                scheduleVieaHolder.minute.setText("");

               Picasso.get().load("http://static.holoduke.nl/footapi/images/teams_gs/" + matchSummary.getLocalTeamId() + "_small.png").into(scheduleVieaHolder.localTeamLogo);

                Picasso.get().load("http://static.holoduke.nl/footapi/images/teams_gs/" + matchSummary.getVisitorTeamId() + "_small.png").into(scheduleVieaHolder.visitorTeamLogo);
                scheduleVieaHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Intent intent = new Intent(TeamInfoFragment.this.getContext(), footballscore_MatchDetailsActivity.class);
                        intent.putExtra("matchId", matchSummary.getId());
                        TeamInfoFragment.this.startActivity(intent);
                    }
                });
            }
        };
        this.scheduleListAdapter = r22;
        this.scheduleList.setAdapter(r22);
        this.scheduleList.setLayoutManager(new LinearLayoutManager(getContext()));
        if (this.team.getFixtures() != null) {
            this.schedules.addAll(this.team.getFixtures());
            this.scheduleListAdapter.notifyDataSetChanged();
        }
    }

    public String prepareCountryName(String str) {
        return str.replace(TokenParser.SP, '-').toLowerCase();
    }

    private static class CompetitionsViewHolder extends RecyclerView.ViewHolder {
        protected CardView cardView;
        protected TextView description;
        protected CircleImageView imageView;
        protected TextView name;

        public CompetitionsViewHolder(View view) {
            super(view);
            this.imageView = (CircleImageView) ViewHolder.get(view, R.id.image);
            this.name = (TextView) ViewHolder.get(view, R.id.tv_name);
            this.description = (TextView) ViewHolder.get(view, R.id.tv_description);
            this.cardView = (CardView) ViewHolder.get(view, R.id.squal_player_card);
        }
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
