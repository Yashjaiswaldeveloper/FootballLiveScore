package com.livetv.footballscore.livescores.activity;

import static com.pesonal.adsdk.AppManage.ADMOB_I;
import static com.pesonal.adsdk.AppManage.ADMOB_N;
import static com.pesonal.adsdk.AppManage.FACEBOOK_I;
import static com.pesonal.adsdk.AppManage.FACEBOOK_N;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.livetv.footballscore.livescores.R;
import com.pesonal.adsdk.AppManage;


public class Guide_Detail_Activity extends AppCompatActivity {

    TextView text;
    RelativeLayout native_ads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_detail);
        AppManage.getInstance(Guide_Detail_Activity.this).showNative((ViewGroup) findViewById(R.id.native_ads), ADMOB_N[0], FACEBOOK_N[0]);
        AppManage.getInstance(Guide_Detail_Activity.this).loadInterstitialAd(this, ADMOB_I[0], FACEBOOK_I[0]);

        text = findViewById(R.id.text);
        native_ads = findViewById(R.id.native_ads);
        String text1 = getIntent().getStringExtra("data");

        text.setText(text1);
    }


    @Override
    public void onBackPressed() {
        AppManage.getInstance(Guide_Detail_Activity.this).showBackPressAd(Guide_Detail_Activity.this, new AppManage.MyCallback() {
            @Override
            public void callbackCall() {
                Guide_Detail_Activity.super.onBackPressed();
            }
        });
    }
}