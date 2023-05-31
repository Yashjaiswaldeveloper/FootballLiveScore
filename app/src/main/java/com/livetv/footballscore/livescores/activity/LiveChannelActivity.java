package com.livetv.footballscore.livescores.activity;

import static com.pesonal.adsdk.AppManage.ADMOB_I;
import static com.pesonal.adsdk.AppManage.ADMOB_N;
import static com.pesonal.adsdk.AppManage.FACEBOOK_I;
import static com.pesonal.adsdk.AppManage.FACEBOOK_N;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.livetv.footballscore.livescores.R;
import com.livetv.footballscore.livescores.databinding.ActivityLiveChannelBinding;
import com.pesonal.adsdk.AppManage;

import java.util.Arrays;
import java.util.Collections;

public class LiveChannelActivity extends AppCompatActivity {
    ActivityLiveChannelBinding binding;
    public static String Livelink2 = ".m3u8";
    public static String Livelink1 = ".m3u8";
    public static String Livelink3 = ".m3u8";
    public static String Livelink4 = ".m3u8";
    public static String Livelink5 = ".m3u8";
    public static String Livelink6 = ".m3u8";
    TextView liveChannel1,liveChannel2,liveChannel3;
    String link[] = {Livelink1, Livelink2, Livelink3, Livelink4, Livelink5, Livelink6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_channel);
        liveChannel1=findViewById(R.id.live_channel1);
        liveChannel2=findViewById(R.id.live_channel2);
        liveChannel3=findViewById(R.id.live_channel3);
        AppManage.getInstance(LiveChannelActivity.this).showNative((ViewGroup) findViewById(R.id.native_ads), ADMOB_N[0], FACEBOOK_N[0]);
        AppManage.getInstance(LiveChannelActivity.this).loadInterstitialAd(this, ADMOB_I[0], FACEBOOK_I[0]);

        Collections.shuffle(Arrays.asList(link));

        liveChannel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppManage.getInstance(LiveChannelActivity.this).showInterstitialAd(LiveChannelActivity.this, new AppManage.MyCallback() {
                    public void callbackCall() {
                playerOpenn(link[0]);
                    }
                },"",AppManage.app_mainClickCntSwAd);
            }
        });
        liveChannel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppManage.getInstance(LiveChannelActivity.this).showInterstitialAd(LiveChannelActivity.this, new AppManage.MyCallback() {
                    public void callbackCall() {
                playerOpenn(link[1]);
                    }
                },"",AppManage.app_mainClickCntSwAd);
            }
        });
        liveChannel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppManage.getInstance(LiveChannelActivity.this).showInterstitialAd(LiveChannelActivity.this, new AppManage.MyCallback() {
                    public void callbackCall() {
                playerOpenn(link[2]);
                    }
                },"",AppManage.app_mainClickCntSwAd);
            }
        });
    }

    public void playerOpenn(String link) {

        Intent intent = new Intent(LiveChannelActivity.this, AritelLive_SportChannelContent.class);
        intent.putExtra("link", link);
        startActivity(intent);


    }


    @Override
    public void onBackPressed() {

        AppManage.getInstance(LiveChannelActivity.this).showBackPressAd(LiveChannelActivity.this, new AppManage.MyCallback() {
            @Override
            public void callbackCall() {
                startActivity(new Intent(getApplicationContext(), ChannelActivity.class));

            }
        });
    }

}