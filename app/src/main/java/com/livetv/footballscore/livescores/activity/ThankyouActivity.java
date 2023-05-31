package com.livetv.footballscore.livescores.activity;

import static com.pesonal.adsdk.AppManage.ADMOB_N;
import static com.pesonal.adsdk.AppManage.FACEBOOK_N;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.livetv.footballscore.livescores.R;
import com.pesonal.adsdk.AppManage;

public class ThankyouActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thankyou);

    }

    @Override
    public void onBackPressed() {
        finishAffinity();
        System.exit(0);
    }
}