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


public class Guide2 extends AppCompatActivity {

    TextView btn, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10;
    RelativeLayout native_ads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide2);

        btn = findViewById(R.id.btn);
        native_ads = findViewById(R.id.native_ads);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn10 = findViewById(R.id.btn10);
        AppManage.getInstance(Guide2.this).showNative((ViewGroup) findViewById(R.id.native_ads), ADMOB_N[0], FACEBOOK_N[0]);
        AppManage.getInstance(Guide2.this).loadInterstitialAd(this, ADMOB_I[0], FACEBOOK_I[0]);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               AppManage.getInstance(Guide2.this).showInterstitialAd(Guide2.this, new AppManage.MyCallback() {
                   public void callbackCall() {
                        Intent intent = new Intent(Guide2.this, Guide_Detail_Activity.class);
                        intent.putExtra("data", getApplicationContext().getResources().getString(R.string.bb));
                        startActivity(intent);
                    }
                },"",AppManage.app_mainClickCntSwAd);

            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppManage.getInstance(Guide2.this).showInterstitialAd(Guide2.this, new AppManage.MyCallback() {
                    public void callbackCall() {
                        Intent intent = new Intent(Guide2.this, Guide_Detail_Activity.class);
                        intent.putExtra("data", getApplicationContext().getResources().getString(R.string.bb1));
                        startActivity(intent);
                   }
               },"",AppManage.app_mainClickCntSwAd);

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppManage.getInstance(Guide2.this).showInterstitialAd(Guide2.this, new AppManage.MyCallback() {
                    public void callbackCall() {
                        Intent intent = new Intent(Guide2.this, Guide_Detail_Activity.class);
                        intent.putExtra("data", getApplicationContext().getResources().getString(R.string.bb2));
                        startActivity(intent);
                    }
                },"",AppManage.app_mainClickCntSwAd);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppManage.getInstance(Guide2.this).showInterstitialAd(Guide2.this, new AppManage.MyCallback() {
                    public void callbackCall() {
                        Intent intent = new Intent(Guide2.this, Guide_Detail_Activity.class);
                        intent.putExtra("data", getApplicationContext().getResources().getString(R.string.bb3));
                        startActivity(intent);
                    }
                },"",AppManage.app_mainClickCntSwAd);

            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppManage.getInstance(Guide2.this).showInterstitialAd(Guide2.this, new AppManage.MyCallback() {
                    public void callbackCall() {
                        Intent intent = new Intent(Guide2.this, Guide_Detail_Activity.class);
                        intent.putExtra("data", getApplicationContext().getResources().getString(R.string.bb4));
                        startActivity(intent);
                    }
                },"",AppManage.app_mainClickCntSwAd);

            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppManage.getInstance(Guide2.this).showInterstitialAd(Guide2.this, new AppManage.MyCallback() {
                    public void callbackCall() {
                        Intent intent = new Intent(Guide2.this, Guide_Detail_Activity.class);
                        intent.putExtra("data", getApplicationContext().getResources().getString(R.string.bb5));
                        startActivity(intent);
                    }
                },"",AppManage.app_mainClickCntSwAd);

            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppManage.getInstance(Guide2.this).showInterstitialAd(Guide2.this, new AppManage.MyCallback() {
                    public void callbackCall() {
                        Intent intent = new Intent(Guide2.this, Guide_Detail_Activity.class);
                        intent.putExtra("data", getApplicationContext().getResources().getString(R.string.bb6));
                        startActivity(intent);
                    }
                },"",AppManage.app_mainClickCntSwAd);

            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppManage.getInstance(Guide2.this).showInterstitialAd(Guide2.this, new AppManage.MyCallback() {
                    public void callbackCall() {
                        Intent intent = new Intent(Guide2.this, Guide_Detail_Activity.class);
                        intent.putExtra("data", getApplicationContext().getResources().getString(R.string.bb7));
                        startActivity(intent);
                    }
                },"",AppManage.app_mainClickCntSwAd);

            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppManage.getInstance(Guide2.this).showInterstitialAd(Guide2.this, new AppManage.MyCallback() {
                    public void callbackCall() {
                        Intent intent = new Intent(Guide2.this, Guide_Detail_Activity.class);
                        intent.putExtra("data", getApplicationContext().getResources().getString(R.string.bb8));
                        startActivity(intent);
                    }
                },"",AppManage.app_mainClickCntSwAd);

            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppManage.getInstance(Guide2.this).showInterstitialAd(Guide2.this, new AppManage.MyCallback() {
                    public void callbackCall() {
                        Intent intent = new Intent(Guide2.this, Guide_Detail_Activity.class);
                        intent.putExtra("data", getApplicationContext().getResources().getString(R.string.bb9));
                        startActivity(intent);
                    }
                },"",AppManage.app_mainClickCntSwAd);

            }
        });

        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppManage.getInstance(Guide2.this).showInterstitialAd(Guide2.this, new AppManage.MyCallback() {
                    public void callbackCall() {
                        Intent intent = new Intent(Guide2.this, Guide_Detail_Activity.class);
                        intent.putExtra("data", getApplicationContext().getResources().getString(R.string.bb10));
                        startActivity(intent);
                    }
                },"",AppManage.app_mainClickCntSwAd);

            }
        });
    }

    @Override
    public void onBackPressed() {
        AppManage.getInstance(Guide2.this).showBackPressAd(Guide2.this, new AppManage.MyCallback() {
            @Override
            public void callbackCall() {
                Intent intent = new Intent(Guide2.this, Guide_Content_Activity.class);
                startActivity(intent);
                //finish();
            }
        });

    }
}