package com.gameloft.android2d.socialnetwork;

import java.util.Hashtable;

public final class C0531o {
    Hashtable<String, Integer> afK = new Hashtable<>();
    Hashtable<String, Integer> afL = new Hashtable<>();

    public final void remove(String str) {
        this.afK.remove(str);
        this.afL.put(str, 3);
    }
}
