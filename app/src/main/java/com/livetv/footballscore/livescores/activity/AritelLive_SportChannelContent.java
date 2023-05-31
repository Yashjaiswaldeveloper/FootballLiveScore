package com.livetv.footballscore.livescores.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.livetv.footballscore.livescores.R;
import com.potyvideo.library.AndExoPlayerView;

public class AritelLive_SportChannelContent extends AppCompatActivity {

    AndExoPlayerView exoPlayerView;
    private String link;
    Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aritel_live_sport_channel_content);

        this.exoPlayerView = findViewById(R.id.andExoPlayerView);


        String string = getIntent().getExtras().getString("link");
        this.link = string;
        this.exoPlayerView.setSource(string);

    }

    @Override
    public void onBackPressed() {

        AritelLive_SportChannelContent.super.onBackPressed();
    }

    public void notfounddialog()
    {

        final Dialog dialog = new Dialog(AritelLive_SportChannelContent.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.linknotfound);
        dialog.setCancelable(true);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
//        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;

        TextView textOkay;
        ImageView emoji;
        textOkay = dialog.findViewById(R.id.okay);

        textOkay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                finish();
                Intent intent=new Intent(AritelLive_SportChannelContent.this, LiveChannelActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(AritelLive_SportChannelContent.this, "Please Retry...", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }
}