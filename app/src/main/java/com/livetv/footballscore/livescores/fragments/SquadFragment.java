package com.livetv.footballscore.livescores.fragments;

import static com.pesonal.adsdk.AppManage.ADMOB_N;
import static com.pesonal.adsdk.AppManage.FACEBOOK_N;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.livetv.footballscore.livescores.R;
import com.livetv.footballscore.livescores.activity.footballscore_PlayerInfoActivity;
import com.livetv.footballscore.livescores.adapter.BasicListAdapter;
import com.livetv.footballscore.livescores.model.Team;
import com.livetv.footballscore.livescores.model.TeamSquadPlayer;
import com.livetv.footballscore.livescores.util.ViewHolder;
import com.pesonal.adsdk.AppManage;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import de.hdodenhof.circleimageview.CircleImageView;

public class SquadFragment extends Fragment {
    private TextView emptyView;
    public ArrayList<TeamSquadPlayer> players = new ArrayList<>();
    private RecyclerView squadList;
    private BasicListAdapter<TeamSquadPlayer, SquadViewHolder> squadListAdapter;
    private Team team;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view= layoutInflater.inflate(R.layout.footballscore_squad_list, viewGroup, false);
        AppManage.getInstance(getActivity()).showNative((ViewGroup) view.findViewById(R.id.native_ads), ADMOB_N[0], FACEBOOK_N[0]);
        return view;
    }

    @SuppressLint("WrongConstant")
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.team = (Team) getArguments().getSerializable("teamDetails");
        this.squadList = (RecyclerView) view.findViewById(R.id.list);
        this.emptyView = (TextView) view.findViewById(R.id.tv_empty);
        BasicListAdapter r2 = new BasicListAdapter<TeamSquadPlayer, SquadViewHolder>(this.players) {
            public SquadViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
                return new SquadViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.footballscore_list_item_team_squad, viewGroup, false));
            }

            public void onBindViewHolder(SquadViewHolder squadViewHolder, int i) {
                final TeamSquadPlayer teamSquadPlayer = SquadFragment.this.players.get(i);

                Picasso.get().load("http://static.holoduke.nl/footapi/images/playerimages/" + teamSquadPlayer.getId() + ".png").into((ImageView) squadViewHolder.imageView);
                squadViewHolder.name.setText(teamSquadPlayer.getName());
                if (teamSquadPlayer.getPosition().equals("G")) {
                    squadViewHolder.description.setText("Goalkeeper");
                } else if (teamSquadPlayer.getPosition().equals("D")) {
                    squadViewHolder.description.setText("Defender");
                } else if (teamSquadPlayer.getPosition().equals("M")) {
                    squadViewHolder.description.setText("Midfielder");
                } else if (teamSquadPlayer.getPosition().equals("A")) {
                    squadViewHolder.description.setText("Attacker");
                }
                squadViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Intent intent = new Intent(SquadFragment.this.getContext(), footballscore_PlayerInfoActivity.class);
                        intent.putExtra("playerId", teamSquadPlayer.getId());
                        SquadFragment.this.getActivity().startActivity(intent);
                    }
                });
            }
        };
        this.squadListAdapter = r2;
        this.squadList.setAdapter(r2);
        this.squadList.setLayoutManager(new LinearLayoutManager(getContext()));
        if (this.team.getSquad() != null) {
            this.players.addAll(this.team.getSquad());
            this.squadListAdapter.notifyDataSetChanged();
        }
        this.emptyView.setVisibility(8);
        if (this.players.size() == 0) {
            this.emptyView.setVisibility(0);
        }
    }

    private static class SquadViewHolder extends RecyclerView.ViewHolder {
        protected CardView cardView;
        protected TextView description;
        protected CircleImageView imageView;
        protected TextView name;

        public SquadViewHolder(View view) {
            super(view);
            this.imageView = (CircleImageView) ViewHolder.get(view, R.id.image);
            this.name = (TextView) ViewHolder.get(view, R.id.tv_name);
            this.description = (TextView) ViewHolder.get(view, R.id.tv_description);
            this.cardView = (CardView) ViewHolder.get(view, R.id.squal_player_card);
        }
    }
}
