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
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.livetv.footballscore.livescores.R;
import com.livetv.footballscore.livescores.activity.footballscore_PlayerInfoActivity;
import com.livetv.footballscore.livescores.adapter.BasicListAdapter;
import com.livetv.footballscore.livescores.model.Commentary;
import com.livetv.footballscore.livescores.model.MatchDetails;
import com.livetv.footballscore.livescores.model.MatchLineupPlayer;
import com.livetv.footballscore.livescores.service.DefaultMessageHandler;
import com.livetv.footballscore.livescores.service.NetworkService;
import com.livetv.footballscore.livescores.util.ViewHolder;
import com.pesonal.adsdk.AppManage;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import de.hdodenhof.circleimageview.CircleImageView;

public class LineupsFragment extends Fragment {
    public TextView emptyView;
    public ArrayList<MatchLineupPlayer> homeTeam = new ArrayList<>();
    private RecyclerView lineupsList;
    public BasicListAdapter<MatchLineupPlayer, LineupViewHolder> lineupsListAdapter;
    public MatchDetails matchDetails;
    private NetworkService networkService = new NetworkService();
    public ArrayList<MatchLineupPlayer> visitorTeam = new ArrayList<>();

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view= layoutInflater.inflate(R.layout.footballscore_lineups_fragments, viewGroup, false);
        AppManage.getInstance(getActivity()).showNative((ViewGroup) view.findViewById(R.id.native_ads), ADMOB_N[0], FACEBOOK_N[0]);
        return view;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.lineupsList = (RecyclerView) view.findViewById(R.id.team_lineup_list);
        this.emptyView = (TextView) view.findViewById(R.id.tv_empty_view);
        this.matchDetails = (MatchDetails) getArguments().getSerializable("matchdetails");
        BasicListAdapter r4 = new BasicListAdapter<MatchLineupPlayer, LineupViewHolder>(this.homeTeam, this.visitorTeam) {
            public LineupViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
                return new LineupViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.footballscore_match_event_list_item, viewGroup, false));
            }

            public void onBindViewHolder(LineupViewHolder lineupViewHolder, int i) {
                final MatchLineupPlayer matchLineupPlayer = LineupsFragment.this.homeTeam.get(i);
                final MatchLineupPlayer matchLineupPlayer2 = LineupsFragment.this.visitorTeam.get(i);
               Picasso.get().load("http://static.holoduke.nl/footapi/images/playerimages/" + matchLineupPlayer.getId() + "_small.png").into((ImageView) lineupViewHolder.leftPlayer);
                lineupViewHolder.leftPlayerName.setText(matchLineupPlayer.getName());
                lineupViewHolder.minute.setVisibility(8);
                lineupViewHolder.leftEvent.setVisibility(8);
                Picasso.get().load("http://static.holoduke.nl/footapi/images/playerimages/" + matchLineupPlayer2.getId() + "_small.png").into((ImageView) lineupViewHolder.rightPlayer);
                lineupViewHolder.rightPlayerName.setText(matchLineupPlayer2.getName());
                lineupViewHolder.rightEvent.setVisibility(8);
                lineupViewHolder.leftLinearLayout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        LineupsFragment.this.startPlayerProfileActivity(matchLineupPlayer.getId());
                    }
                });
                lineupViewHolder.rightLinearLayout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        LineupsFragment.this.startPlayerProfileActivity(matchLineupPlayer2.getId());
                    }
                });
            }
        };
        this.lineupsListAdapter = r4;
        this.lineupsList.setAdapter(r4);
        this.lineupsList.setLayoutManager(new LinearLayoutManager(getContext()));
        Log.d("Constants.TAG", "http://holoduke.nl/footapi/commentaries/" + this.matchDetails.getId() + ".json");
        this.networkService.fetchCommentry(this.matchDetails.getId(), new DefaultMessageHandler(getContext(), false) {
            public void onSuccess(Message message) {
                Commentary commentary = (Commentary) message.obj;
                Log.d("riponc", commentary.toString());
                if (commentary.getTeams() != null) {
                    LineupsFragment.this.homeTeam.clear();
                    LineupsFragment.this.visitorTeam.clear();
                    LineupsFragment.this.homeTeam.addAll(commentary.getTeams().getLocalteam());
                    LineupsFragment.this.visitorTeam.addAll(commentary.getTeams().getVisitorteam());
                    LineupsFragment.this.lineupsListAdapter.notifyDataSetChanged();
                } else if (LineupsFragment.this.matchDetails.getLineups() != null) {
                    LineupsFragment.this.homeTeam.clear();
                    LineupsFragment.this.visitorTeam.clear();
                    LineupsFragment.this.homeTeam.addAll(LineupsFragment.this.matchDetails.getLineups().getLocalteam());
                    LineupsFragment.this.visitorTeam.addAll(LineupsFragment.this.matchDetails.getLineups().getVisitorteam());
                    LineupsFragment.this.lineupsListAdapter.notifyDataSetChanged();
                }
                LineupsFragment.this.emptyView.setVisibility(8);
                if (LineupsFragment.this.homeTeam.size() == 0) {
                    LineupsFragment.this.emptyView.setVisibility(0);
                }
            }

            public void onFailure(Message message) {
                LineupsFragment.this.emptyView.setVisibility(8);
                if (LineupsFragment.this.homeTeam.size() == 0) {
                    LineupsFragment.this.emptyView.setVisibility(0);
                }
            }
        });
    }

    public void startPlayerProfileActivity(String str) {
        if (!str.equals("")) {
            Intent intent = new Intent(getContext(), footballscore_PlayerInfoActivity.class);
            intent.putExtra("playerId", str);
            getActivity().startActivity(intent);
        }
    }

    private static class LineupViewHolder extends RecyclerView.ViewHolder {
        protected CircleImageView leftEvent;
        protected LinearLayout leftLinearLayout;
        protected CircleImageView leftPlayer;
        protected TextView leftPlayerName;
        protected TextView minute;
        protected CircleImageView rightEvent;
        protected LinearLayout rightLinearLayout;
        protected CircleImageView rightPlayer;
        protected TextView rightPlayerName;

        public LineupViewHolder(View view) {
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
}
