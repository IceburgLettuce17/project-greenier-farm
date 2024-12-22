package com.facebook;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

final class GetTokenClient implements ServiceConnection {
    final String applicationId;
    final Context context;
    final Handler handler;
    CompletedListener listener;
    boolean running;
    Messenger sender;

    interface CompletedListener {
        void completed(Bundle bundle);
    }

    GetTokenClient(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.context = applicationContext != null ? applicationContext : context;
        this.applicationId = str;
        this.handler = new Handler() {
            @Override
            public void handleMessage(Message message) {
                GetTokenClient.this.handleMessage(message);
            }
        };
    }

    private void callback(Bundle bundle) {
        if (this.running) {
            this.running = false;
            CompletedListener completedListener = this.listener;
            if (completedListener != null) {
                completedListener.completed(bundle);
            }
        }
    }

    private void getToken() {
        Bundle bundle = new Bundle();
        bundle.putString("com.facebook.platform.extra.APPLICATION_ID", this.applicationId);
        Message obtain = Message.obtain((Handler) null, 65536);
        obtain.arg1 = 20121101;
        obtain.setData(bundle);
        obtain.replyTo = new Messenger(this.handler);
        try {
            this.sender.send(obtain);
        } catch (RemoteException e) {
            callback(null);
        }
    }

    public void handleMessage(Message message) {
        if (message.what == 65537) {
            Bundle data = message.getData();
            if (data.getString("com.facebook.platform.status.ERROR_TYPE") != null) {
                callback(null);
            } else {
                callback(data);
            }
            this.context.unbindService(this);
        }
    }

    final void cancel() {
        this.running = false;
    }

    @Override
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.sender = new Messenger(iBinder);
        getToken();
    }

    @Override
    public final void onServiceDisconnected(ComponentName componentName) {
        this.sender = null;
        this.context.unbindService(this);
        callback(null);
    }

    final void setCompletedListener(CompletedListener completedListener) {
        this.listener = completedListener;
    }

    final boolean start() {
        Intent intent = new Intent("com.facebook.platform.PLATFORM_SERVICE");
        intent.addCategory("android.intent.category.DEFAULT");
        Intent validateKatanaServiceIntent = NativeProtocol.validateKatanaServiceIntent(this.context, intent);
        if (validateKatanaServiceIntent == null) {
            callback(null);
            return false;
        }
        this.running = true;
        this.context.bindService(validateKatanaServiceIntent, this, 1);
        return true;
    }
}
