package com.gameloft.android.LATAM.GloftGF2H;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.StatFs;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.android.C0217R;
import java.io.File;
import java.net.URLEncoder;
import java.text.DecimalFormat;

public class StartUpdate extends Activity implements InterfaceC0334n {
    private static Handler mHandler = new Handler();

    private static long f357zt;

    private static ProgressBar f358zu;

    private static TextView f359zv;

    private static String f360zw;

    private String f361zn;

    private String f362zo;

    private C0332l f363zp;

    private C0326f f364zq;

    private String f365zr = null;

    private int f366zs = 0;

    static int m588a(StartUpdate startUpdate, int i) {
        startUpdate.f366zs = 100;
        return 100;
    }

    private static String m589aO(String str) {
        try {
            new String[1][0] = "";
            return str.split("DOWNLOAD_URL")[0].split("VERSION_AVAILABLE")[1].substring(2, r1[1].length() - 2);
        } catch (Exception e) {
            return "3.1.4";
        }
    }

    private static String m590aP(String str) {
        String encode;
        if (str == null || str.length() <= 0) {
            return "UnknownFingerPrint";
        }
        int indexOf = str.indexOf(":");
        if (indexOf != -1) {
            try {
            } catch (Exception e) {
                encode = null;
            }
            if (indexOf < str.length() - 1) {
                String replaceAll = str.substring(indexOf + 1).replaceAll("[^a-zA-Z 0-9.]+", "");
                String str2 = "UPDATE::UpdateStart::fingerprint=" + replaceAll;
                encode = URLEncoder.encode(replaceAll.trim(), "UTF-8");
                return encode == null ? encode : str;
            }
        }
        str.replaceAll("[^a-zA-Z 0-9.]+", "");
        encode = URLEncoder.encode(str.trim(), "UTF-8");
        if (encode == null) {
        }
    }

    public static boolean m592b(long j) {
        String str = "UPDATE::UpdateStart::SD Cart Path: " + f360zw;
        StatFs statFs = new StatFs(f360zw);
        long blockSize = statFs.getBlockSize() * statFs.getAvailableBlocks();
        String str2 = "UPDATE::UpdateStart::bytesAvailable: " + blockSize;
        String str3 = "UPDATE::UpdateStart::APK Size: " + j;
        f357zt = blockSize - j;
        String str4 = "UPDATE::UpdateStart::(bytesAvailable - fileSize): " + f357zt;
        return f357zt > 0;
    }

    private void m593bc(int i) {
        switch (i) {
            case 0:
                this.f366zs = 0;
                if (getIntent().getIntExtra("SCREEN_ORIENTATION", -1) == 0) {
                    ImageView imageView = (ImageView) getLayoutInflater().inflate(C0217R.layout.layout_progress_bar, (ViewGroup) findViewById(C0217R.id.progress_bar)).findViewById(C0217R.id.Splash);
                    Matrix matrix = new Matrix();
                    imageView.setScaleType(ImageView.ScaleType.MATRIX);
                    matrix.postRotate(90.0f, imageView.getDrawable().getBounds().width() / 2, imageView.getDrawable().getBounds().height() / 2);
                    imageView.setImageMatrix(matrix);
                }
                setContentView(C0217R.layout.layout_progress_bar);
                f358zu = (ProgressBar) findViewById(C0217R.id.progress_bar_waiting);
                break;
            case 1:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(getString(C0217R.string.STATE_CONFIRM_UPDATE).replace("{VERSION}", this.f362zo));
                builder.setPositiveButton(getString(C0217R.string.AU_COMMAND_YES), new DialogInterfaceOnClickListenerC0306bf(this));
                builder.setNegativeButton(getString(C0217R.string.AU_COMMAND_NO), new DialogInterfaceOnClickListenerC0307bg(this));
                builder.create().show();
                break;
            case 2:
                if (getIntent().getIntExtra("SCREEN_ORIENTATION", -1) == 0) {
                    ImageView imageView2 = (ImageView) getLayoutInflater().inflate(C0217R.layout.layout_download_bar, (ViewGroup) findViewById(C0217R.id.download_bar)).findViewById(C0217R.id.Splash);
                    Matrix matrix2 = new Matrix();
                    imageView2.setScaleType(ImageView.ScaleType.MATRIX);
                    matrix2.postRotate(90.0f, imageView2.getDrawable().getBounds().width() / 2, imageView2.getDrawable().getBounds().height() / 2);
                    imageView2.setImageMatrix(matrix2);
                }
                setContentView(C0217R.layout.layout_download_bar);
                f358zu = (ProgressBar) findViewById(C0217R.id.progress_bar_downloading);
                f359zv = (TextView) findViewById(C0217R.id.text_view_download_caption);
                break;
            case 3:
                AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                builder2.setMessage(getString(C0217R.string.NO_ENOUGH_SPACE_AVAILABLE).replace("{SIZE}", new DecimalFormat("0.00").format((f357zt / 1024) / 1024)));
                builder2.setNeutralButton(getString(C0217R.string.AU_COMMAND_OK), new DialogInterfaceOnClickListenerC0308bh(this));
                builder2.create().show();
                break;
            case C0217R.styleable.com_facebook_picker_fragment_done_button_text:
                AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
                builder3.setMessage(getString(C0217R.string.DOWNLOAD_FAIL));
                builder3.setNeutralButton(getString(C0217R.string.AU_COMMAND_OK), new DialogInterfaceOnClickListenerC0309bi(this));
                builder3.create().show();
                break;
        }
    }

    private static String m594dv() {
        try {
            Context applicationContext = ((Activity) C0325e.getContext()).getApplicationContext();
            return applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0).versionName;
        } catch (Exception e) {
            return "";
        }
    }

    private void m595dw() {
        File file = new File(Environment.getExternalStorageDirectory() + "/" + getResources().getString(C0217R.string.au_config_game_package));
        if (file.exists() && file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                file2.delete();
            }
            file.delete();
        }
    }

    public static void m599o(int i, String str) {
        mHandler.post(new RunnableC0305be(i, str));
    }

    @Override
    public final void mo600G(int i) {
        if (i != 0) {
            if (i == AsyncTaskC0333m.f1950ey) {
                m593bc(3);
                return;
            } else {
                m593bc(4);
                return;
            }
        }
        if (this.f365zr == "" && this.f365zr == null) {
            m601bb(5);
            return;
        }
        try {
            String str = "UPDATE::UpdateStart::apkURL: " + f360zw + "/" + this.f365zr;
            File file = new File(f360zw + "/" + this.f365zr);
            if (file.exists()) {
                Intent intent = new Intent("android.intent.action.INSTALL_PACKAGE");
                intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
                intent.putExtra("android.intent.extra.NOT_UNKNOWN_SOURCE", true);
                intent.putExtra("android.intent.extra.ALLOW_REPLACE", true);
                intent.putExtra("android.intent.extra.INSTALLER_PACKAGE_NAME", getApplicationInfo().packageName);
                startActivity(intent);
                finish();
                m601bb(6);
            } else {
                m601bb(5);
            }
        } catch (Exception e) {
            String str2 = "UPDATE::UpdateStart::Error try to run the new apk: " + e;
            m601bb(5);
        }
    }

    public final void m601bb(int i) {
        String str;
        boolean z = false;
        switch (i) {
            case 0:
                C0332l c0332l = this.f363zp;
                boolean m1959af = C0332l.m1984at() ? C0325e.m1959af() : false;
                String str2 = "UPDATE::UpdateStart::isNetworkAvailable: " + m1959af;
                String externalStorageState = Environment.getExternalStorageState();
                if ("mounted".equals(externalStorageState)) {
                    z = true;
                } else {
                    "mounted_ro".equals(externalStorageState);
                }
                String str3 = "UPDATE::UpdateStart::have SD Memory: " + z;
                if (z) {
                    m595dw();
                }
                if (!m1959af || !z) {
                    m601bb(5);
                    break;
                } else {
                    m601bb(1);
                    break;
                }
            case 1:
                this.f362zo = "";
                this.f361zn = "";
                try {
                    String string = getResources().getString(C0217R.string.au_config_game_code);
                    String m590aP = m590aP(Build.FINGERPRINT);
                    this.f361zn = m594dv();
                    str = "igpcode=" + string + "&bn=" + m590aP + "&lvl=" + Build.VERSION.SDK_INT + "&&ver=" + this.f361zn + "&test=" + getResources().getString(C0217R.integer.updteDebug);
                    String str4 = "UPDATE::UpdateStart::key: " + str;
                } catch (Exception e) {
                    String str5 = "UPDATE::UpdateStart::GI_STATE_SEND_REQUEST error " + e.getMessage();
                    str = "";
                }
                this.f364zq = new C0326f(this.f363zp);
                this.f364zq.m1969i("https://secure.gameloft.com/partners/android/update_check_hep.php", str);
                m601bb(2);
                break;
            case 2:
                new Thread(new RunnableC0303bc(this)).start();
                break;
            case 3:
                if (this.f364zq.f1912dF == null) {
                    m601bb(5);
                    break;
                } else if (!this.f364zq.f1912dF.contains("Error: No live release")) {
                    String str6 = "";
                    try {
                        String str7 = "UPDATE::UpdateStart::===========local_version =(" + this.f361zn + ")";
                        str6 = m589aO(this.f364zq.f1912dF).trim();
                        String str8 = "UPDATE::UpdateStart::===========server_version =(" + str6 + ")";
                    } catch (Exception e2) {
                        m601bb(5);
                    }
                    if (this.f361zn.compareTo(str6) != 0) {
                        m593bc(1);
                        break;
                    } else {
                        m601bb(5);
                        break;
                    }
                } else {
                    m601bb(5);
                    break;
                }
            case C0217R.styleable.com_facebook_picker_fragment_done_button_text:
                String str9 = this.f364zq.f1912dF;
                String substring = str9.substring(str9.indexOf("http"));
                this.f365zr = null;
                File file = new File(Environment.getExternalStorageDirectory() + "/" + getResources().getString(C0217R.string.au_config_game_package));
                file.mkdirs();
                f360zw = file.getAbsolutePath();
                String str10 = "UPDATE::UpdateStart:: new path: " + f360zw;
                m593bc(2);
                int lastIndexOf = substring.lastIndexOf(47);
                if (lastIndexOf != -1) {
                    this.f365zr = substring.substring(lastIndexOf + 1, substring.length());
                }
                new AsyncTaskC0333m(f360zw, this.f365zr, this).execute(substring);
                break;
            case C0217R.styleable.com_facebook_picker_fragment_title_bar_background:
                ComponentName componentName = new ComponentName(getResources().getString(C0217R.string.au_config_game_package), getResources().getString(C0217R.string.au_config_wrapper_activity));
                Intent intent = new Intent();
                intent.setFlags(268468224);
                intent.setComponent(componentName);
                startActivity(intent);
                finish();
                m601bb(6);
                break;
            case C0217R.styleable.com_facebook_picker_fragment_done_button_background:
                finish();
                System.exit(0);
                break;
        }
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C0325e.setContext(this);
        this.f363zp = new C0332l();
        m593bc(0);
        m601bb(0);
    }
}
