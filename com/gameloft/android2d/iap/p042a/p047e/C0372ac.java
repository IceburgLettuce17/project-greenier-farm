package com.gameloft.android2d.iap.p042a.p047e;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import p001a.p004b.p005a.p006a.C0012k;

final class C0372ac extends SQLiteOpenHelper {
    public C0372ac(C0371ab c0371ab, Context context) {
        super(context, "purchase.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    private static void m2305a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE history(_id TEXT PRIMARY KEY, state INTEGER, productId TEXT, developerPayload TEXT, purchaseTime INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE purchased(_id TEXT PRIMARY KEY, quantity INTEGER)");
    }

    @Override
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        m2305a(sQLiteDatabase);
    }

    @Override
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i2 != 1) {
            C0012k.m42d("IAP-PurchaseDatabase", "Database upgrade from old: " + i + " to: " + i2);
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS history");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS purchased");
            m2305a(sQLiteDatabase);
        }
    }
}
