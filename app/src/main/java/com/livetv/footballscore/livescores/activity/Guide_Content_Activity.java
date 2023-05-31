package com.livetv.footballscore.livescores.activity;

import static com.pesonal.adsdk.AppManage.ADMOB_I;
import static com.pesonal.adsdk.AppManage.ADMOB_N;
import static com.pesonal.adsdk.AppManage.FACEBOOK_I;
import static com.pesonal.adsdk.AppManage.FACEBOOK_N;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.livetv.footballscore.livescores.R;
import com.pesonal.adsdk.AppManage;

public class Guide_Content_Activity extends AppCompatActivity {

    TextView guide_live_ipl_2022, guide_striming;
    RelativeLayout native_ads;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_content);

        guide_live_ipl_2022 = findViewById(R.id.guide_live_ipl_2022);
        native_ads = findViewById(R.id.native_ads);
        guide_striming = findViewById(R.id.guide_striming);
        AppManage.getInstance(Guide_Content_Activity.this).showNative((ViewGroup) findViewById(R.id.native_ads), ADMOB_N[0], FACEBOOK_N[0]);
        AppManage.getInstance(Guide_Content_Activity.this).loadInterstitialAd(this, ADMOB_I[0], FACEBOOK_I[0]);


        guide_live_ipl_2022.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppManage.getInstance(Guide_Content_Activity.this).showInterstitialAd(Guide_Content_Activity.this, new AppManage.MyCallback() {
                    public void callbackCall() {
                        Intent intent = new Intent(Guide_Content_Activity.this, Guide1.class);
                        startActivity(intent);
                   }
                },"",AppManage.app_mainClickCntSwAd);

            }
        });

        guide_striming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppManage.getInstance(Guide_Content_Activity.this).showInterstitialAd(Guide_Content_Activity.this, new AppManage.MyCallback() {
                    public void callbackCall() {
                        Intent intent = new Intent(Guide_Content_Activity.this, Guide2.class);
                        startActivity(intent);
                    }
                },"",AppManage.app_mainClickCntSwAd);

            }
        });
    }


    @Override
    public void onBackPressed() {
        AppManage.getInstance(Guide_Content_Activity.this).showBackPressAd(Guide_Content_Activity.this, new AppManage.MyCallback() {
            @Override
            public void callbackCall() {
                Intent intent = new Intent(Guide_Content_Activity.this, footballscore_FirstActivity.class);
                startActivity(intent);

            }
        });

    }
}