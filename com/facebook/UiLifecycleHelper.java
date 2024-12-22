package com.facebook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.facebook.Session;
import p001a.p004b.p005a.p007b.C0029c;

public class UiLifecycleHelper {
    private static final String ACTIVITY_NULL_MESSAGE = "activity cannot be null";
    private final Activity activity;
    private final C0029c broadcastManager;
    private final Session.StatusCallback callback;
    private final BroadcastReceiver receiver;

    class ActiveSessionBroadcastReceiver extends BroadcastReceiver {
        private ActiveSessionBroadcastReceiver() {
        }

        @Override
        public void onReceive(Context context, Intent intent) {
            Session activeSession;
            if (Session.ACTION_ACTIVE_SESSION_SET.equals(intent.getAction())) {
                Session activeSession2 = Session.getActiveSession();
                if (activeSession2 == null || UiLifecycleHelper.this.callback == null) {
                    return;
                }
                activeSession2.addCallback(UiLifecycleHelper.this.callback);
                return;
            }
            if (!Session.ACTION_ACTIVE_SESSION_UNSET.equals(intent.getAction()) || (activeSession = Session.getActiveSession()) == null || UiLifecycleHelper.this.callback == null) {
                return;
            }
            activeSession.removeCallback(UiLifecycleHelper.this.callback);
        }
    }

    public UiLifecycleHelper(Activity activity, Session.StatusCallback statusCallback) {
        if (activity == null) {
            throw new IllegalArgumentException(ACTIVITY_NULL_MESSAGE);
        }
        this.activity = activity;
        this.callback = statusCallback;
        this.receiver = new ActiveSessionBroadcastReceiver();
        this.broadcastManager = C0029c.m101c(activity);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Session activeSession = Session.getActiveSession();
        if (activeSession != null) {
            activeSession.onActivityResult(this.activity, i, i2, intent);
        }
    }

    public void onCreate(Bundle bundle) {
        Session activeSession = Session.getActiveSession();
        if (activeSession == null) {
            if (bundle != null) {
                activeSession = Session.restoreSession(this.activity, null, this.callback, bundle);
            }
            if (activeSession == null) {
                activeSession = new Session(this.activity);
            }
            Session.setActiveSession(activeSession);
        }
    }

    public void onDestroy() {
    }

    public void onPause() {
        Session activeSession;
        this.broadcastManager.unregisterReceiver(this.receiver);
        if (this.callback == null || (activeSession = Session.getActiveSession()) == null) {
            return;
        }
        activeSession.removeCallback(this.callback);
    }

    public void onResume() {
        Session activeSession = Session.getActiveSession();
        if (activeSession != null) {
            if (this.callback != null) {
                activeSession.addCallback(this.callback);
            }
            if (SessionState.CREATED_TOKEN_LOADED.equals(activeSession.getState())) {
                activeSession.openForRead(null);
            }
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Session.ACTION_ACTIVE_SESSION_SET);
        intentFilter.addAction(Session.ACTION_ACTIVE_SESSION_UNSET);
        this.broadcastManager.m102a(this.receiver, intentFilter);
    }

    public void onSaveInstanceState(Bundle bundle) {
        Session.saveSession(Session.getActiveSession(), bundle);
    }
}
