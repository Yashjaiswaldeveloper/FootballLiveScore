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


public class Guide1 extends AppCompatActivity {

    TextView btn1, btn2, btn3, btn4;
    RelativeLayout native_ads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide1);

        btn1 = findViewById(R.id.btn1);
        native_ads = findViewById(R.id.native_ads);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        AppManage.getInstance(Guide1.this).loadInterstitialAd(this, ADMOB_I[0], FACEBOOK_I[0]);
        AppManage.getInstance(Guide1.this).showNative((ViewGroup) findViewById(R.id.native_ads), ADMOB_N[0], FACEBOOK_N[0]);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppManage.getInstance(Guide1.this).showInterstitialAd(Guide1.this, new AppManage.MyCallback() {
                    public void callbackCall() {
                        Intent intent = new Intent(Guide1.this, Guide_Detail_Activity.class);
                        intent.putExtra("data", getApplicationContext().getResources().getString(R.string.aa1));
                        startActivity(intent);
                    }
                }, "", AppManage.app_mainClickCntSwAd);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppManage.getInstance(Guide1.this).showInterstitialAd(Guide1.this, new AppManage.MyCallback() {
                    public void callbackCall() {
                        Intent intent = new Intent(Guide1.this, Guide_Detail_Activity.class);
                        intent.putExtra("data", getApplicationContext().getResources().getString(R.string.aa2));
                        startActivity(intent);
                    }
                }, "", AppManage.app_mainClickCntSwAd);

            }
        });


        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppManage.getInstance(Guide1.this).showInterstitialAd(Guide1.this, new AppManage.MyCallback() {
                    public void callbackCall() {
                        Intent intent = new Intent(Guide1.this, Guide_Detail_Activity.class);
                        intent.putExtra("data", getApplicationContext().getResources().getString(R.string.aa3));
                        startActivity(intent);
                    }
                }, "", AppManage.app_mainClickCntSwAd);

            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Guide1.this, Guide_Detail_Activity.class);
                intent.putExtra("data", getApplicationContext().getResources().getString(R.string.aa4));
                startActivity(intent);

            }
        });
    }

    @Override
    public void onBackPressed() {
        AppManage.getInstance(Guide1.this).showBackPressAd(Guide1.this, new AppManage.MyCallback() {
            @Override
            public void callbackCall() {
                Intent intent = new Intent(Guide1.this, Guide_Content_Activity.class);
                startActivity(intent);
            }
        });

    }
}