package com.livetv.footballscore.livescores.fragments;

import static com.pesonal.adsdk.AppManage.ADMOB_N;
import static com.pesonal.adsdk.AppManage.FACEBOOK_N;

import android.annotation.SuppressLint;
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
import com.livetv.footballscore.livescores.adapter.BasicListAdapter;
import com.livetv.footballscore.livescores.model.Team;
import com.livetv.footballscore.livescores.model.TransferPlayer;
import com.livetv.footballscore.livescores.util.ViewHolder;
import com.pesonal.adsdk.AppManage;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import de.hdodenhof.circleimageview.CircleImageView;

public class TransferFragment extends Fragment {
    private TextView emptyView;
    private Team team;
    private RecyclerView transferList;
    private BasicListAdapter<TransferPlayer, TransferListViewHolder> transferListAdapter;
    public ArrayList<TransferPlayer> transferPlayers = new ArrayList<>();

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view= layoutInflater.inflate(R.layout.footballscore_transfer_list, viewGroup, false);
        AppManage.getInstance(getActivity()).showNative((ViewGroup) view.findViewById(R.id.native_ads), ADMOB_N[0], FACEBOOK_N[0]);
        return view;
    }

    @SuppressLint("WrongConstant")
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.transferList = (RecyclerView) view.findViewById(R.id.list);
        this.emptyView = (TextView) view.findViewById(R.id.tv_empty);
        BasicListAdapter r2 = new BasicListAdapter<TransferPlayer, TransferListViewHolder>(this.transferPlayers) {
            public TransferListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
                return new TransferListViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.footballscore_list_item_transfer, viewGroup, false));
            }

            public void onBindViewHolder(TransferListViewHolder transferListViewHolder, int i) {
                TransferPlayer transferPlayer = TransferFragment.this.transferPlayers.get(i);
                transferListViewHolder.name.setText(transferPlayer.getName());
                transferListViewHolder.description.setText(transferPlayer.getDate());
                transferListViewHolder.price.setText(transferPlayer.getType());
                if (transferPlayer.getTo() == null) {
                    transferListViewHolder.toTeam.setText(transferPlayer.getFrom());
                    transferListViewHolder.inOut.setImageDrawable(TransferFragment.this.getResources().getDrawable(R.drawable.in));
                } else {
                    transferListViewHolder.toTeam.setText(transferPlayer.getTo());
                    transferListViewHolder.inOut.setImageDrawable(TransferFragment.this.getResources().getDrawable(R.drawable.out));
                }
                Picasso.get().load("http://static.holoduke.nl/footapi/images/playerimages/" + transferPlayer.getId() + ".png").into((ImageView) transferListViewHolder.imageView);
            }
        };
        this.transferListAdapter = r2;
        this.transferList.setAdapter(r2);
        this.transferList.setLayoutManager(new LinearLayoutManager(getContext()));
        Team team2 = (Team) getArguments().getSerializable("teamDetails");
        this.team = team2;
        if (team2.getTransfers() != null) {
            this.transferPlayers.addAll(this.team.getTransfers().getIn());
            this.transferPlayers.addAll(this.team.getTransfers().getOut());
            this.transferListAdapter.notifyDataSetChanged();
        }
        this.emptyView.setVisibility(8);
        if (this.transferPlayers.size() == 0) {
            this.emptyView.setVisibility(0);
        }
    }

    private static class TransferListViewHolder extends RecyclerView.ViewHolder {
        protected CardView cardView;
        protected TextView description;
        protected CircleImageView imageView;
        protected ImageView inOut;
        protected TextView name;
        protected TextView price;
        protected TextView toTeam;

        public TransferListViewHolder(View view) {
            super(view);
            this.imageView = (CircleImageView) ViewHolder.get(view, R.id.image);
            this.name = (TextView) ViewHolder.get(view, R.id.tv_name);
            this.description = (TextView) ViewHolder.get(view, R.id.tv_description);
            this.cardView = (CardView) ViewHolder.get(view, R.id.squal_player_card);
            this.toTeam = (TextView) ViewHolder.get(view, R.id.tv_to_team);
            this.price = (TextView) ViewHolder.get(view, R.id.tv_price);
            this.inOut = (ImageView) ViewHolder.get(view, R.id.in_out_image);
        }
    }
}
