package com.livetv.footballscore.livescores.activity;

import static com.pesonal.adsdk.AppManage.ADMOB_I;
import static com.pesonal.adsdk.AppManage.ADMOB_N;
import static com.pesonal.adsdk.AppManage.FACEBOOK_I;
import static com.pesonal.adsdk.AppManage.FACEBOOK_N;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.livetv.footballscore.livescores.R;
import com.livetv.footballscore.livescores.databinding.ActivityChannelBinding;
import com.pesonal.adsdk.AppManage;

public class ChannelActivity extends AppCompatActivity {
    TextView liveChannel,liveScore;
    String uri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel);
        uri = getIntent().getStringExtra("urls");
        liveChannel=findViewById(R.id.live_channel);
        liveScore=findViewById(R.id.live_score);
        AppManage.getInstance(ChannelActivity.this).showNative((ViewGroup) findViewById(R.id.native_ads), ADMOB_N[0], FACEBOOK_N[0]);
        AppManage.getInstance(ChannelActivity.this).loadInterstitialAd(this, ADMOB_I[0], FACEBOOK_I[0]);

        liveChannel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppManage.getInstance(ChannelActivity.this).showInterstitialAd(ChannelActivity.this, new AppManage.MyCallback() {
                    public void callbackCall() {
                        startActivity(new Intent(ChannelActivity.this, LiveChannelActivity.class));
                    }
                }, "", AppManage.app_mainClickCntSwAd);
            }
        });

        liveScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppManage.getInstance(ChannelActivity.this).showInterstitialAd(ChannelActivity.this, new AppManage.MyCallback() {
                    public void callbackCall() {
                        startActivity(new Intent(ChannelActivity.this, MyWebActivity.class).putExtra("urls", uri));

                    }
                }, "", AppManage.app_mainClickCntSwAd);
            }
        });
    }

    @Override
    public void onBackPressed() {
        AppManage.getInstance(ChannelActivity.this).showBackPressAd(ChannelActivity.this, new AppManage.MyCallback() {
            @Override
            public void callbackCall() {
                startActivity(new Intent(getApplicationContext(), SportActivity.class));
            }
        });
    }
}
