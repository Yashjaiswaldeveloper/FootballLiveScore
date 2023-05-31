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
import com.livetv.footballscore.livescores.activity.footballscore_LeagueListActivity;
import com.livetv.footballscore.livescores.adapter.BasicListAdapter;
import com.livetv.footballscore.livescores.model.CountryAppStart;
import com.livetv.footballscore.livescores.model.FeedAppStart;
import com.livetv.footballscore.livescores.service.DefaultMessageHandler;
import com.livetv.footballscore.livescores.service.NetworkService;
import com.livetv.footballscore.livescores.util.DividerItemDecoration;
import com.livetv.footballscore.livescores.util.ViewHolder;
import com.pesonal.adsdk.AppManage;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import cz.msebera.android.httpclient.message.TokenParser;

public class HomeFragment extends Fragment {
    /* access modifiers changed from: private */
    public ArrayList<CountryAppStart> countries = new ArrayList<>();
    private RecyclerView countryList;
    public BasicListAdapter<CountryAppStart, CountryListViewHolder> countryListAdapter;
    public FeedAppStart feedAppStart;

    /* access modifiers changed from: private */
    private NetworkService networkService = new NetworkService();
    public int pos;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.e("countries", this.countries.size() + "");
        this.countryListAdapter = new BasicListAdapter<CountryAppStart, CountryListViewHolder>(this.countries) {
            public CountryListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
                return new CountryListViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.footballscore_list_item_country, viewGroup, false));
            }

            public void onBindViewHolder(CountryListViewHolder countryListViewHolder, final int i) {
                countryListViewHolder.countryName.setText(HomeFragment.this.countries.get(i).getCountry());

                StringBuilder sb = new StringBuilder();
                sb.append("http://static.holoduke.nl/footapi/images/flags/");
                HomeFragment homeFragment = HomeFragment.this;
                sb.append(homeFragment.prepareCountryName(homeFragment.countries.get(i).getCountry()));
                sb.append(".png");

                Picasso.get().load(sb.toString()).into(countryListViewHolder.countryImage);
                Log.e("check54217", "onBindViewHolder: " + sb);

                countryListViewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        HomeFragment.this.pos = i;
                        Intent intent = new Intent(HomeFragment.this.getActivity(), footballscore_LeagueListActivity.class);
                        intent.putExtra("country", HomeFragment.this.countries.get(pos));
                        HomeFragment.this.getActivity().startActivity(intent);
                    }
                });
            }
        };
        this.networkService.fetchFeedAppStart(new DefaultMessageHandler(getContext(), true) {
            public void onSuccess(Message message) {
                HomeFragment.this.feedAppStart = (FeedAppStart) message.obj;
                HomeFragment.this.countries.clear();
                HomeFragment.this.countries.addAll(HomeFragment.this.feedAppStart.getCountries());
                HomeFragment.this.replace(0, "Eurocups");
                HomeFragment.this.replace(1, "World Cup");
                HomeFragment.this.replace(2, "World Cup Qualifications");
                HomeFragment.this.replace(3, "Spain");
                HomeFragment.this.replace(4, "England");
                HomeFragment.this.replace(5, "Germany");
                HomeFragment.this.replace(6, "Italy");
                HomeFragment.this.replace(7, "France");
                HomeFragment.this.countryListAdapter.notifyDataSetChanged();
            }
        });
    }

    public void replace(int i, String str) {
        for (int i2 = 0; i2 < this.countries.size(); i2++) {
            if (this.countries.get(i2).getCountry().equals(str)) {
                ArrayList<CountryAppStart> arrayList = this.countries;
                arrayList.add(i, arrayList.get(i2));
                this.countries.remove(i + 1);
                return;
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view= layoutInflater.inflate(R.layout.footballscore_home_list, viewGroup, false);
        AppManage.getInstance(getActivity()).showNative((ViewGroup) view.findViewById(R.id.native_ads), ADMOB_N[0], FACEBOOK_N[0]);
        return view;

    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list);
        this.countryList = recyclerView;
        recyclerView.setAdapter(this.countryListAdapter);
        this.countryList.setLayoutManager(new LinearLayoutManager(getContext()));
        this.countryList.addItemDecoration(new DividerItemDecoration(getContext(), 1));
    }

    private static class CountryListViewHolder extends RecyclerView.ViewHolder {
        protected ImageView countryImage, imageView;
        protected TextView countryName;
        protected LinearLayout linearLayout;


        public CountryListViewHolder(View view) {
            super(view);
            this.countryImage = (ImageView) ViewHolder.get(view, R.id.img_team);
            this.countryName = (TextView) ViewHolder.get(view, R.id.tv_team_name);
            this.linearLayout = (LinearLayout) ViewHolder.get(view, R.id.country_layout);
            this.imageView = (ImageView) ViewHolder.get(view, R.id.backpress);

        }
    }

    public String prepareCountryName(String str) {
        return str.replace(TokenParser.SP, '-').toLowerCase();
    }

}
