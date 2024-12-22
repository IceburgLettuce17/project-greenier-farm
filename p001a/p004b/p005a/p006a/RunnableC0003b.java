package p001a.p004b.p005a.p006a;

import com.facebook.android.C0217R;
import java.io.PrintWriter;
import java.util.ArrayList;

final class RunnableC0003b extends AbstractC0013l implements Runnable {

    private C0015n f9j;

    C0002a f10k;

    private C0002a f11l;

    int f12m;
    int mIndex;
    String mName;

    int f13n;

    int f14o;

    boolean f15p;

    int f16q;

    CharSequence f17r;

    int f18s;

    CharSequence f19t;

    public RunnableC0003b(C0015n c0015n) {
        this.f9j = c0015n;
    }

    final void m27a(C0002a c0002a) {
        if (this.f10k == null) {
            this.f11l = c0002a;
            this.f10k = c0002a;
        } else {
            c0002a.f1b = this.f11l;
            this.f11l.f0a = c0002a;
            this.f11l = c0002a;
        }
        c0002a.f4e = 0;
        c0002a.f5f = 0;
        c0002a.f6g = 0;
        c0002a.f7h = 0;
        this.f12m++;
    }

    public final void m28a(String str, PrintWriter printWriter) {
        printWriter.print(str);
        printWriter.print("mName=");
        printWriter.print(this.mName);
        printWriter.print(" mIndex=");
        printWriter.print(this.mIndex);
        printWriter.print(" mCommitted=");
        printWriter.println(false);
        if (this.f13n != 0) {
            printWriter.print(str);
            printWriter.print("mTransition=#");
            printWriter.print(Integer.toHexString(this.f13n));
            printWriter.print(" mTransitionStyle=#");
            printWriter.println(Integer.toHexString(this.f14o));
        }
        if (this.f16q != 0 || this.f17r != null) {
            printWriter.print(str);
            printWriter.print("mBreadCrumbTitleRes=#");
            printWriter.print(Integer.toHexString(this.f16q));
            printWriter.print(" mBreadCrumbTitleText=");
            printWriter.println(this.f17r);
        }
        if (this.f18s != 0 || this.f19t != null) {
            printWriter.print(str);
            printWriter.print("mBreadCrumbShortTitleRes=#");
            printWriter.print(Integer.toHexString(this.f18s));
            printWriter.print(" mBreadCrumbShortTitleText=");
            printWriter.println(this.f19t);
        }
        if (this.f10k != null) {
            printWriter.print(str);
            printWriter.println("Operations:");
            String str2 = str + "    ";
            for (C0002a c0002a = this.f10k; c0002a != null; c0002a = c0002a.f0a) {
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(0);
                printWriter.println(":");
                printWriter.print(str2);
                printWriter.print("cmd=");
                printWriter.print(c0002a.f2c);
                printWriter.print(" fragment=");
                printWriter.println(c0002a.f3d);
                if (c0002a.f4e != 0 || c0002a.f5f != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(c0002a.f4e));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(c0002a.f5f));
                }
                if (c0002a.f6g != 0 || c0002a.f7h != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(c0002a.f6g));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(c0002a.f7h));
                }
                if (c0002a.f8i != null && c0002a.f8i.size() > 0) {
                    for (int i = 0; i < c0002a.f8i.size(); i++) {
                        printWriter.print(str2);
                        if (c0002a.f8i.size() == 1) {
                            printWriter.print("Removed: ");
                        } else {
                            printWriter.println("Removed:");
                            printWriter.print(str2);
                            printWriter.print("  #");
                            printWriter.print(0);
                            printWriter.print(": ");
                        }
                        printWriter.println(c0002a.f8i.get(i));
                    }
                }
            }
        }
    }

    public final void m29a(boolean z) {
        m30b(-1);
        for (C0002a c0002a = this.f11l; c0002a != null; c0002a = c0002a.f1b) {
            switch (c0002a.f2c) {
                case 1:
                    ComponentCallbacksC0006e componentCallbacksC0006e = c0002a.f3d;
                    componentCallbacksC0006e.mNextAnim = c0002a.f7h;
                    this.f9j.m55a(componentCallbacksC0006e, C0015n.m51f(this.f13n), this.f14o);
                    break;
                case 2:
                    ComponentCallbacksC0006e componentCallbacksC0006e2 = c0002a.f3d;
                    if (componentCallbacksC0006e2 != null) {
                        componentCallbacksC0006e2.mNextAnim = c0002a.f7h;
                        this.f9j.m55a(componentCallbacksC0006e2, C0015n.m51f(this.f13n), this.f14o);
                    }
                    if (c0002a.f8i != null) {
                        for (int i = 0; i < c0002a.f8i.size(); i++) {
                            ComponentCallbacksC0006e componentCallbacksC0006e3 = c0002a.f8i.get(i);
                            componentCallbacksC0006e3.mNextAnim = c0002a.f6g;
                            this.f9j.m57a(componentCallbacksC0006e3, false);
                        }
                        break;
                    } else {
                        break;
                    }
                case 3:
                    ComponentCallbacksC0006e componentCallbacksC0006e4 = c0002a.f3d;
                    componentCallbacksC0006e4.mNextAnim = c0002a.f6g;
                    this.f9j.m57a(componentCallbacksC0006e4, false);
                    break;
                case C0217R.styleable.com_facebook_picker_fragment_done_button_text:
                    ComponentCallbacksC0006e componentCallbacksC0006e5 = c0002a.f3d;
                    componentCallbacksC0006e5.mNextAnim = c0002a.f6g;
                    this.f9j.m68c(componentCallbacksC0006e5, C0015n.m51f(this.f13n), this.f14o);
                    break;
                case C0217R.styleable.com_facebook_picker_fragment_title_bar_background:
                    ComponentCallbacksC0006e componentCallbacksC0006e6 = c0002a.f3d;
                    componentCallbacksC0006e6.mNextAnim = c0002a.f7h;
                    this.f9j.m64b(componentCallbacksC0006e6, C0015n.m51f(this.f13n), this.f14o);
                    break;
                case C0217R.styleable.com_facebook_picker_fragment_done_button_background:
                    ComponentCallbacksC0006e componentCallbacksC0006e7 = c0002a.f3d;
                    componentCallbacksC0006e7.mNextAnim = c0002a.f6g;
                    this.f9j.m72e(componentCallbacksC0006e7, C0015n.m51f(this.f13n), this.f14o);
                    break;
                case 7:
                    ComponentCallbacksC0006e componentCallbacksC0006e8 = c0002a.f3d;
                    componentCallbacksC0006e8.mNextAnim = c0002a.f6g;
                    this.f9j.m70d(componentCallbacksC0006e8, C0015n.m51f(this.f13n), this.f14o);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + c0002a.f2c);
            }
        }
        if (z) {
            this.f9j.m52a(this.f9j.f48O, C0015n.m51f(this.f13n), this.f14o, true);
        }
        if (this.mIndex >= 0) {
            this.f9j.m71e(this.mIndex);
            this.mIndex = -1;
        }
    }

    final void m30b(int i) {
        if (this.f15p) {
            for (C0002a c0002a = this.f10k; c0002a != null; c0002a = c0002a.f0a) {
                if (c0002a.f3d != null) {
                    c0002a.f3d.mBackStackNesting += i;
                }
                if (c0002a.f8i != null) {
                    for (int size = c0002a.f8i.size() - 1; size >= 0; size--) {
                        c0002a.f8i.get(size).mBackStackNesting += i;
                    }
                }
            }
        }
    }

    @Override
    public final void run() {
        ComponentCallbacksC0006e componentCallbacksC0006e;
        if (this.f15p && this.mIndex < 0) {
            throw new IllegalStateException("addToBackStack() called after commit()");
        }
        m30b(1);
        for (C0002a c0002a = this.f10k; c0002a != null; c0002a = c0002a.f0a) {
            switch (c0002a.f2c) {
                case 1:
                    ComponentCallbacksC0006e componentCallbacksC0006e2 = c0002a.f3d;
                    componentCallbacksC0006e2.mNextAnim = c0002a.f4e;
                    this.f9j.m57a(componentCallbacksC0006e2, false);
                    break;
                case 2:
                    ComponentCallbacksC0006e componentCallbacksC0006e3 = c0002a.f3d;
                    if (this.f9j.f42I != null) {
                        componentCallbacksC0006e = componentCallbacksC0006e3;
                        for (int i = 0; i < this.f9j.f42I.size(); i++) {
                            ComponentCallbacksC0006e componentCallbacksC0006e4 = this.f9j.f42I.get(i);
                            if (componentCallbacksC0006e == null || componentCallbacksC0006e4.mContainerId == componentCallbacksC0006e.mContainerId) {
                                if (componentCallbacksC0006e4 == componentCallbacksC0006e) {
                                    componentCallbacksC0006e = null;
                                    c0002a.f3d = null;
                                } else {
                                    if (c0002a.f8i == null) {
                                        c0002a.f8i = new ArrayList<>();
                                    }
                                    c0002a.f8i.add(componentCallbacksC0006e4);
                                    componentCallbacksC0006e4.mNextAnim = c0002a.f5f;
                                    if (this.f15p) {
                                        componentCallbacksC0006e4.mBackStackNesting++;
                                    }
                                    this.f9j.m55a(componentCallbacksC0006e4, this.f13n, this.f14o);
                                }
                            }
                        }
                    } else {
                        componentCallbacksC0006e = componentCallbacksC0006e3;
                    }
                    if (componentCallbacksC0006e != null) {
                        componentCallbacksC0006e.mNextAnim = c0002a.f4e;
                        this.f9j.m57a(componentCallbacksC0006e, false);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    ComponentCallbacksC0006e componentCallbacksC0006e5 = c0002a.f3d;
                    componentCallbacksC0006e5.mNextAnim = c0002a.f5f;
                    this.f9j.m55a(componentCallbacksC0006e5, this.f13n, this.f14o);
                    break;
                case C0217R.styleable.com_facebook_picker_fragment_done_button_text:
                    ComponentCallbacksC0006e componentCallbacksC0006e6 = c0002a.f3d;
                    componentCallbacksC0006e6.mNextAnim = c0002a.f5f;
                    this.f9j.m64b(componentCallbacksC0006e6, this.f13n, this.f14o);
                    break;
                case C0217R.styleable.com_facebook_picker_fragment_title_bar_background:
                    ComponentCallbacksC0006e componentCallbacksC0006e7 = c0002a.f3d;
                    componentCallbacksC0006e7.mNextAnim = c0002a.f4e;
                    this.f9j.m68c(componentCallbacksC0006e7, this.f13n, this.f14o);
                    break;
                case C0217R.styleable.com_facebook_picker_fragment_done_button_background:
                    ComponentCallbacksC0006e componentCallbacksC0006e8 = c0002a.f3d;
                    componentCallbacksC0006e8.mNextAnim = c0002a.f5f;
                    this.f9j.m70d(componentCallbacksC0006e8, this.f13n, this.f14o);
                    break;
                case 7:
                    ComponentCallbacksC0006e componentCallbacksC0006e9 = c0002a.f3d;
                    componentCallbacksC0006e9.mNextAnim = c0002a.f4e;
                    this.f9j.m72e(componentCallbacksC0006e9, this.f13n, this.f14o);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + c0002a.f2c);
            }
        }
        this.f9j.m52a(this.f9j.f48O, this.f13n, this.f14o, true);
        if (this.f15p) {
            this.f9j.m53a(this);
        }
    }
}
