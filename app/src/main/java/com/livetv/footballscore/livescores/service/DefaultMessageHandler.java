package com.livetv.footballscore.livescores.service;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.livetv.footballscore.livescores.R;
import java.lang.ref.WeakReference;

public class DefaultMessageHandler extends Handler {
    private WeakReference<Context> contextWeakReference;
    private ProgressDialog progressDialog;

    public void onFailure(Message message) {
    }

    public void onSuccess(Message message) {
    }

    public DefaultMessageHandler(Context context, boolean z) {
        this.contextWeakReference = new WeakReference<>(context);
        if (z) {
            ProgressDialog progressDialog2 = new ProgressDialog((Context) this.contextWeakReference.get(), R.style.Theme_Football_Dialog);
            this.progressDialog = progressDialog2;
            progressDialog2.setIndeterminate(true);
            this.progressDialog.setCancelable(false);
            this.progressDialog.show();
            this.progressDialog.setContentView(R.layout.footballscore_loading_spinner);
        }
    }

    public void handleMessage(Message message) {
        ProgressDialog progressDialog2 = this.progressDialog;
        if (progressDialog2 != null && progressDialog2.isShowing()) {
            this.progressDialog.dismiss();
        }
        if (message.what == 1) {
            onSuccess(message);
        } else {
            onFailure(message);
        }
    }
}
