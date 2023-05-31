package com.livetv.footballscore.livescores.activity;

import static com.pesonal.adsdk.AppManage.ADMOB_I;
import static com.pesonal.adsdk.AppManage.ADMOB_N;
import static com.pesonal.adsdk.AppManage.FACEBOOK_I;
import static com.pesonal.adsdk.AppManage.FACEBOOK_N;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.livetv.footballscore.livescores.R;
import com.pesonal.adsdk.AppManage;


public class footballscore_FirstActivity extends AppCompatActivity {

    LinearLayout startguide, startguide1, startguide2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thop_activity_first);
        startguide = (LinearLayout) findViewById(R.id.startguide);
        startguide1 = (LinearLayout) findViewById(R.id.startguide1);
        startguide2 = (LinearLayout) findViewById(R.id.startguide2);
        AppManage.getInstance(footballscore_FirstActivity.this).loadInterstitialAd(this, ADMOB_I[0], FACEBOOK_I[0]);
        AppManage.getInstance(footballscore_FirstActivity.this).showNative((ViewGroup) findViewById(R.id.native_ads), ADMOB_N[0], FACEBOOK_N[0]);


        startguide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppManage.getInstance(footballscore_FirstActivity.this).showInterstitialAd(footballscore_FirstActivity.this, new AppManage.MyCallback() {
                    public void callbackCall() {
                        Intent intent = new Intent(footballscore_FirstActivity.this, SelectSportActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                   }
                }, "", AppManage.app_mainClickCntSwAd);

            }
        });
        startguide1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppManage.getInstance(footballscore_FirstActivity.this).showInterstitialAd(footballscore_FirstActivity.this, new AppManage.MyCallback() {
                    public void callbackCall() {
                        Intent intent = new Intent(footballscore_FirstActivity.this, footballscore_MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                }, "", AppManage.app_mainClickCntSwAd);

            }
        });

        startguide2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppManage.getInstance(footballscore_FirstActivity.this).showInterstitialAd(footballscore_FirstActivity.this, new AppManage.MyCallback() {
                    public void callbackCall() {
                        Intent intent = new Intent(footballscore_FirstActivity.this, Guide_Content_Activity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                }, "", AppManage.app_mainClickCntSwAd);

            }
        });

    }

    @Override
    public void onBackPressed() {
        AppManage.getInstance(footballscore_FirstActivity.this).showBackPressAd(footballscore_FirstActivity.this, new AppManage.MyCallback() {
            @Override
           public void callbackCall() {
                startActivity(new Intent(getApplicationContext(), ExitActivity.class));
                }
            });
    }
}