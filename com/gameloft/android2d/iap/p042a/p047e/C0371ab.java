package com.gameloft.android2d.iap.p042a.p047e;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public final class C0371ab {
    private static final String[] abx = {"_id", "productId", "state", "purchaseTime", "developerPayload"};
    private SQLiteDatabase aby;
    private C0372ac abz;

    static {
        String[] strArr = {"_id", "quantity"};
    }

    public C0371ab(Context context) {
        this.abz = new C0372ac(this, context);
        this.aby = this.abz.getWritableDatabase();
    }

    public final synchronized int m2304a(String str, String str2, EnumC0386h enumC0386h, long j, String str3) {
        int i;
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", str);
        contentValues.put("productId", str2);
        contentValues.put("state", Integer.valueOf(enumC0386h.ordinal()));
        contentValues.put("purchaseTime", Long.valueOf(j));
        contentValues.put("developerPayload", str3);
        this.aby.replace("history", null, contentValues);
        Cursor query = this.aby.query("history", abx, "productId=?", new String[]{str2}, null, null, null, null);
        if (query == null) {
            i = 0;
        } else {
            i = 0;
            while (query.moveToNext()) {
                try {
                    EnumC0386h m2328eW = EnumC0386h.m2328eW(query.getInt(2));
                    if (m2328eW == EnumC0386h.PURCHASED || m2328eW == EnumC0386h.REFUNDED) {
                        i++;
                    }
                } catch (Throwable th) {
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
            if (i == 0) {
                this.aby.delete("purchased", "_id=?", new String[]{str2});
            } else {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("_id", str2);
                contentValues2.put("quantity", Integer.valueOf(i));
                this.aby.replace("purchased", null, contentValues2);
            }
            if (query != null) {
                query.close();
            }
        }
        return i;
    }

    public final void close() {
        this.abz.close();
    }
}
