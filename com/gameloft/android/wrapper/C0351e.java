package com.gameloft.android.wrapper;

import android.app.Dialog;
import java.util.ArrayList;
import p009b.p010a.p012b.AlertDialogC0045a;
import p009b.p010a.p012b.DialogC0064m;
import p009b.p010a.p012b.ProgressDialogC0052ag;

public final class C0351e {

    private static ArrayList<Dialog> f2699XO = new ArrayList<>();

    public static boolean f2700XP;

    private static Dialog f2701XQ;

    public static void m2177a(Dialog dialog) {
        f2699XO.add(dialog);
        update();
    }

    public static void m2178a(Dialog dialog, Boolean bool) {
        Dialog dialog2 = f2699XO.get(f2699XO.indexOf(dialog));
        if (dialog2 instanceof DialogC0064m) {
            ((DialogC0064m) dialog2).ain = bool;
        }
        if (dialog2 instanceof ProgressDialogC0052ag) {
            ((ProgressDialogC0052ag) dialog2).ain = bool;
        }
        if (dialog2 instanceof AlertDialogC0045a) {
            ((AlertDialogC0045a) dialog2).ain = bool;
        }
        f2701XQ = dialog;
        update();
    }

    public static boolean m2179ab(boolean z) {
        if (!f2700XP) {
            return z;
        }
        String str = "Dialog interrupt: " + f2700XP;
        return true;
    }

    public static void m2180b(Dialog dialog) {
        f2699XO.remove(dialog);
        update();
        if (f2699XO.size() > 0) {
            f2701XQ = f2699XO.get(f2699XO.size() - 1);
        }
    }

    public static void m2181b(Dialog dialog, Boolean bool) {
        int indexOf = f2699XO.indexOf(dialog);
        if (indexOf >= 0) {
            Dialog dialog2 = f2699XO.get(indexOf);
            if (dialog2 instanceof DialogC0064m) {
                ((DialogC0064m) dialog2).ain = bool;
            }
            if (dialog2 instanceof ProgressDialogC0052ag) {
                ((ProgressDialogC0052ag) dialog2).ain = bool;
            }
            if (dialog2 instanceof AlertDialogC0045a) {
                ((AlertDialogC0045a) dialog2).ain = bool;
            }
        }
        update();
    }

    public static boolean m2182c(Dialog dialog) {
        if (!f2701XQ.equals(dialog)) {
            return false;
        }
        String str = "is Current Dialog " + dialog;
        return true;
    }

    private static void update() {
        int i = 0;
        f2700XP = false;
        while (true) {
            int i2 = i;
            if (i2 >= f2699XO.size()) {
                return;
            }
            Dialog dialog = f2699XO.get(i2);
            if (dialog instanceof DialogC0064m) {
                f2700XP = ((DialogC0064m) dialog).ain.booleanValue() | f2700XP;
            }
            if (dialog instanceof ProgressDialogC0052ag) {
                f2700XP = ((ProgressDialogC0052ag) dialog).ain.booleanValue() | f2700XP;
            }
            if (dialog instanceof AlertDialogC0045a) {
                f2700XP = ((AlertDialogC0045a) dialog).ain.booleanValue() | f2700XP;
            }
            i = i2 + 1;
        }
    }
}
