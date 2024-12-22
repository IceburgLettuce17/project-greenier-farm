package com.facebook.widget;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.Session;
import com.facebook.SessionLoginBehavior;
import com.facebook.SessionState;
import com.facebook.internal.SessionAuthorizationType;
import com.facebook.internal.SessionTracker;
import java.util.Date;
import java.util.List;
import p001a.p004b.p005a.p006a.ComponentCallbacksC0006e;

class FacebookFragment extends ComponentCallbacksC0006e {
    private SessionTracker sessionTracker;

    class DefaultSessionStatusCallback implements Session.StatusCallback {
        private DefaultSessionStatusCallback() {
        }

        @Override
        public void call(Session session, SessionState sessionState, Exception exc) {
            FacebookFragment.this.onSessionStateChange(sessionState, exc);
        }
    }

    FacebookFragment() {
    }

    private void openSession(String str, List<String> list, SessionLoginBehavior sessionLoginBehavior, int i, SessionAuthorizationType sessionAuthorizationType) {
        if (this.sessionTracker != null) {
            Session session = this.sessionTracker.getSession();
            if (session == null || session.getState().isClosed()) {
                session = new Session.Builder(getActivity()).setApplicationId(str).build();
                Session.setActiveSession(session);
            }
            if (session.isOpened()) {
                return;
            }
            Session.OpenRequest requestCode = new Session.OpenRequest(this).setPermissions(list).setLoginBehavior(sessionLoginBehavior).setRequestCode(i);
            if (SessionAuthorizationType.PUBLISH.equals(sessionAuthorizationType)) {
                session.openForPublish(requestCode);
            } else {
                session.openForRead(requestCode);
            }
        }
    }

    protected final void closeSession() {
        Session openSession;
        if (this.sessionTracker == null || (openSession = this.sessionTracker.getOpenSession()) == null) {
            return;
        }
        openSession.close();
    }

    protected final void closeSessionAndClearTokenInformation() {
        Session openSession;
        if (this.sessionTracker == null || (openSession = this.sessionTracker.getOpenSession()) == null) {
            return;
        }
        openSession.closeAndClearTokenInformation();
    }

    protected final String getAccessToken() {
        Session openSession;
        if (this.sessionTracker == null || (openSession = this.sessionTracker.getOpenSession()) == null) {
            return null;
        }
        return openSession.getAccessToken();
    }

    protected final Date getExpirationDate() {
        Session openSession;
        if (this.sessionTracker == null || (openSession = this.sessionTracker.getOpenSession()) == null) {
            return null;
        }
        return openSession.getExpirationDate();
    }

    protected final Session getSession() {
        if (this.sessionTracker != null) {
            return this.sessionTracker.getSession();
        }
        return null;
    }

    protected final List<String> getSessionPermissions() {
        Session session;
        if (this.sessionTracker == null || (session = this.sessionTracker.getSession()) == null) {
            return null;
        }
        return session.getPermissions();
    }

    protected final SessionState getSessionState() {
        Session session;
        if (this.sessionTracker == null || (session = this.sessionTracker.getSession()) == null) {
            return null;
        }
        return session.getState();
    }

    protected final boolean isSessionOpen() {
        return (this.sessionTracker == null || this.sessionTracker.getOpenSession() == null) ? false : true;
    }

    @Override
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.sessionTracker = new SessionTracker(getActivity(), new DefaultSessionStatusCallback());
    }

    @Override
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.sessionTracker.getSession().onActivityResult(getActivity(), i, i2, intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.sessionTracker.stopTracking();
    }

    protected void onSessionStateChange(SessionState sessionState, Exception exc) {
    }

    protected final void openSession() {
        openSessionForRead(null, null);
    }

    protected final void openSessionForPublish(String str, List<String> list) {
        openSessionForPublish(str, list, SessionLoginBehavior.SSO_WITH_FALLBACK, Session.DEFAULT_AUTHORIZE_ACTIVITY_CODE);
    }

    protected final void openSessionForPublish(String str, List<String> list, SessionLoginBehavior sessionLoginBehavior, int i) {
        openSession(str, list, sessionLoginBehavior, i, SessionAuthorizationType.PUBLISH);
    }

    protected final void openSessionForRead(String str, List<String> list) {
        openSessionForRead(str, list, SessionLoginBehavior.SSO_WITH_FALLBACK, Session.DEFAULT_AUTHORIZE_ACTIVITY_CODE);
    }

    protected final void openSessionForRead(String str, List<String> list, SessionLoginBehavior sessionLoginBehavior, int i) {
        openSession(str, list, sessionLoginBehavior, i, SessionAuthorizationType.READ);
    }

    public void setSession(Session session) {
        if (this.sessionTracker != null) {
            this.sessionTracker.setSession(session);
        }
    }
}
