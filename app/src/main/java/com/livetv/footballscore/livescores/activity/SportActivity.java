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
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.livetv.footballscore.livescores.R;
import com.pesonal.adsdk.AppManage;

public class SportActivity extends AppCompatActivity {

    String uri;
    TextView cricket,asia,football,hockey,wrestling,motorsport,tennis,badminton,kabbadi,wwe,isl,allSport,videos;
    RelativeLayout native_ads;

    public void sendnext(String uri) {
//        uri = "https://www.mykhel.com/cricket/"; // missing 'http://' will cause crashed

        Intent intent = new Intent(SportActivity.this, ChannelActivity.class);
        intent.putExtra("urls", uri);
        startActivity(intent);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport);
        cricket=findViewById(R.id.cricket);
        asia=findViewById(R.id.asia);
        football=findViewById(R.id.football);
        hockey=findViewById(R.id.hockey);
        wrestling=findViewById(R.id.wrestling);
        motorsport=findViewById(R.id.motorsport);
        tennis=findViewById(R.id.tennis);
        badminton=findViewById(R.id.badminton);
        kabbadi=findViewById(R.id.kabbadi);
        wwe=findViewById(R.id.wwe);
        isl=findViewById(R.id.isl);
        allSport=findViewById(R.id.all_sport);
        videos=findViewById(R.id.videos);
        native_ads= findViewById(R.id.native_ads);
        AppManage.getInstance(SportActivity.this).loadInterstitialAd(this, ADMOB_I[0], FACEBOOK_I[0]);
        AppManage.getInstance(SportActivity.this).showNative((ViewGroup) findViewById(R.id.native_ads), ADMOB_N[0], FACEBOOK_N[0]);


        cricket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppManage.getInstance(SportActivity.this).showInterstitialAd(SportActivity.this, new AppManage.MyCallback() {
                    public void callbackCall() {
                uri = "https://www.mykhel.com/cricket/"; // missing 'http://' will cause crashed
                sendnext(uri);
                    }
                },"",AppManage.app_mainClickCntSwAd);

            }
        });

        asia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppManage.getInstance(SportActivity.this).showInterstitialAd(SportActivity.this, new AppManage.MyCallback() {
                    public void callbackCall() {
                uri = "https://www.mykhel.com/cricket/asia-cup-2022-s10/?ref_source=MK-Menu"; // missing 'http://' will cause crashed
                sendnext(uri);
                    }
                },"",AppManage.app_mainClickCntSwAd);

            }
        });

        football.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppManage.getInstance(SportActivity.this).showInterstitialAd(SportActivity.this, new AppManage.MyCallback() {
                    public void callbackCall() {
                uri = "https://www.mykhel.com/football/"; // missing 'http://' will cause crashed
                sendnext(uri);
                    }
                },"",AppManage.app_mainClickCntSwAd);

            }
        });

        hockey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppManage.getInstance(SportActivity.this).showInterstitialAd(SportActivity.this, new AppManage.MyCallback() {
                    public void callbackCall() {
                uri = "https://www.mykhel.com/hockey/news/"; // missing 'http://' will cause crashed
                sendnext(uri);
            }
        },"",AppManage.app_mainClickCntSwAd);

    }
        });

        wrestling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppManage.getInstance(SportActivity.this).showInterstitialAd(SportActivity.this, new AppManage.MyCallback() {
                    public void callbackCall() {
                uri = "https://www.mykhel.com/topic/wrestling"; // missing 'http://' will cause crashed
                sendnext(uri);
                    }
                },"",AppManage.app_mainClickCntSwAd);

            }
        });

        motorsport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppManage.getInstance(SportActivity.this).showInterstitialAd(SportActivity.this, new AppManage.MyCallback() {
                    public void callbackCall() {
                uri = "https://www.mykhel.com/motorsport/news/"; // missing 'http://' will cause crashed
                sendnext(uri);
            }
        },"",AppManage.app_mainClickCntSwAd);

    }
        });

        tennis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppManage.getInstance(SportActivity.this).showInterstitialAd(SportActivity.this, new AppManage.MyCallback() {
                    public void callbackCall() {
                uri = "https://www.mykhel.com/tennis/"; // missing 'http://' will cause crashed
                sendnext(uri);
                    }
                },"",AppManage.app_mainClickCntSwAd);

            }
        });

        badminton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppManage.getInstance(SportActivity.this).showInterstitialAd(SportActivity.this, new AppManage.MyCallback() {
                    public void callbackCall() {
                uri = "https://www.mykhel.com/badminton/news/"; // missing 'http://' will cause crashed
                sendnext(uri);
            }
        },"",AppManage.app_mainClickCntSwAd);

    }
        });
        kabbadi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppManage.getInstance(SportActivity.this).showInterstitialAd(SportActivity.this, new AppManage.MyCallback() {
                    public void callbackCall() {
                uri = "https://www.mykhel.com/kabaddi/news/"; // missing 'http://' will cause crashed
                sendnext(uri);
                    }
                },"",AppManage.app_mainClickCntSwAd);

            }
        });
        wwe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppManage.getInstance(SportActivity.this).showInterstitialAd(SportActivity.this, new AppManage.MyCallback() {
                    public void callbackCall() {
                uri = "https://www.mykhel.com/wwe/news/"; // missing 'http://' will cause crashed
                sendnext(uri);
            }
        },"",AppManage.app_mainClickCntSwAd);

    }
        });
        isl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppManage.getInstance(SportActivity.this).showInterstitialAd(SportActivity.this, new AppManage.MyCallback() {
                    public void callbackCall() {
                uri = "https://www.mykhel.com/indian-sports-leagues/"; // missing 'http://' will cause crashed
                sendnext(uri);
                    }
                },"",AppManage.app_mainClickCntSwAd);

            }
        });
        allSport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppManage.getInstance(SportActivity.this).showInterstitialAd(SportActivity.this, new AppManage.MyCallback() {
                    public void callbackCall() {
                uri = "https://www.mykhel.com/more-sports"; // missing 'http://' will cause crashed
                sendnext(uri);
            }
        },"",AppManage.app_mainClickCntSwAd);

    }
        });

        videos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppManage.getInstance(SportActivity.this).showInterstitialAd(SportActivity.this, new AppManage.MyCallback() {
                    public void callbackCall() {
                uri = "https://www.mykhel.com/videos/"; // missing 'http://' will cause crashed
                sendnext(uri);
                    }
                },"",AppManage.app_mainClickCntSwAd);

            }
        });
    }


    @Override
    public void onBackPressed() {
        AppManage.getInstance(SportActivity.this).showBackPressAd(SportActivity.this, new AppManage.MyCallback() {
           @Override
            public void callbackCall() {
               startActivity(new Intent(getApplicationContext(), SelectSportActivity.class));
           }
        });
    }
}