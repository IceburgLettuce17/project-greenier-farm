package com.gameloft.android2d.socialnetwork;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.Request;
import com.facebook.RequestAsyncTask;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.Settings;
import com.facebook.internal.CacheableRequestBatch;
import com.facebook.internal.ServerProtocol;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphUser;
import com.facebook.widget.WebDialog;
import com.gameloft.android.wrapper.C0352f;
import com.gameloft.android.wrapper.C0355i;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;

public class SocialNetwork_Facebook {
    static int agA;
    static Hashtable<String, Integer> agB;
    static Hashtable<String, Integer> agC;
    static int agD;
    static boolean agE;
    private static String agF;
    private static boolean agG;
    private static int agH;
    private static boolean agI;
    private static String agJ;
    private static String agK;
    private static String agL;
    private static boolean agM;
    private static String agN;
    private static String agO;
    private static String agP;
    private static String agQ;
    private static String agR;
    private static String agS;
    private static String agT;
    private static String agU;
    private static String agV;
    private static boolean agW;
    private static boolean agX;
    static boolean agg;
    private static final List<String> agn;
    private static AbstractC0508ao<GraphUser> ago;
    public static boolean agp;
    private static boolean agq;
    public static boolean agr;
    public static boolean ags;
    static ArrayList<String> agt;
    static ArrayList<String> agu;
    static ArrayList<String> agv;
    static ArrayList<URL> agw;
    static ArrayList<URL> agx;
    static int agy;
    static OutputStream agz;
    static Object lock;
    private static Session.StatusCallback statusCallback;
    private static int agc = -1;
    private static String[] agd = {"en_GB", "de_DE", "fr_FR", "it_IT", "es_ES", "pt_BR", "pt_PT", "ja_JP", "zh_CN", "ko_KR", "ru_RU", "tr_TR", "pl_PL", "cz_CZ", "nl_NL", "th_TH", "vi_VN", "ar_AR", "en_US"};
    static C0528l age = null;
    static int agf = 0;
    static String agh = "";
    static int agi = 50;
    static int agj = 50;
    static C0531o agk = new C0531o();
    static C0520d<GraphUser> agl = new C0520d<>();
    private static final List<String> agm = Arrays.asList("basic_info");

    interface SCORE extends GraphObject {
        Object getData();
    }

    static {
        Arrays.asList("publish_actions");
        agn = Arrays.asList("publish_actions");
        agp = false;
        agq = false;
        agr = false;
        ags = false;
        agt = new ArrayList<>();
        agu = new ArrayList<>();
        agv = new ArrayList<>();
        agw = new ArrayList<>();
        agx = new ArrayList<>();
        agy = 0;
        lock = new Object();
        agA = 0;
        agB = new Hashtable<>();
        agC = new Hashtable<>();
        agD = 0;
        agE = false;
        statusCallback = new C0510aq((byte) 0);
        agG = false;
        agI = false;
        agM = false;
        agW = false;
        agX = false;
    }

    static String m2706a(GraphObject graphObject) {
        if (graphObject.asMap().containsKey("uid")) {
            return graphObject.getProperty("uid").toString();
        }
        if (graphObject.asMap().containsKey("id")) {
            return graphObject.getProperty("id").toString();
        }
        return null;
    }

    public static void m2707a(int i, int i2) {
        agi = i;
        agj = i2;
    }

    static void m2708a(C0528l c0528l) {
        new RunnableC0496ac(new CacheableRequestBatch(new Request(Session.getActiveSession(), c0528l.afF + "/achievements", new Bundle(), HttpMethod.GET, new C0494aa(c0528l))));
    }

    public static void m2709a(C0528l c0528l, C0528l[] c0528lArr, String str, String str2) {
        String str3 = null;
        if (c0528lArr != null) {
            str3 = c0528lArr[0].afF;
            for (int i = 1; i < c0528lArr.length; i++) {
                str3 = str3 + "," + c0528lArr[i].afF;
            }
        }
        if (c0528l == null && c0528lArr == null) {
            return;
        }
        Session.getActiveSession();
        String str4 = c0528l.afF;
        String str5 = "Facebook: createInviteFriendRequest uid: " + str4;
        Bundle bundle = new Bundle();
        bundle.putString("message", str);
        bundle.putString("to", str4);
        bundle.putString("suggestions", str3);
        bundle.putString("data", str2);
        if (agc >= 0 && agc < agd.length) {
            bundle.putString("locale", agd[agc]);
        }
        new WebDialog.RequestsDialogBuilder(C0355i.getActivity(), Session.getActiveSession(), bundle).setOnCompleteListener(new C0502ai()).build().show();
    }

    public static void m2710a(String str, String str2, String str3, String str4) {
        if (m2745ty()) {
            Bundle bundle = new Bundle();
            bundle.putString(str3, str4);
            new RequestAsyncTask(new Request(Session.getActiveSession(), age.afF + "/" + str + ":" + str2, bundle, HttpMethod.POST, new C0540x())).execute(new Void[0]);
            return;
        }
        try {
            Session.getActiveSession().requestNewPublishPermissions(new Session.NewPermissionsRequest(C0355i.getActivity(), agn));
            agJ = str;
            agK = str2;
            agL = str3;
            agF = str4;
            agM = true;
        } catch (Exception e) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(str3, str4);
            new RequestAsyncTask(new Request(Session.getActiveSession(), age.afF + "/" + str + ":" + str2, bundle2, HttpMethod.POST, new C0539w())).execute(new Void[0]);
        }
    }

    public static void m2711a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        if (!m2745ty()) {
            try {
                Session.getActiveSession().requestNewPublishPermissions(new Session.NewPermissionsRequest(C0355i.getActivity(), agn));
                agN = str;
                agO = str2;
                agP = str3;
                agQ = str4;
                agR = str5;
                agS = str6;
                agT = str7;
                agU = str8;
                agV = str9;
                agW = true;
                return;
            } catch (Exception e) {
            }
        }
        m2716b(str, str2, str3, str4, str5, str6, str7, str8, str9);
    }

    public static void m2712a(String str, URL url) {
        agp = false;
        agD = 0;
        if (str != null) {
            if (!agB.containsKey(str)) {
                m2729f(str, 0, 0);
            }
            if (agC.get(str).intValue() == 0 && !agt.contains(str)) {
                agt.add(str);
                if (agu.contains(str)) {
                    agu.remove(str);
                }
                agw.add(url);
                if (agx.contains(url)) {
                    agx.remove(url);
                }
            }
        }
        if (agy < 2) {
            agy++;
            new Thread(new RunnableC0499af()).start();
        }
    }

    static boolean m2713ag(boolean z) {
        agq = true;
        return true;
    }

    static String m2714b(GraphObject graphObject) {
        if (graphObject.asMap().containsKey("name")) {
            Object property = graphObject.getProperty("name");
            if (property instanceof String) {
                return (String) property;
            }
        }
        return null;
    }

    public static void m2715b() {
        if (m2733g()) {
            return;
        }
        List<String> list = agm;
        Session activeSession = Session.getActiveSession();
        if (activeSession.isOpened() || activeSession.isClosed()) {
            activeSession = new Session.Builder(C0355i.getActivity()).setApplicationId(agh).build();
        } else {
            new Session.OpenRequest(C0355i.getActivity()).setCallback(statusCallback);
        }
        Session.OpenRequest callback = new Session.OpenRequest(C0355i.getActivity()).setCallback(statusCallback);
        callback.setPermissions(list);
        callback.setCallback((Session.StatusCallback) new C0537u());
        Session.setActiveSession(activeSession);
        activeSession.openForRead(callback);
    }

    private static void m2716b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        Bundle bundle = new Bundle();
        if (str != null) {
            bundle.putString("message", str);
        }
        if (str2 != null) {
            bundle.putString("link", str2);
        }
        if (str3 != null) {
            bundle.putString("name", str3);
        }
        if (str4 != null) {
            bundle.putString("caption", str4);
        }
        if (str5 != null) {
            bundle.putString("description", str5);
        }
        if (str6 != null) {
            bundle.putString("picture", str6);
        }
        if (str7 != null) {
            bundle.putString("tags", str7);
        }
        if (str8 != null) {
            bundle.putString("tags", str8);
        }
        if (str9 != null) {
            bundle.putString("tags", str9);
        }
        new RequestAsyncTask(new Request(Session.getActiveSession(), "me/feed", bundle, HttpMethod.POST, new C0503aj())).execute(new Void[0]);
    }

    static String m2717c(GraphObject graphObject) {
        if (graphObject.asMap().containsKey("username")) {
            Object property = graphObject.getProperty("username");
            if (property instanceof String) {
                return (String) property;
            }
        }
        return null;
    }

    public static void m2718c() {
        m2739tB();
        Session activeSession = Session.getActiveSession();
        if (activeSession != null) {
            activeSession.closeAndClearTokenInformation();
        }
        m2740tC();
        agf = 0;
    }

    public static void m2719c(String str, String str2) {
        agh = str;
        Session.getActiveSession();
        Session.Builder builder = new Session.Builder(C0355i.getActivity());
        builder.setApplicationId(agh);
        Session build = builder.build();
        Session.setActiveSession(build);
        if (build.getState().equals(SessionState.CREATED_TOKEN_LOADED)) {
            Session.OpenRequest callback = new Session.OpenRequest(C0355i.getActivity()).setCallback(statusCallback);
            callback.setPermissions(agm);
            build.openForRead(callback);
        }
        m2740tC();
    }

    private static void m2720c(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        Bundle bundle = new Bundle();
        if (str != null) {
            bundle.putString("message", str);
        }
        if (str2 != null) {
            bundle.putString("link", str2);
        }
        if (str3 != null) {
            bundle.putString("name", str3);
        }
        if (str4 != null) {
            bundle.putString("caption", str4);
        }
        if (str5 != null) {
            bundle.putString("description", str5);
        }
        if (str6 != null) {
            bundle.putString("picture", str6);
        }
        if (str7 != null) {
            bundle.putString("tags", str7);
        }
        if (str8 != null) {
            bundle.putString("tags", str8);
        }
        if (str9 != null) {
            bundle.putString("tags", str9);
        }
        if (agc >= 0 && agc < agd.length) {
            bundle.putString("locale", agd[agc]);
        }
        new WebDialog.FeedDialogBuilder(C0355i.getActivity(), Session.getActiveSession(), bundle).setOnCompleteListener(new C0504ak()).build().show();
        C0352f.m2186eU(1);
    }

    static URL m2721cX(String str) {
        String str2 = ServerProtocol.GRAPH_URL_BASE + str + "/picture?width=" + agi + "&height=" + agj;
        if (str2 != null) {
            try {
                return new URL(str2);
            } catch (MalformedURLException e) {
            }
        }
        return null;
    }

    public static void m2722cY(String str) {
        boolean z = true;
        if (agy > 0) {
            if (agv.size() >= 2) {
                z = false;
            } else if (agt.contains(str) || agu.contains(str)) {
                agv.add(str);
                z = false;
            }
        }
        if (z) {
            new Thread(new RunnableC0498ae(str)).start();
        }
    }

    public static InputStream m2723cZ(String str) {
        int intValue = agB.get(str).intValue();
        int intValue2 = agC.get(str).intValue();
        if (intValue2 == 0) {
            return null;
        }
        byte[] bArr = new byte[intValue2];
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(C0355i.getActivity().openFileInput("facebook\\Facebook_photos"));
            bufferedInputStream.skip(intValue);
            bufferedInputStream.read(bArr);
            bufferedInputStream.close();
        } catch (Exception e) {
        }
        return new ByteArrayInputStream(bArr);
    }

    static String m2724d(GraphObject graphObject) {
        if (graphObject.asMap().containsKey("first_name")) {
            Object property = graphObject.getProperty("first_name");
            if (property instanceof String) {
                return (String) property;
            }
        }
        return null;
    }

    public static void m2725d() {
        m2739tB();
        Session activeSession = Session.getActiveSession();
        Request newMeRequest = Request.newMeRequest(activeSession, new C0495ab(activeSession));
        HashSet hashSet = new HashSet();
        hashSet.addAll(Arrays.asList("id", "name", "username", "first_name", "last_name", "middle_name", "installed"));
        String str = "picture.width(" + agi + ").height(" + agj + ")";
        if (str != null) {
            hashSet.add(str);
        }
        Bundle parameters = newMeRequest.getParameters();
        parameters.putString("fields", TextUtils.join(",", hashSet));
        newMeRequest.setParameters(parameters);
        new RequestAsyncTask(newMeRequest).execute(new Void[0]);
        C0509ap c0509ap = new C0509ap((byte) 0);
        ago = c0509ap;
        c0509ap.m2748tF();
        m2738tA();
        Request newGraphPathRequest = Request.newGraphPathRequest(Session.getActiveSession(), "me/friends", null);
        HashSet hashSet2 = new HashSet();
        hashSet2.addAll(Arrays.asList("id", "name", "username", "first_name", "last_name", "middle_name", "installed", "locale"));
        String str2 = "picture.width(" + agi + ").height(" + agj + ")";
        if (str2 != null) {
            hashSet2.add(str2);
        }
        Bundle parameters2 = newGraphPathRequest.getParameters();
        parameters2.putString("fields", TextUtils.join(",", hashSet2));
        newGraphPathRequest.setParameters(parameters2);
        if (newGraphPathRequest != null) {
            ago.startLoading(newGraphPathRequest);
        }
    }

    static String m2726e(GraphObject graphObject) {
        if (graphObject.asMap().containsKey("middle_name")) {
            Object property = graphObject.getProperty("middle_name");
            if (property instanceof String) {
                return (String) property;
            }
        }
        return null;
    }

    public static boolean m2727e() {
        return agq && agr;
    }

    static String m2728f(GraphObject graphObject) {
        if (graphObject.asMap().containsKey("last_name")) {
            Object property = graphObject.getProperty("last_name");
            if (property instanceof String) {
                return (String) property;
            }
        }
        return null;
    }

    public static void m2729f(String str, int i, int i2) {
        agB.put(str, new Integer(i));
        agC.put(str, new Integer(i2));
    }

    public static boolean m2730f() {
        return ags;
    }

    public static C0528l m2731fg(int i) {
        return agl.m2775ff(i);
    }

    public static boolean m2733g() {
        Session activeSession = Session.getActiveSession();
        return (activeSession == null || !activeSession.isOpened() || activeSession.isClosed()) ? false : true;
    }

    static boolean m2734g(GraphObject graphObject) {
        if (graphObject.asMap().containsKey("installed")) {
            Object property = graphObject.getProperty("installed");
            if (property instanceof Boolean) {
                return ((Boolean) property).booleanValue();
            }
        }
        if (graphObject.asMap().containsKey("is_app_user")) {
            Object property2 = graphObject.getProperty("is_app_user");
            if (property2 instanceof Boolean) {
                return ((Boolean) property2).booleanValue();
            }
        }
        return false;
    }

    public static String getPassword() {
        return Session.getActiveSession().getAccessToken();
    }

    static String m2735h(GraphObject graphObject) {
        if (graphObject.asMap().containsKey("locale")) {
            Object property = graphObject.getProperty("locale");
            if (property instanceof String) {
                return ((String) property).split("_")[1];
            }
        }
        return null;
    }

    public static int m2736i() {
        return agf == 0 ? agl.graphObjects.size() : agf;
    }

    static void m2737k(String str, int i) {
        new RequestAsyncTask(new Request(Session.getActiveSession(), str + "/scores", null, HttpMethod.GET, new C0506am(-1))).execute(new Void[0]);
    }

    public static void onActivityResult(int i, int i2, Intent intent) {
        if (Session.getActiveSession() == null) {
            return;
        }
        Session.getActiveSession().onActivityResult(C0355i.getActivity(), i, i2, intent);
    }

    public static void onCreate(Bundle bundle) {
        try {
            for (Signature signature : C0355i.getActivity().getPackageManager().getPackageInfo(C0355i.getActivity().getPackageName(), 64).signatures) {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA");
                messageDigest.update(signature.toByteArray());
                C0493a.encodeToString(messageDigest.digest(), 0);
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.toString();
        } catch (NoSuchAlgorithmException e2) {
            e2.toString();
        }
        Settings.addLoggingBehavior(LoggingBehavior.INCLUDE_ACCESS_TOKENS);
        if (Session.getActiveSession() != null || bundle == null) {
            return;
        }
        Session restoreSession = Session.restoreSession(C0355i.getActivity(), null, statusCallback, bundle);
        Session.setActiveSession(restoreSession);
        if (restoreSession.getState() == null || !restoreSession.getState().equals(SessionState.CREATED_TOKEN_LOADED)) {
            return;
        }
        Session.OpenRequest callback = new Session.OpenRequest(C0355i.getActivity()).setCallback(statusCallback);
        callback.setPermissions(agm);
        restoreSession.openForRead(callback);
    }

    public static void onDestroy() {
        m2741tD();
    }

    public static void onPause() {
        m2741tD();
    }

    public static void onResume() {
        Settings.publishInstallAsync(C0355i.getContext(), agh);
        if (agG && m2745ty()) {
            String str = agF;
            if (m2745ty()) {
                Bundle bundle = new Bundle();
                bundle.putString("achievement", str);
                new RequestAsyncTask(new Request(Session.getActiveSession(), "me/achievements", bundle, HttpMethod.POST, new C0542z())).execute(new Void[0]);
            } else {
                try {
                    Session activeSession = Session.getActiveSession();
                    Session.NewPermissionsRequest newPermissionsRequest = new Session.NewPermissionsRequest(C0355i.getActivity(), agn);
                    agF = str;
                    agG = true;
                    activeSession.requestNewPublishPermissions(newPermissionsRequest);
                } catch (Exception e) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("achievement", str);
                    new RequestAsyncTask(new Request(Session.getActiveSession(), "me/achievements", bundle2, HttpMethod.POST, new C0541y())).execute(new Void[0]);
                }
            }
        }
        if (agI && m2745ty()) {
            int i = agH;
            if (m2745ty()) {
                Bundle bundle3 = new Bundle();
                bundle3.putInt("score", i);
                new RequestAsyncTask(new Request(Session.getActiveSession(), "me/scores", bundle3, HttpMethod.POST, new C0538v())).execute(new Void[0]);
            } else {
                try {
                    Session.getActiveSession().requestNewPublishPermissions(new Session.NewPermissionsRequest(C0355i.getActivity(), agn));
                    agH = i;
                    agI = true;
                } catch (Exception e2) {
                    Bundle bundle4 = new Bundle();
                    bundle4.putInt("score", i);
                    new RequestAsyncTask(new Request(Session.getActiveSession(), "me/scores", bundle4, HttpMethod.POST, new C0507an())).execute(new Void[0]);
                }
            }
        }
        if (agM && m2745ty()) {
            m2710a(agJ, agK, agL, agF);
        }
        if (agW && m2745ty()) {
            m2711a(agN, agO, agP, agQ, agR, agS, agT, agU, agV);
        }
        if (agX && m2745ty()) {
            String str2 = agN;
            String str3 = agO;
            String str4 = agP;
            String str5 = agQ;
            String str6 = agR;
            String str7 = agS;
            String str8 = agT;
            String str9 = agU;
            String str10 = agV;
            if (!m2745ty()) {
                try {
                    Session.getActiveSession().requestNewPublishPermissions(new Session.NewPermissionsRequest(C0355i.getActivity(), agn));
                    agN = str2;
                    agO = str3;
                    agP = str4;
                    agQ = str5;
                    agR = str6;
                    agS = str7;
                    agT = str8;
                    agU = str9;
                    agV = str10;
                    agX = true;
                } catch (Exception e3) {
                }
            }
            m2720c(str2, str3, str4, str5, str6, str7, str8, str9, str10);
        }
        agG = false;
        agI = false;
        agM = false;
        agW = false;
        agX = false;
    }

    public static void onSaveInstanceState(Bundle bundle) {
        if (Session.getActiveSession() == null) {
            return;
        }
        Session.saveSession(Session.getActiveSession(), bundle);
    }

    public static void onStart() {
        agB = C0355i.m2200bl("FileOfOffsets");
        agC = C0355i.m2200bl("FileOfLengths");
        if (Session.getActiveSession() == null) {
            return;
        }
        Session.getActiveSession().addCallback(statusCallback);
    }

    public static void onStop() {
        if (Session.getActiveSession() == null) {
            return;
        }
        Session.getActiveSession().removeCallback(statusCallback);
        m2741tD();
    }

    public static void m2738tA() {
        Bundle bundle = new Bundle();
        bundle.putString("access_token", Session.getActiveSession().getAccessToken());
        bundle.putString("q", "SELECT friend_count FROM user WHERE uid = me()");
        new Request(Session.getActiveSession(), "/fql", bundle, HttpMethod.GET, new C0497ad()).executeAsync();
    }

    private static void m2739tB() {
        agp = true;
        agq = false;
        agr = false;
        ags = false;
        age = null;
        agl = new C0520d<>();
    }

    private static void m2740tC() {
        agB = new Hashtable<>();
        agC = new Hashtable<>();
        agt = new ArrayList<>();
        agu = new ArrayList<>();
        agv = new ArrayList<>();
        agw = new ArrayList<>();
        agx = new ArrayList<>();
        try {
            C0355i.getActivity().deleteFile("facebook\\Facebook_photos");
            C0355i.getActivity().deleteFile("FileOfOffsets");
            C0355i.getActivity().deleteFile("FileOfLengths");
        } catch (Exception e) {
        }
        try {
            new File(C0355i.getContext().getFilesDir().getAbsolutePath() + "\\facebook").mkdir();
            if (agz != null) {
                agz.close();
            }
            agA = (int) C0355i.getActivity().getFileStreamPath("facebook\\Facebook_photos").length();
            agz = new BufferedOutputStream(C0355i.getActivity().openFileOutput("facebook\\Facebook_photos", 32768), 16384);
        } catch (Exception e2) {
            String str = "Facebook: exception create photo folder " + e2.toString();
        }
    }

    private static void m2741tD() {
        if (agE) {
            return;
        }
        agE = true;
        new Thread(new RunnableC0500ag()).start();
    }

    public static C0528l m2743tw() {
        return age != null ? age : new C0528l();
    }

    static void m2744tx() {
        if (ags) {
            new RequestAsyncTask(new Request(Session.getActiveSession(), agh + "/scores", null, HttpMethod.GET, new C0505al())).execute(new Void[0]);
        }
        agr = true;
    }

    private static boolean m2745ty() {
        Session activeSession = Session.getActiveSession();
        return activeSession != null && activeSession.getPermissions().contains("publish_actions");
    }

    public static void m2746tz() {
        agp = false;
        for (int i = 0; i < 2; i++) {
            m2712a((String) null, (URL) null);
        }
    }
}
