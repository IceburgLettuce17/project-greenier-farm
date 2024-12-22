package com.gameloft.android2d.socialnetwork;

import com.facebook.SessionState;

final class C0501ah {
    static final int[] $SwitchMap$com$facebook$SessionState = new int[SessionState.values().length];

    static {
        try {
            $SwitchMap$com$facebook$SessionState[SessionState.OPENING.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            $SwitchMap$com$facebook$SessionState[SessionState.OPENED.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            $SwitchMap$com$facebook$SessionState[SessionState.CLOSED_LOGIN_FAILED.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            $SwitchMap$com$facebook$SessionState[SessionState.CLOSED.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}
