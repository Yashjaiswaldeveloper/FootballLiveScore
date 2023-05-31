package com.livetv.footballscore.livescores.activity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.livetv.footballscore.livescores.R;

public class footballscore_NewsDetailsActivity extends AppCompatActivity {
    public static final String EXTRA_URL = "url";
    private WebView mWebview;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.footballscore_activity_news_details);
        this.mWebview = (WebView) findViewById(R.id.webView);
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(true);
        setTitle("Details");
         String stringExtra = getIntent().getStringExtra("url");
        this.mWebview.getSettings().setJavaScriptEnabled(true);
        this.mWebview.setWebViewClient(new WebViewClient() {
            @SuppressLint("WrongConstant")
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                Toast.makeText(footballscore_NewsDetailsActivity.this, str, 0).show();
            }

            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                try {
                    progressDialog.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void onPageFinished(WebView webView, String str) {
                // TODO: 07-09-2021 Parth progressDialog null
//                ProgressDialog progressDialog = null;
                if (progressDialog != null) {
                    progressDialog.dismiss();
                }
            }
        });
        this.mWebview.loadUrl(stringExtra);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }
}
