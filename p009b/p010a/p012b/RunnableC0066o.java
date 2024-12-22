package p009b.p010a.p012b;

import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.gameloft.android.wrapper.C0349c;
import com.gameloft.android.wrapper.C0355i;
import p009b.p010a.p015d.AbstractActivityC0092a;

final class RunnableC0066o implements Runnable {
    private C0065n aiY;

    RunnableC0066o(C0065n c0065n) {
        this.aiY = c0065n;
    }

    @Override
    public final void run() {
        AbstractC0067p abstractC0067p;
        AbstractC0067p abstractC0067p2;
        AbstractC0067p abstractC0067p3;
        AbstractC0067p abstractC0067p4;
        AbstractC0067p abstractC0067p5;
        AbstractC0067p abstractC0067p6;
        AbstractC0067p abstractC0067p7;
        abstractC0067p = C0065n.aiU;
        if (((ViewGroup) ((View) abstractC0067p.m165ug()).getParent()) != null) {
            abstractC0067p4 = C0065n.aiU;
            ViewGroup viewGroup = (ViewGroup) ((View) abstractC0067p4.m165ug()).getParent();
            abstractC0067p5 = C0065n.aiU;
            if (viewGroup.indexOfChild((View) abstractC0067p5.m165ug()) >= 0) {
                abstractC0067p6 = C0065n.aiU;
                ViewGroup viewGroup2 = (ViewGroup) ((View) abstractC0067p6.m165ug()).getParent();
                abstractC0067p7 = C0065n.aiU;
                viewGroup2.removeView((View) abstractC0067p7.m165ug());
            }
        }
        if (C0065n.aiX) {
            C0065n.aiX = false;
            FrameLayout frameLayout = new FrameLayout(C0355i.getActivity());
            Display defaultDisplay = ((WindowManager) C0355i.getContext().getSystemService("window")).getDefaultDisplay();
            int width = defaultDisplay.getWidth();
            int height = defaultDisplay.getHeight();
            String str = "Orientation:" + C0349c.f2689XE;
            if ((C0349c.f2689XE.compareTo("landscape") == 0 && width < height) || (C0349c.f2689XE.compareTo("portrait") == 0 && width > height)) {
                height = width;
                width = height;
            }
            String str2 = "width=" + width + " and height=" + height;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
            abstractC0067p2 = C0065n.aiU;
            frameLayout.addView((View) abstractC0067p2.m165ug(), layoutParams);
            this.aiY.aiW.setContentView(frameLayout);
            AbstractActivityC0092a abstractActivityC0092a = this.aiY.aiW;
            abstractC0067p3 = C0065n.aiU;
            abstractActivityC0092a.alG = abstractC0067p3;
        }
    }
}
