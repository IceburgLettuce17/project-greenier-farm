package com.facebook.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.Session;
import com.facebook.SessionState;
import p001a.p004b.p005a.p007b.C0029c;

public class SessionTracker {
    private final C0029c broadcastManager;
    private final Session.StatusCallback callback;
    private boolean isTracking;
    private final BroadcastReceiver receiver;
    private Session session;

    class ActiveSessionBroadcastReceiver extends BroadcastReceiver {
        private ActiveSessionBroadcastReceiver() {
        }

        @Override
        public void onReceive(Context context, Intent intent) {
            Session activeSession;
            if (!Session.ACTION_ACTIVE_SESSION_SET.equals(intent.getAction()) || (activeSession = Session.getActiveSession()) == null) {
                return;
            }
            activeSession.addCallback(SessionTracker.this.callback);
        }
    }

    class CallbackWrapper implements Session.StatusCallback {
        private final Session.StatusCallback wrapped;

        public CallbackWrapper(Session.StatusCallback statusCallback) {
            this.wrapped = statusCallback;
        }

        @Override
        public void call(Session session, SessionState sessionState, Exception exc) {
            if (this.wrapped != null && SessionTracker.this.isTracking()) {
                this.wrapped.call(session, sessionState, exc);
            }
            if (session == SessionTracker.this.session && sessionState.isClosed()) {
                SessionTracker.this.setSession(null);
            }
        }
    }

    public SessionTracker(Context context, Session.StatusCallback statusCallback) {
        this(context, statusCallback, null);
    }

    SessionTracker(Context context, Session.StatusCallback statusCallback, Session session) {
        this(context, statusCallback, session, true);
    }

    public SessionTracker(Context context, Session.StatusCallback statusCallback, Session session, boolean z) {
        this.isTracking = false;
        this.callback = new CallbackWrapper(statusCallback);
        this.session = session;
        this.receiver = new ActiveSessionBroadcastReceiver();
        this.broadcastManager = C0029c.m101c(context);
        if (z) {
            startTracking();
        }
    }

    private void addBroadcastReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Session.ACTION_ACTIVE_SESSION_SET);
        intentFilter.addAction(Session.ACTION_ACTIVE_SESSION_UNSET);
        this.broadcastManager.m102a(this.receiver, intentFilter);
    }

    public Session getOpenSession() {
        Session session = getSession();
        if (session == null || !session.isOpened()) {
            return null;
        }
        return session;
    }

    public Session getSession() {
        return this.session == null ? Session.getActiveSession() : this.session;
    }

    public boolean isTracking() {
        return this.isTracking;
    }

    public boolean isTrackingActiveSession() {
        return this.session == null;
    }

    public void setSession(Session session) {
        if (session == null) {
            if (this.session != null) {
                this.session.removeCallback(this.callback);
                this.session = null;
                addBroadcastReceiver();
                if (getSession() != null) {
                    getSession().addCallback(this.callback);
                    return;
                }
                return;
            }
            return;
        }
        if (this.session == null) {
            Session activeSession = Session.getActiveSession();
            if (activeSession != null) {
                activeSession.removeCallback(this.callback);
            }
            this.broadcastManager.unregisterReceiver(this.receiver);
        } else {
            this.session.removeCallback(this.callback);
        }
        this.session = session;
        this.session.addCallback(this.callback);
    }

    public void startTracking() {
        if (this.isTracking) {
            return;
        }
        if (this.session == null) {
            addBroadcastReceiver();
        }
        if (getSession() != null) {
            getSession().addCallback(this.callback);
        }
        this.isTracking = true;
    }

    public void stopTracking() {
        if (this.isTracking) {
            Session session = getSession();
            if (session != null) {
                session.removeCallback(this.callback);
            }
            this.broadcastManager.unregisterReceiver(this.receiver);
            this.isTracking = false;
        }
    }
}
