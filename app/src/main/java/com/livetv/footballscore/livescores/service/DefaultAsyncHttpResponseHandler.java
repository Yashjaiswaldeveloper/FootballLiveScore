package com.livetv.footballscore.livescores.service;

import android.os.Handler;
import android.os.Message;
import com.livetv.footballscore.livescores.util.StringUtils;
import com.loopj.android.http.AsyncHttpResponseHandler;
import java.lang.reflect.Type;
import java.util.Collection;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;
import cz.msebera.android.httpclient.Header;

public class DefaultAsyncHttpResponseHandler extends AsyncHttpResponseHandler {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private Handler handler;
    private JavaType valueType;

    public DefaultAsyncHttpResponseHandler(Handler handler2) {
        this(handler2, Void.class);
    }

    public DefaultAsyncHttpResponseHandler(Handler handler2, Type type) {
        this.handler = handler2;
        this.valueType = objectMapper.getTypeFactory().constructType(type);
    }

    public DefaultAsyncHttpResponseHandler(Handler handler2, Type type, Class<? extends Collection> cls) {
        this.handler = handler2;
        this.valueType = objectMapper.getTypeFactory().constructCollectionType(cls, (Class<?>) (Class) type);
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        try {
            sendMessageToTarget(1, objectMapper.readValue(StringUtils.getStringFromBytes(bArr), this.valueType));
        } catch (Exception e) {
            sendMessageToTarget(0, "Failed " + e.toString());
            e.printStackTrace();
        }
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        sendMessageToTarget(0, "Failed " + StringUtils.getStringFromBytes(bArr));
    }

    private void sendMessageToTarget(int i, Object obj) {
        Message.obtain(this.handler, i, obj).sendToTarget();
    }
}
