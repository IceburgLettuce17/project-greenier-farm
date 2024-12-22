package p009b.p010a.p015d;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.Toast;
import com.gameloft.android.LATAM.GloftGF2H.PushNotification.C0263i;
import com.gameloft.android.LATAM.GloftGF2H.SplashScreenActivity;
import com.gameloft.android.wrapper.C0349c;
import com.gameloft.android.wrapper.C0351e;
import com.gameloft.android.wrapper.C0352f;
import com.gameloft.android.wrapper.C0355i;
import com.gameloft.android.wrapper.NativeUtils;
import com.gameloft.android2d.iap.C0463b;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Locale;
import p009b.p010a.p011a.C0036b;
import p009b.p010a.p012b.AbstractC0054c;
import p009b.p010a.p012b.AbstractC0067p;
import p009b.p010a.p012b.C0063l;
import p009b.p010a.p012b.C0065n;
import p009b.p010a.p013c.C0085f;
import p009b.p010a.p013c.C0089j;
import p009b.p010a.p016e.C0100b;

public abstract class AbstractActivityC0092a extends Activity {
    public static String VERSION;
    public static AbstractActivityC0092a akM;
    public static boolean akN;
    private static boolean akP;
    public static boolean akQ;
    private static int akR;
    public static boolean akS;
    public static boolean akT;
    public static boolean akU;
    public static boolean akV;
    public static boolean akW;
    public static String akX;
    public static String akY;
    public static boolean akZ;
    private static boolean alA;
    public static boolean alB;
    public static boolean alD;
    public static boolean alE;
    private static boolean alF;
    public static double alH;
    public static int alI;
    public static int alJ;
    public static int alK;
    public static int alL;
    private static PowerManager alN;
    private static KeyguardManager alO;
    private static boolean alP;
    public static boolean alQ;
    public static boolean ala;
    private static Hashtable alb;
    public static boolean alc;
    public static boolean ald;
    public static boolean ale;
    public static boolean alf;
    public static boolean alg;
    public static int alh;
    public static boolean ali;
    public static boolean alj;
    public static String alk;
    public static boolean all;
    public static boolean alm;
    public static boolean aln;
    public static boolean alo;
    public static boolean alp;
    public static boolean alq;
    public static String alr;
    private static boolean als;
    public static boolean alt;
    public static boolean alu;
    public static boolean alv;
    public static boolean alw;
    public static boolean alx;
    private static boolean aly;
    public static Toast alz;
    private static String callingPackage;
    private Configuration akO;
    private AudioManager alC;
    public AbstractC0067p alG = null;
    private boolean alM;

    static {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        if ((C0349c.f2689XE.compareTo("landscape") != 0 || i >= i2) && (C0349c.f2689XE.compareTo("portrait") != 0 || i <= i2)) {
            i = i2;
            i2 = i;
        }
        String str = "static Width = " + i2 + " Height = " + i;
        akN = false;
        akP = false;
        akQ = false;
        akR = 2;
        callingPackage = null;
        akS = false;
        akT = false;
        akU = false;
        akV = false;
        akW = false;
        akX = "";
        akY = "";
        VERSION = "";
        akZ = false;
        ala = false;
        alb = new Hashtable();
        alc = false;
        ald = false;
        ale = false;
        alf = false;
        alg = false;
        alh = 0;
        ali = false;
        alj = false;
        alk = null;
        all = false;
        alm = false;
        aln = false;
        alo = false;
        alp = false;
        alq = false;
        alr = null;
        als = false;
        alt = false;
        alu = false;
        alv = false;
        alw = false;
        alx = false;
        aly = false;
        alA = true;
        alB = false;
        alD = false;
        alE = false;
        alF = false;
        alH = -1.0d;
        alI = -1;
        alJ = -1;
        alK = -1;
        alL = -1;
        alP = false;
        alQ = false;
    }

    private static int m208a(BufferedReader bufferedReader, int i) {
        String readLine;
        int indexOf;
        try {
            readLine = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (readLine == null) {
            return -1;
        }
        String trim = readLine.trim();
        if (trim.length() != 0 && (indexOf = trim.indexOf(":")) > 0) {
            alb.put(trim.substring(0, indexOf).trim(), trim.substring(indexOf + 1).trim());
        }
        return i + 1;
    }

    public static String m209a(Object obj, String str) {
        Activity activity;
        Enumeration<URL> enumeration;
        if (str == null || str.trim().length() == 0) {
            return null;
        }
        if (obj instanceof Activity) {
            activity = (Activity) obj;
        } else {
            if (C0355i.getContext() == null) {
                return null;
            }
            activity = (Activity) C0355i.getContext();
        }
        if (!ala) {
            str = str.replace("-", "_");
        }
        if (!ala) {
            int identifier = activity.getResources().getIdentifier(str, "string", activity.getPackageName());
            if (identifier == 0) {
                return null;
            }
            return activity.getResources().getString(identifier);
        }
        if (ala) {
            ClassLoader classLoader = activity.getClass().getClassLoader();
            if (alb.size() <= 0) {
                try {
                    try {
                        enumeration = classLoader == null ? ClassLoader.getSystemResources("res/raw/content.txt") : classLoader.getResources("res/raw/content.txt");
                    } catch (IOException e) {
                        e.printStackTrace();
                        enumeration = null;
                    }
                    if (enumeration.hasMoreElements()) {
                        m210a(enumeration.nextElement());
                        if (enumeration.hasMoreElements()) {
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                Enumeration keys = alb.keys();
                Iterator it = alb.values().iterator();
                while (keys.hasMoreElements()) {
                    String str2 = ((String) keys.nextElement()) + "^:^" + ((String) it.next());
                }
            }
        }
        if (alb.containsKey(str)) {
            return (String) alb.get(str);
        }
        return null;
    }

    private static void m210a(URL url) {
        InputStream inputStream;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        bufferedReader2 = null;
        InputStream inputStream2 = null;
        try {
            inputStream = url.openStream();
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
                int i = 1;
                do {
                    try {
                        i = m208a(bufferedReader, i);
                    } catch (IOException e) {
                        e = e;
                        inputStream2 = inputStream;
                        try {
                            e.printStackTrace();
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                    return;
                                }
                            }
                            if (inputStream2 != null) {
                                inputStream2.close();
                                return;
                            }
                            return;
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            bufferedReader2 = bufferedReader;
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                    throw th;
                                }
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader2 = bufferedReader;
                        if (bufferedReader2 != null) {
                        }
                        if (inputStream != null) {
                        }
                        throw th;
                    }
                } while (i >= 0);
                bufferedReader.close();
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e4) {
                e = e4;
                bufferedReader = null;
                inputStream2 = inputStream;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException e5) {
            e = e5;
            bufferedReader = null;
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
        }
    }

    public static boolean isLocked() {
        return (alO.inKeyguardRestrictedInputMode() && !alP) || !alN.isScreenOn();
    }

    public static void m211uy() {
        alP = true;
        akM.getWindow().addFlags(524288);
    }

    protected abstract void mo212bX();

    protected abstract void mo213bY();

    public final String m214di(String str) {
        if (str == null || str.trim().length() == 0) {
            return null;
        }
        if (!ala) {
            str = str.replace("-", "_");
        }
        return str.toLowerCase().compareTo("microedition.locale") == 0 ? Locale.getDefault().toString() : str.toLowerCase().compareTo("microedition.device") == 0 ? Build.MODEL : str.toLowerCase().compareTo("microedition.device.manufacturer") == 0 ? Build.MANUFACTURER : str.toLowerCase().compareTo("mac") == 0 ? C0355i.m2205qb() : str.toLowerCase().compareTo("microedition.inch") == 0 ? new StringBuilder().append(alH).toString() : str.toLowerCase().compareTo("microedition.widthreal") == 0 ? new StringBuilder().append(alI).toString() : str.toLowerCase().compareTo("microedition.heightreal") == 0 ? new StringBuilder().append(alJ).toString() : str.toLowerCase().compareTo("microedition.width") == 0 ? new StringBuilder().append(alK).toString() : str.toLowerCase().compareTo("microedition.height") == 0 ? new StringBuilder().append(alL).toString() : str.toLowerCase().compareTo("microedition.screen.virtual") == 0 ? "true" : str.toLowerCase().compareTo("conectivity") == 0 ? C0355i.m2210qg() ? "on" : "off" : str.toLowerCase().compareTo("deviceuptimemillis") == 0 ? C0355i.m2213qj() : str.compareTo("clock") == 0 ? new StringBuilder().append(NativeUtils.getClock()).toString() : str.compareTo("timemillis") == 0 ? new StringBuilder().append(NativeUtils.getClockMillis()).toString() : str.compareTo("timenano") == 0 ? new StringBuilder().append(NativeUtils.getClockNano()).toString() : m209a(this, str);
    }

    public final boolean m215dj(String str) {
        if ("MIDlet://minimize".equals(str)) {
            moveTaskToBack(true);
            return false;
        }
        if (str.startsWith("GlotInitLogger:")) {
            String substring = str.substring(15);
            substring.substring(15).split(":");
            int indexOf = substring.indexOf(":");
            if (indexOf <= 0) {
                return false;
            }
            C0355i.m2195a(substring.substring(0, indexOf).trim(), substring.substring(indexOf + 1).trim().equals("TRUE"), "");
            return false;
        }
        if (str.startsWith("GlotLogger:")) {
            C0355i.m2199bk(str.substring(11));
            return false;
        }
        if ("MIDlet://stayAwake".equals(str)) {
            C0355i.getActivity().runOnUiThread(new RunnableC0093b(this));
            return false;
        }
        if ("MIDlet://allowSleep".equals(str)) {
            C0355i.getActivity().runOnUiThread(new RunnableC0094c(this));
            return false;
        }
        if (str.contains("Show_Toast")) {
            runOnUiThread(new RunnableC0095d(this, str.split("Show_Toast_")[1]));
            return false;
        }
        if (str.equals("Cancel_Toast")) {
            if (alz == null) {
                return false;
            }
            alz.cancel();
            return false;
        }
        if (str.equals("FACEBOOK")) {
            try {
                Intent intent = new Intent();
                intent.setClassName("_GAME_PKG_", "_GAME_PKG_.Facebook_Wrapper");
                startActivity(intent);
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        if (str.equals("FACEBOOK_quicklogin")) {
            try {
                Intent intent2 = new Intent();
                intent2.setClassName("_GAME_PKG_", "_GAME_PKG_.Facebook_Wrapper");
                intent2.putExtra("quicklogin", true);
                startActivity(intent2);
                return false;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        if (str.equals("GLLIVE")) {
            try {
                Intent intent3 = new Intent();
                intent3.setClassName("_GAME_PKG_", "_GAME_PKG_.Gllive_Login");
                startActivity(intent3);
                return false;
            } catch (Exception e3) {
                e3.printStackTrace();
                return false;
            }
        }
        if (str.equals("GLLIVE_HTML5")) {
            try {
                Intent intent4 = new Intent();
                intent4.setClassName("_GAME_PKG_", "_GAME_PKG_.GLiveHTML.GLLiveActivity");
                startActivity(intent4);
                return false;
            } catch (Exception e4) {
                e4.printStackTrace();
                return false;
            }
        }
        if (str.equals("GLLIVE_HTML5_quicklogin")) {
            try {
                Intent intent5 = new Intent();
                intent5.setClassName("_GAME_PKG_", "_GAME_PKG_.GLiveHTML.GLLiveActivity");
                intent5.putExtra("quicklogin", true);
                startActivity(intent5);
                return false;
            } catch (Exception e5) {
                e5.printStackTrace();
                return false;
            }
        }
        if (str.equals("HAVE_NEW_VERSION")) {
            String m214di = m214di("UPDATE-URL");
            if (m214di == null) {
                m214di = "http://confirmation.gameloft.com/partners/android/update_check.php";
            }
            C0355i.m2198bj(m214di + "?key=" + C0355i.m2189A("serialkey", "raw"));
            if (C0355i.response == null) {
                return false;
            }
            int parseInt = Integer.parseInt(m214di("MIDlet-Version").replace(".", ""));
            String[] split = C0355i.response.split("\n");
            int parseInt2 = split.length == 2 ? Integer.parseInt(split[0].replace("[VERSION_AVAILABLE]=", "").replace(".", "")) : 0;
            String str2 = "Current:" + parseInt + " New:" + parseInt2;
            if (parseInt2 <= parseInt) {
                return false;
            }
            System.setProperty("URL_NEW_VERSION", split[1].replace("[DOWNLOAD_URL]=", ""));
            String str3 = "URL_NEW_VERSION:" + split[1].replace("[DOWNLOAD_URL]=", "");
            return true;
        }
        if (str.equals("LAUNCH_AUTOUPDATE")) {
            try {
                Intent intent6 = new Intent("android.intent.action.VIEW", Uri.parse(C0355i.response.substring(C0355i.response.indexOf("http"))));
                C0355i.response = null;
                startActivity(intent6);
                return false;
            } catch (Exception e6) {
                return false;
            }
        }
        if (str.equals("isDeviceRooted")) {
            return NativeUtils.CheckRoot();
        }
        if (str.equals("isConnectedWifi")) {
            return C0355i.m2211qh();
        }
        if (str.equals("isConnectedMobile")) {
            return C0355i.m2212qi();
        }
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            return false;
        } catch (Exception e7) {
            throw new C0036b();
        }
    }

    @Override
    public void onActivityResult(int i, int i2, Intent intent) {
        C0098g.onActivityResult(i, i2, intent);
        boolean z = ald;
    }

    @Override
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            Display defaultDisplay = ((WindowManager) C0355i.getContext().getSystemService("window")).getDefaultDisplay();
            int width = defaultDisplay.getWidth();
            int height = defaultDisplay.getHeight();
            this.akO.updateFrom(configuration);
            if ((C0349c.f2689XE.compareTo("landscape") != 0 || width >= height) && (C0349c.f2689XE.compareTo("portrait") != 0 || width <= height)) {
                width = height;
                height = width;
            }
            String str = "onSizeChange: " + height + ", " + width + " orientation:" + C0349c.f2689XE;
            this.alG.mo150aV(height, width);
        } catch (Exception e) {
        }
        C0098g.m218uB();
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (alQ) {
            return;
        }
        akM = this;
        C0355i.setContext(this);
        akY = m209a(this, "GAME-IGP-CODE");
        callingPackage = getCallingPackage();
        String string = C0355i.getActivity().getPreferences(0).getString("is_multiplejar", "0");
        if (!C0349c.f2687XC || (string.compareTo("1") == 0 && (C0355i.f2718Yg == null || C0355i.f2718Yg == ""))) {
            Intent intent = new Intent();
            intent.setClassName(getPackageName(), getPackageName() + ".Start");
            startActivity(intent);
            finish();
            onDestroy();
            return;
        }
        if (akT) {
            getWindow().setFlags(1664, 1664);
        } else {
            getWindow().setFlags(1536, 1536);
        }
        requestWindowFeature(1);
        boolean z = C0355i.f2717Yf;
        setVolumeControlStream(3);
        this.akO = new Configuration();
        this.akO.setToDefaults();
        this.akO.orientation = -1;
        akP = false;
        if (getResources().getDrawable(getResources().getIdentifier("icon", "drawable", getPackageName())) == null) {
            throw new RuntimeException();
        }
        C0085f.m207v(this);
        String stringExtra = getIntent().getStringExtra("LANGUAGE");
        if (stringExtra != null) {
            C0355i.setContext(this);
            C0100b c0100b = null;
            try {
                c0100b = C0100b.m227g("rmsLanguage", true);
                byte[] bytes = stringExtra.getBytes();
                if (c0100b.m235uD() > 0) {
                    c0100b.m231b(1, bytes, 0, bytes.length);
                } else {
                    c0100b.m232e(bytes, 0, bytes.length);
                }
            } catch (Exception e) {
            }
            if (c0100b != null) {
                try {
                    C0100b.m229uC();
                } catch (Exception e2) {
                }
            }
        }
        C0352f.m2183a(this);
        int intExtra = getIntent().getIntExtra("SCREEN_ORIENTATION", -1);
        if (intExtra != -1) {
            setRequestedOrientation(intExtra);
        }
        this.alM = false;
        alA = false;
        alz = Toast.makeText(this, "", 0);
        alO = (KeyguardManager) C0355i.getContext().getSystemService("keyguard");
        alN = (PowerManager) getSystemService("power");
        C0263i.m537a(C0355i.getActivity());
        String m214di = akM.m214di("Has-Push-Notification");
        if (m214di != null) {
            if (m214di.compareTo("1") == 0) {
                C0263i.m572p(true);
            } else {
                C0263i.m572p(false);
            }
        }
        new Thread(new RunnableC0097f()).start();
        SplashScreenActivity.f344yW = m209a(C0355i.getActivity(), "GAME-IGP-CODE");
        SplashScreenActivity.f345yX = m209a(C0355i.getActivity(), "MIDlet-Version");
        C0098g.onCreate(bundle);
        if (ald) {
            C0463b.m2496a(C0355i.getActivity(), akM.m214di("IAP-GameCodeIGP"), akM.m214di("IAP-DynamicFeedURL"), akM.m214di("IAP-EnableCreditCard"), false, akM.m214di("IAP-EnableUmpBilling"), akM.m214di("IAP-EnableShenzhoufu"), akM.m214di("IAP-ChannelID"), akM.m214di("IAP-GoogleDeveloperKey"), alr, false, false, 0, false, false, alk, false, false, false, false, 0, false, false, false, false);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        C0065n.m161b(this);
        AbstractC0067p m162ue = C0065n.m162ue();
        if (m162ue == null) {
            return true;
        }
        Iterator it = m162ue.aiZ.iterator();
        int i = 0;
        while (it.hasNext()) {
            ((C0063l) it.next()).aiS = menu.add(0, i, 0, (CharSequence) null).getItemId();
            i++;
        }
        return true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        setResult(akR);
        boolean z = C0355i.f2717Yf;
        akP = true;
        if (callingPackage == null && !alu) {
            System.exit(0);
        }
        C0098g.onDestroy();
        boolean z2 = ald;
        C0089j.release();
    }

    @Override
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.alG.m165ug().mo118a(keyEvent);
    }

    @Override
    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        return this.alG.m165ug().mo118a(keyEvent);
    }

    @Override
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return this.alG.m165ug().mo118a(keyEvent);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        C0263i.onNewIntent(intent);
        C0098g.m219uz();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        C0065n.m161b(this);
        C0065n.m162ue();
        return false;
    }

    @Override
    protected void onPause() {
        boolean z = C0355i.f2717Yf;
        super.onPause();
        if (alQ) {
            return;
        }
        if (this.alG != null) {
            AbstractC0054c.aip.m165ug().onPause();
            this.alG.mo146aQ();
            this.alG.mo153al(false);
        }
        akM.getWindow().clearFlags(524288);
        alP = false;
        C0098g.onPause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (alQ) {
            return;
        }
        boolean z = C0355i.f2717Yf;
        C0098g.onRestart();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (alQ) {
            return;
        }
        if (this.alG != null) {
            AbstractC0054c.aip.m165ug().onResume();
            this.alG.mo147aR();
        }
        if (alB) {
            if (this.alC.isMusicActive()) {
                C0085f.akr = true;
            } else {
                C0085f.akr = false;
            }
        }
        if (!this.alM) {
            try {
                mo212bX();
                this.alM = true;
            } catch (C0096e e) {
                e.printStackTrace();
            }
        }
        if (this.alG != null) {
            this.alG.mo153al(true);
        }
        if (akW) {
            C0352f.m2187pZ();
            alF = true;
        }
        C0098g.onResume();
    }

    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        boolean z = C0355i.f2717Yf;
        C0098g.onSaveInstanceState(bundle);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (alQ) {
            return;
        }
        if (alB) {
            this.alC = (AudioManager) C0355i.getContext().getSystemService("audio");
            if (this.alC.isMusicActive()) {
                C0085f.akr = true;
            } else {
                C0085f.akr = false;
            }
        }
        C0355i.setContext(this);
        System.setProperty("microedition.sensor.version", "1.0");
        System.setProperty("microedition.locale.country", C0355i.m2217qn());
        System.setProperty("microedition.locale", C0355i.m2216qm());
        System.setProperty("microedition.device", C0352f.m2185bi("microedition.device"));
        System.setProperty("microedition.device.version", C0352f.m2185bi("microedition.device.version"));
        System.setProperty("microedition.device.aid", C0352f.m2185bi("microedition.device.aid"));
        System.setProperty("IMEI", C0352f.m2185bi("IMEI"));
        System.setProperty("HDIDFV", C0355i.m2208qe());
        System.setProperty("AndroidID", C0355i.m2206qc());
        System.setProperty("Serial", C0355i.getSerial());
        System.setProperty("DebugMode", "false");
        System.setProperty("microetition.device.carrier", C0355i.m2218qo());
        System.setProperty("isDeviceRooted", NativeUtils.CheckRoot() ? "1" : "0");
        System.setProperty("supports.mixing", "true");
        System.setProperty("microedition.media.version", "1.1");
        System.setProperty("microedition.device.volume", new StringBuilder().append(C0355i.m2214qk()).toString());
        System.setProperty("download.code", C0355i.m2215ql());
        System.setProperty("glot.debug.infor", C0355i.m2209qf());
        System.setProperty("getAvailableSpace", new StringBuilder().append(C0355i.m2192a(getFilesDir().getPath(), C0355i.getContext())).toString());
        System.setProperty("com.gameloft.Signature", new StringBuilder().append(C0355i.m2220qq()).toString());
        System.setProperty("microedition.width", new StringBuilder().append(alK).toString());
        System.setProperty("microedition.height", new StringBuilder().append(alL).toString());
        System.setProperty("microedition.screen.virtual", "true");
        boolean z = C0355i.f2717Yf;
        C0098g.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (alQ) {
            return;
        }
        boolean z = C0355i.f2717Yf;
        C0098g.onStop();
    }

    @Override
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!(this.alG instanceof AbstractC0054c)) {
            return false;
        }
        AbstractC0067p abstractC0067p = this.alG;
        motionEvent.getX();
        motionEvent.getY();
        return AbstractC0054c.m134tV();
    }

    @Override
    public void onWindowFocusChanged(boolean z) {
        boolean m2179ab = C0351e.m2179ab(z);
        String str = "onWindowFocusChanged: " + m2179ab;
        if (isLocked()) {
            String str2 = "lock guard s : false";
            m2179ab = false;
        }
        if (this.alG != null) {
            this.alG.mo152aj(m2179ab);
        }
        if (akN && m2179ab) {
            try {
                if (!this.alM) {
                    mo212bX();
                    this.alM = true;
                }
                akN = false;
                if (akW && !alF) {
                    C0352f.m2187pZ();
                }
            } catch (C0096e e) {
                e.printStackTrace();
            }
            if (this.alG != null) {
                this.alG.mo153al(m2179ab);
            }
        }
        if (!akN && !m2179ab) {
            if (!akP) {
                if (this.alG != null) {
                    this.alG.mo153al(m2179ab);
                }
                try {
                    mo213bY();
                } catch (C0096e e2) {
                    e2.printStackTrace();
                }
            }
            akN = true;
        }
        alF = false;
        C0098g.m217uA();
    }

    public final void m216ux() {
        akP = true;
        setResult(akR);
        boolean z = C0355i.f2717Yf;
        try {
            Thread.sleep(1000L);
        } catch (Exception e) {
        }
        finish();
        boolean z2 = alu;
    }
}
