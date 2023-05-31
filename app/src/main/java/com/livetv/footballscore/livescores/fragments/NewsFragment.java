package com.livetv.footballscore.livescores.fragments;

import static com.pesonal.adsdk.AppManage.ADMOB_N;
import static com.pesonal.adsdk.AppManage.FACEBOOK_N;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
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
import com.livetv.footballscore.livescores.activity.footballscore_NewsDetailsActivity;
import com.livetv.footballscore.livescores.adapter.BasicListAdapter;
import com.livetv.footballscore.livescores.model.News;
import com.livetv.footballscore.livescores.model.NewsItem;
import com.livetv.footballscore.livescores.service.DefaultMessageHandler;
import com.livetv.footballscore.livescores.service.NetworkService;
import com.livetv.footballscore.livescores.util.DividerItemDecoration;
import com.livetv.footballscore.livescores.util.ViewHolder;
import com.pesonal.adsdk.AppManage;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class NewsFragment extends Fragment {
    /* access modifiers changed from: private */
    /* access modifiers changed from: private */
    private NetworkService networkService = new NetworkService();
    public News news;
    RelativeLayout native_ads;
    /* access modifiers changed from: private */
    public NewsItem newsItem;
    public ArrayList<NewsItem> newsItems = new ArrayList<>();
    private RecyclerView newsList;
    public BasicListAdapter<NewsItem, NewsViewHolder> newsListAdapter;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        this.newsListAdapter = new BasicListAdapter<NewsItem, NewsViewHolder>(this.newsItems) {
            public NewsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
                return new NewsViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.footballscore_list_item_news, viewGroup, false));
            }

            public void onBindViewHolder(NewsViewHolder newsViewHolder, final int i) {
                final NewsItem newsItem = NewsFragment.this.newsItems.get(i);
                Picasso.get().load(newsItem.getImage()).resize(50, 50).placeholder((int) R.drawable.news_visual_voetbalnieuws).into((ImageView) newsViewHolder.image);
                newsViewHolder.title.setText(newsItem.getTitle());
                newsViewHolder.date.setText(newsItem.getDate());
                newsViewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        NewsItem unused = NewsFragment.this.newsItem = NewsFragment.this.newsItems.get(i);
                        Intent intent = new Intent(NewsFragment.this.getContext(), footballscore_NewsDetailsActivity.class);
                        intent.putExtra("url", newsItem.getLink());
                        NewsFragment.this.getActivity().startActivity(intent);
                    }
                });
            }
        };
        this.networkService.fetchNewsList(new DefaultMessageHandler(getContext(), true) {
            public void onSuccess(Message message) {
                NewsFragment.this.news = (News) message.obj;
                NewsFragment.this.newsItems.addAll(NewsFragment.this.news.getItems());
                NewsFragment.this.newsListAdapter.notifyDataSetChanged();
            }
        });
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.native_ads = view.findViewById(R.id.native_ads);
        AppManage.getInstance(getActivity().getApplicationContext()).showNative((ViewGroup) view.findViewById(R.id.native_ads), ADMOB_N[0], FACEBOOK_N[0]);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list);
        this.newsList = recyclerView;
        recyclerView.setAdapter(this.newsListAdapter);
        this.newsList.setLayoutManager(new LinearLayoutManager(getContext()));
        this.newsList.addItemDecoration(new DividerItemDecoration(getContext(), 1));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.footballscore_news_list, viewGroup, false);
    }

    private static class NewsViewHolder extends RecyclerView.ViewHolder {
        protected TextView date;
        protected CircleImageView image;
        protected LinearLayout linearLayout;
        protected TextView title;

        public NewsViewHolder(View view) {
            super(view);
            this.image = (CircleImageView) ViewHolder.get(view, R.id.img_news);
            this.title = (TextView) ViewHolder.get(view, R.id.tv_title);
            this.date = (TextView) ViewHolder.get(view, R.id.tv_date);
            this.linearLayout = (LinearLayout) ViewHolder.get(view, R.id.linear_layout);
        }
    }

}
