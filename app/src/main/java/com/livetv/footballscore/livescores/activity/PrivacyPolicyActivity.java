package com.livetv.footballscore.livescores.activity;

import static com.pesonal.adsdk.AppManage.ADMOB_N;
import static com.pesonal.adsdk.AppManage.FACEBOOK_N;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.livetv.footballscore.livescores.R;
import com.pesonal.adsdk.AppManage;

public class PrivacyPolicyActivity extends AppCompatActivity {
    CheckBox checkbox;
    TextView privacy_policy;
    RelativeLayout agree_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy2);
        AppManage.getInstance(PrivacyPolicyActivity.this).loadInterstitialAd(this);
        agree_btn = findViewById(R.id.agree_btn);
        checkbox = findViewById(R.id.checkBox);
        privacy_policy = findViewById(R.id.privacy_policy);
        AppManage.getInstance(PrivacyPolicyActivity.this).showNative((ViewGroup) findViewById(R.id.native_ads), ADMOB_N[0], FACEBOOK_N[0]);
        privacy_policy.setOnClickListener(v -> gotoUrl("https://techiemediaadvertising.blogspot.com/2022/06/techiemedia-inc.html"));

        agree_btn.setOnClickListener(v -> {
            if (checkbox.isChecked()) {
                Intent intent = new Intent(PrivacyPolicyActivity.this, footballscore_FirstActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(PrivacyPolicyActivity.this, "Please Accept Privacy Policy", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}