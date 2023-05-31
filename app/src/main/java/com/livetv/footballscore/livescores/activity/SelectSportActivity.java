package com.livetv.footballscore.livescores.activity;

import static com.pesonal.adsdk.AppManage.ADMOB_N;
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

public class SelectSportActivity extends AppCompatActivity {
    TextView btnChannle1;
    RelativeLayout native_ads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_sport);
        btnChannle1=findViewById(R.id.btnChannle1);
        native_ads= findViewById(R.id.native_ads);
        AppManage.getInstance(SelectSportActivity.this).loadInterstitialAd(this);
        AppManage.getInstance(SelectSportActivity.this).showNative((ViewGroup) findViewById(R.id.native_ads), ADMOB_N[0], FACEBOOK_N[0]);

        btnChannle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppManage.getInstance(SelectSportActivity.this).showInterstitialAd(SelectSportActivity.this, new AppManage.MyCallback() {
                    public void callbackCall() {

                startActivity(new Intent(SelectSportActivity.this,SportActivity.class));
                    }
                },"",AppManage.app_mainClickCntSwAd);

            }
        });
    }

    @Override
    public void onBackPressed() {
        AppManage.getInstance(SelectSportActivity.this).showBackPressAd(SelectSportActivity.this, new AppManage.MyCallback() {
            @Override
            public void callbackCall() {
                startActivity(new Intent(getApplicationContext(), footballscore_FirstActivity.class));
            }
        });
    }
}

